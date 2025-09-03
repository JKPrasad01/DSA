package d.linkedlist;

//  Definition for singly-linked list.
   class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class LLProblems {
    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {

        ListNode f=head;
        ListNode s=head;

        while (f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;
        }
        return s;
    }


    public boolean isPalindrome(ListNode head) {
        if(head==null)return true;
        ListNode f=head;
        ListNode s=head;

        while (f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;
        }

        ListNode firstHalf=head;
        ListNode secondHalf=reverseListNode(s);

        while (secondHalf!=null){
            if(firstHalf.val!=secondHalf.val){
                return false;
            }
            firstHalf=firstHalf.next;
            secondHalf=secondHalf.next;
        }
        return true;
    }

    private ListNode reverseListNode(ListNode cur) {
        if(cur==null)return null;

        ListNode prev=null;
        while (cur!=null){
            ListNode N=cur.next;
            cur.next=prev;
            prev=cur;
            cur=N;
        }
        return prev;
    }

//
//    Input: list1 = [1,2,4], list2 = [1,3,4]
//    Output: [1,1,2,3,4,4]


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode();
        ListNode cur=dummy;

        while (list1!=null && list2!=null){
            if(list1.val<list2.val){
                cur.next=list1;
                list1=list1.next;
            }
            else{
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
        }

        while (list1!=null){
            cur.next=list1;
            list1=list1.next;
            cur=cur.next;
        }

        while (list2!=null){
            cur.next=list2;
            list2=list2.next;
            cur=cur.next;
        }
        return dummy.next;
    }
}
