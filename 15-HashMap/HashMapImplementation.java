import java.security.Key;
import java.util.*;
import java.util.LinkedList;

public class HashMapImplementation {
    public static class HashMap<K,V>{
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n; // No. of Nodes
        private int N; // No. of buckets.
        private LinkedList<Node> buckets[];
        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<N; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }
        public void put(K key, V value){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di == -1){ // -1 means key is not exit.
                buckets[bi].add(new Node(key, value));
                n++;
            }
            else{ // key exists.
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            double lambda = (double) n/N;
            if(lambda > 2.0){
                rehash();
            }
        }
        private int hashFunction(K key){
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }
        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            for(int i=0; i<ll.size(); i++){
                if(ll.get(i).key == key){
                    return i;
                }
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node>[] oldBucket = buckets;
            buckets = new LinkedList[N*2];
            for(int i=0; i<N*2; i++){
                buckets[i] = new LinkedList<>();
            }
            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.get(j);
                    put(node.key,node.value);
                }
            }
        }
        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di == -1){ // -1 means key is not exit.
                return null;
            }
            else{ // key exists.
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }
        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di == -1){ // -1 means key is not exit.
                return false;
            }
            else{ // key exists.
                return true;
            }
        }
        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di == -1){ // -1 means key is not exit.
                return null;
            }
            else{ // key exists.
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }
        public boolean isEmpty(){
            return n == 0;
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> hm = new HashMap<>();
        System.out.println("Enter Key and Value");
        String key = sc.next();
        int val = sc.nextInt();
        hm.put(key,val);
        System.out.println(hm.containsKey(key));
        System.out.println(hm.get(key));
//        while(true){
//            System.out.println("1.Insert");
//            System.out.println("2.Remove");
//            System.out.println("3.ContainsKey");
//            System.out.println("4.Get");
//            System.out.println("5.KeySet");
//            System.out.println("6.IsEmpty");
//            System.out.println("0.Exit");
//            System.out.println("Enter Your Choice:");
//            int choice = sc.nextInt();
//            if(choice == 1){
//                System.out.println("Enter Key and Value");
//                String key = sc.next();
//                int value = sc.nextInt();
//                hm.put(key,value);
//                System.out.println("Insertion Done!!");
//                System.out.println();
//            } else if (choice == 2) {
//                System.out.println("Enter Key");
//                String key = sc.next();
//                System.out.println(hm.remove(key));
//            } else if (choice == 3) {
//                System.out.println("Enter Key");
//                String key = sc.next();
//                System.out.println(hm.containsKey(key));
//            } else if (choice == 4){
//                System.out.println("Enter Key");
//                String key = sc.next();
//                System.out.println(hm.get(key));
//            } else if (choice == 5) {
//                ArrayList<String> ans = hm.keySet();
//                for(String tmp : ans){
//                    System.out.print(tmp+" ");
//                }
//                System.out.println();
//            } else if (choice == 6) {
//                System.out.println(hm.isEmpty());
//            } else{
//                return;
//            }
//        }
    }
}
