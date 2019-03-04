package edu.url.gameofgnomes;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
            
        /*
        contruir arbol x fichas
        calcular futuros -> crar nivel
        */
        
        Tree t1 = new Tree();
        List<Integer> templist = GameOfGnomes.getPossibleStates(0);
        System.out.println( "Hello World!" );
    }
}
