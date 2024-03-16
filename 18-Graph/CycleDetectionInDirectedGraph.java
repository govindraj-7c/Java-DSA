import java.util.*;
public class CycleDetectionInDirectedGraph {
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

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));
    }
    public static boolean cycleDetection(ArrayList<Edge>[] graph, int src, boolean[] visited, boolean[] stack){
        visited[src] = true;
        stack[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(stack[e.dest]){
                return true;
            }
            else if(cycleDetection(graph,e.dest,visited,stack)){
                return true;
            }
        }
        stack[src] = false;
        return false;
    }
    public static boolean cycleDetectionUtil(ArrayList<Edge>[] graph, int V){
        boolean[] visited = new boolean[V];
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                return cycleDetection(graph,i,visited,new boolean[V]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(cycleDetection(graph,0,new boolean[V],new boolean[V]));
    }
}
