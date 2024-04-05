import java.util.Comparator;
import java.util.PriorityQueue;

public class PQueue {
    public static void main(String[] args) {
        //for add elements in reverse order we use comparator.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        //Adding Elements in Priority - Queue
        pq.add(5);
        pq.add(10);
        pq.add(1);
        pq.add(7);
        pq.add(3);

        //Printing Priority-Queue Elements
        while(!pq.isEmpty()){
            System.out.print(pq.remove()+" ");
        }
    }
}
