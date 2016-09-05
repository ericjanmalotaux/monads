package nl.malotau.logicaltypes;

public interface Joinable<F, T> extends Functor<F, T> {
    public Functor<F, ?> join() throws Failure;
}
