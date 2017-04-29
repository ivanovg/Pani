package exersize5;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static final int SIZE = 10000;

    public static void main(String[] args) {

        // Erstelle Sortieralgorithmen
        List<Sorter<Integer>> sorters = new LinkedList<Sorter<Integer>>();
        sorters.add(new GnomeSorter<Integer>());
        sorters.add(new BubbleSort<Integer>());
        sorters.add(new InsertionSort<Integer>());
        sorters.add(new SelectionSort<Integer>());
        sorters.add(new ShakerSort<Integer>());
        sorters.add(new ShellSort<Integer>());

        // Lasse Algorithmen gegen verschiedene Eingaben laufen
        System.out.println("SORTIERTE EINGABE:");
        runSortersOnInput(sorters, createSortedArray(SIZE));

        System.out.println("\nFAST SORTIERTE EINGABE (5% SWAPS):");
        runSortersOnInput(sorters, createAlmostSortedArray(SIZE, SIZE / 20));

        System.out.println("\nTEILWEISE SORTIERTE EINGABE MIT 10% ZUFAELLIGEN WERTEN AM ENDE:");
        runSortersOnInput(sorters, createPartiallySortedArray(SIZE, 0.10));

        System.out.println("\nZUFAELLIGE EINGABE:");
        runSortersOnInput(sorters, createRandomArray(SIZE));

        System.out.println("\nUMGEKEHRT SORTIERTE EINGABE:");
        runSortersOnInput(sorters, createInverseSortedArray(SIZE));

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

    /**
     * Erzeugt ein umgekehrt sortiertes Array.
     *
     * @param size
     *            Anzahl der Elemente
     * @return Array mit den Elementen (size-1)...0.
     */
    public static final Integer[] createInverseSortedArray(int size) {
        Integer[] result = new Integer[size];
        for (int i = 0; i < size; i++) {
            result[i] = size - i - 1;
        }
        return result;
    }

    /**
     * Erzeugt ein Array mit zufälliger Reihenfolge
     *
     * @param size
     *            Anzahl der Elemente
     * @return Array mit den Elementen 0..(size-1) in zufälliger Reihenfolge
     */
    public static final Integer[] createRandomArray(int size) {
        // Damit alle dieselben Werte bekommen waehlen wir festen Seed
        Random r = new Random(423);
        Integer[] result = createSortedArray(size);
        for (int i = 0; i < result.length; i++) {
            int randomIndex = i + r.nextInt(size - i);
            Integer tmp = result[i];
            result[i] = result[randomIndex];
            result[randomIndex] = tmp;
        }
        return result;
    }

    /**
     * Erzeugt ein Array mit annähernd sortierter Reihenfolge
     *
     * @param size
     *            Anzahl der Elemente
     * @param swaps
     *            Anzahl der zufälligen Vertauschunden nach Erstellung eines
     *            sortierten Arrays
     * @return Array mit Elementen 0..(size-1), das gegenüber der korrekten
     *         Reihenfolge eine Reihe von Vertauschungen aufweist.
     */
    public static final Integer[] createAlmostSortedArray(int size, int swaps) {
        Random r = new Random(1241);
        Integer[] result = createSortedArray(size);
        for (int i = 0; i < swaps; i++) {
            int randomIndex = r.nextInt(size);
            int randomIndex2 = r.nextInt(size);
            Integer tmp = result[randomIndex2];
            result[randomIndex2] = result[randomIndex];
            result[randomIndex] = tmp;
        }
        return result;
    }

    /**
     * Erzeug ein Array aus zwei Teilen. Der erste Teil enthält eine sortierte Folge von Zahlen aus 0..(size-1) mit Lücken,
     * der zweite Teil enthält die fehlenden Zahlen in unsortierter Reihenfolge.
     * @param size Anzahl der Elemente (insgesamt)
     * @param probabilityOfUnsortedness Wahrscheinlichkeit einer Zahl, im unsortierten Teil zu kommen.
     * @return Erzeugtes Array
     */
    public static final Integer[] createPartiallySortedArray(int size, double probabilityOfUnsortedness) {
        Random r = new Random(1243);
        Integer[] result = new Integer[size];
        int frontIndex = 0;
        int backIndex = size-1;
        int value = 0;
        while (frontIndex<=backIndex) {
            if (r.nextDouble()<probabilityOfUnsortedness) {
                result[backIndex--] = value++;
            } else {
                result[frontIndex++] = value++;
            }
        }
        for (int i = backIndex+1; i < result.length; i++) {
            int randomIndex = i + r.nextInt(size - i);
            Integer tmp = result[i];
            result[i] = result[randomIndex];
            result[randomIndex] = tmp;
        }
        return result;
    }

}
