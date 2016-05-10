package algorithms.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * @question: Two Sum
 * 
 * @description:Given an array of integers, return indices of the two numbers
 *                    such that they add up to a specific target.
 *                    ����һ���ض�������������������ҳ�һ������ ������������������� �õ�������ض������� ���������������±ꡣ
 * 
 *                    You may assume that each input would have exactly one
 *                    solution. ȷ���������պ�����ôһ����
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
	 * ʱ�临�Ӷȣ�O(n)
	 * 
	 * ������<br/>
	 * 
	 * target = nums[x] + numx[y]
	 * 
	 * ���ǿ϶�Ҫ���ľ��Ǳ���nums���飬��֪target������nums <br/>
	 * 
	 * diff = target-nums[i]�������ʽ���������������㷨������˼�롣
	 * 
	 * �������� map ��ֵ�Ե����ԣ��� target �뵱ǰ���������� diff ֵ��������� index ���б������
	 * ��map.containsKey(diff) == true ��ʱ��˵���ҵ���nums[map.get(diff)] + nums[i] =
	 * target����ôһ������.
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
