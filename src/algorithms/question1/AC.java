package algorithms.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * @question: Two Sum
 * 
 * @description:Given an array of integers, return indices of the two numbers
 *                    such that they add up to a specific target.
 *                    给你一个特定的数，从这个数组中找出一对数， 且这两个数相加起来刚 好等于这个特定的数， 返回这两个数的下标。
 * 
 *                    You may assume that each input would have exactly one
 *                    solution. 确保你的输入刚好有那么一个解
 * 
 * @Example: Given nums = [2, 7, 11, 15], target = 9 <br/>
 *           Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @UPDATE (2016/2/13): The return format had been changed to zero-based
 *         indices. Please read the above updated description carefully.
 * 
 * @author qi
 */
public class AC {
	/**
	 * 时间复杂度：O(n)
	 * 
	 * 分析：<br/>
	 * 
	 * target = nums[x] + numx[y]
	 * 
	 * 我们肯定要做的就是遍历nums数组，已知target，遍历nums <br/>
	 * 
	 * diff = target-nums[i]，这个公式就是我们完成这个算法的中心思想。
	 * 
	 * 作者利用 map 键值对的特性，将 target 与当前遍历的数的 diff 值及这个数的 index 进行保存管理。
	 * 当map.containsKey(diff) == true 的时候，说明找到了nums[map.get(diff)] + nums[i] =
	 * target的这么一对数了.
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[1] = i;
				result[0] = map.get(target - nums[i]);
				return result;
			}
			map.put(nums[i], i);
		}
		return result;
	}
}
