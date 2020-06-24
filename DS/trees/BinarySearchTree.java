package com.company.DS.trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree {
    private class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }
    private Node root;

    public Node insert(int value){
        if(root == null){
            root = new Node(value);
            return root;
        }
        Node current = root;
        Node previous = root;

        while (true){
            if(current == null){
                current = new Node(value);
                if(value >= previous.value)
                    previous.right = current;
                else
                    previous.left = current;
                return root;
            }
            else if(value >= current.value){
                previous = current;
                current = current.right;
            }
            else{
                previous = current;
                current = current.left;
            }
        }
    }

    public boolean find(int value){
        Node current = root;
        while (true){
            if(current == null)return false;
            if(current.value == value)return true;
            else if(value >= current.value)current = current.right;
            else current = current.left;
        }
    }

    public void inOrder(Node root){
        if(root == null)
            return;
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    public void preOrder(Node root){
        if(root == null)
            return;
        System.out.println(root.value);
        inOrder(root.left);
        inOrder(root.right);
    }

    public void postOrder(Node root){
        if(root == null)
            return;
        inOrder(root.left);
        inOrder(root.right);
        System.out.println(root.value);
    }

    public int height(Node root){
        if(root == null)
            return -1;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean findByRecursion(Node root, int value){
        if(root == null)return false;
        if(root.value == value)return true;
        boolean leftSide = findByRecursion(root.left, value);
        boolean rightSide = findByRecursion(root.right, value);
        return leftSide || rightSide;
    }

    public int depth(Node root, int value, int level){
        if(root == null)return -1;
        if(root.value == value)return level;
        int leftDepth = depth(root.left, value, level + 1);
        if(leftDepth != -1)
            return leftDepth;
        return depth(root.right, value, level + 1);
    }

    public void minValueBinaryTree(Node root){
        if(root == null)return;
        int minValue = minValue(root);
        System.out.println("The minimum value in Binary tree: "+minValue);
    }

    private int minValue(Node root){
        if(root == null)return Integer.MAX_VALUE;
        int leftMin = minValue(root.left);
        int rightMin = minValue(root.right);
        int minLeftRight = Math.min(leftMin, rightMin);
        return Math.min(minLeftRight, root.value);
    }

    private boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }

    private boolean rootEquality(Node root1, Node root2){
        if(root1 == null && root2 == null)return true;
        else if(root1 == null || root2 == null)return false;

        if(root1.value != root2.value)return false;
        boolean leftSubTree = rootEquality(root1.left, root2.left);
        boolean rightSubTree = rootEquality(root1.right, root2.right);
        return leftSubTree && rightSubTree;
    }

    public boolean treeEquality(BinarySearchTree other){
        if(other == null)return false;
        Node root1 = root;
        Node root2 = other.root;
        return rootEquality(root1, root2);
    }

    private boolean validBSTImplementation(Node root, int min, int max){
        if(root == null)return true;
        if(root.value < min || root.value > max)return false;
        boolean leftSubTree = validBSTImplementation(root.left, min, root.value);
        boolean rightSubTree = validBSTImplementation(root.right, root.value, max);
        return leftSubTree && rightSubTree;
    }

    public void swapRoot(){
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public boolean validBST(Node root){
        return validBSTImplementation(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void kDistanceRoot(Node root, int k){
        if(root == null)return;
        if(k == 0) System.out.print(root.value+", ");
        kDistanceRoot(root.left, k - 1);
        kDistanceRoot(root.right, k - 1);
    }

    public void levelOrderTraversal(Node root){
        if(root == null)return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()){
            var temp = queue.poll();
            System.out.print(temp+", ");
            if(temp.left != null)queue.add(temp.left);
            if(temp.right != null)queue.add(temp.right);
        }
    }
}
