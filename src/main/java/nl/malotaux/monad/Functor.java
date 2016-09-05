package nl.malotaux.monad;

import java.util.function.Function;

/**
 * Hello world!
 */
public interface Functor<T, F extends Functor<?, ?>> {
    <R> F map(Function<T, R> f);
}
