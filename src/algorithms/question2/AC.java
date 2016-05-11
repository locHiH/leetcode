package algorithms.question2;

import java.util.Random;

/**
 * 
 * ��Ϊ����������֮ǰ��Ҫ����ͷ��㣺<br />
 * ListNode n1 = l1; <br />
 * ListNode n2 = l2; <br />
 * 
 * ����������ӣ��ֲ�֪�����ǵĽڵ������£�n1 ��size ��n2 ��size ������<br />
 * ���ԣ�ѭ������ֹ�����϶���n1 == null && n2 == null��ʱ��
 * 
 * ��ô���ڲ�ѭ����ʱ����������ʲô�أ� <br />
 * ���������˵��������� <br />
 * >>> h
 * 
 * ����������Ľڵ���� new ListNode(sum % 10)
 * 
 * ��ÿ��ѭ����ʼ���step 1 �� sum /= 10; ��仰����������ڽ�λ��־ÿ�ζ��ܲ��뵽next��������������ò���...
 * 
 * Ȼ����ѭ������֮����Ҫ����һ�����������<br />
 * n1.next == null && n2.next == null && (n1.val + n2.val) / 10 == 1�����
 * ����������£�sum == 10�ˣ�����next ��Ϊ���ˣ���������ѭ���������������Ļ��ͻ���ʧ��һ��node ���ԣ������: <br />
 * 
 * if (sum / 10 == 1) { temp.next = new ListNode(1); }
 * 
 * ����õݹ��أ�������Ҫ�õݹ�������һ��...��Ȼ�ݹ�Ŀ�����...��������㷨�ĵ�����nodeҲ��û��Ҫ�Ŀ���..so...lets do it!!!
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
