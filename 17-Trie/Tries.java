import java.util.Scanner;
public class Tries {
    static class Node{
        Node[] children = new Node[26];
        boolean eow;
        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
        int level = 0;
        int len = word.length();
        int idx = 0;

        Node curr = root;
        for(; level<len; level++){
            idx = word.charAt(level)-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public static boolean search(String word){
        int level = 0;
        int len = word.length();
        int idx = 0;
        Node curr = root;
        for(; level<len; level++){
            idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String[] words = {"the", "a", "there", "their", "any", "thee"};
//        for (String word : words) {
//            insert(word);
//            System.out.println("inserted " + word);
//        }

        while (true){
            System.out.println("1.Insertion");
            System.out.println("2.Searching");
            System.out.println("0.Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.println("Enter Any Word");
                String word = sc.next();
                insert(word);
                System.out.println();
            } else if (choice == 2) {
                System.out.println("Enter Word to search");
                String word = sc.next();
                System.out.println(word+" : "+search(word));
                System.out.println();
            } else if (choice == 0) {
                return;
            }
        }
    }
}
