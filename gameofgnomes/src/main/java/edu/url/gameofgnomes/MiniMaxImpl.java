/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.url.gameofgnomes;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author Sebastian
 */
public class MiniMaxImpl implements MiniMax {
 //****************INMPLEMENTATION**********************************
    public MiniMaxImpl() {
        System.out.println( "----------------------" );
    }
    public Tree t1 = new Tree();
    //public char lastLabel = 'A';
    public int countLabel =65;
    public Stack<Integer> stack = new Stack<Integer>();  
    public boolean flagSize = true;
    
    @Override
    public Tree getTree() { //create tree
        return t1;
    }

    @Override
    public boolean checkWin() { //first player wins
      // stack = new Stack<Integer>();  
       Node n = getWinner(t1.getRoot(),-10,10);//infinity values
       System.out.println("Path");
       visit(n);
       if(flagSize) 
            getTreeValues(n);
       return n.score==1; //roots value player 1 
    }//alpha-> mejor valor para max beta-> mejor valor para min
    /*Hacia abajo copiar alpha y beta
      Hacia arriba comparar 
        si es un estado vacio comparar con -inf y +inf*/
    public Node getWinner(Node root, int alpha, int beta){ 
        //stack.push((int)(root.label.charAt(0)));
        List<Node> children = root.getChildren();
        root.setAlpha(alpha);// hacia abajo
        root.setBeta(beta);
        
        if(children.isEmpty())//its a leaf 
           return root;
        for (int i = 0; i < children.size(); i++) {
            int value = getWinner(children.get(i), alpha, beta).score;//hacia arriba
            
            if(root.isMaxPlayer)//alpha
            {   if(root.alpha>value)
                    return root;
                getMax(root, value);
            }
            else//beta
            {
                if(root.beta<value)
                    return root;
                getMin(root, value);
            }
        }
       return root;
    }  
    public void getMax(Node root, int score)
    {   //alpha
        if(root.getScore()<score||root.getScore()==0){
            root.setAlpha(score);
            root.setScore(score);}           
    }
    public void getMin(Node root, int score)
    {   //beta
        if(root.getScore()>score||root.getScore()==0){
            root.setBeta(score);
            root.setScore(score);}
    }
    public void visit(Node root){
        System.out.println(root.getLabel());
        List<Node> children = root.getChildren();
        for (int i = 0; i < children.size(); i++) {
            if(children.get(i).getScore()==1)
                visit(children.get(i));
        }
    }
    public void getTreeValues(Node root) {
        System.out.println(" Node " + root.label + " count " + root.getNoOfGnomes() +" value " + root.score);
        List<Node> children = root.getChildren();
        for (int i = 0; i < children.size(); i++) {
                getTreeValues(children.get(i));
        }
    }
    
    @Override
    public void constructTree(int noOfGnomes) { 
        t1 = new Tree();
        countLabel =66; //A
        if(noOfGnomes>10)
            flagSize = false;
        t1.setRoot(new Node(noOfGnomes, true, (char)(65))); //number of coins, first player, first label
        createTree(t1.root, noOfGnomes);
        //t1.toString();
       System.out.println( "Construct tree finished");
    }
    
     public Node createTree(Node root,int noOfGnomes){ 
        List<Integer> coinsLeft = GameOfGnomes.getPossibleStates(noOfGnomes); 
        for (int i = 0; i < coinsLeft.size(); i++) { 
           Node n = new Node(coinsLeft.get(i), !root.isMaxPlayer,(char)(countLabel++));
           if(coinsLeft.get(i)==0)
               if(root.isMaxPlayer)
                    n.setScore(1);
               else
                    n.setScore(-1);
           if(flagSize)
                System.out.println(" Parent " + root.label + " -> Child " + n.getLabel() + " count " + n.getNoOfGnomes() +" value " + n.score);
           root.addChild(createTree(n, coinsLeft.get(i)));   
        }
        return root;
    }
     public char getLabel(int ascii){
        // int ascii = (int) preLabel;
         //ascii++;
         return ((char) ascii);
     }
    
}
