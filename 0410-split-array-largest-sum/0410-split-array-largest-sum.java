class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int greatest_value = 0;
        int whole_sum = 0;

        for (int i = 0; i < n; i++) {
            whole_sum += nums[i];
            if (nums[i] > greatest_value) {
                greatest_value = nums[i];
            }

        }

        int start = greatest_value;
        int end = whole_sum;

        while (start < end) {
            int pieces = 1;
            int mid = start + (end - start) / 2;
            int subArray_sum = 0;
            for (int i = 0; i < n; i++) {
                if (subArray_sum + nums[i] <= mid) {
                    subArray_sum += nums[i];
                } else {
                    pieces++;
                    subArray_sum = nums[i];
                }
            }

            if (pieces <= k) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }
        return start;

    }
}