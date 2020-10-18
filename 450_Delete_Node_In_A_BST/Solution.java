class Solution {
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        
        if (root.left == null || root.right == null) {
            return root.left == null ? root.right : root.left;
        } else if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }
        
        TreeNode prev = null, smallest = root.right;
        while (smallest.left != null) {
            prev = smallest;
            smallest = smallest.left;
        }
        
        prev.left = smallest.right;
        smallest.left = root.left;
        smallest.right = root.right;
        return smallest;
    }
    
}