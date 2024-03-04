import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class CreationOfGraph{
    public static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph, int src, int dest, int wt){
        graph[src].add(new Edge(src,dest,wt));
    }
    public static void BFS(ArrayList<Edge>[] graph, int V, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int curr = queue.remove();
            if(!visited[curr]){
                System.out.print(curr+" ");
                visited[curr] = true;
            }
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                queue.add(e.dest);
            }
        }
        System.out.println();
    }
    public static void DFS(ArrayList<Edge>[] graph, int curr, boolean[] visited){
        if(visited[curr]){
            return;
        }
        System.out.println(curr);
        visited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            DFS(graph, e.dest, visited);
        }
    }
    public static void allPaths(ArrayList<Edge>[] graph, int src, int dest, String path, boolean[] visited){
        if(src == dest){
            System.out.println(path);
            return;
        }
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest]){
                visited[e.dest] = true;
                allPaths(graph, e.dest, dest,path+"->"+e.dest,visited);
                visited[e.dest] = false;
            }
        }
    }
    public static void main(String[] args) {
        int V = 7;
        boolean[] visited = new boolean[V];
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        createGraph(graph,0,1,1);
        createGraph(graph,0,2,1);

        createGraph(graph,1,0,1);
        createGraph(graph,1,3,1);

        createGraph(graph,2,0,1);
        createGraph(graph,2,4,1);

        createGraph(graph,3,1,1);
        createGraph(graph,3,4,1);
        createGraph(graph,3,5,1);

        createGraph(graph,4,2,1);
        createGraph(graph,4,3,1);
        createGraph(graph,4,5,1);

        createGraph(graph,5,3,1);
        createGraph(graph,5,4,1);
        createGraph(graph,5,6,1);

        createGraph(graph,6,5,1);

//        BFS(graph, 7, visited);
//        DFS(graph,0,visited);
        int src = 0;
        int tar = 5;
        visited[src] = true;
        allPaths(graph,src,tar,""+src,visited);
    }
}