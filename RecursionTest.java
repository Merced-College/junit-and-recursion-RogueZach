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

    // countHi tests

    @Test
    public void testCountHi_specExample_xxhixx() {
        assertEquals(1, Recursion.countHi("xxhixx"));
    }

    @Test
    public void testCountHi_specExample_xhixhix() {
        assertEquals(2, Recursion.countHi("xhixhix"));
    }

    @Test
    public void testCountHi_specExample_hi() {
        assertEquals(1, Recursion.countHi("hi"));
    }

    @Test
    public void testCountHi_emptyString() {
        assertEquals(0, Recursion.countHi(""));
    }

    @Test
    public void testCountHi_singleChar() {
        assertEquals(0, Recursion.countHi("h"));
    }

    @Test
    public void testCountHi_noHi() {
        assertEquals(0, Recursion.countHi("abcdefg"));
    }

    @Test
    public void testCountHi_consecutiveHi() {
        assertEquals(3, Recursion.countHi("hihihi"));
    }

    @Test
    public void testCountHi_uppercaseIgnored() {
        // Problem spec says lowercase "hi" only.
        assertEquals(0, Recursion.countHi("HI HI HI"));
    }

    @Test
    public void testCountHi_hiWithFillerBetween() {
        assertEquals(2, Recursion.countHi("hiabchi"));
    }

    @Test
    public void testCountHi_embeddedHi() {
        // "hhhiii" contains exactly one "hi".
        assertEquals(1, Recursion.countHi("hhhiii"));
    }

    @Test
    public void testCountHi_mixedPattern() {
        assertEquals(2, Recursion.countHi("ahixhi"));
    }

    // countHi2 tests

    @Test
    public void testCountHi2_specExample_ahixhi() {
        assertEquals(1, Recursion.countHi2("ahixhi"));
    }

    @Test
    public void testCountHi2_specExample_ahibhi() {
        assertEquals(2, Recursion.countHi2("ahibhi"));
    }

    @Test
    public void testCountHi2_specExample_xhixhi() {
        assertEquals(0, Recursion.countHi2("xhixhi"));
    }

    @Test
    public void testCountHi2_emptyString() {
        assertEquals(0, Recursion.countHi2(""));
    }

    @Test
    public void testCountHi2_plainHi() {
        assertEquals(1, Recursion.countHi2("hi"));
    }

    @Test
    public void testCountHi2_xhiOnly() {
        assertEquals(0, Recursion.countHi2("xhi"));
    }

    @Test
    public void testCountHi2_twoHiNoX() {
        assertEquals(2, Recursion.countHi2("hihi"));
    }

    @Test
    public void testCountHi2_xhiThenHiHi() {
        // "xhihihi": skip leading "xhi", then "hihi" -> 2
        assertEquals(2, Recursion.countHi2("xhihihi"));
    }

    @Test
    public void testCountHi2_hiWithNonXBefore() {
        assertEquals(2, Recursion.countHi2("hixhhi"));
    }

    @Test
    public void testCountHi2_noHi() {
        assertEquals(0, Recursion.countHi2("abcdefg"));
    }

    @Test
    public void testCountHi2_alternatingPatterns() {
        // "hihixhi": hi (1), hi (1), xhi (skipped) -> 2
        assertEquals(2, Recursion.countHi2("hihixhi"));
    }

    // strCount tests

    @Test
    public void testStrCount_specExample_cat() {
        assertEquals(2, Recursion.strCount("catcowcat", "cat"));
    }

    @Test
    public void testStrCount_specExample_cow() {
        assertEquals(1, Recursion.strCount("catcowcat", "cow"));
    }

    @Test
    public void testStrCount_specExample_dog() {
        assertEquals(0, Recursion.strCount("catcowcat", "dog"));
    }

    @Test
    public void testStrCount_emptyString() {
        assertEquals(0, Recursion.strCount("", "cat"));
    }

    @Test
    public void testStrCount_exactMatch() {
        assertEquals(1, Recursion.strCount("cat", "cat"));
    }

    @Test
    public void testStrCount_backToBackMatches() {
        assertEquals(2, Recursion.strCount("catcat", "cat"));
    }

    @Test
    public void testStrCount_nonOverlappingRule() {
        // "ccccc" with sub "cc" -> cc|cc|c, so 2 (NOT 4 with overlap).
        assertEquals(2, Recursion.strCount("ccccc", "cc"));
    }

    @Test
    public void testStrCount_repeatedPattern() {
        assertEquals(3, Recursion.strCount("ababab", "ab"));
    }

    @Test
    public void testStrCount_doubleChar() {
        assertEquals(2, Recursion.strCount("aaaa", "aa"));
    }

    @Test
    public void testStrCount_longerSub() {
        assertEquals(2, Recursion.strCount("hellohello", "hello"));
    }

    @Test
    public void testStrCount_singleCharSub() {
        assertEquals(4, Recursion.strCount("xaxaxax", "x"));
    }

    @Test
    public void testStrCount_subLongerThanStr() {
        assertEquals(0, Recursion.strCount("hi", "hello"));
    }

    // stringClean tests

    @Test
    public void testStringClean_specExample_yyzzza() {
        assertEquals("yza", Recursion.stringClean("yyzzza"));
    }

    @Test
    public void testStringClean_specExample_abbbcdd() {
        assertEquals("abcd", Recursion.stringClean("abbbcdd"));
    }

    @Test
    public void testStringClean_specExample_Hello() {
        assertEquals("Helo", Recursion.stringClean("Hello"));
    }

    @Test
    public void testStringClean_emptyString() {
        assertEquals("", Recursion.stringClean(""));
    }

    @Test
    public void testStringClean_singleChar() {
        assertEquals("a", Recursion.stringClean("a"));
    }

    @Test
    public void testStringClean_twoSameChars() {
        assertEquals("a", Recursion.stringClean("aa"));
    }

    @Test
    public void testStringClean_noDuplicates() {
        assertEquals("abc", Recursion.stringClean("abc"));
    }

    @Test
    public void testStringClean_allSameChars() {
        assertEquals("a", Recursion.stringClean("aaaa"));
    }

    @Test
    public void testStringClean_pairs() {
        assertEquals("abc", Recursion.stringClean("aabbcc"));
    }

    @Test
    public void testStringClean_longerPairs() {
        assertEquals("abcd", Recursion.stringClean("aabbccdd"));
    }

    @Test
    public void testStringClean_alternatingNoDupes() {
        assertEquals("ababab", Recursion.stringClean("ababab"));
    }

    @Test
    public void testStringClean_uppercase() {
        assertEquals("XYZ", Recursion.stringClean("XXYYZZ"));
    }

}