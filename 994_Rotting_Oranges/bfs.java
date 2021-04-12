class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        Queue<Cell> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    queue.offer(new Cell(i, j));
            }
        }
        
        int res = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Cell cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur.i + dir[0], y = cur.j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new Cell(x, y));
                    }
                }
            }
            res++;
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return res == -1 ? 0 : res;
    }
    
    class Cell {
        int i, j;
        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}