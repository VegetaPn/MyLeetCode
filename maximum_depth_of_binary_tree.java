/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ldp = maxDepth(root.left);
        int rdp = maxDepth(root.right);
        int dp = ldp >= rdp ? ldp + 1 : rdp + 1;

        return dp;
    }
}
