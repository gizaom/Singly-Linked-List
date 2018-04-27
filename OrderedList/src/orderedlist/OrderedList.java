
package orderedlist;
/**
 Author: Kevin De Jesus
 File: OrderedList.java
 I affirm that this program is entirely my own work and none of it is the work 
 of any other person.
	__________Kevin De Jesus_________
	(your signature)
 */

/**
 Class of singly-linked lists that extend the Comparable interface.
 @param <T> generic element that can be comparable
 */
public class OrderedList<T extends Comparable<T>> {
    //definition of the nested class Node
    class Node {
        //instance variables
        T data; //object of the "type variable" class.
        Node next; //pointer to the next node on the list.
        
        /**
         Constructs a Node object
         @param x data of the object 
         @param next next element in the list, defaulted to null.
         */
        Node(T x, Node next){
            data = x; //sets the data to the parameter passed.
            this.next = next;
        }
    }
    
    private Node head; //pointer to first Node in the list.
    private boolean ascendingOrder; 
    /**
     determines whether the list should be sorted in ascending or descending
     order.
     */
    
    /**
     Creates an empty list that sorts in ascending order by default.
     */
    public OrderedList(){
        head = null;
        ascendingOrder = true;
    }
    
    /**
     Inserts an element into the list.
     @param data the element to be added
     */
    public void insert(T data){
        Node node = new Node(data, null); //creates a new node to be inserted.
     
        /**
         checks to see if the list has any elements, if it doesn't, then the 
         the first node inserted will be pointed to by the head pointer.
         */
        if(isEmpty()){
            head = node;//first element by default gets pointed to by the head
                         //pointer when it is the first element inserted.
        }
        
        /**
         ascendingOrder boolean checks to see which sorting format the insert
         method must use. If the list has been reversed, then inserted elements
         must be sorted in the opposite format of the current format.
         */
        else if(ascendingOrder){
            insertAscending(node);
        }
        
        else{
            insertDescending(node);
        }
    }
    
    /**
     Checks if the list is empty.
     @return true or false
     */
    public boolean isEmpty(){
        return head == null;
    }
    
    /**
     Inserts an element into a singly linked list that is sorted by
     ascending order.
     @param node node to be inserted
     */
    private void insertAscending(Node node){
            Node current = head; //points to the first element in the list.
            Node previous = null; //node which points to the element before the
                                  //current element in the list.
            
            
            while(current != null){
                /**
                 if the new node is less than the node that the current pointer
                 is pointing to, then the new node will be inserted before the
                 current node.
                 */
                if(node.data.compareTo(current.data) < 0){
                    break;
                }
                previous = current;//previous now points to the current node.
                current = current.next;//current pointer moves to the next node
                                       //in the list.
            }
            node.next = current;
            
            /**
             if the inserted node is smaller than the first element in the list,
             then the head pointer now points to the inserted node. Else the 
             new element just gets inserted after the element that is pointed to
             by the previous pointer.
             */
            if(current == head){
                head = node;
            }
            else{
                previous.next = node;
            }
    }
    
    /**
     Inserts an element into a singly linked list that is sorted by descending
     order.
     @param node node to be inserted
     */
    private void insertDescending(Node node){
        Node current = head;//current pointer starts with the first element in
                            //the list.
        Node previous = null;//element that precedes the element pointed to by 
                             //the current pointer;
        
        while(current != null){
            /**
             if the new node is greater than the node that the current pointer
             is pointing to, then the new node will be inserted before the
             current node.
            */
            if(node.data.compareTo(current.data) > 0){
                break;
            }
            previous = current;
            current = current.next;
        }
        node.next = current;
        
        if(current == head){
            head = node;
        }
        
        else{
            previous.next = node;
        }
    }
    
    /**
     Clears the list of elements.
     */
    public void clear(){
        head = null;//makes the head pointer point to null.
    }
    
    /**
     Searches the list for a given element and deletes it from the list if it is
     found.
     @param data The element to be deleted.
     @return true if the element is found or false if it is not found.
     */
    public boolean delete(T data){
        Node current = head; //points to the first element in the list.
        Node temp = null; 
        
        while(current != null){
            if(current.data.equals(data)){
                break;
            }
            temp = current;
            current = current.next;
        }
        
        if(current == null){
            return false;
        }
        
        else if(current == head){
            head = head.next;
        }
        else
            temp.next = current.next;
            return true;
    }
    
    /**
     Reverses the elements in the singly-linked list.
     */
    public void reverse(){
        /**
         checks to see if the list is empty, in which case, the list is returned
         as is with the head pointer pointing to null;
         */
        if(isEmpty()){
            return;
        }
        Node temp = head;//temporary node points to the first element.
        int count = 0; //count used to iterate through the list.
        
        while(temp != null){
            count++;
            temp = temp.next;//iterates until the temp pointer is pointing to
                             //null value which means the end of the list.
        }   
        ascendingOrder = !ascendingOrder; //reverses the boolean so that the 
        //insert method knows which format to insert new elements in.
        
        int i = 0;
        
        while(i < count){
            T data = head.data;//sequentially points to the "head" of the list,
                               //after the previous head is removed or until the
                               //list is fully reversed.
            delete(head.data);//removes each node in the list sequentially.
            insert(data);//reinserts the node in the new position.
            i++;
        }
    }
    
    /**
     Overridden toString method for singly-linked lists;
     @return The ordered singly-linked list as a String.
     */
    @Override
    public String toString(){
        if(isEmpty()){
            return null;//returns null if the list is empty.
        }
        
        else{
            String str = "";
            Node current = head;
            while(current != null){
               str += current.data + " ";
               current = current.next;
            }
            str += "\n";
            return str;
        }
    }
}