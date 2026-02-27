package implemention.linkedList;


public class LinkedList {
    private int size;
    private Node head;


    private static class Node{
        int value;
        Node next;

        Node(int value){
         this.value=value;
         this.next=null;
        }
    }

    public void add(int value){
       Node node = new Node(value);

        if(head==null){
            head=node;
        }
        else {
            Node cur=head;
            while (cur.next!=null) cur=cur.next;
            cur.next=node;
        }
        size++;
    }


    public void addFirst(int value){
        Node newNode = new Node(value);
        newNode.next=head;
        head=newNode;
      size++;
    }

    public int deleteFirst(){
        if(head==null) throw new RuntimeException("LinkedList is empty");
        Node cur=head;
        head=head.next;
        size--;
        return cur.value;
    }

    public int deleteLast(){
        if(head==null) throw new RuntimeException("LinkedList is empty");
        Node cur=head;
        size--;

        if(head.next==null){
            head=null;
            return cur.value;
        }
        while (cur.next.next!=null){
            cur=cur.next;
        }
        int value=cur.next.value;
        cur.next=null;
        return value;

    }




    public void print(){
        Node cur=head;

        while (cur!=null){
            System.out.print(cur.value +" -> ");
            cur=cur.next;
        }
        System.out.println("END");

    }
    public int size(){
        return size;
    }

}
