class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        if (m == 0 || n == 0) {
            return res;
        }
        
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> heap = new PriorityQueue<>((a, b) -> (nums1[a.i] + nums2[a.j]) - (nums1[b.i] + nums2[b.j]));
        heap.offer(new Cell(0, 0));
        visited[0][0] = true;
        
        while (k > 0 && !heap.isEmpty()) {
            Cell top = heap.poll();
            res.add(Arrays.asList(nums1[top.i], nums2[top.j]));
            
            Cell nei = new Cell(top.i + 1, top.j);
            if (nei.i < m && !visited[nei.i][nei.j]) {
                visited[nei.i][nei.j] = true;
                heap.offer(nei);
            }
            
            nei = new Cell(top.i, top.j + 1);
            if (nei.j < n && !visited[nei.i][nei.j]) {
                visited[nei.i][nei.j] = true;
                heap.offer(nei);
            }
            
            k--;
        }
        
        return res;
    }
    
    class Cell {
        int i, j;
        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}