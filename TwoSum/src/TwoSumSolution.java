import java.util.HashMap;

public class TwoSumSolution {
	
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the value and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate over the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If it does, return the indices
                return new int[] { map.get(complement), i };
            }
            
            // If it doesn't, add the current number and its index to the map
            map.put(nums[i], i);
        }
        
        // Throw an exception if no solution is found (based on problem statement this won't happen)
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSumSolution solution = new TwoSumSolution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = solution.twoSum(nums, target);
        
        // Print the result
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
