package JavaFx;

import GeoCaching.Main;
import GeoCaching.Main.*;
import edu.princeton.cs.algs4.*;
import GeoCaching.Cache;

import java.util.ArrayList;

import static GeoCaching.Main.*;
import static JavaFx.Controller.readCachesFromFile;

public class SymbolGraphCaches{
    private ST<Node, Integer> st;
    private Node[] keys;
    private EdgeDoubleWeightedGraph graph;

    /**
     * Initializes a graph from a file using the specified delimiter.
     * Each line in the file contains
     * the name of a vertex, followed by a list of the names
     * of the vertices adjacent to that vertex, separated by the delimiter.
     * @param filename the name of the file
     */
    public SymbolGraphCaches(String filename) {
        readCachesFromFile(".//data//cachesFX.txt");
        listarCache();
        st = new ST<>();
        ArrayList<EdgeDoubleWeighted> ArrayEDW = new ArrayList<>();

        In in = new In(filename);
        while (!in.isEmpty()) {
            String[] a = in.readLine().split(", ");
            System.out.println(a[0] + ", " + a[1]);
            Node n1 = new Node(getCache(a[0]));
            Node n2 = new Node(getCache(a[1]));

            System.out.println(n1.getC().getNome());
            System.out.println(n1.getC().getRegiao());

            n1.tostring();
            n2.tostring();

            Double stWeight = Double.parseDouble(a[2]);
            Double ndWeight = Double.parseDouble(a[3]);

            if (!st.contains(n1))
                st.put(n1, st.size());
            if (!st.contains(n2))
                st.put(n2, st.size());

            int v = st.get(n1);
            int w = st.get(n2);

            keys = new Node[st.size()];
            for (Node name : st.keys()) {
                if (st.get(name) != null)
                    keys[st.get(name)] = name;
            }
            EdgeDoubleWeighted e = new EdgeDoubleWeighted(v, w, stWeight, ndWeight);
            ArrayEDW.add(e);
        }
        graph = new EdgeDoubleWeightedGraph(st.size());
        for (EdgeDoubleWeighted e : ArrayEDW) graph.addEdge(e);
        System.out.println(graph);
    }

    public EdgeDoubleWeightedGraph graph() {
        return graph;
    }

    public ST<Node, Integer> getSt() {
        return st;
    }

    public void setSt(ST<Node, Integer> st) {
        this.st = st;
    }

    public Node[] getKeys() {
        return keys;
    }

    public void setKeys(Node[] keys) {
        this.keys = keys;
    }

    public EdgeDoubleWeightedGraph getGraph() {
        return graph;
    }

    public void setGraph(EdgeDoubleWeightedGraph graph) {
        this.graph = graph;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = graph.V();
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    /**
     * Returns the name of the vertex associated with the integer {@code v}.
     * @param  v the integer corresponding to a vertex (between 0 and <em>V</em> - 1)
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     * @return the name of the vertex associated with the integer {@code v}
     */
    public Node nameOf(int v) {
        validateVertex(v);
        return keys[v];
    }

    /**
     * Does the graph contain the vertex named {@code s}?
     * @param s the name of a vertex
     * @return {@code true} if {@code s} is the name of a vertex, and {@code false} otherwise
     */
    public boolean contains(Node s) {
        return st.contains(s);
    }

    /**
     * Returns the integer associated with the vertex named {@code s}.
     * @param s the name of a vertex
     * @return the integer (between 0 and <em>V</em> - 1) associated with the vertex named {@code s}
     */
    public int indexOf(Node s) {
        return st.get(s);
    }
}