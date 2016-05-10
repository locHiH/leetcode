package algorithms.question60;

/**
 * 
 * @question : Permutation Sequence
 * 
 * @description:
 * 
 * 				The set [1,2,3,��,n] contains a total of n! unique permutations.
 *               ����ôһ����1��n��Ԫ��Ψһ���������м���[1,2,3,...,n]
 * 
 *               By listing and labeling all of the permutations in order, We
 *               get the following sequence (ie, for n = 3): <br/>
 *               �����Ǹ��������п����������¼���������ϣ�
 * 
 *               "123" <br/>
 *               "132" <br/>
 *               "213" <br/>
 *               "231" <br/>
 *               "312" <br/>
 *               "321" <br/>
 * 
 *               Given n and k, return the kth permutation sequence.
 *               ���ص�k��������ϵ��ַ�����
 * 
 * 
 * @Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author qi
 *
 */
public class Mine {
	/**
	 * ���Ҷ�����Ŀ֮���ҹ۲쵽����������еı仯��һ�֡�ĩβð�ݡ�����ʽ <br/>
	 * 
	 * 0. for(int i : nSet) <br />
	 * 1. opSet = originSet <br />
	 * 2. ���С�ĩβð�ݡ� <br />
	 * 3. ��ĩβ�ƶ����ڶ���λ��ʱ�������ǰ��opSet === originSet ��˵��������е���ð���� <br />
	 * 4. �� originSet �ĵ�0��λ���� i�����û�<br />
	 * 5. to 1
	 *
	 * ������Ǿ�������ʵ�֣� n<=4 ��ʱ��û�з������⣬���ǵ�n >= 5��֮������Ĵ����û����ɹ�����<br />
	 * �����˴����Ĵ���𰸡�
	 * 
	 * ���ң�k ֵҲû�кúõ����� <br />
	 * ���ң�����ķ�����ȫ������˼ά��һ�㶼������Ա <br />
	 * �����ѵ���ũд�Ĵ��� <br />
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
