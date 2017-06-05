package exersize8;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

  private BinarySearchTree<Character> createInstance(String fromString) {
    BinarySearchTree<Character> tree = new BinarySearchTree<>();
    for (Character c: fromString.toCharArray()) {
      tree.insert(c);
    }
    return tree;
  }
  
  @Test
  public void testInsert() {
    BinarySearchTree<Character> tree = new BinarySearchTree<>();
    tree.insert('A');
    tree.insert('L');
    tree.insert('G');
    tree.insert('O');
    tree.insert('R');
    tree.insert('I');
    tree.insert('T');
    tree.insert('H');
    tree.insert('M');
    tree.insert('U');
    tree.insert('S');
    StringBuilder sb = new StringBuilder();
    tree.visitNodesDfs(sb::append, DfsOrder.PREORDER);
    Assert.assertEquals("ALGIHOMRTSU", sb.toString());
    
    sb = new StringBuilder();
    tree.visitNodesDfs(sb::append, DfsOrder.POSTORDER);
    Assert.assertEquals("HIGMSUTROLA", sb.toString());
  }
  
  @Test
  public void testFloor() {
    Assert.assertEquals(Character.valueOf('I'), createInstance("ALGORITHMUS").floor('K'));
  }

  @Test
  public void testNonExistingFloor() {
    Assert.assertEquals(null, createInstance("XLGORITHMUS").floor('A'));
  }
  
  @Test
  public void testContainsPositive() {
    Assert.assertTrue(createInstance("ALGORITHMUS").contains('H'));
  }
  
  @Test
  public void testContainsNegative() {
    Assert.assertFalse(createInstance("ALGORITHMUS").contains('Y'));
  }

}
