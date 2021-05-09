package GeoCaching;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    //Path
    private static String inputxt = (".//data//input.txt");
    private static String dumptxt = (".//data//dump.txt");
    private static String utilizadortxt = (".//data//utilizador.txt");
    private static String cachestxt = (".//data//caches.txt");

    private static String utilizadoresRemovidostxt = (".//data//utilizadoresRemovidos.txt");
    private static String cachesRemovidastxt = (".//data//cachesRemovidas.txt");

    public static SeparateChainingHashST<Integer, Basic> basics = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<Integer, Admin> admins = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<Integer, Premium> premiums = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<String, Cache> caches = new SeparateChainingHashST<>();

    public static void main(String[] args) throws IOException {

        /*Basic b1 = new Basic(0, "Nuninho", "Basic");
        Basic b2 = new Basic(1, "Ricardinho", "Basic");
        Basic b3 = new Basic(2, "Joaozinho", "Basic");
        addBasicUser(b1);
        addBasicUser(b2);
        addBasicUser(b3);
        Premium p1 = new Premium(0, "Miguelito", "Premium");
        Premium p2 = new Premium(1, "Danielzao", "Premium");
        addPremiumUser(p1);
        addPremiumUser(p2);
        Admin a1 = new Admin(0, "Deolinda", "admin");
        Admin a2 = new Admin(1, "Josefina", "admin");
        addAdminUser(a1);
        addAdminUser(a2);
        Cache c1 = new Cache("ZedosCaes", "norte", 30.0f, 2.5f, "Serra da Estrela", "dificil", "basic");
        Cache c2 = new Cache("CasaDoRicardo", "sul", 23.4f, 3.9f, "Jardim", "facil", "premium");
        addCache(c1);
        addCache(c2);
        Item item = new Item("test");
        Item item1 = new Item("test1");
        b1.addItemsUser(item);
        p1.addItemsUser(item1);
        TravelBug tb1 = new TravelBug("TravelBug1", "qualquercoisa", null, "Ir_a_casa_do_ricardo");
        TravelBug tb2 = new TravelBug("TravelBug2", "qualquercoisa2", null, "Ir_a_casa_do_Danielzao");
        admins.get(a1.getID()).addTravelbugsUser(tb1);
        premiums.get(p2.getID()).addTravelbugsUser(tb2);

        //basics.get(b1.getID()).tostring();
        //admins.get(a1.getID()).tostring();
        //removerBasicUser(basics.get(b1.getID()));
        // basics.get(b1.getID()).visitarCache(caches.get(c1.getNome()), "Ola", item, null);
        basics.get(b2.getID()).visitarCache(caches.get(c1.getNome()), "Ola 2", item, null);
        //removeCache(caches.get(c1.getNome()));
        //removerPremiumUser(premiums.get(p2.getID()));
        //removerAdminUser(admins.get(a1.getID()));*/

        leituraFicheiroTxt(inputxt);
        /*listarBasicUsers();
        listarPremiumUsers();
        listarAdminUsers();
        listarCache();*/
        listarCachesPremiumComItems();

        //escritaFicheiroTxt();
    }



    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * ADD / EDITAR / REMOVER / LISTAR --CACHES / LOGS--
     */

    private static void addCache(Cache c) {
        if (caches.contains(c.getNome())) {
            System.out.println("Erro, cache ja existe na DB!");
            return;
        }
        caches.put(c.getNome(), c);
    }

    private static void removeCache(Cache c) {
        if (caches.contains(c.getNome())) {
            caches.delete(c.getNome());
        } else System.out.println("Erro, a cache nao existe nao DB!");
    }

    public static void editarCache(Cache c, String nome, Point GPS, String pontoInteresse, String dificuldade, String tipo) {
        String name = c.getNome();
        if (caches.contains(name)) {
            caches.get(name).setNome(nome);
            caches.get(name).setGPS(GPS);
            caches.get(name).setPontoInteresse(pontoInteresse);
            caches.get(name).setDificuldade(dificuldade);
            caches.get(name).setTipo(tipo);
        }
    }

    public static void listarCache() {
        System.out.println("Caches: \n");
        for (String cache : caches.keys()) {
            caches.get(cache).tostring();
        }
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * ADD / EDITAR / REMOVER / LISTAR --USERS--
     */

    public static void addBasicUser(Basic b) {
        int id = b.getID();
        if (basics.contains(id)) {
            System.out.println("Erro, Utilizador Basic com ID:" + id + " já existe na DB!");
            return;
        }
        basics.put(id, b);
    }

    public static void addPremiumUser(Premium p) {
        int id = p.getID();
        if (premiums.contains(id)) {
            System.out.println("Erro, Utilizador Premium com ID:" + id + " já existe na DB!");
            return;
        }
        premiums.put(id, p);
    }

    public static void addAdminUser(Admin a) {
        int id = a.getID();
        if (admins.contains(id)) {
            System.out.println("Erro, Utilizador Admin com ID:" + id + " já existe na DB!");
            return;
        }
        admins.put(id, a);
    }

    public static void editarBasicUser(Basic b, String nome, ArrayList<Item> Items) {
        int id = b.getID();
        if (!basics.contains(id)) {
            System.out.println("Erro Utilizador nao registado na DB!");
            return;
        }
        basics.get(id).setNome(nome);
        basics.get(id).setItems(Items);
    }

    public static void editarPremiumUser(Premium p, String nome, ArrayList<Item> Items) {
        int id = p.getID();
        if (!premiums.contains(id)) {
            System.out.println("Erro Utilizador nao registado na DB!");
            return;
        }
        premiums.get(id).setNome(nome);
        premiums.get(id).setItems(Items);
    }

    public static void editarAdminUser(Admin a, String nome, ArrayList<Item> Items) {
        int id = a.getID();
        if (!admins.contains(id)) {
            System.out.println("Erro Utilizador nao registado na DB!");
            return;
        }
        admins.get(id).setNome(nome);
        admins.get(id).setItems(Items);
    }

    public static void removerBasicUser(Basic b) throws IOException {
        int id = b.getID();
        if (!basics.contains(id)) {
            System.out.println("Erro Utilizador nao registado na DB!");
            return;
        }
        FileWriter wr = new FileWriter(utilizadoresRemovidostxt, true);
        wr.write(b.getID() + ", " + b.getNome() + ", " + b.getPerm() + "\n");
        wr.write(String.valueOf(b.getItems().size()) + " items");
        for (Item i : b.getItems()) {
            wr.write(", " + i.getDescricao());
        }
        wr.write("\n" + String.valueOf(b.getTravelbugs().size()) + " TravelBugs\n");
        for (String nome : b.getTravelbugs().keys()) {
            wr.write(b.getTravelbugs().get(nome).getNome() + ", " +
                    b.getTravelbugs().get(nome).getDescricao() + ", " +
                    b.getTravelbugs().get(nome).getObjetivo() + "\n");
        }
        wr.close();
        basics.delete(id);
    }

    public static void removerPremiumUser(Premium p) throws IOException {
        int id = p.getID();
        if (!premiums.contains(id)) {
            System.out.println("Erro Utilizador nao registado na DB!");
            return;
        }
        FileWriter wr = new FileWriter(utilizadoresRemovidostxt, true);
        wr.write(p.getID() + ", " + p.getNome() + ", " + p.getPerm() + "\n");
        wr.write(String.valueOf(p.getItems().size()) + " items");
        for (Item i : p.getItems()) {
            wr.write(", " + i.getDescricao());
        }
        wr.write("\n" + String.valueOf(p.getTravelbugs().size()) + " TravelBugs\n");
        for (String nome : p.getTravelbugs().keys()) {
            wr.write(p.getTravelbugs().get(nome).getNome() + ", " +
                    p.getTravelbugs().get(nome).getDescricao() + ", " +
                    p.getTravelbugs().get(nome).getObjetivo() + "\n");
        }
        wr.close();
        premiums.delete(id);
    }

    public static void removerAdminUser(Admin a) throws IOException {
        int id = a.getID();
        if (!admins.contains(id)) {
            System.out.println("Erro Utilizador nao registado na DB!");
            return;
        }
        FileWriter wr = new FileWriter(utilizadoresRemovidostxt, true);
        wr.write(a.getID() + ", " + a.getNome() + ", " + a.getPerm() + "\n");
        wr.write(String.valueOf(a.getItems().size()) + " items");
        for (Item i : a.getItems()) {
            wr.write(", " + i.getDescricao());
        }
        wr.write("\n" + String.valueOf(a.getTravelbugs().size()) + " TravelBugs\n");
        for (String nome : a.getTravelbugs().keys()) {
            wr.write(a.getTravelbugs().get(nome).getNome() + ", " +
                    a.getTravelbugs().get(nome).getDescricao() + ", " +
                    a.getTravelbugs().get(nome).getObjetivo() + "\n");
        }
        wr.close();
        admins.delete(id);
    }

    public static void listarBasicUsers() {
        System.out.println("Basic Users: \n");
        for (Integer i : basics.keys()) {
            basics.get(i).tostring();
        }
    }

    public static void listarPremiumUsers() {
        System.out.println("Premium Users: \n");
        for (Integer i : premiums.keys()) {
            premiums.get(i).tostring();
        }
    }

    public static void listarAdminUsers() {
        System.out.println("Admin Users: \n");
        for (Integer i : admins.keys()) {
            admins.get(i).tostring();
        }
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * LEITURA E ESCRITA DE FICHEIROS INFORMAÇÃO -- INPUT --
     */

    public static void leituraFicheiroTxt(String path) {
        In in = new In(path);

        while (!in.isEmpty()) {
            int l = Integer.parseInt(in.readLine());
            for (int i = 0; i < l; i++) {
                String line = in.readLine();
                String[] fields = line.split(", ");
                switch (fields[2]) {
                    case "basic" -> {
                        Basic b = new Basic(Integer.parseInt(fields[0]), fields[1], fields[2]);
                        addBasicUser(b);
                    }
                    case "premium" -> {
                        Premium p = new Premium(Integer.parseInt(fields[0]), fields[1], fields[2]);
                        addPremiumUser(p);
                    }
                    case "admin" -> {
                        Admin a = new Admin(Integer.parseInt(fields[0]), fields[1], fields[2]);
                        addAdminUser(a);
                    }
                }
            }
            int m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                String line = in.readLine();
                String[] aux = line.split(", ");
                for (int j = 0; j < Integer.parseInt(aux[1]); j++) {
                    String line2 = in.readLine();
                    String[] field = line2.split(", ");
                    Cache c = new Cache(field[0], aux[0], Float.parseFloat(field[2]), Float.parseFloat(field[3]), null, null, field[1]);
                    addCache(c);
                    for (int k = 0; k < Integer.parseInt(field[4]); k++) {
                        Item item = new Item(field[5 + k]);
                        c.getItems().add(item);
                    }
                }
            }
        }
    }

    public static void escritaFicheiroTxt() throws IOException {
        FileWriter wr = new FileWriter(dumptxt, true);
        int nUtilizadores = basics.size() + premiums.size() + admins.size();
        wr.write(String.valueOf(nUtilizadores) + "\n");
        for (Integer i : basics.keys()) {
            wr.write(basics.get(i).getID() + ", " + basics.get(i).getNome() + ", " + basics.get(i).getPerm() + "\n");
        }
        for (Integer i : premiums.keys()) {
            wr.write(premiums.get(i).getID() + ", " + premiums.get(i).getNome() + ", " + premiums.get(i).getPerm() + "\n");
        }
        for (Integer i : admins.keys()) {
            wr.write(admins.get(i).getID() + ", " + admins.get(i).getNome() + ", " + admins.get(i).getPerm() + "\n");
        }
        Cache c = new Cache();
        wr.write(String.valueOf(c.getRegions().size()) + "\n");

        for (String s : c.getRegions()) {
            regionCache rc = getCachesInRegion(s);
            wr.write(String.valueOf(rc.nCaches) + ", " + s + "\n");
            for (Cache cache : rc.cachesInRegion) {
                wr.write(cache.getNome() + ", " + cache.getTipo() + ", " + cache.getGPS().getLatitude() + ", " +
                        cache.getGPS().getLongitude() + ", " + String.valueOf(cache.getItems().size()));
                for (Item i : cache.getItems()) {
                    wr.write(", " + i.getDescricao());
                }
            }
            wr.write("\n");
        }
        wr.close();
    }

    public static class regionCache {
        public regionCache() {
        }

        ArrayList<Cache> cachesInRegion = new ArrayList<>();
        int nCaches;
    }

    public static regionCache getCachesInRegion(String Region) {
        regionCache rc = new regionCache();
        for (String s : caches.keys()) {
            if (caches.get(s).getRegiao().equals(Region)) {
                rc.cachesInRegion.add(caches.get(s));
                rc.nCaches++;
            }
        }
        return rc;
    }
    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * --- PESQUISAS ---
     */

    public static void listarCachesPremiumComItems() {
        int i = 0;
        for (String s : caches.keys()) {
            i++;
            if (caches.get(s).getTipo().equals("premium") && !caches.get(s).getItems().isEmpty()) {
                caches.get(s).tostring();
            }
        }
        if (i == 0)
            System.out.println("Nao existem Caches Premium com 1 ou mais items na DB!");
    }
}