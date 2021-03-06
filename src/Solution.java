//convert sorted list to height-balanced Binary Search Tree
import java.util.*;
public class Solution {
	static ListNode currentHead = null;
    static TreeNode buildTree(int start, int end) {
        if(start>end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode left = buildTree(start, mid-1);
        TreeNode root = new TreeNode(currentHead.val);
        root.left = left;
        currentHead = currentHead.next;
        root.right = buildTree(mid + 1, end);
        return root;
    }
    
    public static TreeNode sortedListToBST(ListNode head) {
        if(head==null) {
            return null;
        }
        currentHead = head;
        int len = 0;
        while(head!=null) {
            len++;
            head = head.next;
        }
        
        return buildTree(0, len-1);
    }
    public static void printBST(TreeNode root)
    {
    	System.out.println(root.val);
    	if(root.left!=null)
    		printBST(root.left);
    	if(root.right!=null)
    		printBST(root.right);
    }
    public static void main(String []args)
    {
    	ListNode head=new ListNode(2);
    	ListNode p1=new ListNode(3);
    	ListNode p2=new ListNode(4);
    	ListNode p3=new ListNode(5);
    	ListNode p4=new ListNode(6);
    	ListNode p5=new ListNode(7);
    	head.next=p1;
    	p1.next=p2;
    	p2.next=p3;
    	p3.next=p4;
    	p4.next=p5;
    	TreeNode newH=sortedListToBST(head);
    	printBST(newH);
    	
    }
}
