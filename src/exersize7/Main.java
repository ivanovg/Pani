package exersize7;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Erstelle Sortieralgorithmen
        List<Sorter<Integer>> sorters = new LinkedList<Sorter<Integer>>();
        sorters.add(new HeapSort<Integer>());
        sorters.add(new HeapSortLeftToRight<Integer>());

        runSortersOnInput(sorters, createSortedArray(6));

    }

	/* Hilfsmethoden, nicht relevant zur Bearbeitung der Aufgaben. */

    /**
     * Hilfsmethode, die dieselbe Eingabe nacheinander mit verschiedenen
     * Sortieralgorithmen sortiert.
     *
     * @param sorters
     *            Sortieralgorithmen
     * @param input
     *            Eingabe
     */
    private static void runSortersOnInput(List<Sorter<Integer>> sorters, Integer[] input) {
        for (Sorter<Integer> sorter : sorters) {
            sorter.sort(input);
        }
    }

    /**
     * Erzeugt ein sortiertes Array.
     *
     * @param size
     *            Anzahl der Elemente
     * @return Array mit den Elementen 0..(size-1).
     */
    public static final Integer[] createSortedArray(int size) {
        Integer[] result = new Integer[size];
        for (int i = 0; i < size; i++) {
            result[i] = i;
        }
        return result;
    }

}
