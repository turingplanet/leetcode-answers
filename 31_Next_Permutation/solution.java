class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return;
        }
        
        int pivot = n - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }
        if (pivot < 0) {
            reverse(nums, 0, n - 1);
            return;
        }
        
        int lg = pivot + 1;
        while (lg < n && nums[lg] > nums[pivot]) {
            lg++;
        }
        swap(nums, pivot, lg - 1);
        reverse(nums, pivot + 1, n - 1);
    }
    
    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
    
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}

