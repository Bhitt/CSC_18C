/*
 * Author: Branden Hitt
   Purpose: implement a deque class utilizing Prof Conrad's deque interface
 */
package deque_assignment;

/**
 *
 * @author bhitt
 */
public class Deque_Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create deque
        Deque<Integer> de = new Deque<>();
        
        System.out.println("Is the deque empty: "+de.isEmpty());
        System.out.println("The size of the deque: "+ de.size());
        System.out.print("Current Queue: ");
        de.display();
        System.out.print("\n \n");
        
        //enque to the back 3 items
        System.out.println("Adding 3 items to the back of the deque (10,11,12)");
        de.enqueue_back(10);
        de.enqueue_back(11);
        de.enqueue_back(12);
        
        //display the contents
        System.out.print("Current Queue: ");
        de.display();
        System.out.print("\n \n");

        
        //add item to the front and another item to the back
        System.out.println("Adding an item to the front and back of the deque (9,13)");
        de.enqueue_front(9);
        de.enqueue_back(13);
        
        //display the contents
        System.out.print("Current Queue: ");
        de.display();
        System.out.print("\n \n");
        
        //remove and return an item from the front
        System.out.println("Dequeue an item from the front: "+ de.dequeue_front());
        
        //display the contents
        System.out.print("Current Queue: ");
        de.display();
        System.out.print("\n \n");
        
        //remove and return an item from the back
        System.out.println("Dequeue an item from the back: "+ de.dequeue_back());
        
        //display the contents
        System.out.print("Current Queue: ");
        de.display();
        System.out.print("\n \n");
        
        //display the remaining contents
        System.out.println("Is the deque empty: "+ de.isEmpty());
        System.out.println("The size of the deque: "+ de.size());
        System.out.print("Current Queue: ");
        de.display();
        System.out.print("\n \n");
    }
    
}
