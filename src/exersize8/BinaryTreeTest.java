package exersize8;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

  private BinaryTree<Character> createTestInstance() {
    return new BinaryTree<>(
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
  }
  
  @Test
  public void testSize() {
    Assert.assertEquals(11, createTestInstance().getSize());
  }

  @Test
  public void testHeight() {
    Assert.assertEquals(4, createTestInstance().getHeight());
  }
  
  @Test
  public void testLeafCount() {
    Assert.assertEquals(5, createTestInstance().getLeafCount());
  }
  
  @Test
  public void testContainsPositive() {
    Assert.assertTrue(createTestInstance().contains('H'));
  }
  
  @Test
  public void testContainsNegative() {
    Assert.assertFalse(createTestInstance().contains('Y'));
  }
  
  @Test
  public void testInOrder() {
    StringBuilder sb = new StringBuilder();
    createTestInstance().visitNodesDfs(sb::append, DfsOrder.INORDER);
    Assert.assertEquals("AGLOSRTIUHM", sb.toString());
  }
  
  @Test
  public void testPreOrder() {
    StringBuilder sb = new StringBuilder();
    createTestInstance().visitNodesDfs(sb::append, DfsOrder.PREORDER);
    Assert.assertEquals("SOGALUTRIMH", sb.toString());
  }
  
  @Test
  public void testPostOrder() {
    StringBuilder sb = new StringBuilder();
    createTestInstance().visitNodesDfs(sb::append, DfsOrder.POSTORDER);
    Assert.assertEquals("ALGORITHMUS", sb.toString());
  }
  
  @Test
  public void testLevelOrder() {
    StringBuilder sb = new StringBuilder();
    createTestInstance().visitNodesBfs(sb::append);
    Assert.assertEquals("SOUGTMALRIH", sb.toString());
  }

}
