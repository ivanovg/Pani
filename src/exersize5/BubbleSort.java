package exersize5;

/**
 * Created by Panteha Taherifard on 28/04/2017.
 */
public class BubbleSort<T extends Comparable<T>> extends Sorter<T> {

    @Override
    protected String name() {
        return "BubbleSort";
    }

    @Override
    protected void sort() {
        boolean needsNext = true;
        for (int k = inputSize() - 1; k > 0 && needsNext; k--) {
            needsNext = false;
            for (int i = 0; i < k; i++) {
                if (less(i + 1, i)) {
                    swap(i + 1, i);
                    needsNext = true;
                }
            }
        }
    }
}
