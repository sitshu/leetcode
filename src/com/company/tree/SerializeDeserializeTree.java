package com.company.tree;

public class SerializeDeserializeTree {

    static int i= 0;
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        root.left = two;
        root.right =three;
        three.left = four;
        three.right = five;
        String s = serialize(root);
        TreeNode built = deserialize(s);

    }
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }

      }


    public static String serialize(TreeNode root) {

        StringBuilder s = new StringBuilder();
        serializeHelper(root, s);
        return s.toString();

    }

    public static void serializeHelper(TreeNode root, StringBuilder s) {

        if(root == null) {
            s.append('X');
            return;
        }
        s.append(root.val);
        serializeHelper(root.left, s);
        serializeHelper(root.right, s);
        return;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        int n = data.length();
        if(n==0)
            return null;
        TreeNode root = deserializeHelper( n, data) ;
        return root;
    }

    public static TreeNode deserializeHelper( int n, String data) {

        if (i >= n)
            return null;

        if (data.charAt(i) == 'X'){
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Character.getNumericValue(data.charAt(i)));
        i++;
        node.left = deserializeHelper( n, data);
        node.right = deserializeHelper( n, data);
        return node;
    }

}
