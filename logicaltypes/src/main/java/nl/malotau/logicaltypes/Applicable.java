package nl.malotau.logicaltypes;

/**
 * Hello world!
 */
public interface Applicable<T1, T2> {
    public T2 apply(T1 arg) throws Failure;
}