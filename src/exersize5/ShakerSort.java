package exersize5;

/**
 * Created by Panteha Taherifard on 28/04/2017.
 */
public class ShakerSort<T extends Comparable> extends Sorter {

    @Override
    protected String name() {
        return "ShakerSort";
    }

    @Override
    protected void sort() {
        int start = -1;
        int end = inputSize() - 2;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            start++;
            for (int i = start; i <= end; i++) {
                if (less(i + 1, i)) {
                    swap(i + 1, i);
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
            swapped = false;
            end--;
            for (int i = end; i >= start; i--) {
                if (less(i + 1, i)) {
                    swap(i + 1, i);
                    swapped = true;
                }
            }
        }
    }
}
