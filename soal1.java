import java.util.*;
import java.lang.*;
import java.io.*;


class soal1
{
public static void main(String[] args) {
	int[] nums = {2,7,11,15};
	int target = 22;
	System.out.print("target : ");
	System.out.print(target);
	System.out.println();
	System.out.println();
	System.out.println(Arrays.toString(Find2Sum(nums, target)));
}

private static int[] Find2Sum(int[] nums, int target) {
	Map<Integer, Integer> map = new HashMap<>();
	int max = Integer.MIN_VALUE;
	int[] res = new int[] {-1, -1};
	for(int i=0;i<nums.length;i++) {
		if(map.containsKey(nums[i])) {
			if(nums[i] > max || nums[map.get(nums[i])] > max) {
				res[0] = map.get(nums[i]);
				res[1] = i;
				max = Math.max(nums[i], nums[map.get(nums[i])]);
			}
		}
		map.put(target - nums[i], i);
	}
	return res;
}
}
