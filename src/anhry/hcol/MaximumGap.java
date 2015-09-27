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
 * ��һ��δ����������飬����֮�����������ҵ���������Ԫ���в�ֵ�����ֵ��
 * 
 * ������O(n)��ʱ��/�ռ临�Ӷ��½�����⡣
 * 
 * ������鳤��С��2�򷵻�0
 * 
 * �����п��Բ��������������ֵΪ32λ����signed integer
 * 
 * @author HCol
 * @email darkf0un6er@gmail.com
 *
 */
public class MaximumGap {

	/**
	 * 1. ���ȣ�Ҫ���� 2. �������е�1��Ԫ�ؿ�ʼ��
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
			/* ���� */
			ArrayList<Integer> mList = new ArrayList<Integer>();
			for (int i = 0; i < length; i++) {
				mList.add(nums[i]);
			}
			Collections.sort(mList);
			/* �Ƚ� */
			int p = 0;										// ����ָ��1
			int q = 1;										// ����ָ��2
			int difference1 = nums[q] - nums[p];			// ��ֵ�洢��1
			int difference2 = 0;							// ��ֵ�洢��2

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
