package lw05.prelab;

import java.util.*;

public class Main {
    static int[][] graph;
    static int size;
    static String[] names;

    static void addEdge(int from, int to, int minutes) {
        graph[from][to] = minutes;
        graph[to][from] = minutes;
    }

    static List<Integer> bfs(int start) {
        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();                  
            order.add(current);
            for (int next = 0; next < size; next++) {
                if (graph[current][next] > 0 && !visited.contains(next)) {                       
                    visited.add(next);
                    queue.add(next);                     
                }
            }
        }
        return order;
    }

    static Set<Integer> dfsVisited = new HashSet<>();  
    static List<Integer> dfsOrder = new ArrayList<>();  

    static void dfs(int current) {
        dfsVisited.add(current);                                  
        dfsOrder.add(current);
        for (int next = 0; next < size; next++) {
            if (graph[current][next] > 0 && !dfsVisited.contains(next)) {
                dfs(next);                           
            }
        }
    }

    static void dijkstraAlg(int start, int dest) {
        int[] dist = new int[size];
        for (int i = 0; i < size; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        boolean[] visited = new boolean[size];
        int[] prev = new int[size];

        for (int i = 0; i < size; i++) {
            int current = findTheNextNode(visited, dist);
            visited[current] = true;
            for (int next = 0; next < size; next++) {
                int newDist = dist[current] + graph[current][next];
                if (graph[current][next] > 0 && !visited[next] && newDist < dist[next]) {
                    dist[next] = newDist;
                    prev[next] = current;
                }
            }
        }

        System.out.println("=== Shortest Time from " + names[start] + " ===");
        for (int i = 0; i < size; i++) {
            System.out.println(names[i] + " : " + dist[i] + " min");
        }
        System.out.println("=== Shortest Route from " + names[start] + " to " + names[dest] + " ===");
        route(dest, start, prev);
        System.out.println();
        System.out.println("Total time: " + dist[dest] + " min");
    }

    static int findTheNextNode(boolean[] visited, int[] dist) {
        int min = Integer.MAX_VALUE;
        int closest = -1;
        for (int i = 0; i < size; i++) {
            if (!visited[i] && dist[i] < min) {          
                min = dist[i];
                closest = i;
            }
        }
        return closest;
    }

    static void route(int current, int start, int[] prev) {
        if (current == start) {
            System.out.print(names[current]);
        } else {
            route(prev[current], start, prev);
            System.out.print(" -> " + names[current]);
        }
    }

    static void printPath(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(names[list.get(i)]);
            if (i < list.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (Main.class.getResourceAsStream("campus.txt"));
        size = sc.nextInt();
        names = new String[size];
        graph = new int[size][size];

        for (int i = 0; i < size; i++) {
            names[i] = sc.next();
        }

        int edges = sc.nextInt();
        for (int i = 0; i < edges; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int minutes = sc.nextInt();
            addEdge(from, to, minutes);
        }

        int start = sc.nextInt();
        int dest = sc.nextInt();
        
        System.out.println("=== BFS from " + names[start] + " ===");
        List<Integer> bfsOrder = bfs(start);
        printPath(bfsOrder);

        System.out.println("=== DFS from " + names[start] + " ===");
        dfs(start);
        printPath(dfsOrder);

        dijkstraAlg(start, dest);

        sc.close();
    }

}
