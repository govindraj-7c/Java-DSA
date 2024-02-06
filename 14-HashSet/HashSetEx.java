import java.util.*;
public class HashSetEx {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        //Adding Values:
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        //Printing Size Of HashSet:
        System.out.println("Size: "+set.size());

        //Searching The Element:
        if(set.contains(1)){
            System.out.println("Element Is Present..");
        }
        else{
            System.out.println("Element Is Not Present..");
        }

        //Deleting Element from HashSet:
        set.remove(4);
        if(set.contains(4)){
            System.out.println("Element is present..");
        }
        else{
            System.out.println("Element is Not Present..");
        }

        //Printing All Elements Of HashSet:
        System.out.print(set);
        System.out.println();

        //Iterating HashSet Elements:
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" , ");
        }
        System.out.println();

        //Checking HashSet is Empty Or Not:
        if(!set.isEmpty()){
            System.out.println("Not Empty..");
        }
        else{
            System.out.println("Empty..");
        }
    }
}
