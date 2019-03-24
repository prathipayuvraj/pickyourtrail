package pickyourtrail;

import java.util.Scanner;

public class SuperStack {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of operations to be performed");
		int operationsCount = scanner.nextInt();
		System.out.println("Enter the operations");
		String[] operations = new String[operationsCount];
		for(int i=0;i<operationsCount;i++) {
			operations[i] = scanner.nextLine();
		}
		Stack stack = new Stack();
		String currentOperation;
		for(int index = 0;index < operationsCount;index++) {
			currentOperation = operations[index];
			
			if(currentOperation.startsWith("push")) {
				stack.push(Integer.parseInt(currentOperation.split(" ")[1]));
			}
			else if(currentOperation.equals("pop")) {
				stack.pop();
			}
			else if(currentOperation.startsWith("inc")){
				stack.inc(Integer.parseInt(currentOperation.split(" ")[1]), Integer.parseInt(currentOperation.split(" ")[2]));
			}else {
				System.out.println("Invalid Operation");
			}
		}
	}

}

class Stack 
{ 
    static final int MAX = 200000; 
    int top; 
    int stackArray[] = new int[MAX]; // Maximum size of Stack 
  
    Stack() 
    { 
        top = -1; 
    } 
    
    //push operation
    void push(int x) 
    { 
        if (top <= (MAX-1)) 
        { 
            stackArray[++top] = x; 
            System.out.println(x);
        } 
    } 
  
    //pop operation
    void pop() 
    { 
            int x = stackArray[top--];
            System.out.println(top < 1 ? "EMPTY" : stackArray[top]);
        } 
    
    //increment operation
    void inc(int elements, int supplement) {
    	for(int index=0; index<elements; index++) {
    		stackArray[index] = stackArray[index] + supplement;
    	}
    	System.out.println(stackArray[top]);
    }
} 
