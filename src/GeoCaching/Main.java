package GeoCaching;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    //Path
    public String inputxt = (".//data//input.txt");
    public String utilizadortxt = (".//data//utilizador.txt");
    public String cachestxt = (".//data//caches.txt");
    public String logxt = (".//data//log.txt");
    public String travelBugxt = (".//data//travelBug.txt");

    public static SeparateChainingHashST<Integer, Basic> basics = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<Integer, Admin> admins = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<Integer, Premium> premiums = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<String, Cache> caches = new SeparateChainingHashST<>();


    public static void main(String[] args) {
        Basic b1 = new Basic(0, "Nuninho", "Basic");
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
        Cache c1 = new Cache("ZedosCaes", "norte", null, null, "dificil", "basic");
        Cache c2 = new Cache("CasaDoRicardo", "sul", null, null, "facil", "premium");
        addCache(c1);
        addCache(c2);
        Item item = new Item("test");
        Item item1 = new Item("test1");
        b1.addItemsUser(item);
        p1.addItemsUser(item1);
        TravelBug tb1 = new TravelBug("TravelBug1", "qualquercoisa", null, "Ir_a_casa_do_ricardo");
        TravelBug tb2 = new TravelBug("TravelBug2", "qualquercoisa2", null, "Ir_a_casa_do_Danielzao");
        a1.addTravelbugsUser(tb1);
        p2.addTravelbugsUser(tb2);

        b1.tostring();
        b2.tostring();
        b3.tostring();
        p1.tostring();
        p2.tostring();
        a1.tostring();
        a2.tostring();

       /* var items = admin.getItems();
        items.add(item1);

        cache.getItems().add(item);
        admin.trocarItems(cache, item, item1);
        admin.trocarItems(cache, item1, item);
        var item2 = (Item) admin.getItems().get(0);
        System.out.println(item2.getDescricao());*/
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
            System.out.println(caches.get(cache).toString());
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

    public static void removerBasicUser(Basic b) {
        int id = b.getID();
        if (!basics.contains(id)) {
            System.out.println("Erro Utilizador nao registado na DB!");
            return;
        }
        basics.delete(id);
    }

    public static void removerPremiumUser(Premium p) {
        int id = p.getID();
        if (!premiums.contains(id)) {
            System.out.println("Erro Utilizador nao registado na DB!");
            return;
        }
        premiums.delete(id);
    }

    public static void removerAdminUser(Admin a) {
        int id = a.getID();
        if (!admins.contains(id)) {
            System.out.println("Erro Utilizador nao registado na DB!");
            return;
        }
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

    /*public Object editar_utilizador(Object ob ,int id, UsersBase base, String tipo, String nome) {
        for (Integer i : base.getBasics().keys()){
            if (base.getBasics().get(i).ID == id){
                if (tipo.equals("premium")){
                    base.getBasics().delete(i);
                    Premium p = new Premium(id, nome, base);
                    return p;
                }
                base.getBasics().delete(i);
                Admin a = new Admin(id, nome,base);
                return a;
            }
        }

        for (Integer k : base.getPremiums().keys()){
            if (base.getPremiums().get(k).ID == id){
                if (tipo.equals("basic")){
                    base.getPremiums().delete(k);
                    Basic b = new Basic(id, nome, base);
                    return b;
                }
                base.getPremiums().delete(k);
                Admin a = new Admin(id, nome,base);
                return a;
            }
        }
        System.out.println("Impossivel editar user");
        return ob;
    }*/

    /*public void guardarCursoHistorico (Curso c) throws IOException {
        FileWriter myWriter = new FileWriter(".//data//cursosHistorico.txt",true);

        myWriter.write("Curso:\n");
        myWriter.write(c.getNome() + ";" + c.getFaculdade().getName() + "\n");
        myWriter.write("TURMAS:\n");
        for (String codigo : c.getTurmas().keys()) {
            Turma t = c.getTurmas().get(codigo);
            myWriter.write(t.getAno() + ";" + t.getCodigo() + ";" + t.getCurso().getNome() + ";" +
                    t.getDisciplina().getNome() + ";" + t.getSala().getCodigo() + ";" + "\n");
        }
        myWriter.write("\n");
        myWriter.close();
    }*/
}
