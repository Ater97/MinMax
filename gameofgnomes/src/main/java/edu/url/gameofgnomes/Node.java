package edu.url.gameofgnomes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Node {


    int noOfGnomes;//
    boolean isMaxPlayer;
    int score;
    String label;
    int alpha;
    int beta;
    

    List<Node> children;

    public Node(int noOfGnomes, boolean isMaxPlayer, char label){
        this.noOfGnomes = noOfGnomes;
        this.isMaxPlayer = isMaxPlayer;
        this.children = new ArrayList<>();
        this.label =  String.valueOf(label);
    }

    public int getNoOfGnomes() {
        return noOfGnomes;
    }

    public void setNoOfGnomes(int noOfGnomes) {
        this.noOfGnomes = noOfGnomes;
    }

    public boolean isMaxPlayer() {
        return isMaxPlayer;
    }

    public void setMaxPlayer(boolean maxPlayer) {
        isMaxPlayer = maxPlayer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
    public int getBeta() {
        return beta;
    }

    public void setBeta(int beta) {
        this.beta = beta;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node() {
    }
    

    void addChild(Node newNode) {
        children.add(newNode);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        String result = "Node{" +
                "noOfGnomes=" + noOfGnomes +
                ", score=" + score +
                ", label=" + label +
                "} -";

        if(this.getChildren() != null && this.getChildren().size() >  0) {

           result += this.getChildren().stream()
                    .map(x -> x.toString())
                    .collect(Collectors.toList()).toString();
        }
        return  result;
    }
}