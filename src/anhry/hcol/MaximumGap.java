package anhry.hcol;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
 * 
 * 有一组未排序过的数组，排序之后，在数组中找到连续两个元素中差值的最大值。
 * 
 * 试着在O(n)的时间/空间复杂度下解决问题。
 * 
 * 如果数组长度小于2则返回0
 * 
 * 数组中可以不包含负数，最大值为32位机的signed integer
 * 
 * @author HCol
 * @email darkf0un6er@gmail.com
 *
 */
public class MaximumGap {

	/**
	 * 1. 首先，要排序 2. 从数组中的1号元素开始，
	 * 
	 * @param args
	 * @return
	 */
	public int func(Integer nums[]) {
		int length = nums.length;
		
		if (length < 2)
			return 0;
		else {
			int maximumDifference = 0;
			/* 排序 */
			ArrayList<Integer> mList = new ArrayList<Integer>();
			for (int i = 0; i < length; i++) {
				mList.add(nums[i]);
			}
			Collections.sort(mList);
			/* 比较 */
			int p = 0;										// 数组指针1
			int q = 1;										// 数组指针2
			int difference1 = nums[q] - nums[p];			// 差值存储器1
			int difference2 = 0;							// 差值存储器2

			while (++q < length) {
				p++;
				difference2 = nums[q] - nums[p];
				maximumDifference = difference1 > difference2 ? difference1
						: difference2;
				difference1 = difference2;
			}
			return maximumDifference;
		}
	}

	public static void main(String[] args) {
		System.out.println(Integer.SIZE);
	}
}
