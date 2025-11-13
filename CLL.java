public class CLL {

    private Node head;
    private Node tail;
    private int size;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val) {
        Node node = new Node(val);

        if (head == null){
            head = node;
            tail = node;
           node.next = head;  // circular link
        } else {
        tail.next = node;
        node.next = head;
        tail = node;
    }
    size ++;
}

    public void insertAtIndex(int val, int index){
        Node node = new Node(val);


        // case 1: Insert at the beginning
        if( index == 0){
            node.next = head;
            head = node;
            if (tail == null) {
                 tail = node;
            }
           size++;
           return; 
        }

        //case2 : Insert at the end
        if ( index == size){
            tail.next = node;
           tail = node;
           size++;
            return;
        } 

        // case 3 : Insert in the middle
        Node temp = head;
        for (int i = 1; i < index ; i++) {
            temp= temp.next;
        }
        
        node.next = temp.next;
        temp.next = node;

        size++;

    }

    public int delete( int index){

        if (head == null) {
            System.out.println("List is Empty!");
            return-1;
        }

        if (index < 0 || index >= size ) {
            System.out.println("Invalid index!");
            return -1;
        }
        int val ;

        // case 1 : Delete from start
        if (index == 0) {
          val = head.val;

         // if only one node
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
            size--;
            return val;
        }

         // case 3: Delete from middle
         Node prev =head;
        for (int i = 1; i < index ; i++) {
            prev = prev.next;
        }

        val = prev.next.val;
        prev.next = prev.next.next;

        // case 2: Delete from last 
        if (index == size - 1){
            tail = prev;
        }
        size--;
        return val;
       
    }
        
       
    public void display(){
        Node node = head;
        if (head != null){
            do{
            System.out.print(node.val + " -> ");
            node = node.next;
            } while ( node != head);
        }
        System.out.println("START");
    }

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String args[]) {
        CLL list = new CLL();
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.display();
        list.insertAtIndex(14, 2);
        list.display();
        list.delete(3);
        list.display();
    }
    
}
