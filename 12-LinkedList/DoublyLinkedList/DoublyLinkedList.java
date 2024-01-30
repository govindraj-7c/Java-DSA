package DoublyLinkedList;
import java.util.Scanner;
public class DoublyLinkedList {
    Node head;
    public class Node{
        int data;
        Node prev;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
        newNode.prev = currNode;
    }
    public void insertAtStart(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    public void insertAtMiddle(int data, int key){
        Node newNode = new Node(data);
        Node currNode = head;
        while(currNode.data != key){
            currNode = currNode.next;
        }
        newNode.next = currNode.next;
        newNode.prev = currNode;
        currNode.next = newNode;
    }
    public void deleteAtEnd(){
        if(head == null){
            System.out.println("Linked List is Empty!!");
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        Node prevNode = currNode.prev;
        prevNode.next = null;
        currNode.prev = null;
    }
    public void deleteAtStart(){
        if(head == null){
            System.out.println("Linked List is Empty!!");
            return;
        }
        head = head.next;
        head.prev = null;
    }
    public void deleteAtMiddle(int key){
        Node currNode = head;
        while(currNode.data != key){
            currNode = currNode.next;
        }
        Node prevNode = currNode.prev;
        Node nextNode = currNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public void display(){
        if(head == null){
            System.out.println("Linked List is Empty!!");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data+" <-> ");
            currNode = currNode.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
        while(true){
            System.out.println("1.InsertAtEnd");
            System.out.println("2.InsertAtStart");
            System.out.println("3.InsertAtMiddle");
            System.out.println("4.DeleteAtEnd");
            System.out.println("5.DeleteAtStart");
            System.out.println("6.DeleteAtMiddle");
            System.out.println("7.Display");
            System.out.println("0.Exit");
            System.out.println("Enter Your Choice:");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter value:");
                    int val1 = sc.nextInt();
                    dll.insertAtEnd(val1);
                break;
                case 2:
                    System.out.println("Enter Value:");
                    int val2 = sc.nextInt();
                    dll.insertAtStart(val2);
                break;
                case 3:
                    System.out.println("Enter value and Key:");
                    int val3 = sc.nextInt();
                    int key = sc.nextInt();
                    dll.insertAtMiddle(val3,key);
                break;
                case 4:
                    dll.deleteAtEnd();
                break;
                case 5:
                    dll.deleteAtStart();
                break;
                case 6:
                    System.out.println("Enter Key:");
                    int key2 = sc.nextInt();
                    dll.deleteAtMiddle(key2);
                break;
                case 7:
                    dll.display();
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
