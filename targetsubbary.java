import java.util.HashMap;

public class targetsubbary {
    public static int findTargetSumWays(int[] nums, int target) {

        int ans = findTargetSumWayshelper(nums, 0, target);

        return ans;
    }

    public static int findTargetSumWayshelper(int[] nums, int index, int target) {
        // Check Base Case
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }

        // Include with a +ive
        int include = findTargetSumWayshelper(nums, index + 1, target - nums[index]);

        // Exclude with a -ive
        int exclude = findTargetSumWayshelper(nums, index + 1, target + nums[index]);

        return include + exclude;
    }

    public int findTargetSumWaysmemoization(int[] nums, int target) {

        HashMap<String, Integer> map = new HashMap<>();
        int ans = findTargetSumWaymemoizationshelper(nums, 0, target, map);

        return ans;
    }

    public int findTargetSumWaymemoizationshelper(int[] nums, int index, int target , HashMap<String, Integer> map) {
        // Check Base Case
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }

        // Create a unique key for String and target
        String key = index + "," + target;

        // If the index is already present in the map
        if(map.containsKey(key)){
            return map.get(key);
        }

        // Include with a +ive
        int include = findTargetSumWaymemoizationshelper(nums, index + 1, target - nums[index], map);

        // Exclude with a -ive
        int exclude = findTargetSumWaymemoizationshelper(nums, index + 1, target + nums[index], map);

        int ans = include + exclude;

        map.put(key , ans);

        return ans;
    }

    public static void main(String[] args) {

    }
}
