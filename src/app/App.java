package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> pile1 = new ArrayList<Integer>();
        List<Integer> pile2 = new ArrayList<Integer>();
        Integer stonesArray[] = {4,5,6,7,8};

        List<Integer> stones = getDescendedList(stonesArray);
        splitStonesToPiles(stones,pile1,pile2);

        System.out.println("Pile #1 "+pile1+", weight - "+getWeightOfPile(pile1));
        System.out.println("Pile #2 "+pile2+", weight - "+getWeightOfPile(pile2));
    }

    private static List<Integer> getDescendedList(Integer stonesArray[]){
        List<Integer> stones = Arrays.asList(stonesArray);
        Collections.sort(stones, Collections.reverseOrder());

        return stones;
    }

    private static void splitStonesToPiles(List<Integer> stones, List<Integer>pile1, List<Integer>pile2){
        int pileWeight1;
        int pileWeight2;
        for (int stoneWeight:stones){
            pileWeight1 = getWeightOfPile(pile1);
            pileWeight2 = getWeightOfPile(pile2);
            if (pileWeight1<=pileWeight2) {
                pile1.add(stoneWeight);
            } else {
                pile2.add(stoneWeight);
            }
        }
    }

    private static int getWeightOfPile(List<Integer> pile){
        int weight = 0;
        for (int stoneWeight:pile){
            weight=weight+stoneWeight;
        }
        return weight; 
    }
}