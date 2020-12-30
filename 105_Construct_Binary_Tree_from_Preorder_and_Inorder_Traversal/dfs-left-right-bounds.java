class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> in_map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            in_map.put(inorder[i], i);
        }
        return dfs(preorder, in_map, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode dfs(int[] pre, Map<Integer, Integer> in_map, int prel, int prer, int inl, int inr) {
        if (inl > inr) {
            return null;
        }
        
        TreeNode root = new TreeNode(pre[prel]);
        
        int root_position = in_map.get(root.val);
        int left_subtree_len = root_position - inl;
        
        root.left = dfs(pre, in_map, prel + 1, prel + left_subtree_len, inl, root_position - 1);
        root.right = dfs(pre, in_map, prel + left_subtree_len + 1, prer, root_position + 1, inr);
        return root;
    }
}