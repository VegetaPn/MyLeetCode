class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        int mid = low + (high - low) / 2;
        int cnt = 0;

        while (low < high) {
            cnt = 0;
            mid = low + (high - low) / 2;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
