package exersize6;

/**
 * Created by pani on 28/04/2017.
 */
public class SelectionSort<T extends Comparable> extends Sorter {

    @Override
    protected String name() {
        return "SelectionSort";
    }

    @Override
    protected void sort() {
        for (int newIndex = 0; newIndex < inputSize() - 1; newIndex++) {
            int minIndex = newIndex;
            for (int i = newIndex + 1; i < inputSize(); i++) {
                if (less(i, minIndex)) {
                    minIndex = i;
                }
            }
            if (minIndex != newIndex) {
                swap(minIndex, newIndex);
            }
        }
    }
}
