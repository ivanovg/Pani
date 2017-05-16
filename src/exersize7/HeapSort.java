package exersize7;

/**
 * Created by Panteha on 5/15/2017.
 */
public class HeapSort<T extends Comparable<T>> extends Sorter<T> {

    @Override
    protected String name() {
        return "HeapSort";
    }

    @Override
    protected void sort() {
        // mache ein Heap aus dem eingegebenen Array
        makeHeap();

        System.out.println(this + "   =>   makeHeap\n");

        // sortiere von rechts nach links
        for (int index = inputSize() - 1; index > 0; index--) {

            // das groesste Element (der Wurzel) wird am Ende des zu sortieren verbleibenen Arrayteils verschoben und
            // das neue root Element wird durch sink an die richtige Stelle gebracht
            deleteMax(index);
            System.out.println(this + "   =>   deleteMax and sink");
        }
    }

    /**
     * Propagiert das Element an dem angegebenen Index nach hinten im Array, so dass das Heap-Eigenschaft erhalten wird.
     *
     * @param index Index vom Element der verschoben wird.
     * @param size Letzter Index im Array
     */
    private void sink(int index, int size) {
        // Anfangsbelegung vom root Element gleich der angegebene Index
        int rootIndex = index;
        int childIndex;
        // Haltet fest mit welschem Kindelement vertascht wird.
        int newIndex;

        // So lange es ein linkes Kindelement gibt
        while (2 * rootIndex + 1 <= size) {
            childIndex = 2 * rootIndex + 1; // Index von Kind Element
            newIndex = rootIndex;           // Der neue root Index ist zunaechst das alte

            // Wenn das linke Kindelement groesser als das root Element ist, wird der neue root Index der Index vom linken Kindelement zugewiesen.
            if (less(newIndex, childIndex))
                newIndex = childIndex;

            // Wenn es ein rechtes Kindelement gibt und es auch groesser als das linke Kindelement ist,
            // wird das neue root Index der Index vom rechten Kindelement zugewiesen.
            if (childIndex + 1 <= size && less(newIndex, childIndex + 1))
                newIndex = childIndex + 1;

            // Wenn das neue root Index gleich der alte geblieben ist,
            // ist das "Sinken" fertig.
            if (newIndex == rootIndex)
                return;

            // Sonst vertausche das alte root Element mit dem neuen
            // Der alte root Index wird mit dem neuen ersetzt
            else {
                swap(rootIndex, newIndex);
                rootIndex = newIndex;
            }
        }
    }

    /**
     * Erstellt eine Heap-Struktur mit der sink Methode.
     */
    private void makeHeap() {
        // Von hinten nach vorne wird jedes Element, der auch Kindelemente hat an der richtige Stelle "gesunken".
        // (inputSize - 2) / 2 => das letzte Element mit Kinder Elemente
        for (int index = (inputSize() - 2) / 2; index >= 0; index--) {
            sink(index, inputSize() - 1);
        }
    }

    /**
     * Vertauscht das Element and der Stelle 0 mit dem Element an der Stelle size.
     * Der neue Element an der Stelle 0 wird durch sink and der richtige Position gebracht.
     *
     * @param size An diese Stelle wird das Element an der Stelle 0 verschoben.
     */
    private void deleteMax(int size) {
        swap(0, size);
        sink(0, size - 1);
    }

}

