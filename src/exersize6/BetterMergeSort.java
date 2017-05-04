package exersize6;

/**
 * Created by Panteha Taherifard on 04.05.17.
 */
public class BetterMergeSort<T extends Comparable> extends Sorter {

    @Override
    protected String name() {
        return "BetterMergeSort";
    }

    @Override
    protected void sort() {
        sort(0, inputSize() - 1);
    }

    private void sort(int lo, int hi) {
        if (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            sort(lo, mid-1);
            sort(mid , hi);

            // Wenn der letzte Element(mid-1) im ersten Array kleiner gleich der erste
            // Element(mid) im zweiten Array ist, wird der Merge uebersprungen.
            if (lessOrEqual(mid-1, mid))
                return;

            merge(lo, mid, hi);
        }
    }

    private void merge(int lo, int mid, int hi) {
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
