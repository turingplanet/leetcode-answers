class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] arr = new int[n * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[i / n][i % n];
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : arr) {
            if (heap.size() < k || x <= heap.peek()) {
                heap.offer(x);
            }
            
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}