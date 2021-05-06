package GeoCaching;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

public class Main {

    //Path
    public String inputxt = (".//data//input.txt");
    public String utilizadortxt = (".//data//utilizador.txt");
    public String cachestxt = (".//data//caches.txt");
    public String logxt = (".//data//log.txt");
    public String travelBugxt = (".//data//travelBug.txt");

    public static SeparateChainingHashST<String, Basic> basics = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<String, Admin> admins = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<String, Premium> premiums = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<String, Cache> caches = new SeparateChainingHashST<>();
    public static RedBlackBST<String, TravelBug> travelbugs = new RedBlackBST<>();
    public static RedBlackBST<String, Log> logs = new RedBlackBST<>();

    //Metodo interacao


    public static void main(String[] args) {

    }
}
