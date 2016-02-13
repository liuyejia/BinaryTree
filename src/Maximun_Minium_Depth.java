import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution {
   //Using BFS method to find the minimum depth of binary tree
   public int minDepth_BFS(TreeNode root) {
      if(root==null)
        return 0;
        int depth=1,currentLevel=1,nextLevel=0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node=queue.remove();
            currentLevel--;
            if(node.left==null&&node.right==null)
              return depth;
            if(node.left!=null)
            {
                queue.add(node.left);
                nextLevel++;
            }
            if(node.right!=null)
            {
                queue.add(node.right);
                nextLevel++;
            }
            //nodes in the currentLeval were all visited 
            if(currentLevel==0)
             if(nextLevel!=0)
             {
                 
                 depth++;
                 
             }
             
             curretLevel=nextLevel;
             nextLevel=0;
        }
         return depth;   
           
           
       }
      
      //Using recursion to find Minimum depth of binary tree
       public int minDep_Recur(TreeNode root)
       {
           if(root==null)
             return 0;
          if(root.left==null&&root.right==null)
            return 1;
          else
          {
              int leftDep=root.left!=null?minDep(root.left):Integer.MAX_VALUE;
              int rightDep=root.right!=null?minDep(root.right):Integer.MAX_VALUE;
              return Math.min(leftDep,rightDep)+1;
          }
         
       }
     
    

     //Using recursion to find Maximum depth of binart Tree
     public int maxDepth(TreeNode root) {
        if(root==null)
         return 0;
        if(root.left==null&&root.right==null)
          return 1;
        // int min=1;
         int leftDep=root.left!=null?maxDepth(root.left):Integer.MIN_VALUE;
         int rightDep=root.right!=null?maxDepth(root.right):Integer.MIN_VALUE;
         return Math.max(leftDep,rightDep)+1;
    }


    }
