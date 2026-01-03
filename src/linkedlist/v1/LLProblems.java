package linkedlist.v1;

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

    public ListNode reverseListRec(ListNode head) {


        if(head==null || head.next==null){
            return head;
        }

        ListNode newHead = reverseListRec(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }



    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        ListNode f=dummy;
        ListNode s=dummy;


        for(int i=0;i<n;i++){
            f=f.next;
        }

        while (f.next!=null){
            f=f.next;
            s=s.next;
        }
        s.next=s.next.next;

        return dummy.next;

    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        ListNode a= headA;
        ListNode b=headB;

        while(a!=b){

            a=a!=null ? a.next : headB;
            b=b!=null ? b.next : headA;
        }

        return  a;
    }



//    Input: head = [1,2,3,4,5]
//    Output: [5,4,3,2,1]

    public ListNode reverseList(ListNode head) {

        if(head==null)return null;

        ListNode prev=null;
        ListNode cur=head;

        while (cur.next!=null){
            ListNode Next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=Next;
        }
        return prev;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a=headA;
        ListNode b=headB;

        while (a!=b){

         a = a!=null ? a.next : headB;
         b= b!=null ? b.next : headA;
        }
        return a;
    }
    
    //    Input: list1 = [1,2,4], list2 = [1,3,4]
    //    Output: [1,1,2,3,4,4]
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode cur1 = list1;
        ListNode cur2=list2;

        ListNode dummy=new ListNode(0);
        ListNode node =dummy.next;
        while (cur1!=null && cur2!=null){
            if(cur1.val<cur2.val){
                dummy.next=cur1;
                cur1= cur1.next;
            }
            else{
                dummy.next=cur2;
                cur2=cur2.next;
            }
            dummy=dummy.next;
        }
        while (cur1!=null){
                dummy.next=cur1;
                cur1= cur1.next;
            dummy=dummy.next;
        }
        while (cur2!=null){
                dummy.next=cur2;
                cur2=cur2.next;
            dummy=dummy.next;
        }
        return node;
    }


//    Input: head = [4,2,1,3]
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;

        ListNode node=head;

        while(node!=null){
            ListNode cur=node;
            while (cur.next!=null){
                ListNode N=cur.next;
                if(cur.val>N.val){
                    int temp=cur.val;
                    cur.val=N.val;
                    N.val=temp;
                }
                cur=cur.next;
            }
            node=node.next;
        }
        return head;
    }


    
//    public ListNode sortList(ListNode head) {
//
//    }
}
