/*
35. Search Insert Position  QuestionEditorial Solution  My Submissions
Total Accepted: 120816
Total Submissions: 316008
Difficulty: Medium
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    public int binarySearch(int[] nums, int lo, int hi, int target) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) return mid;
        if (mid <= lo) return target < nums[lo] ? lo : lo + 1;
        else return nums[mid] < target ? binarySearch(nums, mid, hi, target) : binarySearch(nums, lo, mid, target);
    }
}
