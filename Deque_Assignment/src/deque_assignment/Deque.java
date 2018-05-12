/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deque_assignment;

/**
 *
 * @author bhitt
 */
public class Deque<T> implements DequeInterface {
    //linked list containing the items in the deque
    private Node<T> head=null, tail=null;
    
    //current number of items in the deque
    private int numItems;
    
    public Deque(){
        numItems = 0;
    }
    
    // returns true if the deque is empty (no items in deque) 
    // false if deque is (has at least one or more items in deque)
    @Override
    public boolean isEmpty() {
        return head==null;
    }

    
    // return the number of items currently in the deque
    @Override
    public int size() {
        return numItems;
    }

    
    // returns the value of the item currently at front of deque
    @Override
    public Object front() {
        if ( head==null ) return null;
        return head.getValue();
    }

    // returns the value of the item currently at the end of the deque
    @Override
    public Object back() {
        if ( tail==null ) return null;
        return tail.getValue();
    }

    // places parameter newItem onto the front of the deque
    @Override
    public void enqueue_front(Object newItem) {
        // if head node is null, make head and tail node contain the first node
        if ( head == null)
        {
                head = new Node(newItem);
                tail=head; // when first item is enqueued, head and tail are the same
                numItems++; // increment the number of items in the queue
        }
        else
        {
                Node<T> newNode = new Node(newItem);
                head.setPrevious(newNode);
                newNode.setNext(head);
                head=newNode;
                numItems++;
        }
    }

    // places parameter newItem onto the end of the deque
    @Override
    public void enqueue_back(Object newItem) {
        // if head node is null, make head and tail node contain the first node
        if ( head == null)
        {
                head = new Node(newItem);
                tail=head; // when first item is enqueued, head and tail are the same
                numItems++; // increment the number of items in the queue
        }
        else
        {
                Node<T> newNode = new Node(newItem);
                tail.setNext(newNode);
                newNode.setPrevious(tail);
                tail=newNode;
                numItems++;
        }
    }
    
    // returns and removes the current item at the front of the deque
    // the item that is in the deque behind the item becomes the new front item
    @Override
    public Object dequeue_front() {
        T headDataValue = null;
		if ( numItems > 0 )
		{
			headDataValue = head.getValue();
			Node<T> oldHead=head;
			head=head.getNext();
			oldHead.setNext(null);
			oldHead.setPrevious(null);		
			numItems--;
		}
		return headDataValue;  // returns the data value from the popped head, null if queue empty
    }
    
    
    // returns and removes the current item at the back of the deque
    // the item that is in the deque behind the item becomes the new front item
    @Override
    public Object dequeue_back() {
        T tailDataValue = null;
		if ( numItems > 0 )
		{
			tailDataValue = tail.getValue();
			Node<T> oldTail=tail;
			tail=tail.getPrevious();
			oldTail.setNext(null);
			oldTail.setPrevious(null);		
			numItems--;
		}
		return tailDataValue;  // returns the data value from the popped head, null if queue empty
    }

    // display all of the contents in the deque from front to back
    @Override
    public void display() {
      Node current=head;
      for(int i=0;i<numItems;i++){
          System.out.print(current.getValue()+" ");
          current=current.getNext();
          if(current==null)break;
      }
    }
    
    
    //*******************//
    // Node Inner Class  //
    //*******************//
    private class Node<T> {
        private T value;
        private Node _previous, _next;
    
        public Node(T data) {
            value = data;
            _previous = null;
			_next = null;
        }
    
        protected Node(T data, Node previousNode, Node nextNode) {
            value = data;
            _previous = previousNode;
			_next = nextNode;
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

        public T getValue() {
            return value;
        }
    
        public void setNext(Node newNextNode) {
            _next = newNextNode;
        }
		
	public void setPrevious(Node newPreviousNode) {
            _previous = newPreviousNode;
        }
    }
}
