class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> in_map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            in_map.put(inorder[i], i);
        }
        return dfs(preorder, in_map, 0, 0, preorder.length);
    }
    
    private TreeNode dfs(int[] pre, Map<Integer, Integer> in_map, int prel, int inl, int len) {
        if (len == 0) {
            return null;
        }
        
        TreeNode root = new TreeNode(pre[prel]);
        
        int root_position = in_map.get(root.val);
        int left_subtree_len = root_position - inl;
        
        root.left = dfs(pre, in_map, prel + 1, inl, left_subtree_len);
        root.right = dfs(pre, in_map, prel + left_subtree_len + 1, root_position + 1, len - left_subtree_len - 1);
        return root;
    }
}