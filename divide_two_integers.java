package xyz.yhngo.main;

/**
 * Created by Vegeta on 9/17/16.
 */
public class DivideWithout {

    public int divide(int dividend, int divisor) {

        if (dividend == 0) {
            return 0;
        }

        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        long first = Math.abs((long)dividend);
        long second = Math.abs((long)divisor);

        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }

        long res = findMultiple(first, second);

        if (res > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return sign == 1 ? (int) res : (int) -res;
    }

    private long findMultiple(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }

        long growth = divisor;
        long multiple = 1;
        while (growth + growth <= dividend) {
            growth += growth;
            multiple += multiple;
        }

        return multiple + findMultiple(dividend - growth, divisor);
    }

    public static void main(String[] args) {
        DivideWithout divideWithout = new DivideWithout();
        System.out.println(divideWithout.divide(-2147483648, -1));
    }
}
