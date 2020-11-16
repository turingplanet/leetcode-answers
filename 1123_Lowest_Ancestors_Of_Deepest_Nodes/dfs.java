class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }
    
    private Cell dfs(TreeNode root) {
        if (root == null) {
            return new Cell(null, 0);
        }
        
        Cell left = dfs(root.left);
        Cell right = dfs(root.right);
        if (left.height == right.height) {
            return new Cell(root, left.height + 1);
        } else if (left.height > right.height) {
            return new Cell(left.node, left.height + 1);
        } else {
            return new Cell(right.node, right.height + 1);
        }
    }
    
    class Cell {
        TreeNode node;
        int height;
        Cell(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }
}