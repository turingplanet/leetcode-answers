class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    
    private Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        map.put(node, new Node(node.val));
        Node clone = map.get(node);
        for (Node nei : node.neighbors) {
            clone.neighbors.add(dfs(nei, map));
        }
        return clone;
    }
}