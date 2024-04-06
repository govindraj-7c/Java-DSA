import java.util.PriorityQueue;

public class PQueue2 {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s) {
            return this.rank - s.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        //adding elements in Priority Queue
        pq.add(new Student("Govind", 100));
        pq.add(new Student("Chinmay", 50));
        pq.add(new Student("Ashok", 30));
        pq.add(new Student("Aditya", 40));

        //Printing Elements:
        while (!pq.isEmpty()){
            Student temp = pq.remove();
            System.out.println(temp.name+" -> "+temp.rank);
        }
    }
}
