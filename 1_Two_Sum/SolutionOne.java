import java.util.*;

public class SolutionOne {

    public static void main(String[] args) {
        int[] input = new int[]{2, 7, 11, 15};
        SolutionOne s1 = new SolutionOne();
        System.out.println(Arrays.toString(s1.twoSum(input, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.containsKey(target - nums[i])) {
                result[0] = set.get(target - nums[i]);
                result[1] = i;
            }
            set.put(nums[i], i);
        }
        return result;
    }
}