class Solution {
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        int max = -1;
        int maxIndex = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }

        }

        for (int i = 0; i < n; i++) {
            int product = nums[i] * 2;
            if (maxIndex != i && max < product) {
                return -1;

            }

        }
        return maxIndex;
    }
}