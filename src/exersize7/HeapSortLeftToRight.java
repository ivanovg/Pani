package exersize7;

/**
 * Created by Panteha on 5/15/2017.
 */
public class HeapSortLeftToRight<T extends Comparable<T>> extends Sorter<T> {

    @Override
    protected String name() {
        return "HeapSortLeftToRight";
    }

    @Override
    protected void sort() {
        makeHeap();
        for (int size = inputSize() - 1; size > 0; size--) {
            swap(0, size);
            makeHeap(size);
        }
    }

    /**
     * Verschiebt das Element an der angegebenen Index nach vorne zu der richtigen Stelle
     *
     * @param index Der Index der zu verschiebenen Element
     */
    private void swim(int index) {
        // Index von Kindelement ist zunaechst das angegebene Index
        int childIndex = index;
        int parentIndex;

        // So lange es noch ein Elternelement gebe.
        while (childIndex > 0) {
            parentIndex = (childIndex - 1) / 2;

            // Wenn das Elternelement kleiner als das Kindelement ist werden beide vertauscht
            // Der neue Index von Kindelement ist dann der vom Elternelement
            if (less(parentIndex, childIndex)) {
                swap(parentIndex, childIndex);
                childIndex = parentIndex;
            }

            // Sonst ist das "swim" fertig.
            else
                return;
        }
    }

    /**
     * Macht eine Heap-Struktur nur bis zu der angegebene Groesse in den zu sortierenden Array.
     *
     * @param size Die Groesse der Heap-Struktur
     */
    private void makeHeap(int size) {
        for (int index = 1; index < size; index++) {
            swim(index);
        }
    }

    /**
     * Macht eine Heap-Struktur aus dem ganzen Array, der zu sortieren ist.
     */
    private void makeHeap() {
        makeHeap(inputSize());
    }

}

