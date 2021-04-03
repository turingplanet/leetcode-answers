class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
    
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int nei : rooms.get(cur)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    queue.offer(nei);
                }
            }
        }
        
        return visited.size() == n;
    }
}