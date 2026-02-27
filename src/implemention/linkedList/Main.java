package implemention.linkedList;

public class Main {
    public static void main(String[] args) {


        LinkedList ll=new LinkedList();

        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        ll.addFirst(8);
        ll.addFirst(2);
        ll.deleteFirst();



        ll.print();
        System.out.println(ll.size());
    }
}
