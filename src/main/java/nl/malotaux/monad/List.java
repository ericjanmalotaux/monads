package nl.malotaux.monad;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class List<T> extends AbstractSequentialList<T> {

    private final LinkedList<T> list;

    List(Iterable<T> value) {
        this.list = Lists.newLinkedList(value);
    }

    public <R> List<R> map(Function<T, R> f) {
        return new List<>(list.stream().map(f).collect(toList()));
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return list.listIterator();
    }

    public <R> List<R> flatMap(Function<T, List<R>> f) {
        List<R> result = unit(Collections.emptyList());
        for (T value : list) {
            result.addAll(f.apply(value));
        }
        return result;
    }

    <R> List<R> unit(java.util.List<R> list) {
        return new List<>(list);
    }


}