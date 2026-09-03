/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> preorderTraversal = new ArrayList<>();
        // recursive
        // preorder(root, preorderTraversal);

        // iterative
        if (root == null)
            return preorderTraversal;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            preorderTraversal.add(current.val);

            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
            
        }

        return preorderTraversal;
    }
}