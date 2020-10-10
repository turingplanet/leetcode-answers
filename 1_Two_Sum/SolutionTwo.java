import java.util.*;

public class SolutionTwo {

    public static void main(String[] args) {
        int[] input = new int[]{2, 7, 11, 15};
        SolutionTwo s = new SolutionTwo();
        System.out.println(Arrays.toString(s.twoSum(input, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
