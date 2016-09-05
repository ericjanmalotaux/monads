package nl.malotaux.monad;

import static java.util.Collections.emptyList;

public class AdresList extends List<Adres> {
    AdresList(Iterable<Adres> value) {
        super(value);
    }

    @Override
    <R> List<R> unit(java.util.List<Adres> list) {
        return new AdresList(list);
    }

}
