class Solution {
    public int shortestWay(String source, String target) {
        Map<Character, List<Integer>> map = getCharIndexes(source);
        int res = 1, index = -1;
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            int nextIndex = bsearch(map, ch, index);
            if (nextIndex == -1 && index == -1) {
                return -1;
            } else if (nextIndex == -1) {
                res++;
                index = -1;
                i--;
            } else {
                index = nextIndex;
            }
        }
        return res;
    }
    
    private int bsearch(Map<Character, List<Integer>> map, char ch, int index) {
        if (!map.containsKey(ch))
            return -1;
        List<Integer> array = map.get(ch);
        int l = 0, r = array.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (array.get(mid) <= index)
                l = mid + 1;
            else
                r = mid;
        }
        return array.get(l) > index ? array.get(l) : -1;
    }
    
    private Map<Character, List<Integer>> getCharIndexes(String src) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < src.length(); i++) {
            char ch = src.charAt(i);
            map.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
        }
        return map;
    }
}