import java.util.Scanner;
public class Stack {
    int top = -1;
    int size = 5;
    int[] arr = new int[size];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        while(true){
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("0. Exit");
            System.out.println("Enter Your Choice:");
            int choice = sc.nextInt();
            switch (choice){
                case 1 :
                    stack.push();
                    break;
                case 2 :
                    stack.pop();
                    break;
                case 3 :
                    stack.display();
                    break;
                case 0 :
                    return;
                default :
                    System.out.println("You Entered Wrong Choice..");
            }
        }
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == size-1;
    }
    void push(){
        Scanner sc = new Scanner(System.in);
        if(isFull())
            System.out.println("Stack is Full..");
        else{
            System.out.println("Enter Number to Push:");
            int no = sc.nextInt();
            ++top;
            arr[top] = no;
            System.out.println(no+" Pushed into the Stack..");
        }
    }
    void pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty..");
        }
        else{
            System.out.println(arr[top--]+" is Popped from the Stack");
        }
    }
    void display(){
        if(isEmpty()){
            System.out.println("Stack is Empty..");
        }
        else{
            for(int i=0; i<=top; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
