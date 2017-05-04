package exersize6;

/**
 * Created by georgi on 28/04/2017.
 */
public class ShellSort<T extends Comparable> extends Sorter {

    @Override
    protected String name() {
        return "ShellSort";
    }

    @Override
    protected void sort() {
        int[] columns = {2147483647, 1131376761, 410151271, 157840433, 58548857,
                21521774, 8810089, 3501671, 1355339, 543749, 213331, 84801,
                27901, 11969, 4711, 1968, 815, 271, 111, 41, 13, 4, 1};

        for (int column : columns) {
            for (int newIndex = column; newIndex < inputSize(); newIndex++) {
                for (int swapIndex = newIndex; swapIndex >= column; swapIndex -= column) {
                    if (less(swapIndex, swapIndex - column)) {
                        swap(swapIndex, swapIndex - column);
                    }
                    else {
                        break;
                    }
                }
            }
        }
    }
}
