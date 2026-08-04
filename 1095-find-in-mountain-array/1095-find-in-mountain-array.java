/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peak = FindPeakInMountainArray(mountainArr);
        int firstHalf = orderAgnostic(mountainArr, target, 0, peak);
        if (firstHalf != -1) {
            return firstHalf;
        }
        return orderAgnostic(mountainArr, target, peak + 1, n - 1);
    }

    int FindPeakInMountainArray(MountainArray arr) {
        int left = 0;
        int right = arr.length() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr.get(mid) > arr.get(mid + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

    int orderAgnostic(MountainArray arr, int target, int left, int right) {
        boolean asc = arr.get(left) < arr.get(right);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = arr.get(mid);

            if (value == target) {
                return mid;
            }
            if (asc) {
                if (target < value) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target < value) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}