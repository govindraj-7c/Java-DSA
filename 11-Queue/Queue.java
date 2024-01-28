import java.util.Scanner;
public class Queue {
    static int size = 5;
    static int front = -1, rear = -1;
    static int[] arr = new int[size];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.EnQueue");
            System.out.println("2.DeQueue");
            System.out.println("3.Display");
            System.out.println("0.Exit");
            System.out.println("Enter Your Choice:");
            int choice = sc.nextInt();
            switch (choice){
                case 1: enqueue();
                    break;
                case 2: dequeue();
                    break;
                case 3: display();
                    break;
                case 0: return;
                default:
                    System.out.println("You Entered Wrong Choice..");
                    break;
            }
        }
    }
    public static boolean isEmpty(){
        if((front == -1 && rear == -1) || (front > size-1)){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean isFull(){
        if(rear >= size-1){
            return true;
        }
        else{
            return false;
        }
    }
    public static void enqueue(){
        Scanner sc = new Scanner(System.in);
        if(isFull()){
            System.out.println("Queue is Full..");
        }
        else{
            if(front == -1){
                front++;
            }
            System.out.println("Enter Element to Insert:");
            int ele = sc.nextInt();
            arr[++rear] = ele;
            System.out.println(ele+" Inserted Successfully..");
        }
    }
    public static void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty..");
        }
        else{
            System.out.println(arr[front++]+" removed Successfully..");
        }
    }
    public static void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty..");
        }
        else{
            for(int i=front; i<=rear; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
