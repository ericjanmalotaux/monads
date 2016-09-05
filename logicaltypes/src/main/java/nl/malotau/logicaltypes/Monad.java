package nl.malotau.logicaltypes;

public abstract class Monad<M, A> implements Joinable<M, A> {

    public <T> Monad<M, T> flatMap(Applicable<A, Monad<M, T>> f) throws Failure {
        Applicable<Monad<M, A>, Monad<M, Monad<M, T>>> a = (Applicable<Monad<M, A>, Monad<M, Monad<M, T>>>) fmap(f);
        Monad<M, Monad<M, T>> monad = a.apply(this);
        return (Monad<M, T>) monad.join();
    }

    public Monad<M, A> fail(String ex) throws Failure {
        throw new Failure(ex);
    }
}