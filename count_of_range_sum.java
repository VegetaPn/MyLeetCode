package xyz.yhngo.main;

/**
 * Created by Vegeta on 9/1/16.
 */
public class CountofRangeSum {
    public static void main(String args[]) {
        int[] nums = new int[]{-2,5,-1};
        int l = -2;
        int h = 2;
        CountofRangeSum crs = new CountofRangeSum();
        int r = crs.countRangeSum(nums, l, h);
        System.out.println(r);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        // Construct sum array
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return getCountofRange(sums, 0, nums.length + 1, lower, upper);
    }

    private int getCountofRange(long[] sums, int lo, int hi, int lower, int upper) {
        if (hi - lo <= 1) {
            return 0;
        }
        int mid = lo + (hi - lo) / 2;
        int cnt = getCountofRange(sums, lo, mid, lower, upper) + getCountofRange(sums, mid, hi, lower, upper);

        int j = mid, k = mid, t = mid;
        long[] cached = new long[hi - lo];
        for (int i = lo, r = 0; i < mid; i++, r++) {
            while (j < hi && sums[j] - sums[i] < lower) j++;
            while (k < hi && sums[k] - sums[i] <= upper) k++;
            while (t < hi && sums[t] - sums[i] < 0) cached[r++] = sums[t++];
            cached[r] = sums[i];
        }

        cnt += (k - j);
        System.arraycopy(cached, 0, sums, lo, t - lo);
        return cnt;
    }
}
