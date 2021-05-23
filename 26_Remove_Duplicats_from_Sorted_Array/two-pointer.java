class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;

        while (fast < nums.length) {
            nums[slow] = nums[fast++];
            while (fast < nums.length && nums[fast] == nums[slow]) {
                fast++;
            }
            slow++;
        }
        
        return slow;
    }
}