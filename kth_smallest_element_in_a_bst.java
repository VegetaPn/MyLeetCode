/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int cnt = 0;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        traverseNodes(root, k);
        return result;
    }

    private void traverseNodes(TreeNode r, int k) {
        if (r.left != null) {
            traverseNodes(r.left, k);
        }
        cnt++;
        if (cnt == k) {
            result = r.val;
            return;
        }
        if (r.right != null) {
            traverseNodes(r.right, k);
        }
    }
}
