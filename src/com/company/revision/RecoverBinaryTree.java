package com.company.revision;


import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

public class RecoverBinaryTree {

    static TreeNode firstElement;
    static TreeNode secondElement;
    static TreeNode prev=  new TreeNode(Integer.MIN_VALUE);
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode two = new TreeNode(1);
        TreeNode three = new TreeNode(4);
        TreeNode four = new TreeNode(2);
//        TreeNode five = new TreeNode(5);
        root.left = two;
        root.right = three;
        three.left = four;
        //[3,1,4,null,null,2]
        recoverTree(root);
    }
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


        public static void recoverTree(TreeNode root) {
            recoverTreeHelper(root);

            if(secondElement!= null && firstElement!=null){
                int temp = firstElement.val;
                firstElement.val = secondElement.val;
                secondElement.val = temp;
            }
            return;
        }

        public static void recoverTreeHelper(TreeNode root){

            if(root == null)
                return;
            recoverTreeHelper(root.left);
            if(firstElement==null && root.val <= prev.val){
                firstElement = prev;
            }

            if(firstElement!=null && root.val <= prev.val){
                secondElement = root;
            }
            prev = root;
            recoverTreeHelper(root.right);
            return;
        }
    }

