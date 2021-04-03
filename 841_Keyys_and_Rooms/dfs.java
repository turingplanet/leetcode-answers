class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> visited = new HashSet<>();
        
        dfs(rooms, visited, 0);
        
        return visited.size() == n;
    }
    
    private void dfs(List<List<Integer>> edges, Set<Integer> visited, int room) {
        if (visited.contains(room)) {
            return;
        }
        
        visited.add(room);
        for (int nei : edges.get(room)) {
            dfs(edges, visited, nei);
        }
    }
}