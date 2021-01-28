class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Cell>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String s1 = equations.get(i).get(0), s2 = equations.get(i).get(1);
            graph.computeIfAbsent(s1, k -> new ArrayList<>()).add(new Cell(s2, values[i]));
            graph.computeIfAbsent(s2, k -> new ArrayList<>()).add(new Cell(s1, 1.0 / values[i]));
        }
        
        double[] res = new double[queries.size()];
        Arrays.fill(res, -1.0);
        for (int i = 0; i < queries.size(); i++) {
            dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, graph, res, i, new HashSet<>());
        }
        return res;
    }
    
    private void dfs(String src, String dst, double cur, Map<String, List<Cell>> graph, double[] res, int index, Set<String> visited) {
        if (!visited.add(src)) {
            return;
        }
        if (src.equals(dst) && graph.containsKey(src)) {
            res[index] = cur;
            return;
        }    
        
        for (Cell nei : graph.getOrDefault(src, new ArrayList<>())) {
            dfs(nei.str, dst, cur * nei.div, graph, res, index, visited);
        }
    }
    
    class Cell {
        String str;
        double div;
        
        Cell(String str, double div) {
            this.str = str;
            this.div = div;
        }
    }
}