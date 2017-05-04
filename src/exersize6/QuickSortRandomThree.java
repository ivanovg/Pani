package exersize6;

/**
 * Created by Panteha Taherifard on 04.05.17.
 */
public class QuickSortRandomThree<T extends Comparable> extends QuickSort {

    @Override
    protected String name() {
        return "QuickSort with a random pivot element";
    }

    @Override
    protected int getPivotIndex(int lo, int hi) {
        int first = (int)(Math.random() * (hi - lo)) + lo;
        int second = (int)(Math.random() * (hi - lo)) + lo;
        int third = (int)(Math.random() * (hi - lo)) + lo;
        return middle(first, second, third);
    }

    private int middle(int first, int second, int third) {
        if (lessOrEqual(first, second) && lessOrEqual(first, third)) {
            if (lessOrEqual(second, third))
                return second;
            else
                return third;
        }
        else if (lessOrEqual(second, first) && lessOrEqual(second, third)) {
            if (lessOrEqual(first, third))
                return first;
            else
                return third;
        }
        else if (lessOrEqual(first, second))
            return first;
        else return second;
    }
}
