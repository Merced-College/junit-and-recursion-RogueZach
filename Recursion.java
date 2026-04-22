/*

 * Description: This class contains solutions to five classic recursion problems. Every method solves its problem using recursion only (no loops):
 *
 * count8      - counts occurrences of the digit 8 in an integer, where an 8 immediately to the right of another 8 counts twice (so 8818 yields 4).
 * countHi     - counts occurrences of the substring "hi" in a string.
 * countHi2    - counts "hi" occurrences, ignoring any "hi" that has an 'x' immediately before it.
 * strCount    - counts non-overlapping occurrences of a given substring inside a string.
 * stringClean - collapses runs of adjacent duplicate characters down to a single character (e.g. "yyzzza" -> "yza").

 */

public class Recursion {

    /**
     * Recursively counts the number of 8 digits in n.
     * An 8 that has another 8 immediately to its left counts double.
     */
    public static int count8(int n) {
        if (n == 0) return 0;

        int lastDigit = n % 10;
        int rest      = n / 10;
        int countInRest = count8(rest);

        if (lastDigit == 8) {
            // If the digit to the left is also 8, this 8 counts twice.
            if (rest % 10 == 8) {
                return countInRest + 2;
            }
            return countInRest + 1;
        }
        return countInRest;
    }

    /**
     * Recursively counts occurrences of the lowercase substring "hi" in str.
     */
    public static int countHi(String str) {
        if (str.length() < 2) return 0;

        if (str.startsWith("hi")) {
            return 1 + countHi(str.substring(2));
        }
        return countHi(str.substring(1));
    }

    /**
     * Recursively counts occurrences of "hi" in str, but does NOT count any
     * "hi" that has an 'x' immediately before it.
     */
    public static int countHi2(String str) {
        if (str.length() < 2) return 0;

        // If the next three chars are "xhi", skip all three so we don't count that "hi".
        if (str.length() >= 3 && str.substring(0, 3).equals("xhi")) {
            return countHi2(str.substring(3));
        }
        if (str.startsWith("hi")) {
            return 1 + countHi2(str.substring(2));
        }
        return countHi2(str.substring(1));
    }

    /**
     * Recursively counts non-overlapping occurrences of sub inside str.
     */
    public static int strCount(String str, String sub) {
        if (str.length() < sub.length()) return 0;

        if (str.substring(0, sub.length()).equals(sub)) {
            // Consume the matched chunk so matches cannot overlap.
            return 1 + strCount(str.substring(sub.length()), sub);
        }
        return strCount(str.substring(1), sub);
    }

    /**
     * Recursively returns a "cleaned" version of str where any run of adjacent
     * duplicate characters has been reduced to a single character.
     */
    public static String stringClean(String str) {
        if (str.length() < 2) return str;

        if (str.charAt(0) == str.charAt(1)) {
            // Drop the first char; the duplicate still in position 0 of the remainder.
            return stringClean(str.substring(1));
        }
        return str.charAt(0) + stringClean(str.substring(1));
    }

}