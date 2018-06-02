/*
 * Author : Branden Hitt
 * Assignment Specifications: Implement a priority queue in Java using a single linked list. 
    For information on Priority Queues, visit: https://en.wikipedia.org/wiki/Priority_queue.  
    You are to implement the following methods: insert(element, priority), remove_maximum(), 
    decrease(element, priority_delta), increase(element, priority_delta), and display(). 
    The specifications for each method is as follows:
    1.	insert – insert an element into the queue with a given priority (higher priority value,
        the higher the priority is for the data element).
    2.	remove_maximum – removes the highest priority element from the priority queue.
    3.	decrease – search for element in the priority queue and decrease its priority to the new
        priority level (priority = priority – priority_delta).
    4.	increase – search for element in the priority queue and increase its priority to the new
        priority level (priority = priority + priority_delta).
    5.	display – display the elements in the priority queue in order from highest priority to
        lowest priority.
 */
package priority_queue_18c_final;

/**
 *
 * @author bhitt
 */
public class PriorityQueue<T> implements IPriorityQueue<T> {

    // linked list containing the items in the priority queue
    private Node<T> head=null;

    // current number of items in priority queue
    private int numberOfItems;

    // PriorityQueue constructor that starts with empty queue.
    public PriorityQueue()
    {
        numberOfItems=0; // default to zero items
    }
    
    // returns true if the queue is empty (no items in queue) 
    //         false if queue is (has at least one or more items in queue)
    @Override
    public boolean isEmpty() {
        return numberOfItems==0;
    }

    // returns the highest-priority element but does not modify the queue
    @Override
    public T peek() {
        if ( isEmpty() )
            return null;
        return head.getValue();
    }

    //insert –  insert an element into the queue with a given priority (higher priority value, 
    //          the higher the priority is for the data element).
    @Override
    public void insert(T element, Double priority) {
        Node<T> newNode =  new Node<T>(element, priority);
        //if there are no elements in the queue
        if(head == null){
            head = newNode;
            numberOfItems++;
            return;
        }
        //if there are existing elements
        Node<T> current=head;
        for(int i=0;i<numberOfItems;i++)
        {
            if(newNode.getPriority() >= current.getPriority()){
                //place node before current
                newNode.setNext(current);
                //check for first
                if(current.getPrevious() == null) head = newNode;
                else{
                    current.getPrevious().setNext(newNode);
                }
                current.setPrevious(newNode);
                break;
            }else{
                if ( current.getNext() == null ){
                    current.setNext(newNode);
                    newNode.setPrevious(current);
                    break;
                }
                current=current.getNext();
                  
            }

        }
        numberOfItems++;
    }

    //remove_maximum – removes the highest priority element from the priority queue and returns it
    @Override
    public T remove_maximum() {
        T headDataValue = null;
        if ( numberOfItems > 0 )
        {
                headDataValue = head.getValue();
                Node<T> oldHead=head;
                head=head.getNext();
                head.setPrevious(null);
                oldHead.setNext(null);
                oldHead.setPrevious(null);
                numberOfItems--;
        }
        return headDataValue;  // returns the data value from the popped head, null if queue empty
    }

    
    //decrease – search for element in the priority queue and decrease its priority to the new
    //           priority level (priority = priority – priority_delta).
    @Override
    public void decrease(T element, Double priority_delta) {
        Node<T> current=head;
        //if the element being changed is the head
        if(element == current.getValue()){
            current.setPriority(current.getPriority() - priority_delta);
            //if there is only one element in the queue
            if(current.getNext() == null) return;
            //
            current.getNext().setPrevious(null);
            head = current.getNext();
            numberOfItems--;
            insert(current.getValue(),current.getPriority());
            return;
        }
        //find the element being changed
        for(int i=0;i<numberOfItems;i++)
        {
            if(current.getValue() == element){
                current.setPriority(current.getPriority() - priority_delta);
                if(current.getNext() != null){
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious()); 
                }else{
                    current.getPrevious().setNext(null);
                }
                numberOfItems--;
                insert(current.getValue(),current.getPriority());
                return;
            }
            current=current.getNext();
            if ( current==null ) break;
        }
    }

    //increase – search for element in the priority queue and increase its priority to the new
    //           priority level (priority = priority + priority_delta).
    @Override
    public void increase(T element, Double priority_delta) {
        Node<T> current=head;
        //if the element being changed is the head
        if(element == current.getValue()){
            current.setPriority(current.getPriority() + priority_delta);
            //if there is only one element in the queue
            if(current.getNext() == null) return;
            //
            current.getNext().setPrevious(null);
            head = current.getNext();
            numberOfItems--;
            insert(current.getValue(),current.getPriority());
            return;
        }
        //find the element being changed
        for(int i=0;i<numberOfItems;i++)
        {
            if(current.getValue() == element){
                current.setPriority(current.getPriority() + priority_delta);
                if(current.getNext() != null){
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious()); 
                }else{
                    current.getPrevious().setNext(null);
                }
                numberOfItems--;
                insert(current.getValue(),current.getPriority());
                return;
            }
            current=current.getNext();
            if ( current==null ) break;
        }
    }

    //display – display the elements in the priority queue in order from highest priority to
    //          lowest priority.
    @Override
    public void display() {
        Node current=head;
        System.out.println("----Priority Queue----");
        System.out.println("Item count: "+numberOfItems);
        for(int i=0;i<numberOfItems;i++)
        {
                System.out.println(current.getValue()+" ("+current.getPriority()+")");
                current=current.getNext();
                if ( current==null ) break;
        }
        System.out.println("----------------------");
    }
    
    // Node Inner Class
    private class Node<T> {
        private T value;
        private Double priority;
        private Node _previous, _next;
    
        public Node(T data, Double p) {
            value = data;
            _previous = null;
            _next = null;
            priority = p;
        }
    
        protected Node(T data, Double p, Node previousNode, Node nextNode) {
            value = data;
            _previous = previousNode;
            _next = nextNode;
            priority = p;
        }
		
        public Node getNext() {
            return _next;
        }
		
	public Node getPrevious() {
            return _previous;
        }
        
	public void setValue(T newValue)
	{
            value=newValue;
	}
        
        public void setPriority(Double newPriority)
        {
            priority = newPriority;
        }

        public T getValue() {
            return value;
        }
        
        public Double getPriority(){
            return priority;
        }
    
        public void setNext(Node newNextNode) {
            _next = newNextNode;
        }
		
	public void setPrevious(Node newPreviousNode) {
            _previous = newPreviousNode;
        }
    }
}
