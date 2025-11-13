
public class RemoveNodes {
    
     private Node head;
    private Node tail;
    private int size;
 //   private Node dummy;

    public RemoveNodes() {
        this.size = 0;
    
}
 public void insert(int val){
        Node node = new Node(val);

        if(head == null){
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = node;
        }
    }


public Node Remove(){
    
        // Step 1: Reverse the list
        head = reverse(head);
        
        // Step 2: Remove smaller nodes
        Node curr = head;
        int max = curr.val;
        Node dummy = curr;
        
        while (curr != null && curr.next != null) {
            if (curr.next.val < max) {
                // Remove next node
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                max = curr.val;
            }
        }
        
        // Step 3: Reverse again to restore order
        return reverse(dummy);
    }
    
    // Helper function to reverse linked list
    private Node reverse(Node head) {
        Node prev = null, next = null, curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
    //    Node prev;

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
        RemoveNodes list = new RemoveNodes();
        list.insert(5);
        list.insert(2);
        list.insert(13);
        list.insert(3);
        list.insert(8);
       
        list.head = list.Remove();
        list.display();
    }
}
