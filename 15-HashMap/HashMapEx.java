import java.util.*;
public class HashMapEx {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        //Insertion in HashMap:
        map.put("India",100);
        map.put("China",150);
        map.put("USA",50);
        map.put("Russia",70);

        //Printing HashMap:
        System.out.println(map);

        //Deletion in HashMap:
        map.remove("China");
        System.out.println(map);

        //Searching Value is Present OR Not:
        if(map.containsKey("India")){
            System.out.println("Value is Present..");
        }
        else{
            System.out.println("Value is Not Present..");
        }

        //Getting the Value By Using it's Key:
        System.out.println(map.get("India"));
        System.out.println(map.get("Russia"));

        //Iteration 1:
        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.print(e.getKey()+" ");
            System.out.print(e.getValue());
            System.out.println();
        }

        //Iteration 2:
        Set<String> key = map.keySet();
        for(String keys : key){
            System.out.println(keys+" : "+ map.get(keys));
        }
    }
}
