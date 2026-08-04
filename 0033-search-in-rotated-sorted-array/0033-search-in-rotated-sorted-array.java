class Solution {
    public int search(int[] nums, int target) {

        int pivot = FindPivotInArray(nums);

       
        if (pivot == -1) {
            return FindTarget(nums, 0, nums.length - 1, target);
        }

         if (nums[pivot] == target) {
            return pivot;
        }


        int firstHalf = FindTarget(nums, 0, pivot - 1, target);
        if (firstHalf != -1) {
            return firstHalf;
        }
        return FindTarget(nums, pivot + 1, nums.length - 1, target);

    }

    int FindPivotInArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid < right && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (mid > left && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            if (nums[mid] >= nums[left]) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }

        }
        return -1;
    }

    int FindTarget(int[] nums, int left, int right, int target) {

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = nums[mid];

            if (value == target) {
                return mid;
            }

            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }
}