import java.util.*;
import java.util.Stack;

public class TopologicalSort {
    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void topSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> stack){
        visited[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest]){
                topSort(graph, e.dest, visited, stack);
            }
        }
        stack.push(src);
    }

    public static void topSortUtil(ArrayList<Edge>[] graph , int V, Stack<Integer> stack){
        boolean[] visited = new boolean[V];
        for(int i=0; i< graph.length; i++){
            if(!visited[i]) {
                topSort(graph, i, visited, stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topSortUtil(graph, V, new Stack<>());
    }
}
