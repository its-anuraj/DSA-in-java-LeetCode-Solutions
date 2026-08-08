class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = -1;
        int smax = -1;
        int maxIndex = -1;

        for (int i = 0; i < n; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;

            }
        }

        for (int i = 0; i < n; i++) {
            if (smax < nums[i] && i != maxIndex) {
                smax = nums[i];
            }
        }
        return (max - 1) * (smax - 1);
    }
}