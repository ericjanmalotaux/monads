package nl.malotaux.monad;

import com.sun.org.apache.xerces.internal.util.PropertyState;
import junit.framework.TestCase;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.assertThat;

public class IdentityTest extends TestCase {
    public void testMap() throws Exception {
        Identity<String> idString = new Identity<>("abc");
        Identity<Integer> idInt = idString.map(String::length);
        assertThat(idInt, CoreMatchers.is(new Identity(3)));
    }
}