package algorithms.question60;

/**
 * 
 * @question : Permutation Sequence
 * 
 * @description:
 * 
 * 				The set [1,2,3,…,n] contains a total of n! unique permutations.
 *               有这么一个从1到n的元素唯一的有序序列集合[1,2,3,...,n]
 * 
 *               By listing and labeling all of the permutations in order, We
 *               get the following sequence (ie, for n = 3): <br/>
 *               上面那个有序序列可有生成以下几种排列组合：
 * 
 *               "123" <br/>
 *               "132" <br/>
 *               "213" <br/>
 *               "231" <br/>
 *               "312" <br/>
 *               "321" <br/>
 * 
 *               Given n and k, return the kth permutation sequence.
 *               返回第k个排列组合的字符串。
 * 
 * 
 * @Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author qi
 *
 */
public class Mine {
	/**
	 * 当我读完题目之后，我观察到这个有序序列的变化是一种”末尾冒泡“的形式 <br/>
	 * 
	 * 0. for(int i : nSet) <br />
	 * 1. opSet = originSet <br />
	 * 2. 进行“末尾冒泡” <br />
	 * 3. 当末尾移动到第二个位置时，如果当前的opSet === originSet 则说明这个序列的泡冒完了 <br />
	 * 4. 将 originSet 的第0个位置与 i进行置换<br />
	 * 5. to 1
	 *
	 * 下面就是具体代码的实现， n<=4 的时候没有发现问题，可是当n >= 5了之后，下面的代码就没法完成工作了<br />
	 * 出现了大量的错误答案。
	 * 
	 * 而且，k 值也没有好好的利用 <br />
	 * 而且，解题的方法完全是线性思维，一点都不程序员 <br />
	 * 活脱脱的码农写的代码 <br />
	 */
	int counter;

	public String getPermutation(int n, int k) {
		if (k < 1 || k > arrangementNum(n - 1, n - 1) * n) {
			throw new IllegalArgumentException("'k' may can not be reached.");
		}
		counter = 0;
		k = k - 1;

		int orderedSeq[] = new int[n];
		for (int i = 0; i < n; i++) {
			orderedSeq[i] = (i + 1);
		}

		int temp[] = orderedSeq.clone();
		for (int i = 0; i < n && counter != k; counter++) {
			for (int p = n - 1, j = arrangementNum(n - 1, n - 1); j > 1 && counter != k; j--, p--, counter++) {
				if (p - 1 == 0) {
					p = n - 1;
				}
				swap(temp, p, p - 1);
			}
			if (i + 1 < n && counter != k) {
				temp = orderedSeq.clone();
				i++;
				swap(temp, 0, i);
			} else
				break;
		}
		return convertor(temp);
	}

	private String convertor(int n[]) {
		String pStr = "";
		for (int x : n) {
			pStr += x;
		}
		return pStr;
	}

	private int arrangementNum(int n, int m) {
		if (m > n)
			throw new IllegalArgumentException("\'m\' may not be big than \'n\'...");
		if (m <= 0)
			return 1;
		return n * arrangementNum(n - 1, m - 1);
	}

	private void swap(int a[], int n, int m) {
		if (n > a.length || n < 0 || m > a.length || m < 0)
			throw new IllegalArgumentException("Oops..");

		int temp = a[n];
		a[n] = a[m];
		a[m] = temp;
	}
}
