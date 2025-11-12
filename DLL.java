public class DLL {

    private Node head;
    private Node tail;
    private int size;

    public  void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;

        if(head != null) {
             head.prev = node;
        }
        head = node;
        if (tail == null){
            tail = node;
        }
        size++;
    }

    public void insertLast(int val){
        if(tail == null){
             insertFirst(val);
             return;
        }
         Node node = new Node(val);
         tail.next = node;
         node.prev = tail;
         tail = node;
        size ++;
        
    }

    public void insert(int val, int index){
        if( index == 0){
            insertFirst(val);
            return;
        }
        if ( index == size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i = 1 ; i< index ; i++){
            temp = temp.next;
        }
        Node node = new Node(val, temp.next , temp);
        temp.next.prev = node;
        temp.next = node;
        size ++;
    }

    public int deleteFirst(){
        
        if(head == null){
            System.out.println("List is Emppty!");
           return -1;
        }
        int val = head.val;
        head = head.next;
       
        if (head == null){
        tail = null;
        }else {
            head.prev = null;
        }
        size--;
        return val;
    }

    public void display(){
        Node node = head;
        Node last  = null;
        while(node != null){
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("Print in reverse");
        while (last != null){
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
         System.out.println("START");
    }

    public Node get(int index){
        Node node = head;

        for (int  i = 0 ; i< index; i++){
            node = node.next;
        }
        return node;
    }

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next , Node prev) {
            this.val = val;
            this.next = next;
            this.prev  = prev;
        }
    }

    public static void main(String args[]){
         DLL list = new DLL();
         list.insertFirst(3);
         list.insertFirst(2);
         list.insertFirst(8);
         list.insertFirst(17);
         list.insertLast(13);
         list.insert(11, 3);
         list.display();
         System.out.println("\nDeleted First: " + list.deleteFirst());
         list.display();


    }
    
}
