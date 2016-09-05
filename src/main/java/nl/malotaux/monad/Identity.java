package nl.malotaux.monad;

import java.util.function.Function;

public class Identity<T> implements Functor<T, Identity<?>> {
    private final T value;

    public Identity(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Identity)) {
            return false;
        }

        Identity<?> identity = (Identity<?>) o;

        return value != null ? value.equals(identity.value) : identity.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public <R> Identity<R> map(Function<T, R> f) {
        return new Identity<>(f.apply(value));
    }
}
