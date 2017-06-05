package exersize8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * Class representing a binary tree storing only key values (like sets). This class does not provide
 * any operations changing the tree, as any dynamic operations have to be provided by the subclasses
 * adding additional restrictions.
 * 
 * @author katz.bastian
 *
 * @param <T>
 *          type of key values
 */
public class BinaryTree<T> {

  /** Root node of the tree, may be null for empty tree. */
  // protected to ease access from subclasses (for training only)
  protected TreeNode<T> root;

  /**
   * Constructor to define from an existing structure of {@link TreeNode}s.
   * 
   * @param root
   *          root node
   */
  public BinaryTree(TreeNode<T> root) {
    this.root = root;
  }

  /**
   * Constructor to define an empty tree.
   */
  public BinaryTree() {
    // intentionally left blank.
  }

  /* Query operations */

  /**
   * @return number of leaves of the tree.
   */
  public int getLeafCount() {
    return getLeafCount(root);
  }

    /**
     * Helper method. Recursively calculates the amount of leave in the tree.
     *
     * @param node Current node.
     * @return Amount of the leave in the tree.
     */
    private int getLeafCount(TreeNode<T> node) {
        // Am Ende des Baumes
        if (node == null)
            return 0;
        // Hat der aktuelle Knoten noch Kinder
        else if (node.left != null || node.right != null)
            return getLeafCount(node.left) + getLeafCount(node.right);
        // Wenn nicht, dann ist der aktuelle Knoten ein Blatt
        else
            return 1;
    }

  /**
   * @param element
   *          key
   * @return true if the key is contained in the tree, false otherwise.
   */
  public boolean contains(T element) {
    return contains(root, element);
  }

    /**
     * Rekursiv abfragen, ob der Baum ein bestimmtes Wert beinhaltet.
     *
     * @param node Der aktuelle Knoten.
     * @param element Der abgefragte Wert.
     * @return True, wenn der Wert gefunden ist.
     */
  private boolean contains(TreeNode<T> node, T element) {
      // Am Ende des Baumes
      if (node == null)
          return false;
      // Aktueller Knoten und rekursiv alle Kindknoten abfragen, ob sein Wert mit dem gefragten übereinstimmt.
      else
          return contains(node.left, element) || contains(node.right, element) || node.data.equals(element);
  }

  /**
   * @return number of nodes in the tree.
   */
  public int getSize() {
    return getSize(root);
  }

  /**
   * Helper method. Recursively calculates the number of nodes in the (sub)tree.
   * 
   * @param node
   *          tree node
   * @return number of nodes in the subtree of the given node
   */
  private int getSize(TreeNode<T> node) {
    if (node == null) {
      return 0;
    }
    return 1 + getSize(node.left) + getSize(node.right);
  }

  /**
   * Calculates the height of the tree. By definition, the empty tree has height 0, a tree with one
   * node has height 1.
   * 
   * @return the height of the tree.
   */
  public int getHeight() {
    return getHeight(root);
  }

  /**
   * Helper method. Recursively calculates the height of a (sub)tree.
   * 
   * @param node
   *          tree node
   * @return height of the subtree of the given node.
   */
  private int getHeight(TreeNode<T> node) {
    if (node == null) {
      return 0;
    }
    return 1 + Math.max(getHeight(node.left), getHeight(node.right));
  }

  /* Traversal operations. */

  /**
   * Applies an operation on all nodes in the tree in level-order.
   * 
   * @param operation
   *          operation to be applied to all nodes
   */
  public void visitNodesBfs(Consumer<T> operation) {
    Queue<TreeNode<T>> bfsQueue = new LinkedList<>();

    // Initial wartet nur die Wurzel
    bfsQueue.add(root);

    // Solange noch Knoten warten
    while (!bfsQueue.isEmpty()) {

      // Nimm nächsten Knoten
      TreeNode<T> node = bfsQueue.remove();
      if (node != null) {
        // Bearbeite Knoten
        operation.accept(node.data);

        // Füge Kinder in Schlange ein
        bfsQueue.add(node.left);
        bfsQueue.add(node.right);
      }
    }
  }

  /**
   * Applies an operation on all nodes in the tree in pre-, in- or post-order, i.e. in any order
   * produces by depth-first-search.
   * 
   * @param operation
   *          operation to be applied to all nodes
   * @param order
   *          defines in which order the operation is applied to the node and the subtrees
   */
  public void visitNodesDfs(Consumer<T> operation, DfsOrder order) {
    visitNodesDfs(root, operation, order);
  }

  /**
   * Helper method to recursively apply an operation on all nodes in the tree in pre-, in- or
   * post-order, i.e. in any order produces by depth-first-search.
   * 
   * @param node
   *          tree node
   * @param operation
   *          operation to be applied to all nodes in the subtree of the given node
   * @param order
   *          defines in which order the operation is applied to the node and the subtrees
   */
  private void visitNodesDfs(TreeNode<T> node, Consumer<T> operation, DfsOrder order) {
    if (node != null) {

      // start with the node in pre-order
      if (order == DfsOrder.PREORDER) {
        operation.accept(node.data);
      }

      // recursively visit nodes in left subtree
      visitNodesDfs(node.left, operation, order);

      // for in-order, apply operation to node between recursive calls
      if (order == DfsOrder.INORDER) {
        operation.accept(node.data);
      }

      // recursively visit nodes in right subtree
      visitNodesDfs(node.right, operation, order);

      // end with the node in post-order
      if (order == DfsOrder.POSTORDER) {
        operation.accept(node.data);
      }
    }
  }

}
