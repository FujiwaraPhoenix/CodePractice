import java.util.Arrays;
import java.util.HashMap;

//Arrays is imported for the convenience of answer confirmation.
//HashMap is used to solve the question in O(n) time.
public class Solution01 {
	public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] output = new int[2];
        for (int i = 0; i < nums.length; i++) {
        	/*
        	System.out.println("Checking index " + i);
        	System.out.println("Checking for " + (target-nums[i]) + " in map.");
        	System.out.println(hm.containsKey(target-nums[i]));
        	*/
        	if (hm.containsKey(target-nums[i])) {
        		return new int[]{hm.get(target-nums[i]), i};
        	}
        	else {
        		hm.put(nums[i], i);
        	}
        }
        return output;
    }
	
	public static void main(String[] args) {
		Solution01 sol01 = new Solution01();
		int[] testA = new int[] {2,7,11,15};
		System.out.println(Arrays.toString(sol01.twoSum(testA, 9)));
		int[] testB = new int[] {3,2,4};
		System.out.println(Arrays.toString(sol01.twoSum(testB, 6)));
		int[] testC = new int[] {3,3};
		System.out.println(Arrays.toString(sol01.twoSum(testC, 6)));
		
	}
}
