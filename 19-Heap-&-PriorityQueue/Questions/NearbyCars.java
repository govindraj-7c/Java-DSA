package Questions;

import java.util.PriorityQueue;

public class NearbyCars {
    static class Points implements Comparable<Points>{
        int x;
        int y;
        int distance;
        int idx;
        public Points(int x, int y, int distance, int idx){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.idx = idx;
        }

        @Override
        public int compareTo(Points p) {
            return this.distance - p.distance;
        }
    }
    public static void main(String[] args) {
        int[][] cars = {{3,3}, {5,-1}, {-2,4}};
        int k = 2;
        PriorityQueue<Points> pq = new PriorityQueue<>();
        for(int i=0; i< cars.length; i++){
            int dist = cars[i][0]*cars[i][0] + cars[i][1]*cars[i][1];
            pq.add(new Points(cars[i][0], cars[i][1], dist, i));
        }
        for(int i=0; i<k; i++){
            System.out.print("C"+pq.remove().idx+" ");
        }
    }
}
