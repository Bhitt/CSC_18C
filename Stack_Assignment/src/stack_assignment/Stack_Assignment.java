/*
  Branden Hitt
  Lab: Handle an expression with [],{}, and/or () then test it for valid balancing
 */
package stack_assignment;

import java.util.Scanner;

/**
 *
 * @author bhitt
 */
public class Stack_Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //scanner for input
        System.out.println("Enter an expression to test if balanced:");
        Scanner input = new Scanner(System.in);
        
        //grab statement for validation
        String statement = input.nextLine();
        
        //test strings
        //String statement = "(({{{}}()}))";
        //String statement = "12+ (34*67)";
        //String statement = "((())";
        //String statement = "12+ ((34+56) (34-12)";
        
        //add scope tags to stack and validate
        Stack<Character> cStack = new Stack<>();
        for (int i = 0; i < statement.length(); i++) {
            //display stack (for testing)
            //cStack.display();
            
            //check first char to make sure it is an opening scope tag
            if( cStack.isEmpty() && (statement.charAt(i) == '(' || statement.charAt(i) == '[' || statement.charAt(i) == '{')){
                //add opening to stack
                cStack.push(statement.charAt(i));
                continue;
            } else if(cStack.isEmpty() && (statement.charAt(i) == ')' || statement.charAt(i) == ']' || statement.charAt(i) == '}')){
                //first value is incorrect, end loop
                cStack.push(statement.charAt(i));
                break;
            }
            
            //match and remove
            if ( !cStack.isEmpty() && statement.charAt(i) == ')' && cStack.peek() == '(' ){
                cStack.pop();
            }else if( !cStack.isEmpty() && statement.charAt(i) == '}' && cStack.peek() == '{' ){
                cStack.pop();
            }else if( !cStack.isEmpty() && statement.charAt(i) == ']' && cStack.peek() == '[' ){
                cStack.pop();
            }else if( !cStack.isEmpty() && 
                      (statement.charAt(i) == '[' || statement.charAt(i) == ']' ||
                       statement.charAt(i) == '{' || statement.charAt(i) == '}' ||
                       statement.charAt(i) == '(' || statement.charAt(i) == ')' )){
                //add to stack
                cStack.push(statement.charAt(i));
            }
        }
        //output based on empty or full stack
        if(cStack.isEmpty()) System.out.println("true");
        else {
            //System.out.println("Current stack:");
            //cStack.display();
            System.out.println("false");
        }
        
    }

}
