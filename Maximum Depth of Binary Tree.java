/*
	Maximum Depth of Binary Tree 
	Given a binary tree, find its maximum depth.

	The maximum depth is the number of nodes along the longest path 
	from the root node down to the farthest leaf node.
*/

public class Solution {
    public int maxDepth(TreeNode root){
    	if (root == null)
    		return 0;
    	
    	int leftMaxDepth = maxDepth(root.left);
    	int rightMaxDepth = maxDepth(root.right);

    	return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}