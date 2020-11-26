class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String w1 : wordList) {
            Set<String> neis = new HashSet<>();
            for (String w2 : wordList) {
                if (oneChange(w1, w2)) {
                    neis.add(w2);
                }
            }
            map.put(w1, neis);
        }
        
        Set<String> neis = new HashSet<>();
        for (String w : wordList) {
            if (oneChange(beginWord, w)) {
                neis.add(w);
            }
        }
        map.put(beginWord, neis);
        
        if (!map.containsKey(endWord)) {
            return new ArrayList<>();
        }
        
        Queue<String> queue = new LinkedList<>();
        Map<String, List<String>> parents = new HashMap<>();
        queue.offer(beginWord);
        parents.put(beginWord, null);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<String, List<String>> tmp_parents = new HashMap<>();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String nei : map.get(cur)) {
                    if (!parents.containsKey(nei)) {
                        if (!tmp_parents.containsKey(nei)) {
                            queue.offer(nei);
                        }
                        tmp_parents.computeIfAbsent(nei, k -> new ArrayList<>()).add(cur);
                    }
                }
            }
            parents.putAll(tmp_parents);
            
            if (tmp_parents.containsKey(endWord)) {
                List<List<String>> res = new ArrayList<>();
                List<String> tmp = new LinkedList<>();
                tmp.add(endWord);
                dfs(res, parents, endWord, beginWord, tmp);
                return res;
            }
        }
        
        return new ArrayList<>();
    }
    
    private void dfs(List<List<String>> res, Map<String, List<String>> parents, String w, String beginWord, List<String> cur) {
        if (w.equals(beginWord)) {
            res.add(new ArrayList<>(cur)); 
            return;
        }
        
        for (String prev : parents.get(w)) {
            cur.add(0, prev);
            dfs(res, parents, prev, beginWord, cur);
            cur.remove(0);
        }
    }
    
    
    private boolean oneChange(String w1, String w2) {
        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}