package exersize5;

/**
 * Implementierung von StupidSort aka GnomeSort.
 *
 * @author katz.bastian
 *
 * @param <T> Vergleichbarer Typ.
 */
public class GnomeSorter<T extends Comparable<T>> extends Sorter<T> {

    @Override
    protected String name() {
        return "GnomeSort";
    }

    @Override
    protected void sort() {
        int pos = 0;
        while (pos < inputSize()) {
            if (pos == 0 || lessOrEqual(pos - 1, pos)) {
                pos++;
            } else {
                swap(pos, pos - 1);
                pos--;
            }
        }
    }

}