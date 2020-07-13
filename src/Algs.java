import java.lang.reflect.Array;
import java.util.*;

public class Algs {
    public Algs(Maze maze) {
        this.maze = maze;
    }

    public int[][] run_alg(String alg) {
        if (alg.equals("DFS"))
            return dfs();
        if (alg.equals("BFS"))
            return bfs();

        return null;
    }

    private int[][] solutionPath(Node root, Node current) {
        int[][] solutionPath = new int[current.size][2];
        int i = 0;
        while (root.position != current.position) {
            solutionPath[i++] = current.position;
            current = current.parent;
        }
        return solutionPath;
    }

    private ArrayList<Node> getUnvisited(Node current, Set<List<Integer>> visited, ArrayList<Node> fringe) {
        ArrayList<Integer> currentPosition = new ArrayList<>();
        currentPosition.add(current.position[0]);
        currentPosition.add(current.position[1]);
        if (!visited.contains(currentPosition)) {
            List<Integer> adding = new ArrayList<>();
            adding.add(current.position[0]);
            adding.add(current.position[1]);

            visited.add(adding);
            this.maze.changeColor(current.position);

            for (int[] point : maze.neighbor(current.position))
                fringe.add(new Node(current, point));
        }
        return fringe;
    }

    private int[][] dfs() {
        Set<List<Integer>> visited = new HashSet<>();
        ArrayList<Node> fringeStack = new ArrayList<>();
        Node root = new Node(null, maze.getStarting_point());
        fringeStack.add(root);

        while (fringeStack.size() != 0) {
            Node current = fringeStack.remove(fringeStack.size()-1); // pop
            if (maze.isGoal(current.position))
                return solutionPath(root, current);

            fringeStack = getUnvisited(current, visited, fringeStack);
        }
        return null;
    }

    private int[][] bfs() {
        Set<List<Integer>> visited = new HashSet<>();
        ArrayList<Node> fringeQueue = new ArrayList<>();
        Node root = new Node(null, maze.getStarting_point());
        fringeQueue.add(root);

        while (fringeQueue.size() != 0) {
            Node current = fringeQueue.remove(0); // popleft
            if (maze.isGoal(current.position))
                return solutionPath(root, current);
            fringeQueue = getUnvisited(current, visited, fringeQueue);
        }
        return null;
    }


    private Maze maze;
    private String alg;

    private static class Node {

        public Node(Node parent, int[] position) {
            this.parent = parent;
            this.position = position;
            if (parent != null)
                this.size = parent.size + 1;
            else
                this.size += 1;
        }

        public Node(Node parent, int[] position, int g, int h) {
            this.parent = parent;
            this.position = position;
            if (parent != null)
                this.size = parent.size + 1;
            else
                this.size += 1;
            this.g = g;
            this.h = h;
            this.f = g+h;
        }

        private int size = 0;

        private Node parent;
        private int[] position;
        private int g, h, f;

    }
}
