import java.util.*;
public class ArticulationPoint {
    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph, int V){
        for(int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,0));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
    }

    public static void dfs(ArrayList<Edge>[] graph, int[] dt, int[] low, int time, boolean[] visited, boolean[] ap, int curr, int par){
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;
            if(neigh == par){
                continue;
            } else if (visited[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
            else{
                dfs(graph, dt, low, time, visited, ap, neigh, curr);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(dt[curr] <= low[neigh] && par != -1){
                    ap[curr] = true;
                }
                children++;
            }
        }

        if(par == -1 && children > 1){
            ap[curr] = true;
        }
    }

    public static void getAp(ArrayList<Edge>[] graph, int V){
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] visited = new boolean[V];
        boolean[] ap = new boolean[V];

        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(graph, dt, low, time, visited, ap, i, -1);
            }
        }

        for(int i=0; i<V; i++){
            if(ap[i]){
                System.out.println("Articulation Point : "+i);
            }
        }
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph,V);

        getAp(graph, V);
    }
}
