package nl.malotaux.monad;

import junit.framework.TestCase;

public class OptionalTest extends TestCase {
    Optional<Integer> tryParse(String s) {
        try {
            final int i = Integer.parseInt(s);
            return Optional.of(i);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public void testMap() throws Exception {
        Optional<String> str = Optional.of("42");
        Optional<?> num = str.flatMap(this::tryParse);

    }

}