package algorithms.question2;

/**
 * 
 * @author qi
 *
 */
public class Mine {

	/**
	 * ��ν���λ���ŵģ���Ч�Ĵ��뵽next��������ȥ..
	 * 
	 * �������ֻ������node �ҵݹ������Ļ�����һ���¾�����Ҫ�ж����node ����Ч��
	 * 
	 * ԭ����������Ҫָ��һ���ϳ���list �����н�����أ����ǣ�����Ŀ�������£����ǲ����б����ԱȾ�û��֪��l1,
	 * l2��������Ƚϳ���������������һ��Ļ��ⲻ��������...
	 * 
	 * @��� ���о�Ȼ��while ���� 1ms..Ϊʲô..�������ʵ���е��..����һ�㶼������(programmatically)
	 * 
	 *     �е��Ц������������е���ϲ�����(��Ц...WTF...
	 * 
	 * @param l1
	 * @param l2
	 * @return l1
	 * 
	 *         �� l1 ͷ���Ϊ�ڵ㷵������������
	 * 
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// �ݹ���ֹ����
		if (l1 == null && l2 == null) {
			// ����
			return new ListNode(0);
			// ����
			// return null;
		}
		// ������ǰ�ڵ�Ϊ10�����
		if (l1.equals(l2)) {
			if (l1.val / 10 == 1) {
				// �������ڵ�Ϊβ�ڵ�Ļ�������Ҫ�½�һ���ڵ�
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

		// �޽��ж�
		boolean needMove = (l1.next == null && l2 != null && l2.next != null);
		// ���㵱ǰ�ڵ�
		int sum = 0;
		if (l1 != null) {
			sum += l1.val;
		}
		if (l2 != null) {
			sum += l2.val;
		}
		l1.val = sum % 10;
		// �޽�
		if (needMove) {
			l1.next = l2.next;
		}
		// ��λ
		if (sum / 10 == 1) {
			// �������ڵ�Ϊβ�ڵ�Ļ�������Ҫ�½�һ���ڵ�
			if (l1.next == null) {
				l1.next = new ListNode(1);
				l1.val %= 10;
				return l1;
			}
			l1.next.val += 1;
		}
		// ����
		// l1.next = addTwoNumbers(l1.next, l2 == null ? null : l2.next);
		// ����
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
	 * ��һ�γ��ԣ��ڿ�ac����֮ǰ..
	 * 
	 * ��λ��־�޷�������һ���ݹ�ȥ...
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
