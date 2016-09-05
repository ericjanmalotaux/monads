package nl.malotau.logicaltypes;

public abstract class Maybe<A> extends Monad<Maybe, A> {
    protected abstract <T> Maybe<T> mbBind(Applicable<A, Monad<Maybe, T>> arg) throws Failure;

    public static <T> Maybe<T> pure(T x) {
        return new Just<T>(x);
    }

    public static final Maybe<?> NOTHING = new Maybe() {
        public String toString() {
            return "Nothing";
        }

        public Object arg() throws Failure {
            throw new Failure("Cannot extract a value from Nothing.");
        }

        public Functor join() throws Failure {
            return this;
        }

        protected Maybe mbBind(Applicable f) {
            return this;
        }
    };

    public final static class Just<J> extends Maybe<J> {
        private final J _unit;


        public Just(J obj) {
            _unit = obj;
        }

        @Override
        public Maybe<?> join() throws Failure {
            try {
                return (Maybe<?>) _unit;
            } catch (ClassCastException ex) {
                throw new Failure("Joining on a flat structure!");
            }
        }

        @Override
        public String toString() {
            return "Just " + _unit;
        }

        @Override
        public J arg() throws Failure {
            return _unit;
        }

        @Override
        protected <T> Maybe<T> mbBind(Applicable<J, Monad<Maybe, T>> f) throws Failure {
            return (Maybe<T>) f.apply(_unit);
        }
    }

    public Functor<Maybe, ?> join() throws Failure {
        return null;
    }

    public <T> Applicable<? extends Functor<Maybe, A>, ? extends Functor<Maybe, T>> fmap(final Applicable<A, T> f)
        throws
        Failure {
        return new Applicable<Maybe<A>, Maybe<T>>() {
            public Maybe<T> apply(Maybe<A> arg) throws Failure {
                Applicable<A, Monad<Maybe, T>> lifted = new Applicable<A, Monad<Maybe, T>>() {
                    public Monad<Maybe, T> apply(A arg) throws Failure {
                        return Maybe.pure(f.apply(arg));
                    }
                };
                return arg.mbBind(lifted);
            }
        };
    }

    public A arg() throws Failure {
        return null;
    }

    @Override
    public Maybe<A> fail(String ex) throws Failure {
        return (Maybe<A>) NOTHING;
    }
}
