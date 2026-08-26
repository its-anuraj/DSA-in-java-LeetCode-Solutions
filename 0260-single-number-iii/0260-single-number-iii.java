class Solution {
    public int[] singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        int diffBit = ans & (-ans);

        int a = 0;
        int b = 0;

        for (int num : nums) {
            if ((num & diffBit) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[] { a, b };
    }
}