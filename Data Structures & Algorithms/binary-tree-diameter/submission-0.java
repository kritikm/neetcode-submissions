/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int diameter = 0;

    private int deepestDepth(TreeNode root) {
        if (root == null) return -1;

        int leftDepth = deepestDepth(root.left);
        int rightDepth = deepestDepth(root.right);

        diameter = Math.max(diameter, 2 + leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        deepestDepth(root);
        return diameter;
    }
}
