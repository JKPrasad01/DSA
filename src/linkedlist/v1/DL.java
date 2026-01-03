package linkedlist.v1;

public class DL {
    private Node head;
    private Node tail;
    private int size;

    private static class Node{
        private final int value;
        private Node prev;
        private Node next;

        public Node(int value){
            this.value=value;
        }
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if(head==null && tail == null){
            head=node;
            tail=node;
        }
        else{
            node.next=head;
            head.prev=node;
            head=node;
        }
        size++;
    }

    public void addLast(int value){
        Node node= new Node(value);
        if(head==null || tail ==null){
            addFirst(value);
        }
        else {
            Node cur=head;
            while (cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
            node.prev=cur;
            tail=node;
            size++;
        }
    }

    public void add(int index ,int value){
        Node node = new Node(value);
        if(index>getSize()) throw new RuntimeException("Doubly LinkedList is Out Of Bound");
        if(index==getSize())addLast(value);
        if(index==0) addFirst(value);
        else{
            Node cur=head;
            for(int i=0;i<index-1;i++){
                cur=cur.next;
            }
            Node t=cur.next;
            cur.next=node;
            node.prev=cur;
            t.prev=node;
            node.next=t;
            size++;
        }
    }

    public int getSize(){
        int count=0;
        Node cur=head;
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    public void display(){
        Node cur=head;
        while (cur!=null){
            System.out.print(cur.value+" -> ");
            cur=cur.next;
        }
        System.out.println("end");
    }

    public void displayBack(){
        Node cur=tail;
        while (cur!=null){
            System.out.print(cur.value+" -> ");
            cur=cur.prev;
        }
        System.out.println("start");
    }

    public int deleteFirst(){
        if(head==null){
            throw new RuntimeException("Doubly Linked List is Empty");
        }
        size--;
        if(head.next==null){
            int value=head.value;
            tail=null;
            head=null;
            return value;
        }
        int value=head.value;
        head=head.next;
        head.prev=null;
        return value;
    }

    public int deleteLast(){
        if(head==null || head.next==null){
            return deleteFirst();
        }
        Node cur=head;

        while (cur.next.next!=null){
            cur=cur.next;
        }
        Node t=cur.next;
        int value=t.value;
        cur.next=null;
        tail=cur;
        size--;
        return value;
    }

    public int delete(int index){
        if(index>getSize() || index < 0 )throw new RuntimeException("Doubly LinkedList is Out of Bound");
        if(index==0)return deleteFirst();
        if(index==getSize())return deleteLast();
        Node cur=head;
        for (int i=0;i<index-1;i++){
            cur=cur.next;
        }
        Node t=cur.next.next;
        int value=cur.next.value;
        t.prev=cur;
        cur.next=t;
    return value;
    }

}
