package CircularLinkedList;
import java.util.Scanner;
public class CircularLinkedList{
    Node head;
    public class Node{
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
            head.next = head;
            return;
        }
        Node currNode = head;
        while(currNode.next != head){
            currNode = currNode.next;
        }
        currNode.next = newNode;
        newNode.next = head;
    }
    public void insertAtStart(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            head.next = head;
        }
        Node currNode = head;
        while(currNode.next != head){
            currNode = currNode.next;
        }
        currNode.next = newNode;
        newNode.next = head;
        head = newNode;
    }
    public void insertAtMiddle(int data, int key){
        Node newNode = new Node(data);
        Node currNode = head;
        if(currNode.next == head){
            currNode.next = newNode;
            newNode.next = head;
            return;
        }
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
        Node currNode = head;
        while(currNode.next.next != head){
            currNode = currNode.next;
        }
        currNode.next = head;
    }
    public void deleteAtStart(){
        if(head == null){
            System.out.println("Linked List is Empty!!");
            return;
        }
        Node currNode = head;
        while(currNode.next != head){
            currNode = currNode.next;
        }
        currNode.next = head.next;
        head = head.next;
    }
    public void deleteAtMiddle(int key){
        Node currNode = head;
        while(currNode.next.data != key){
            currNode = currNode.next;
        }
        currNode.next = currNode.next.next;
    }
    public void display(){
        if(head == null){
            System.out.println("Linked List is Empty!!");
            return;
        }
        Node currNode = head;
        do{
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }while(currNode != head);
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList cll = new CircularLinkedList();
        while(true){
            System.out.println("1.InsertAtEnd");
            System.out.println("2.InsertAtStart");
            System.out.println("3.InsertAtMiddle");
            System.out.println("4.DeleteAtEnd");
            System.out.println("5.DeleteAtStart");
            System.out.println("6.DeleteAtMiddle");
            System.out.println("7.Display");
            System.out.println("0.Exit");
            System.out.println("Enter Your Choice");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Value");
                    int val1 = sc.nextInt();
                    cll.insertAtEnd(val1);
                break;
                case 2:
                    System.out.println("Enter Value");
                    int val2 = sc.nextInt();
                    cll.insertAtStart(val2);
                break;
                case 3:
                    System.out.println("Enter Value And Key");
                    int val3 = sc.nextInt();
                    int key1 = sc.nextInt();
                    cll.insertAtMiddle(val3,key1);
                break;
                case 4:
                    cll.deleteAtEnd();
                break;
                case 5:
                    cll.deleteAtStart();
                break;
                case 6:
                    System.out.println("Enter Key:");
                    int key2 = sc.nextInt();
                    cll.deleteAtMiddle(key2);
                break;
                case 7:
                    cll.display();
                break;
                case 0:
                    return;
                default:
                    System.out.println("You Entered Wrong Choice..");
                break;
            }
        }
    }
}