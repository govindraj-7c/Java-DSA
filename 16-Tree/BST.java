import java.util.Scanner;
public class BST {
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public Node insertion(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insertion(root.left,val);
        }
        else{
            root.right = insertion(root.right,val);
        }
        return root;
    }
    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" -> ");
        inOrder(root.right);
    }
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" -> ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" -> ");
    }
    public boolean search(Node root, int val){
        if(root == null){
            return false;
        }
        else if(root.data > val){
            return search(root.left,val);
        }
        else if (root.data == val) {
            return true;
        }
        else{
            return search(root.right,val);
        }
    }
    public Node delete(Node root, int key){
        //first search that key is present or not
        if(root.data > key){
            root.left = delete(root.left,key);
        } else if (root.data < key) {
            root.right = delete(root.right,key);
        }
        else{
            //case 1: No Child
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2 : One Child
            if(root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }
            //case 3 : Both Child
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node inOrderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bt = new BST();
        Node root = null;
        while (true){
            System.out.println("1.Insertion");
            System.out.println("2.In-Order");
            System.out.println("3.Pre-Order");
            System.out.println("4.Post-Order");
            System.out.println("5.Search");
            System.out.println("6.Delete");
            System.out.println("0.Exit");
            System.out.println("Enter Your choice");
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.println("Enter size of Array");
                int size = sc.nextInt();
                System.out.println("Enter Array Elements");
                int[] arr = new int[size];
                for(int i=0; i<size; i++){
                    arr[i] = sc.nextInt();
                    root = bt.insertion(root,arr[i]);
                }
            } else if (choice == 2) {
                bt.inOrder(root);
                System.out.println();
            } else if (choice == 3) {
                bt.preOrder(root);
                System.out.println();
            } else if (choice == 4) {
                bt.postOrder(root);
                System.out.println();
            } else if (choice == 5) {
                System.out.println("Enter key to search:");
                int key = sc.nextInt();
                System.out.println(bt.search(root,key));
                System.out.println();
            } else if (choice == 6) {
                System.out.println("Enter Key to Delete:");
                int key = sc.nextInt();
                bt.delete(root,key);
                System.out.println();
            } else if (choice == 0) {
                return;
            }
        }
    }
}
