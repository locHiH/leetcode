package algorithms.question60;

import java.util.ArrayList;

/**
 * 
 * @ref https://leetcode.com/discuss/42700/explain-like-im-five-java-solution-in
 *      -o-n
 *
 * @分析 链接中的教程已经解释得很清楚了，总结一下关键思路： <br />
 *     <p>
 *     首先，利用n来生成{1,2,3,...,n}这么一个元数组，因为咱们最终字符串生成都是从这里面获取的。
 *     通过元数组，我们知道如果要进行排列组合的话，会有 n! 个排列组合
 *     当我们确定了某一个位置之后的数字是多少之后，那剩下的排列组合是不是就变成了(n-1)!了
 * 
 *     n! = n * (n-1)!
 * 
 *     解这道题的关键概念之一
 * 
 *     所以当我们有n的元数组之后，因为是有序的，我们从1开始 (ie: n=4 >>> {1,2,3,4} )，所有的排列组合如下：<br />
 *     1 + 组合{2,3,4} <br />
 *     2 + 组合{1,3,4} <br />
 *     3 + 组合{1,2,4} <br />
 *     4 + 组合{1,2,3} <br />
 * 
 *     这可以得到几个关键的数字，以1开头的组合有 (n-1)!种，以此类推:2,3,4开头的组合同样是(n-1)!种， 所以当 n = 4
 *     的时候，所有组合有 4 * (4 - 1)! = 24 种，每个数字开头的组合各有6总
 * 
 *     那我们要如何确定第一个数字呢？<br />
 *     >>> k
 * 
 *     k 就像一个索引一样，因为我们要返回的是第 k 个组合的字符串，而每个数字开头的组合各有(n-1)!种 所以，当我们在n =
 *     4情况下，需要找第20个排列组合的字符串时，我们利用如下公式来确定第一个数字：
 * 
 *     k = k-1 (things always starting at 0 :p )
 * 
 *     index = k / (n-1)! = 19 / (4-1)! = 19/6 = 3
 * 
 *     index from {1,2,3,4} >>> 1st number is 4
 * 
 *     想想，我们要找第20个组合，也就是说，以1,2,3开头的组合肯定就不是我们的目标对不对，因为20属于index为{19,20,21,22,23,
 *     24} 最后6个组合中，而最后的6个组合的第一位数肯定是{1,2,3,4}中的末尾4
 * 
 * 
 *     确定了第一位数之后，我们就来确定第二位数，而剩下的组合只有：<br />
 * 
 *     4 + 组合{1,2,3}
 * 
 *     如何确定第二位数呢？<br />
 * 
 *     其实还是利用k值，当我们已经排除掉以1,2,3开头的组合之后，我们是不是排除了 <br />
 *     3*(n-1)! 种组合 <br />
 * 
 *     那么也就是说我们当前的 k 值已经不能再指引我们寻找到准确的组合序列了，或者这么说，原本需要寻找的第k个序列是在{1,2,3,4}中的第k个
 *     而我们现在已经确定了范围在 4 + 组合{1,2,3}的范围中了，那么对k值也要进行相应的修正：
 * 
 *     k -= index * (n-1)!= 19 - 3(4-1)! = 19 - 18 = 1
 * 
 *     因为我们已经排除掉了1,2,3的组合，而这个1是什么呢，1就是在剩下的{19,20,21,22,23,24}这6种组合中index为1的组合，
 *     而这个组合就是我们的目标组合
 * 
 *     当我们修正 k 值之后，重复上面的方法，就可以得到后面的数了。
 * 
 *     index = k / (3-1)! = 1 / (3-1)! = 1/2 = 0
 * 
 *     index from {1,2,3} >>> 2nd number is 1
 * 
 *     >>> 修正 k 值 k -= index * (n-1)! = 1 - 0 * (2-1)! = 1 <br />
 *     >>> 第三个数的index = 1 / (2 - 1)! = 1 <br />
 *     >>> 第三个数为: index from {2,3} >>> 3td number is 3
 * 
 *     >>> 修正 k 值 k -= index * (n-1)! = 1 - 1 * (1-1)! = 0 <br />
 *     >>> 第三个数的index = 0 / (1 - 1)! = 0 <br />
 *     >>> 第三个数为: index from {2} >>> 4th number is 2
 * 
 *     >>>所以n = 4的情况下第20个组合为：{4,1,3,2}
 * 
 *     bingo!
 *     </p>
 * 
 * 
 * @author qi
 *
 */
public class AC {
	// static final int MAX = 10;
	// static int factorial[] = new int[MAX];
	// {
	// factorial[0] = 1;
	// for (int i = 1; i < MAX; i++) {
	// factorial[i] = factorial[i - 1] * i;
	// }
	//
	// }
	public String getPermutation(int n, int k) {
		// faster without calculating
		int factorial[] = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };
		// create array like {1,2,3,4,5...}
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		// things always starting at 0
		k = k - 1;

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			int index = k / factorial[n - i];
			sb.append(numbers.get(index));
			numbers.remove(index);
			k -= index * factorial[n - i];
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new AC().getPermutation(4, 20));
	}
}
