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

}