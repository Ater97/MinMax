package edu.url.gameofgnomes;

public class Tree {
    Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    @Override
    public String toString(){
        
        
        return root.toString();
        
    }
}