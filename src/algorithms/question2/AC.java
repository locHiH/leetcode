package algorithms.question2;

import java.util.Random;

/**
 * 
 * 因为是链表，遍历之前需要保存头结点：<br />
 * ListNode n1 = l1; <br />
 * ListNode n2 = l2; <br />
 * 
 * 两个链表相加，又不知道他们的节点的情况下，n1 的size 和n2 的size 不定长<br />
 * 所以，循环的终止条件肯定是n1 == null && n2 == null的时候
 * 
 * 那么，在不循环的时候我们做了什么呢？ <br />
 * 我们生成了第三条链表 <br />
 * >>> h
 * 
 * 第三条链表的节点就是 new ListNode(sum % 10)
 * 
 * 在每次循环开始后的step 1 ： sum /= 10; 这句话的意义就在于进位标志每次都能参与到next的运算中来，叼得不行...
 * 
 * 然后在循环完了之后需要处理一种特殊情况：<br />
 * n1.next == null && n2.next == null && (n1.val + n2.val) / 10 == 1的情况
 * 在这种情况下，sum == 10了，但是next 都为空了，所以跳出循环，如果不做处理的话就会遗失掉一个node 所以，在最后: <br />
 * 
 * if (sum / 10 == 1) { temp.next = new ListNode(1); }
 * 
 * 如果用递归呢？！我需要用递归来尝试一下...虽然递归的开销大...但是这个算法的第三条node也是没必要的开销..so...lets do it!!!
 * 
 * @author qi
 */
public class AC {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode n1 = l1;
		ListNode n2 = l2;
		ListNode h = new ListNode(0);
		ListNode temp;
		temp = h;
		int sum = 0;
		while (n1 != null || n2 != null) {

			sum /= 10;

			if (n1 != null) {
				sum += n1.val;
				n1 = n1.next;
			}

			if (n2 != null) {
				sum += n2.val;
				n2 = n2.next;
			}

			temp.next = new ListNode(sum % 10);
			temp = temp.next;
		}

		if (sum / 10 == 1) {
			temp.next = new ListNode(1);
		}
		return h.next;
	}

	/**
	 * test cases
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);

		Random mRandom = new Random();

		ListNode t1 = l1;
		ListNode t2 = l2;
		for (int i = 0; i < 10; i++, t1 = t1.next) {
			t1.next = new ListNode(mRandom.nextInt(9));

			if (i == mRandom.nextInt(10))
				continue;

			t2.next = new ListNode(mRandom.nextInt(9));
			t2 = t2.next;
		}

		System.out.println("l1:");
		t1 = l1.next;
		while (t1 != null) {
			System.out.print(t1.val + " ");
			t1 = t1.next;
		}

		System.out.println("\nl2:");

		t2 = l2.next;
		while (t2 != null) {
			System.out.print(t2.val + " ");
			t2 = t2.next;
		}

		System.out.println("\nresult:");

		ListNode result = new Mine().addTwoNumbers(l2.next, l1.next);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
