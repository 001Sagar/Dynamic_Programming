import java.util.HashMap;

class Solution {
    public int rob(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = helper(nums, 0, map);

        return ans;
    }

    public int helper(int[] nums, int index, HashMap<Integer, Integer> map) {
        // Base Case
        if (index >= nums.length) {
            return 0;
        }

        // if map contains the index
        if (map.containsKey(index)) {
            return map.get(index);
        }

        // Include the Current Index
        int include = nums[index] + helper(nums, index + 2, map);

        int exclude = helper(nums, index + 1, map);

        int ans = Math.max(include, exclude);

        map.put(index, ans);

        return ans;
    }
}