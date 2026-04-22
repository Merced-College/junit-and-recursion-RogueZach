import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursionTest {

    // count8 tests

    @Test
    public void testCount8_singleEight() {
        assertEquals(1, Recursion.count8(8));
    }

    @Test
    public void testCount8_specExample_818() {
        assertEquals(2, Recursion.count8(818));
    }

    @Test
    public void testCount8_specExample_8818() {
        assertEquals(4, Recursion.count8(8818));
    }

    @Test
    public void testCount8_zero() {
        assertEquals(0, Recursion.count8(0));
    }

    @Test
    public void testCount8_noEights() {
        assertEquals(0, Recursion.count8(1234567));
    }

    @Test
    public void testCount8_doubleEight() {
        // 88: right 8 counts twice (=2), left 8 counts once (=1) -> 3
        assertEquals(3, Recursion.count8(88));
    }

    @Test
    public void testCount8_tripleEight() {
        // 888: 1 + 2 + 2 = 5
        assertEquals(5, Recursion.count8(888));
    }

    @Test
    public void testCount8_quadrupleEight() {
        // 8888: 1 + 2 + 2 + 2 = 7
        assertEquals(7, Recursion.count8(8888));
    }

    @Test
    public void testCount8_separatedEights() {
        // 80808: three isolated 8s, none adjacent -> 3
        assertEquals(3, Recursion.count8(80808));
    }

    @Test
    public void testCount8_twoPairs() {
        // 88088: two separate "88" runs -> 3 + 3 = 6
        assertEquals(6, Recursion.count8(88088));
    }

    @Test
    public void testCount8_singleNonEight() {
        assertEquals(0, Recursion.count8(5));
    }

}