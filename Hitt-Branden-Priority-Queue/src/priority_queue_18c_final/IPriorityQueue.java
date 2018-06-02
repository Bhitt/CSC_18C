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
public interface IPriorityQueue<T> {
    
    // returns true if the queue is empty (no items in queue) 
    //         false if queue is (has at least one or more items in queue)
    public boolean isEmpty();
    
    // returns the highest-priority element but does not modify the queue
    public T peek();
    
    //insert –  insert an element into the queue with a given priority (higher priority value, 
    //          the higher the priority is for the data element).
    public void insert(T element,Double priority);
    
    //remove_maximum – removes the highest priority element from the priority queue and returns it
    public T remove_maximum();
    
    //decrease – search for element in the priority queue and decrease its priority to the new
    //           priority level (priority = priority – priority_delta).
    public void decrease(T element, Double priority_delta);
    
    //increase – search for element in the priority queue and increase its priority to the new
    //           priority level (priority = priority + priority_delta).
    public void increase(T element, Double priority_delta);
    
    //display – display the elements in the priority queue in order from highest priority to
    //          lowest priority.
    public void display();
}
