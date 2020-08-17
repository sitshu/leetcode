package com.company.tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfTree {
    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        result.add(root.val);
        leftBoundary(root.left, result);
        leaves(root.left, result);
        leaves(root.right, result);
        rightBoundary(root.right, result);
        return result;
    }

    public void leftBoundary(TreeNode root, List<Integer> result) {

        if(root== null)
            return;
        if(root.left == null && root.right == null )
            return;
        result.add(root.val);
        if(root.left!=null)
            leftBoundary(root.left, result);
        else if(root.right!=null)
            leftBoundary(root.right, result);

    }
    public void rightBoundary(TreeNode root, List<Integer> result) {

        if(root== null)
            return;
        if(root.left == null && root.right == null )
            return;

        if(root.right!=null)
            rightBoundary(root.right, result);
        else if(root.left!=null)
            rightBoundary(root.left, result);
        result.add(root.val);

    }

    public void leaves(TreeNode root, List<Integer> result) {

        if(root == null)
            return;
        if(root.left == null && root.right == null ){
            result.add(root.val);
            return;
        }
        leaves(root.left, result);
        leaves(root.right, result);
    }
}
