package com.company.tree;

public class MaxPathSum {
    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return maxSum;

    }

    public int maxPathSumHelper(TreeNode root) {
        if(root == null)
            return 0;
        int leftSum = Math.max(0, maxPathSumHelper(root.left));
        int rightSum = Math.max(0, maxPathSumHelper(root.right));

        maxSum = Math.max(maxSum, root.val+leftSum+rightSum);

        return Math.max(leftSum, rightSum) + root.val;

    }
}
