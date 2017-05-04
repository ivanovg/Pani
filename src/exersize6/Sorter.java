package exersize6;

import java.text.MessageFormat;

/**
 * Abstrakte Klasse zum Evaluieren von Sortieralgorithmen
 *
 * @author katz.bastian
 *
 * @param <T>
 *            Typ, der {@link Comparable} implementiert.
 */
public abstract class Sorter<T extends Comparable<T>> {

    // Array mit der Eingabe
    private T[] array;

    // Zaehler fuer swaps und compares
    private int swapCount = 0;
    private int compareCount = 0;

    /**
     * @return Name des Algorithmus.
     */
    protected abstract String name();

    /**
     * Sortiermethode. Darf nur die Methoden {@link #inputSize()},
     * {@link #less(int, int)}, {@link #lessOrEqual(int, int)} und
     * {@link #swap(int, int)} verwenden, um das Array zu sortieren.
     */
    protected abstract void sort();

    /**
     * Sichtbare Sortiermethode. Sortiert das uebergebene Array mit der in der
     * konkreten Klasse implementierten Algorithmus.
     *
     * @param array
     *            Eingabe.
     */
    public final void sort(T[] array) {
        this.array = array.clone();
        swapCount = 0;
        compareCount = 0;
        sort();
        System.gc();
        long start = System.currentTimeMillis();
        sort();
        long end = System.currentTimeMillis();
        if (assertSorted()) {
            String pattern = name() + " hat {0} Vergleiche und {1} Vertauschungen in {2}ms durchgefuehrt. c={3}";
            System.out.println(MessageFormat.format(pattern, compareCount, swapCount, end - start, c(compareCount)));
        } else {
            System.out.println(name() + " hat die Eingabe nicht sortiert!");
        }
    }

    /**
     * Hilsmethode, die ueberprueft, ob das Array tatsaechlich sortiert ist (zaehlt
     * keine Vergleiche).
     *
     * @return true genau dann, wenn das Array sortiert ist.
     */
    private boolean assertSorted() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Vertauscht die beiden Werte an den gegebenen Positionen
     *
     * @param firstIndex
     *            erste Position
     * @param secondIndex
     *            zweite Position
     */
    protected void swap(int firstIndex, int secondIndex) {
        swapCount++;
        T tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }

    protected final int inputSize() {
        return array.length;
    }

    /**
     * Liefert zurueck, ob der durch den ersten Index bezeichnete Wert kleiner
     * oder gleich dem durch den zweiten Index bezeichnete Wert ist.
     *
     * @param firstIndex
     *            erster Index
     * @param secondIndex
     *            zweiter Index
     * @return true, wenn Wert an erstem Index kleiner oder gleich, false sonst.
     */
    protected final boolean lessOrEqual(int firstIndex, int secondIndex) {
        compareCount++;
        return array[firstIndex].compareTo(array[secondIndex]) <= 0;
    }

    /**
     * Liefert zurueck, ob der durch den ersten Index bezeichnete Wert echt
     * kleiner ist als der durch den zweiten Index bezeichnete Wert.
     *
     * @param firstIndex
     *            erster Index
     * @param secondIndex
     *            zweiter Index
     * @return true, wenn Wert an erstem Index echt kleiner, false sonst.
     */
    protected final boolean less(int firstIndex, int secondIndex) {
        compareCount++;
        return array[firstIndex].compareTo(array[secondIndex]) < 0;
    }

    private double c(int compareCount) {
        return compareCount/(array.length * Math.log(array.length)/Math.log(2));
    }

}
