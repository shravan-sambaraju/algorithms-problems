package problems.trees;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathEqualsSum {
	
	 public  boolean printPath(BinaryTreeNode root, int sum, List<BinaryTreeNode> path){
	        if(root == null){
	            return false;
	        }

	        if(root.left == null && root.right == null){
	            if(root.data == sum){
	                path.add(root);
	                return true;
	            }else{
	                return false;
	            }
	        }
	        if(printPath(root.left, sum-root.data, path) || printPath(root.right, sum - root.data, path)){
	            path.add(root);
	            return true;
	        }
	        return false;
	    }
	 
	 public static void main(String args[]) {
			BinaryTreeNode node = new BinaryTreeNode(1);
			node.left = new BinaryTreeNode(2);
			node.right = new BinaryTreeNode(3);
			node.left.left = new BinaryTreeNode(4);
			node.left.right = new BinaryTreeNode(5);
			node.right.left = new BinaryTreeNode(6);
			node.right.right = new BinaryTreeNode(7);
			
			  List<BinaryTreeNode> resultList = new ArrayList<BinaryTreeNode>();
			  
			  RootToLeafPathEqualsSum rtsum = new RootToLeafPathEqualsSum();
			  
			  boolean result = rtsum.printPath(node,10,resultList);
			  
			  if(result){
				  resultList.forEach(BinaryTreeNode -> System.out.print(BinaryTreeNode.data + " "));
		        }else{
		            System.out.println("No path for sum " + 10); 
		        }

}
}