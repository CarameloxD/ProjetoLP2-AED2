package GeoCaching;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
    //ArrayList<Item> ali1 = new ArrayList<>();
    //Item i1 = new Item(1,"Bola",)


    public static void main(String[] args) {
        //ArrayList<Item> items = new ArrayList<Item>();
        Admin admin = new Admin(1, "Nuno");

        Cache cache = new Cache(1, null, null, "", null);

        Item item = new Item("test", admin, null);
        Item item1 = new Item("test1", null, cache);
        var items = admin.getItems();
        items.add(item1);

        cache.Items.add(item);
        admin.trocarItems(cache,item,item1);
        admin.trocarItems(cache,item1,item);
        var item2 = (Item) admin.getItems().get(0);
        System.out.println(item2.Descricao);
    }

    private void PopulateItems(){

    }
}
