/*
Author: Branden Hitt
Purpose: Implement a program that computes all the primes up to some integer n,
         have this n be an integer you prompt the user to enter. 
 */
package sieve.of.eratosthenes;

import java.util.Scanner;

/**
 *
 * @author bhitt
 */
public class SieveOfEratosthenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {     
        //bool for verbose output
        boolean isVerbose = false;
        for(int i=0;i<args.length;i++){
            if(args[i].equals("verbose") || 
               args[i].equals("--verbose")) isVerbose=true;
        }

        //scanner for input of number n
        System.out.println("This program finds all the primes up to n.");
        System.out.println("Enter in an integer (n):");
        Scanner input = new Scanner(System.in);
        
        //grab n
        Integer n = input.nextInt();
        
        //create queue of ints from 2 to n
        Queue<Integer> queueOfIntegers = new Queue<>();
        for(int i=2;i<n+1;i++){
            queueOfIntegers.enqueue(i);
        }
        
        //Create an empty queue to store primes, named queueOfPrimes
        Queue<Integer> queueOfPrimes = new Queue<>();
        
        //create variable for prime number p
        Integer p=0;
        //create temp variable for comparisons
        Integer temp=0;
        
        //empty queue
        Queue<Integer> newQueue;
        
        do{
            //display queueOfIntegers
            if(isVerbose){
                System.out.print("Content of: queueOfIntegers:");
                queueOfIntegers.display();
                System.out.print("\n \n");                
            }
            //Get the next prime number, p, by removing the first value in queueOfIntegers.
            p = queueOfIntegers.pop_front();
            if(isVerbose) System.out.println("Dequeuing a prime number: "+p + "\n");
            //Enqueue the value of p into queue of primes.
            queueOfPrimes.enqueue(p);
            if(isVerbose){
                System.out.print("Content of: queueOfPrimes: ");
                queueOfPrimes.display();
                System.out.print("\n \n");    
            }
            //Create a new queue and only carry values that arent divisible by current prime
            newQueue = new Queue<>();
            while(!queueOfIntegers.isEmpty()){
                //grab the top number in queueOfIntegers
                temp = queueOfIntegers.pop_front();
                //if divisible by current prime, throw in new queue
                if((temp%queueOfPrimes.back())!=0)newQueue.push_back(temp);
            }
            //add the newQueue numbers back into queueOfIntegers
            queueOfIntegers = newQueue;
        }while(!queueOfIntegers.isEmpty());
        queueOfPrimes.display();   
    } 
}
