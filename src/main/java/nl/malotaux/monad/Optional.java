package nl.malotaux.monad;

import java.util.function.Function;

class Optional<T> implements Monad<T, Optional<?>> {

    private final T valueOrNull;

    private Optional(T valueOrNull) {
        this.valueOrNull = valueOrNull;
    }

    @Override
    public <R> Optional<R> map(Function<T, R> f) {
        if (valueOrNull == null) {
            return empty();
        } else {
            return of(f.apply(valueOrNull));
        }
    }

    public static <T> Optional<T> of(T a) {
        return new Optional<T>(a);
    }

    public static <T> Optional<T> empty() {
        return new Optional<T>(null);
    }

    @Override
    public Optional<?> flatMap(Function<T, Optional<?>> f) {
        if (valueOrNull == null) {
            return empty();
        }
        return f.apply(valueOrNull);
    }
}