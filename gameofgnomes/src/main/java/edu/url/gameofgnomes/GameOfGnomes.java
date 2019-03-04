package edu.url.gameofgnomes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameOfGnomes {

    /**
     * Calculates the next "futures" based in a given set of actions (1 to 3 retrievals). Discards also non positive values
     * @param noOfGnomesInHeap
     * @return
     */
    static List<Integer> getPossibleStates(int noOfGnomesInHeap){
        return IntStream
                .rangeClosed(1,3)
                .boxed()
                //.peek(System.out::println)
                .map(i -> noOfGnomesInHeap - i)
                .filter(newHeapCount -> newHeapCount >= 0)
                .collect(Collectors.toList());
    }
    
    
}
