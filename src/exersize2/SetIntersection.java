package exersize2;

import java.util.Random;

/**
 * Created by Pantheha on 3/26/2017.
 */
public class SetIntersection {

    private static int countIntersectionUnsorted(int[] unsorted, int[] unsorted2) {
        int count = 0;
        for (int i: unsorted) {
            for (int j: unsorted2) {
                if (i == j) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int countIntersectionOneInputOrdered(int[] unsorted, int[] sorted) {
        int count = 0;
        int lo;
        int hi;
        for (int i: unsorted) {
            lo = 0;
            hi = sorted.length-1;
            while (lo <= hi) {
                int m = (lo + hi) / 2;
                if (sorted[m] == i) {
                    count++;
                    break;
                }
                if (sorted[m] > i)
                    hi = m - 1;
                if (sorted[m] < i)
                    lo = m + 1;
            }
        }
        return count;
    }

    private static int countIntersectionOrdered(int[] sorted, int[] sorted2) {
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < sorted.length && j < sorted2.length) {
            if (sorted[i] < sorted2[j]) {
                i++;
                continue;
            }
            if (sorted[i] > sorted2[j]) {
                j++;
                continue;
            }
            if (sorted[i] == sorted2[j]) {
                count++;
                i++;
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("                10.000 Elements | 100.000 Elements | 1.000.000 Elements | 10.000.000 Elements");
        System.out.printf("Sorted        | %14fs | %15fs | %17fs | %18fs\n", time("sorted", 10000), time("sorted", 100000), time("sorted", 1000000), time("sorted", 10000000));
        System.out.printf("OneInputSorted| %14fs | %15fs | %17fs | %18fs\n", time("oneInputSorted", 10000), time("oneInputSorted", 100000), time("oneInputSorted", 1000000), time("oneInputSorted", 10000000));
        System.out.printf("Unsorted      | %14fs | %15fs | %17fs | %18fs\n", time("unsorted", 10000), time("unsorted", 100000), time("unsorted", 1000000), time("unsorted", 10000000));
    }

    private static int[] randomSorted(int size) {
        Random r = new Random();
        int[] result = new int[size];
        int randomValue = 0;
        for (int i = 0; i < size; i++) {
            randomValue += 1 + r.nextInt(10);
            result[i] = randomValue;
        }
        return result;
    }

    private static int[] randomUnsorted(int size) {
        Random r = new Random();
        int[] result = randomSorted(size);
        for (int i = 0; i < size; i++) {
            int randomIndex = i + r.nextInt(size - i);
            int swap = result[i];
            result[i] = result[randomIndex];
            result[randomIndex] = swap;
        }
        return result;
    }

    private static double time(String type, int elements) {
        int[] firstUnsorted = randomUnsorted(elements);
        int[] secondUnsorted = randomUnsorted(elements);
        int[] firstSorted = randomSorted(elements);
        int[] secondSorted = randomSorted(elements);
        long start = System.currentTimeMillis();
        long end;
        switch (type) {
            case ("unsorted") : countIntersectionUnsorted(firstUnsorted, secondUnsorted);
                break;
            case ("oneInputSorted") : countIntersectionOneInputOrdered(firstUnsorted, firstSorted);
                break;
            case ("sorted") : countIntersectionOrdered(firstSorted, secondSorted);
                break;
            default: return 0;
        }
        end = System.currentTimeMillis();
        return (end - start)/1000.0;
    }

}
