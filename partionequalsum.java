import java.util.HashMap;

public class partionequalsum {

    public boolean canPartition(int[] nums) {

        HashMap<String, Boolean> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        return helper(nums, 0, target, map);
    }

    public static boolean helper(int[] nums, int index, int target, HashMap<String, Boolean> map) {
        // Check Base Case
        if (target == 0) {
            return true;
        }

        if (nums.length == index || target < 0) {
            return false;
        }
        // Create a unique key with index and target
        String key = index + "," + target;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        boolean include = helper(nums, index + 1, target - nums[index], map);
        boolean exclude = helper(nums, index + 1, target, map);

        map.put(key, include || exclude);

        return include || exclude;
    }

    public static void main(String[] args) {

    }
}
