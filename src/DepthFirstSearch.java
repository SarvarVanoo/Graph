import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch {
    private int V;

    public LinkedList<Integer> adj[];

    public DepthFirstSearch(int v)
    {
        V =v;
        adj = new LinkedList[V];
        for(int i=0; i<v; i++)
        {
            adj[i]= new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }

    void DFS(int s)
    {
        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        stack.push(s);

        while(stack.empty() != true)
        {
            s = stack.peek();
            stack.pop();

            System.out.print(s + " ");
            visited[s] = true;

            Iterator<Integer> i = adj[s].iterator();

            while(i.hasNext())
            {
                int n = i.next();
                if(visited[n]!=true)
                {
                   stack.push(n);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        DepthFirstSearch obj = new DepthFirstSearch(5);

        obj.addEdge(1, 0);
        obj.addEdge(0, 2);
        obj.addEdge(2, 1);
        obj.addEdge(0, 3);
        obj.addEdge(1, 4);

        System.out.println("Depth First Search");
        obj.DFS(0);

    }
}
