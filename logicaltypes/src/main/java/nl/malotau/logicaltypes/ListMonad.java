package nl.malotau.logicaltypes;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ListMonad<A> extends Monad<ListMonad, A> {
    private final List<A> elements;

    public ListMonad(Collection<A> elements) {
        this.elements = new LinkedList<A>(elements);
    }

    public Functor<ListMonad, ?> join() throws Failure {
        return null;
    }

    public <T> Applicable<? extends Functor<ListMonad, A>, ? extends Functor<ListMonad, T>> fmap(
        Applicable<A, T> f) throws Failure {
        return null;
    }

    public A arg() throws Failure {
        return null;
    }
}
