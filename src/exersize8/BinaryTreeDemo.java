package exersize8;

public class BinaryTreeDemo {

  public static void main(String[] args) {
    
    // create tree
    BinarySearchTree<Character> tree = new BinarySearchTree<>();
    for (Character c: "ALGORITHMUS".toCharArray()) {
      tree.insert(c);
    }
  
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
