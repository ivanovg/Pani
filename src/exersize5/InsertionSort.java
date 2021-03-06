package exersize5;

/**
 * Created by Panteha Taherifard on 28/04/2017.
 */
public class InsertionSort<T extends Comparable<T>> extends Sorter<T> {

    @Override
    protected String name() {
        return "InsertionSort";
    }

    @Override
    protected void sort() {
        for (int newIndex = 1; newIndex <= inputSize() - 1; newIndex++) {
            for (int swapIndex = newIndex; swapIndex > 0; swapIndex--) {
                if (less(swapIndex, swapIndex - 1)) {
                    swap(swapIndex, swapIndex - 1);
                }
                else {
                    break;
                }
            }
        }
    }
}
