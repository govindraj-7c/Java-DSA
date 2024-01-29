import java.util.Scanner;
public class LinkedList {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode != null){
            currNode = currNode.next;
        }
        currNode = newNode;
    }
    public void insertAtStart(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void insertAtMiddle(int data, int key){
        Node newNode = new Node(data);
        Node currNode = head;
        while(currNode.data != key){
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        currNode.next = newNode;
    }
    public void deleteAtEnd(){
        if(head == null){
            System.out.println("Linked List is Empty!!");
            return;
        }
        else if(head.next == null){
            head = null;
            return;
        }
        Node currNode = head;
        while(currNode.next.next != null){
            currNode = currNode.next;
        }
        currNode.next = null;
    }
    public void deleteAtStart(){
        if(head == null){
            System.out.println("Linked List Empty!!");
            return;
        }
        head = head.next;
    }
    public void display(){
        if(head == null){
            System.out.println("Linked List is Empty!!");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        while(true){
            System.out.println("1.InsertAtEnd");
            System.out.println("2.InsertAtStart");
            System.out.println("3.InsertAtMiddle");
            System.out.println("4.DeleteAtEnd");
            System.out.println("5.DeleteAtStart");
            System.out.println("6.Display");
            System.out.println("0.Exit");
            System.out.println("Enter Your Choice:");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter value");
                    int val1 = sc.nextInt();
                    ll.insertAtEnd(val1);
                    break;
                case 2:
                    System.out.println("Enter value");
                    int val2 = sc.nextInt();
                    ll.insertAtStart(val2);
                    break;
                case 3:
                    System.out.println("Enter value and Key");
                    int val3 = sc.nextInt();
                    int key = sc.nextInt();
                    ll.insertAtMiddle(val3, key);
                    break;
                case 4:
                    ll.deleteAtEnd();
                    break;
                case 5:
                    ll.deleteAtStart();
                    break;
                case 6:
                    ll.display();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("You Entered Wrong Choice");
                    break;
            }
        }
    }
}
