package exersize6;

import java.util.Random;

/**
 * Created by Panteha Taherifard on 04.05.17.
 */
public class QuickSortRandomPivot<T extends Comparable> extends QuickSort {

    @Override
    protected String name() {
        return "QuickSort with a random pivot index";
    }

    @Override
    protected int getPivotIndex(int lo, int hi) {
        return (int)(Math.random() * (hi - lo)) + lo;
    }
}
