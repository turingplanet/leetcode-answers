class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        
        int index = 0;
        for (int x : set) {
            nums[index++] = x;
        }
        
        return set.size();
    }
}