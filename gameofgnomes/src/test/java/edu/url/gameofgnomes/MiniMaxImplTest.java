package edu.url.gameofgnomes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Ignore;

public class MiniMaxImplTest {

    private Tree gameTree;
    private MiniMax miniMax;

    @Before 
    public void initMiniMaxUtility() {
        miniMax = new MiniMaxImpl();
    }

    /**
     * Rigorous Test :-)
     */
    
    //@Ignore
    @Test
    public void checkMinimax() {

        miniMax.constructTree(3);
        System.out.println(miniMax.getTree());
        boolean result = miniMax.checkWin();
        System.out.println(miniMax.getTree());
        assertTrue(result);
        miniMax.constructTree(6);
        result = miniMax.checkWin();
        System.out.println(miniMax.getTree());
        assertTrue(result);
        miniMax.constructTree(8);
        result = miniMax.checkWin();
        System.out.println(miniMax.getTree());
        assertFalse(result);
    }
    
    @Test(timeout=20000)
    public void checkExponentialMinimax() {

        miniMax.constructTree(25);
        System.out.println(miniMax.getTree());
        boolean result = miniMax.checkWin();
        System.out.println(miniMax.getTree());
        assertTrue(result);

    }

}