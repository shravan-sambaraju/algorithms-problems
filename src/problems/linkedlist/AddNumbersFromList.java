package problems.linkedlist;

public class AddNumbersFromList {
    // NOTE : the input parameters and output LL is reversed.
    public static ListNode addTwoReversedNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode sum = head;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.data;
                l2 = l2.next;
            }
            sum.next = new ListNode(carry % 10);
            sum = sum.next;
            carry /= 10;
        }
        sum.next = carry == 1 ? new ListNode(1) : null;
        return head.next;
    }
  
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int advance = 0;
        while(l1 != null && l2 != null){
            int sum = l1.data + l2.data + advance;
            advance = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            if(advance != 0)
                cur.next = addTwoNumbers(l1, new ListNode(advance));
            else
                cur.next = l1;
        }else if(l2 != null){
            if(advance != 0)
                cur.next = addTwoNumbers(l2, new ListNode(advance));
            else
                cur.next = l2;
        }else if(advance != 0){
            cur.next = new ListNode(advance);
        }
        return head.next;
    }
    
    public static void main(String args[]){
    	
    	ListNode node = new ListNode();
		node.setData(1);
		ListNode node2 = new ListNode();
		node2.setData(3);
		node.setNext(node2);
		ListNode node3 = new ListNode();
		node3.setData(5);
		node2.setNext(node3);
		ListNode node4 = new ListNode();
		node4.setData(7);
		node3.setNext(node4);
		
		
		ListNode node11 = new ListNode();
		node11.setData(2);
		ListNode node12 = new ListNode();
		node12.setData(4);
		node11.setNext(node12);
		ListNode node13 = new ListNode();
		node13.setData(6);
		node12.setNext(node13);
		ListNode node14 = new ListNode();
		node14.setData(8);
		node13.setNext(node14);
		
		ListNode finalfirst = addTwoReversedNumbers(node,node11);
		
		while(finalfirst!=null){
			System.out.println(finalfirst.getData());
			finalfirst = finalfirst.getNext();
			
		}
		
		System.out.println("************");
		
		ListNode finalsecond = addTwoNumbers(node,node11);
		
		while(finalsecond!=null){
			System.out.println(finalsecond.getData());
			finalsecond = finalsecond.getNext();
			
		}
    	
    }
}