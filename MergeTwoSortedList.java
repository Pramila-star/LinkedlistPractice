
public class MergeTwoSortedList {

    private Node head;
    private Node tail;
    private int size;

    public MergeTwoSortedList() {
        this.head = null;
        this.tail = null;
    }


   public Node merge(Node list1, Node list2) {
       Node dummy = new Node(-1);  
       Node temp = dummy;  
       
       while (list1 != null && list2 != null) {
        if (list1.value <= list2.value) {
            temp.next = list1;
            list1 = list1.next;
        } else {
            temp.next = list2;
            list2 = list2.next;
        }
        temp = temp.next;
    }

          // Attach any remaining nodes
        if (list1 != null) temp.next = list1;
        if (list2 != null) temp.next = list2;

        return dummy.next; // head of merged list
       }
    

    public void display(Node node){
    //    Node temp =head;
        while(node != null){
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.println("END");
    }
    
     public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size += 1;
    }
    
    public void insertLast(int val) {
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size ++;
    }
   

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node (int value , Node next){
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String args[]){
        MergeTwoSortedList list1 = new MergeTwoSortedList();
         MergeTwoSortedList list2 = new MergeTwoSortedList();
        list1.insertLast(1);
        list1.insertLast(3);
        list1.insertLast(5);
       // list1.display();
    
        list2.insertLast(1);
        list2.insertLast(2);
        list2.insertLast(9);
        list2.insertLast(14);

        System.out.print("List 1: ");
        list1.display(list1.head);

         System.out.print("List 2: ");
         list2.display(list2.head);
        
        
        MergeTwoSortedList obj = new MergeTwoSortedList();

        Node mergeHead = obj.merge(list1.head, list2.head);

        System.out.print("Merged List: ");
        obj.display(mergeHead);
        

    }

}
