class Solution {
    public int pivotIndex(int[] nums) {
        int totalsum = 0;

        for (int num : nums) {
            totalsum += num;
        }

        int leftsum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalsum -= nums[i];

            if (leftsum == totalsum) {
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }
}