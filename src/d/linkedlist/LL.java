package d.linkedlist;

public class LL {
    private Node head;
    private int size;

    private static class Node{
        private Node next;
        private int value;

        Node(int value){
            this.value=value;
        }
    }

    public void addFirst(int value){
        Node node = new Node(value);
        if(head==null){
            head= node;
        }else{
            node.next=head;
            head=node;
        }
        size++;
    }

    public void addLast(int value){
        Node cur=head;
        Node node =new Node(value);
        if(head==null){
            addFirst(value);
            return;
        }
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
        size++;
    }

    //without using size want to do
    public void add(int index,int value){
       Node node=new Node(value);
        Node cur=head;
        if(index==0){
            addFirst(value);
            return;
        }
        if(getSize()<=index){
            throw new RuntimeException("LinkedList Out Bound");
        }
        for(int i=0;i<index-1;i++){
            cur=cur.next;
        }
        Node t= cur.next;
        cur.next=node;
        node.next=t;
        size++;
    }
    public void display(){
        Node cur=head;
        while(cur!=null){
            System.out.print(cur.value+" -> ");
            cur = cur.next;
        }
        System.out.println("end");
    }

    public int getSize(){
        Node cur=head;
        int count=0;
        while (cur!=null){
            cur=cur.next;
            count++;
        }
        return count;
    }

    public int removeFirst(){
        if(head==null){
            throw new RuntimeException("LinkedList is empty");
        }
        Node temp=head;
        int val=temp.value;
        head=temp.next;
        temp=null;
        size--;
        return val;
    }

    public int removeLast(){
        if(head==null || head.next== null){
            return removeFirst();
        }
        size--;
        if(head.next.next==null){
            int val=head.next.value;
            head.next=null;
            return val;
        }
        Node cur=head;
        while (cur.next.next!=null){
            cur=cur.next;
        }
        int val=cur.next.value;
        cur.next=null;
        return val;
    }

    public int remove(int index){
        if(index==0){
            return removeFirst();
        }

        Node cur=head;
        for(int i=0;i<index-1;i++){
            cur=cur.next;
        }
        Node temp = cur.next;
        int val=temp.value;
        cur.next=temp.next;
        temp=null;
        return val;
    }
}
