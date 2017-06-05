package exersize8;

/**
 * Internal node of binary trees holding a single key/value.
 * 
 * @author katz.bastian
 *
 * @param <T>
 *          key type
 */
public class TreeNode<T> {
  T data;
  TreeNode<T> left;
  TreeNode<T> right;

  TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}
