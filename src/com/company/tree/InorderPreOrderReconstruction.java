package com.company.tree;

import java.util.HashMap;
import java.util.Map;

public class InorderPreOrderReconstruction {

    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    int[] inorder;
    int pre_index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int j=0;
        for(int i: inorder){
            map.put(i, j++);
        }
        this.inorder = inorder;
        this.preorder = preorder;
        TreeNode node = helper(0, inorder.length);
        return node;
    }

    public TreeNode helper(int in_begin, int in_end){
        if(in_begin == in_end)
            return null;


        int val = preorder[pre_index];
        TreeNode root = new TreeNode(val);
        int in_index = map.get(val);
        pre_index++;
        root.left = helper(in_begin, in_index);
        root.right = helper(in_index+1, in_end);
        return root;

    }
}
