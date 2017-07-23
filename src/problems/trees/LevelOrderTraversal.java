package problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {
	
	public static  ArrayList<Integer> levelOrder(BinaryTreeNode root){
        if(root == null){
            System.out.println("Please enter a valid tree!");
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        while(queue.size() > 0){
            root = queue.poll();
            result.add(root.data);
            if(root.left != null){
                queue.add(root.left);
            }
            if(root.right != null){
                queue.add(root.right);
            }
        }
		return result;
    }
	
	public static  void levelOrderReverse(BinaryTreeNode root){
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        queue.offer(root);
        while(queue.size() > 0){
            root = queue.poll();
            stack.push(root);
            if(root.left != null){
                queue.add(root.left);
            }
            if(root.right != null){
                queue.add(root.right);
            }
            
        }
        
        while(!stack.isEmpty()){
        	System.out.println(stack.pop().data);
        	
        }

	}
	
	public static void main(String args[]) {
		BinaryTreeNode node = new BinaryTreeNode(1);
		node.left = new BinaryTreeNode(2);
		node.right = new BinaryTreeNode(3);
		node.left.left = new BinaryTreeNode(4);
		node.left.right = new BinaryTreeNode(5);
		node.right.left = new BinaryTreeNode(6);
		node.right.right = new BinaryTreeNode(7);
		
		System.out.println(levelOrder(node).toString());
		levelOrderReverse(node);
		

}
}