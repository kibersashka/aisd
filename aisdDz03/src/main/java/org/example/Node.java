package org.example;

public class Node {
    int value;
    Node left;
    Node right;
    private int height;
    public Node(){

    }

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
        height = 0;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public int getHeight() {
        return height;
    }
    @Override
    public String toString(){
        return value + " ";
    }

}
