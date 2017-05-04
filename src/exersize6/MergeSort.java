package exersize6;

/**
 * Implementierung von StupidSort aka GnomeSort.
 *
 * @author katz.bastian
 *
 * @param <T>
 *            Vergleichbarer Typ.
 */
public class MergeSort<T extends Comparable<T>> extends Sorter<T> {

    @Override
    protected String name() {
        return "MergeSort";
    }

    @Override
    protected void sort() {
        sort(0, inputSize() - 1);
    }

    public void sort(int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            sort(lo, mid-1);
            sort(mid , hi);
            merge(lo, mid, hi);
        }
    }

    void merge(int lo, int mid, int hi) {
        int len = hi - lo + 1;
        int[] temp = new int[len];
        for (int k = 0, li = lo, re = mid; k < len; k++)
            if ((li < mid) && ((re > hi) || less(li, re))) {
                temp[li-lo] = k;
                li++;
            } else {
                temp[re-lo] = k;
                re++;
            }
        for (int k = 0; k < len; k++) {
            while (temp[k]!=k) {
                swap(lo+k, lo+temp[k]);
                int t = temp[k];
                temp[k] = temp[temp[k]];
                temp[t] = t;
            }
        }
    }

}
