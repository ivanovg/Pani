package exersize4.disjointset;

/**
 * Created by Georgi on 4/20/2017.
 */
public class DisjointSet {

    int[] disjointSet;
    /**
     * Erzeugt eine Disjoint-Set Datenstruktur für die Zahlen 0 bis size-1.
     *
     * Datenstruktur ist in einem Array repräsentiert. Jeder Index korespondiert
     * zu den den Zahlen von 0 bis size-1 und der Wert unter jedem Index ist die
     * Nummer der Gruppe, zu der die Zahl gehört.
     *
     * @param size
     *            Größe der Datenstruktur.
     */
    public DisjointSet(int size) {
        disjointSet = new int[size];
        for (int i = 0; i < size; i++) {
            disjointSet[i] = i;
        }
    }

    /**
     * Liefert zur Zahl a die kleinste Zahl, die in derselben Gruppe ist wie a
     *
     * @param a
     *            Eingabe
     * @return Kleinste Zahl (Repräsentant) in der Gruppe von a.
     */
    public int find(int a) {
        // laufe durch den DisjointSet und bis eine Zahl gefunden ist, die die selbe Gruppennummer
        // hat wie a. Da die Zahlen aufsteigend geordnet sind, ist a die kleinste Zahl, wenn bis dahin
        // keine andere Zahl gefunden ist.
        for (int i = 0; i < a; i++) {
            if (disjointSet[i] == disjointSet[a])
                return i;
        }
        return a;
    }

    /**
     * Verschmilzt die Gruppen von a und b
     * Die neue Gruppennummer ist die Gruppennummer von a
     *
     * @param a verwaltete Zahl
     * @param b verwaltete Zahl
     */
    public void union(int a, int b) {
        int groupNumberNew = disjointSet[a];
        int groupNumberOld = disjointSet[b];
        for (int i = 0; i < disjointSet.length; i++) {
            if (disjointSet[i] == groupNumberOld)
                disjointSet[i] = groupNumberNew;
        }
    }

    /**
     * Liefert ein boolean Ergebnis, ob zwei Zahlen in der selbe Gruppe sind.
     *
     * @param a Erste Zahl
     * @param b Zweite Zahl
     *
     * @return Boolean Ergebnis, ob zwei Zahlen in der selbe Gruppe sind
     */
    public boolean areTheSameGroup(int a, int b) {
        if (disjointSet[a] == disjointSet[b])
            return true;
        else
            return false;
    }

}
