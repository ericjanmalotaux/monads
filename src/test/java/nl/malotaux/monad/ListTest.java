package nl.malotaux.monad;


import junit.framework.TestCase;
import org.hamcrest.CoreMatchers;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ListTest extends TestCase {
    public void testMap() throws Exception {
        List<String> list = new List(Arrays.asList("een", "twee", "drie"));
        List<String> upper = list.map(s -> s.toUpperCase());
        assertThat(upper, CoreMatchers.hasItems("EEN", "TWEE", "DRIE"));
    }

}