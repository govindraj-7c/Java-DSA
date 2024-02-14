import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    int idx = -1;
    public Node insertion(int[] arr){
        idx++;
        if(arr[idx] == -1){
            return null;
        }
        Node newNode = new Node(arr[idx]);
        newNode.left = insertion(arr);
        newNode.right = insertion(arr);
        return newNode;
    }
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" -> ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" -> ");
        inOrder(root.right);
    }
    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" -> ");
    }
    public void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node curr = queue.remove();
            if(curr == null){
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }
                else {
                    queue.add(null);
                }
            }
            else{
                System.out.print(curr.data+" ");
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
        }
    }
    public int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftCount = heightOfTree(root.left);
        int rightCount = heightOfTree(root.right);
        return Math.max(leftCount,rightCount )+ 1;
    }
    public int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftCount = heightOfTree(root.left);
        int rightCount = heightOfTree(root.right);
        return leftCount + rightCount + 1;
    }
    public int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }
    public int diameterOfTree(Node root){
        if(root == null){
            return 0;
        }
        int dia1 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
        int dia2 = diameterOfTree(root.left);
        int dia3 = diameterOfTree(root.right);
        return Math.max(dia1, Math.max(dia2,dia3));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        Node root = null;
        while(true){
            System.out.println("1.Insertion");
            System.out.println("2.PreOrder");
            System.out.println("3.InOrder");
            System.out.println("4.PostOrder");
            System.out.println("5.LevelOrder");
            System.out.println("6.Height of Tree");
            System.out.println("7.Count Of Nodes");
            System.out.println("8.Sum of Nodes");
            System.out.println("9.Diameter Of Tree");
            System.out.println("0.Exit");
            System.out.println("Enter Your choice:");
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.println("Enter Size of Array:");
                int size = sc.nextInt();
                System.out.println("Enter Array Elements:");
                int[] arr = new int[size];
                for(int i=0; i<size; i++){
                    arr[i] = sc.nextInt();
                }
                root = bt.insertion(arr);
                System.out.println();
            } else if (choice == 2) {
                bt.preOrder(root);
                System.out.println();
            } else if (choice == 3) {
                bt.inOrder(root);
                System.out.println();
            } else if (choice == 4) {
                bt.postOrder(root);
                System.out.println();
            } else if (choice == 5) {
                bt.levelOrder(root);
                System.out.println();
            } else if (choice == 6) {
                System.out.println(bt.heightOfTree(root));
            } else if (choice == 7) {
                System.out.println(bt.countOfNodes(root));
            } else if (choice == 8) {
                System.out.println(bt.sumOfNodes(root));
            } else if (choice == 9) {
                System.out.println(bt.diameterOfTree(root));
            } else if (choice == 0) {
                return;
            }
        }
    }
}
