package com.company.DS.trees;

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
}
