class Solution {
    public boolean search(int[] nums, int target) {

        int pivot = FindPivot(nums);

        if (pivot == -1) {
            return FindTarget(nums, 0, nums.length - 1, target);
        }

        if (nums[pivot] == target) {
            return true;
        }

        boolean FirstHalf = FindTarget(nums, 0, pivot - 1, target);
        if (FirstHalf) {
            return true;
        }

        return FindTarget(nums, pivot + 1, nums.length - 1, target);

    }

    int FindPivot(int[] nums) {

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

            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {

                if (left < right && nums[left] > nums[left + 1]) {
                    return left;
                }
                left++;

                if (right > left && nums[right] < nums[right - 1]) {
                    return right - 1;
                }
                right--;

            } else if (nums[left] < nums[mid] || (nums[left] == nums[mid] && nums[mid] > nums[right])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }

    boolean FindTarget(int[] nums, int left, int right, int target) {

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = nums[mid];

            if (target == value) {
                return true;
            }

            if (target < value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}