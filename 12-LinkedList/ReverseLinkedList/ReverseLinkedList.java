package ReverseLinkedList;
import java.util.Scanner;
public class ReverseLinkedList {
    Node head;
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void insertion(int data){
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
    }
    public void reverse(){
        if(head == null || head.next == null){
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }
    public void display(){
        if(head == null){
            System.out.println("Linked is Empty!!");
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
        ReverseLinkedList rll = new ReverseLinkedList();
        int[] arr = new int[5];
        System.out.println("Enter Five Elements:");
        for(int i=0; i<5; i++){
            arr[i] = sc.nextInt();
            rll.insertion(arr[i]);
        }
        rll.display();
        rll.reverse();
        rll.display();
    }
}
