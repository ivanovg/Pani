package exersize8;

public class BinarySearchTreeDemo {

  public static void main(String[] args) {

    // create tree
    BinaryTree<Character> tree = new BinaryTree<>(
        new TreeNode<>('S',
          new TreeNode<>('O',
              new TreeNode<>('G', 
                  new TreeNode<>('A', null, null), 
                  new TreeNode<>('L', null, null)),
              null),
          new TreeNode<>('U',
              new TreeNode<>('T', 
                  new TreeNode<>('R', null, null), 
                  new TreeNode<>('I', null, null)),
              new TreeNode<>('M', 
                  new TreeNode<>('H', null, null), 
                  null))));

    // output queries

    System.out.print("PRE-ORDER:   ");
    tree.visitNodesDfs(System.out::print, DfsOrder.PREORDER);
    System.out.println();

    System.out.print("IN-ORDER:    ");
    tree.visitNodesDfs(System.out::print, DfsOrder.INORDER);
    System.out.println();

    System.out.print("POST-ORDER:  ");
    tree.visitNodesDfs(System.out::print, DfsOrder.POSTORDER);
    System.out.println();

    System.out.print("LEVEL-ORDER: ");
    tree.visitNodesBfs(System.out::print);
    System.out.println();

    System.out.println("TREE HEIGHT: " + tree.getHeight());
    System.out.println("NODE COUNT:  " + tree.getSize());
    System.out.println("LEAF COUNT:  " + tree.getLeafCount());
  }

}
