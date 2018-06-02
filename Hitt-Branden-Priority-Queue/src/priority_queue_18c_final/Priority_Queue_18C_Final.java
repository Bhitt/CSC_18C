/* Author : Branden Hitt
 * Assignment Specifications: Implement a priority queue in Java using a single linked list. 
    For information on Priority Queues, visit: https://en.wikipedia.org/wiki/Priority_queue.  
    You are to implement the following methods: insert(element, priority), remove_maximum(), 
    decrease(element, priority_delta), increase(element, priority_delta), and display(). 
    The specifications for each method is as follows:
1.	insert – insert an element into the queue with a given priority (higher priority value, the higher the priority is for the data element).
2.	remove_maximum – removes the highest priority element from the priority queue.
3.	decrease – search for element in the priority queue and decrease its priority to the new priority level (priority = priority – priority_delta).
4.	increase – search for element in the priority queue and increase its priority to the new priority level (priority = priority + priority_delta).
5.	display – display the elements in the priority queue in order from highest priority to lowest priority.

 */
package priority_queue_18c_final;

/**
 *
 * @author bhitt
 */
public class Priority_Queue_18C_Final {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("**Adding 3 elements: Doctor Strange(2)");
        System.out.println("                      Thor (3)");
        System.out.println("                      Spiderman (1)");
        PriorityQueue<String> pQueue = new PriorityQueue<>();
        pQueue.insert("Doctor Strange", Double.valueOf(2));
        pQueue.insert("Thor", Double.valueOf(3));
        pQueue.insert("Spiderman", Double.valueOf(1));
        pQueue.display();
        System.out.println();
        
        System.out.println("**Decreasing element Thor by 2");
        pQueue.decrease("Thor", Double.valueOf(2));
        pQueue.display();
        System.out.println();
        
        System.out.println("**Increasing element Spiderman by 2");
        pQueue.increase("Spiderman", Double.valueOf(2));
        pQueue.display();
        System.out.println();
        
        System.out.println("**Is the queue empty: "+pQueue.isEmpty());
        System.out.println("**Peek the top element: "+pQueue.peek());
        System.out.println("Remove the highest priority: "+pQueue.remove_maximum());
        pQueue.display();
        System.out.println();
        
        System.out.println("**Add one final element: DeadPool (7)");
        pQueue.insert("DeadPool", Double.valueOf(7));
        pQueue.display();
    }
}
