import java.util.*;
public class BellmanFord {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-10));
    }

    public static void bellmanFordAlgo(ArrayList<Edge>[] graph, int V, int src){
        int[] des = new int[V];
        for(int i=0; i<V; i++){
            des[i] = Integer.MAX_VALUE;
        }
        des[0] = 0;

        for(int k=0; k<V-1; k++){
            for(int j=0; j<V; j++){
                for(int i=0; i<graph[j].size(); i++){
                    Edge e = graph[j].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(des[u] != Integer.MAX_VALUE && des[u]+e.wt < des[v]){
                        des[v] = des[u]+e.wt;
                    }
                }
            }
        }
        //Negative Cycle Detection:
        for(int k=0; k<V-1; k++){
            for(int j=0; j<V; j++){
                for(int i=0; i<graph[j].size(); i++){
                    Edge e = graph[j].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(des[u] != Integer.MAX_VALUE && des[u]+e.wt < des[v]){
                        System.out.println("Negative Cycle Detected!!");
                    }
                }
            }
        }

        for(int i=0; i< des.length; i++){
            System.out.print(des[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        bellmanFordAlgo(graph,V,0);
    }
}
