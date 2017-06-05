package exersize8;

/**
 * (Partial) implementation of a binary search tree.
 * 
 * @author katz.bastian
 *
 * @param <T>type
 *          of key values
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

  /**
   * Inserts a key to the search tree (if not already contained).
   * 
   * @param data
   *          key to add.
   */
  public void insert(T data) {
    root = insert(root, data);
  }

    /**
     * Fügt ein neues Element im Baum. Genauer Platz wird rekursiv übermittelt.
     *
     * @param node Der aktuelle Knoten.
     * @param data Das Element, das hinzufügen ist.
     * @return Das eingefügte Element.
     */
  private TreeNode<T> insert(TreeNode<T> node, T data) {
      // Am Ende des Baumes (richtigen Platz)
      if (node == null)
          return new TreeNode<T>(data, null, null);
      // Wenn der einzufügende Wert kleiner als den aktuellen ist weiter im linken Teilbaum den richtigen Platz suchen.
      else if (data.compareTo(node.data) < 0)
          node.left = insert(node.left, data);
      // Sonst weiter im rechten Teilbaum den richtigen Platz suchen.
      else if (data.compareTo(node.data) > 0)
          node.right = insert(node.right, data);
      // Wenn der einzufügende Wert gleich den aktuellen ist passiert nichts.
      return node;
  }

  @Override
  public boolean contains(T data) {
    return contains(root, data);
  }

    /**
     * Fragt rekursiv ab, ob der Baum ein bestimmten Wert beinhaltet.
     *
     * @param node Der aktuelle Knoten.
     * @param data Das abgefragte Wert.
     * @return True, wenn der Baum den gesuchten Wert beinhaltet.
     */
  private boolean contains (TreeNode<T> node, T data) {
      // Am Ende des Baumes
      if (node == null)
          return false;
      // Gesuchter Wert kleiner als den aktuellen => im linken Teilbaum suchen.
      else if (data.compareTo(node.data) < 0)
          return contains(node.left, data);
      // Gesuchter Wert größer als den aktuellen => im rechten Teilbaum suchen.
      else if (data.compareTo(node.data) > 0)
          return contains(node.right, data);
      // Ansonten gefunden.
      else
          return true;
  }


  /**
   * Finds the largest key smaller than a given key.
   * @param data
   *          query key
   * @return the largest key smaller than the query key or null if no such key exists
   */
  public T floor(T data) {
    return floor(root, data);
  }

    /**
     * Findet rekursiv den größten Wert im Baum, der kleinter ist als den angegebenen.
     *
     * @param node Der aktuelle Knoten.
     * @param data Der Wert, mit dem es verglichen wird.
     * @return Der größte Wert im Baum, der kleinter ist als den angegebenen ist, oder null wenn es keinen existiert.
     */
  private T floor(TreeNode<T> node, T data) {
      // Am Ende des Baumes.
      if (node == null)
          return null;
      // Wenn der angegebene Wert größer als den aktuellen ist.
      else if (data.compareTo(node.data) > 0) {
          // wenn es keinen rechten Teilbaum gibt ist der aktuelle Wert der Antwort.
          if (node.right == null)
              return node.data;
          // sonst ist der Antwort der größere wert von aktuellen Wert und der Antwort aus dem rechten Teilbaum
          else
              return max(node.data, floor(node.right, data));
      }
      // Wenn der angegebene Wert kleiner gleich den aktuellen ist.
      else {
          // Wenn es keinen linken Teilbaum gibt, gibt es auch kein passendes Antwort.
          if (node.left == null)
              return null;
          // Sonst wird passendes Antwort im linken Teilbaum gesucht.
          else
              return floor(node.left, data);
      }
  }

    /**
     * Hilfsmethode um den größeren von Zwei Comperable zu ermitteiln. Null Werte werden auch behandelt.
     *
     * @param first Erstes Element.
     * @param second Zweites Element.
     * @return Der größere Element.
     */
  private T max(T first, T second) {
      if (first == null)
          return second;
      if (second == null)
          return first;
      if (first.compareTo(second) > 0)
          return first;
      else
          return second;
  }

}
