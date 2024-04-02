import java.util.*;
import java.util.Stack;

public class KosarajuAlgorithm {
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

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));
    }

    public static void dfs(ArrayList<Edge>[] graph, boolean[] visited, int src){
        visited[src] = true;
        System.out.print(src+" ");
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest]){
                dfs(graph,visited,e.dest);
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack){
        visited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                topSort(graph,e.dest,visited,stack);
            }
        }
        stack.push(curr);
    }
    public static void kosarajuAlgo(ArrayList<Edge>[] graph, int V){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                topSort(graph,i,visited,stack);
            }
        }

        ArrayList<Edge>[] transpose = new ArrayList[V];

        for(int i=0; i<V; i++){
            transpose[i] = new ArrayList<>();
        }

        for(int i=0; i<V; i++){
            visited[i] = false;
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        while (!stack.isEmpty()){
            int curr = stack.pop();
            if(!visited[curr]) {
                System.out.print("SCC : ");
                dfs(transpose,visited,curr);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        kosarajuAlgo(graph, V);
    }
}
