class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    
    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
    }
}