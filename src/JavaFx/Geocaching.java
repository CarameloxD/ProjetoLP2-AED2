package JavaFx;

import java.io.Serializable;
import java.util.ArrayList;

public class Geocaching <T extends Node> implements Serializable{
    private SymbolGraphCaches nodes = new SymbolGraphCaches(".//data//ligacoescaches.txt");
    private EdgeDoubleWeightedGraph g = nodes.graph();

    public void addNode(Node Node, ArrayList<Node> connected) {
        SymbolGraphCaches n = nodes;
    }

    /**
     * @return return all the nodes from Geocaching Graph
     * */

    public SymbolGraphCaches getNodes() {
        return nodes;
    }

    public void setNodes(SymbolGraphCaches nodes) {
        this.nodes = nodes;
    }

    public EdgeDoubleWeightedGraph getG() {
        return g;
    }

    public void setG(EdgeDoubleWeightedGraph g) {
        this.g = g;
    }

    public ArrayList<Node> getAllNodes() {
        ArrayList<Node> n = new ArrayList<>();
        for(int v = 0; v < g.V() ; v++) {
            n.add(nodes.nameOf(v));
        }
        return n;
    }

    public Node getNode(int v){
        return nodes.nameOf(v);
    }

    /**
     * @param regiao condition to get specific nodes
     * @return returns all nodes from Graph by region
     * */
    public ArrayList<Node> getAllNodesByRegiao(String regiao) {
        ArrayList<Node> NodesByRegiao = new ArrayList<>();
        for(int v = 0; v < g.V(); v++) {
            if(nodes.nameOf(v).getC().getRegiao().equals(regiao)) {
                NodesByRegiao.add(nodes.nameOf(v));
            }
        }
        return NodesByRegiao;
    }

    /**
     * vai buscar todas as edges adjacentes a partir daquele nó
     * @param t nó
     * @return um iterable de edges com as edges adjacentes
     */
    public Iterable<EdgeDoubleWeighted> getAllEdgesFromNode(T t) {
        for(int v = 0; v < g.V(); v++) {
            if(nodes.nameOf(v).compareTo(t) == 0) { //Finds the node and gets all the adjacent edges.
                return nodes.graph().adj(v);
            }
        }
        return null;
    }
}
