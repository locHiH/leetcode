package algorithms.question2;

/**
 * 
 * @author qi
 *
 */
public class Mine {

	/**
	 * 如何将进位优雅的，有效的传入到next的运算中去..
	 * 
	 * 如果我们只用两条node 且递归来做的话，第一件事就是需要判断这个node 的有效性
	 * 
	 * 原则上我们需要指出一条较长的list 来进行结果返回，但是，在题目的条件下，我们不进行遍历对比就没法知道l1,
	 * l2哪条链表比较长，而且西安遍历一遍的话这不合理，所以...
	 * 
	 * @后记 运行居然比while 快了 1ms..为什么..但是这个实现有点丑..而且一点都不程序化(programmatically)
	 * 
	 *     有点可笑的是这个程序有点像合并链表(苦笑...WTF...
	 * 
	 * @param l1
	 * @param l2
	 * @return l1
	 * 
	 *         以 l1 头结点为节点返回整个运算结果
	 * 
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 递归终止条件
		if (l1 == null && l2 == null) {
			// 倒序
			return new ListNode(0);
			// 正序
			// return null;
		}
		// 修正当前节点为10的情况
		if (l1.equals(l2)) {
			if (l1.val / 10 == 1) {
				// 如果这个节点为尾节点的话，就需要新建一个节点
				if (l1.next == null) {
					l1.next = new ListNode(1);
					l1.val %= 10;
					return l1;
				}
				l1.next.val += 1;
				l1.val = l1.val % 10;
				l1.next = addTwoNumbers(l1.next, l1.next);
			}
			return l1;
		}

		// 嫁接判断
		boolean needMove = (l1.next == null && l2 != null && l2.next != null);
		// 运算当前节点
		int sum = 0;
		if (l1 != null) {
			sum += l1.val;
		}
		if (l2 != null) {
			sum += l2.val;
		}
		l1.val = sum % 10;
		// 嫁接
		if (needMove) {
			l1.next = l2.next;
		}
		// 进位
		if (sum / 10 == 1) {
			// 如果这个节点为尾节点的话，就需要新建一个节点
			if (l1.next == null) {
				l1.next = new ListNode(1);
				l1.val %= 10;
				return l1;
			}
			l1.next.val += 1;
		}
		// 正序
		// l1.next = addTwoNumbers(l1.next, l2 == null ? null : l2.next);
		// 倒序
		ListNode head = addTwoNumbers(l1.next, l2 == null ? null : l2.next);
		ListNode p = head;
		while (p.next != null) {
			p = p.next;
		}
		p.next = l1;
		l1.next = null;
		return head;
	}

	/**
	 * 
	 * 第一次尝试，在看ac代码之前..
	 * 
	 * 进位标志无法进入下一个递归去...
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	// public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	//
	// if (l1 == null && l2 == null) {
	// return null;
	// } else if (l1 != null && l2 == null) {
	// if (l1.val >= 10) {
	// l1.val %= 10;
	// }
	// l1.next = addTwoNumbers(l1.next, new ListNode(1));
	// return l1;
	// } else if (l1 == null && l2 != null) {
	// l1 = new ListNode(0);
	// l1.next = null;
	// }
	//
	// boolean overRange = false;
	// if (l1.val + l2.val >= 10)
	// overRange = true;
	//
	// l1.val = (l1.val + l2.val) % 10;
	//
	// if (overRange) {
	// if (l1.next == null)
	// l1.next = new ListNode(1);
	// else
	// l1.next.val += 1;
	// }
	//
	// l1.next = addTwoNumbers(l1.next, l2.next);
	// return l1;
	// }
}
