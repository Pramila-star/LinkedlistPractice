public class InsertionUsingRecursion {

    private  Node head;
    private Node tail;
    private int size;

     public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size += 1;
    }

    public void insertRec(int val, int index){
         head = insertRec(val , index , head);
    }

    private Node insertRec(int val, int index, Node node){
        if ( index == 0){
            Node temp = new Node(val , node);
            size++;
            return temp;
        }

        node.next = insertRec(val , index-1,node.next);
        return node;
    }

     public void display(){
        Node temp =head;
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

     private class Node {
        int val;
        Node next;
     //   Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next ) {
            this.val = val;
            this.next = next;
        //    this.prev  = prev;
        }
    }

    public static void main(String args[]){
        InsertionUsingRecursion list = new InsertionUsingRecursion();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        list.insertRec(78 , 2);
        list.display();
    }

    
}
