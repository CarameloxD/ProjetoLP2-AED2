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
    private static String utilizadorestxt = (".//data//utilizadores.txt");
    private static String cachestxt = (".//data//caches.txt");
    private static String travelbugstxt = (".//data//travelbugs.txt");
    private static String ligacoescachestxt = (".//data//ligacoescaches.txt");


    private static String utilizadoresRemovidostxt = (".//data//utilizadoresRemovidos.txt");
    private static String cachesRemovidastxt = (".//data//cachesRemovidas.txt");

    public static SeparateChainingHashST<Integer, Basic> basics = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<Integer, Admin> admins = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<Integer, Premium> premiums = new SeparateChainingHashST<>();
    public static SeparateChainingHashST<String, Cache> caches = new SeparateChainingHashST<>();
    private static ArrayList<ligacoesCaches> ligacoes = new ArrayList<>();
    private static RedBlackBST<String, TravelBug> travelbugs = new RedBlackBST<>();

    public static void main(String[] args) throws IOException {
        leituraFicheiroTxt(inputxt);
        // MANUEL
        basics.get(1).visitarCache(caches.get("geocache1"), null, null, null);
        basics.get(1).visitarCache(caches.get("geocache2"), null, null,
                findItemInCache(caches.get("geocache2"), "travelbug2"));
        basics.get(1).visitarCache(caches.get("geocache6"), null, null, null);
        basics.get(1).visitarCache(caches.get("geocache8"), null, null, null);
        basics.get(1).visitarCache(caches.get("geocache13"), null, null, null);
        basics.get(1).visitarCache(caches.get("geocache16"), null, null, null);
        basics.get(1).visitarCache(caches.get("geocache17"), null,
                findItemInUsers(basics.get(1), "travelbug2"), null);

        //PEDRO
        basics.get(2).visitarCache(caches.get("geocache18"), null, null, null);
        basics.get(2).visitarCache(caches.get("geocache13"), null, null, null);
        basics.get(2).visitarCache(caches.get("geocache8"), null, null,
                findItemInCache(caches.get("geocache8"), "capa"));

        //FERNANDO
        admins.get(3).visitarCache(caches.get("geocache12"), null, null, null);
        admins.get(3).visitarCache(caches.get("geocache11"), null, null, null);
        admins.get(3).visitarCache(caches.get("geocache10"), null, null, null);
        admins.get(3).visitarCache(caches.get("geocache8"), null, null, null);
        admins.get(3).visitarCache(caches.get("geocache9"), null, null, null);
        admins.get(3).visitarCache(caches.get("geocache5"), null, null, null);
        admins.get(3).visitarCache(caches.get("geocache6"), null, null, null);
        admins.get(3).visitarCache(caches.get("geocache4"), null, null, null);
        admins.get(3).visitarCache(caches.get("geocache3"), null, null, null);
        admins.get(3).visitarCache(caches.get("geocache2"), null, null, null);
        admins.get(3).visitarCache(caches.get("geocache1"), null, null,
                findItemInCache(caches.get("geocache1"), "travelbug1"));
        admins.get(3).visitarCache(caches.get("geocache7"), null, null, null);
        admins.get(3).visitarCache(caches.get("geocache15"), null,
                findItemInUsers(admins.get(3), "travelbug1"), null);
        admins.get(3).visitarCache(caches.get("geocache17"), null, null, null);
        admins.get(3).visitarCache(caches.get("geocache18"), null, null, null);
        admins.get(3).visitarCache(caches.get("geocache13"), null, null, null);

        //JOANA
        basics.get(4).visitarCache(caches.get("geocache14"), null, null, null);
        basics.get(4).visitarCache(caches.get("geocache15"), null, null, null);
        basics.get(4).visitarCache(caches.get("geocache18"), null, null, null);
        basics.get(4).visitarCache(caches.get("geocache17"), null, null, null);
        basics.get(4).visitarCache(caches.get("geocache13"), null, null, null);

        //MARIA
        premiums.get(5).visitarCache(caches.get("geocache3"), null, null,
                findItemInCache(caches.get("geocache3"), "travelbug3"));
        premiums.get(5).visitarCache(caches.get("geocache8"), null, null, null);
        premiums.get(5).visitarCache(caches.get("geocache9"), null, null, null);
        premiums.get(5).visitarCache(caches.get("geocache10"), null, null, null);
        premiums.get(5).visitarCache(caches.get("geocache16"), null, null, null);
        premiums.get(5).visitarCache(caches.get("geocache11"), null, null, null);
        premiums.get(5).visitarCache(caches.get("geocache12"), null,
                findItemInUsers(premiums.get(5), "travelbug3"), null);

        //FILOMENA
        admins.get(6).visitarCache(caches.get("geocache5"), null, null, null);
        admins.get(6).visitarCache(caches.get("geocache6"), null, null, null);
        admins.get(6).visitarCache(caches.get("geocache7"), null, null, null);
        admins.get(6).visitarCache(caches.get("geocache3"), null, null, null);
        admins.get(6).visitarCache(caches.get("geocache2"), null, null, null);
        admins.get(6).visitarCache(caches.get("geocache1"), null, null, null);
        admins.get(6).visitarCache(caches.get("geocache8"), null, null, null);
        admins.get(6).visitarCache(caches.get("geocache13"), null, null, null);

        /*Date inicio = new Date(2021, 5, 8, 21, 50, 0);
        Date fim = new Date(2021, 5, 9, 21, 55, 0);
        topUtilizadores(inicio, fim);
        requesitoF();*/


        escritaFicheiroTxtUtilizadores();
        escritaFicheiroTxtCaches();
        escritaFicheiroTxtTravelBugs();
        escritaFicheiroTxtLigacoesCaches();
    }

    /**
     * Pesquisa por um objeto do tipo Item no Arraylist de Items da Cache recebida por parametro,
     * por nome no caso de TravelBugs ou descrição nos Items;
     *
     * @param cache         Objeto do tipo Cache;
     * @param descricao     Nome/descrição do TravelBug/Item a procurar;
     * @return              Retorna o Objeto do tipo Item case seja encontrado na Cache
     */
    public static Item findItemInCache(Cache cache, String descricao) {
        for (Item i : cache.getItems()) {
            if (i instanceof TravelBug)
                if (((TravelBug) i).getNome().equals(descricao))
                    return i;
            if (i.getDescricao().equals(descricao))
                return i;

        }
        System.out.println("ERRO! { \n\tNenhum item com a descrição: '" + descricao +
                "', encontrado nos Items das Caches!\n}\n");
        return null;
    }
    /**
     * Pesquisa por um objeto do tipo Item no Arraylist de Items do Utilizador recebido por parametro,
     * por nome no caso de TravelBugs ou descrição nos Items;
     *
     * @param User          Objeto do tipo Utilizador ( Basic, Premium ou Admin );
     * @param descricao     Nome/descrição do TravelBug/Item a procurar;
     */
    public static Item findItemInUsers(Object User, String descricao) {
        if (User instanceof Admin) {
            for (Item i : ((Admin) User).getItems()) {
                if (i instanceof TravelBug)
                    if (((TravelBug) i).getNome().equals(descricao))
                        return i;
                if (i.getDescricao().equals(descricao))
                    return i;
            }
        }
        if (User instanceof Premium) {
            for (Item i : ((Premium) User).getItems()) {
                if (i instanceof TravelBug)
                    if (((TravelBug) i).getNome().equals(descricao))
                        return i;
                if (i.getDescricao().equals(descricao))
                    return i;
            }
        }
        if (User instanceof Basic) {
            for (Item i : ((Basic) User).getItems()) {
                if (i instanceof TravelBug)
                    if (((TravelBug) i).getNome().equals(descricao))
                        return i;
                if (i.getDescricao().equals(descricao))
                    return i;
            }
        }
        System.out.println("ERRO! { \n\tNenhum item com a descrição: '" + descricao +
                "', encontrado nos Items dos Utilizadores!\n}\n");
        return null;
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * ADD / EDITAR / REMOVER / LISTAR --CACHES / LOGS--
     */


    /**
     * Adicionar objetos do tipo Cache na ST de Caches global;
     *
     * @param c Objeto do tipo Cache a add;
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

    /**
     * Editar objetos do tipo Cache que estão ST de Caches global;
     * Caso o objeto nao esteja inserido na ST, uma mensagem
     * de erro é enviada para o terminal;
     *
     * @param c              Objeto do tipo Cache a editar;
     * @param nome           Novo nome da Cache (String)
     * @param latitude       Nova latitude da Cache (Float)
     * @param longitude      Nova longitude da Cache (Float)
     * @param pontoInteresse Novo pontoInteresse da Cache (String)
     * @param dificuldade    Nova dificuldade da Cache (String)
     * @param tipo           Novo tipo da Cache (String) ("basic" / "premium")
     */
    public static void editarCache(Cache c, String nome, float latitude, float longitude, String
            pontoInteresse, String dificuldade, String tipo) {
        String name = c.getNome();
        if (!caches.contains(name)) {
            System.out.println("Erro Cache nao registada na DB!");
            return;
        }
        caches.get(name).setNome(nome);
        caches.get(name).getGPS().setLatitude(latitude);
        caches.get(name).getGPS().setLatitude(longitude);
        caches.get(name).setPontoInteresse(pontoInteresse);
        caches.get(name).setDificuldade(dificuldade);
        caches.get(name).setTipo(tipo);
    }

    /**
     * Lista todas os objetos do tipo Cache que foram inseridas na ST caches;
     */
    public static void listarCache() {
        System.out.println("Caches: \n");
        for (String cache : caches.keys()) {
            caches.get(cache).tostring();
        }
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /*  ADD / EDITAR / REMOVER / LISTAR --USERS--  */

    /**
     * Adicionar objetos do tipo Basic na ST basics;
     *
     * @param b Objeto do tipo Basic a add;
     */
    public static void addBasicUser(Basic b) {
        int id = b.getID();
        if (basics.contains(id)) {
            System.out.println("Erro, Utilizador Basic com ID:" + id + " já existe na DB!");
            return;
        }
        basics.put(id, b);
    }

    /**
     * Adicionar objetos do tipo Premium na ST basics;
     *
     * @param p Objeto do tipo Premium a add;
     */
    public static void addPremiumUser(Premium p) {
        int id = p.getID();
        if (premiums.contains(id)) {
            System.out.println("Erro, Utilizador Premium com ID:" + id + " já existe na DB!");
            return;
        }
        premiums.put(id, p);
    }

    /**
     * Adicionar objetos do tipo Admin na ST basics;
     *
     * @param a Objeto do tipo Admin a add;
     */
    public static void addAdminUser(Admin a) {
        int id = a.getID();
        if (admins.contains(id)) {
            System.out.println("Erro, Utilizador Admin com ID:" + id + " já existe na DB!");
            return;
        }
        admins.put(id, a);
    }

    /**
     * Editar objetos do tipo Basic que estão ST basics;
     * Caso o objeto nao esteja inserido na ST, uma mensagem
     * de erro é enviada para o terminal;
     *
     * @param b     Objeto do tipo Basic a editar;
     * @param nome  Novo nome do Basic (String);
     * @param Items Novo ArrayList de Items no Basic (ArrayList<Item>);
     */
    public static void editarBasicUser(Basic b, String nome, ArrayList<Item> Items) {
        int id = b.getID();
        if (!basics.contains(id)) {
            System.out.println("Erro Utilizador nao registado na DB!");
            return;
        }
        basics.get(id).setNome(nome);
        basics.get(id).setItems(Items);
    }

    /**
     * Editar objetos do tipo Premium que estão ST basics;
     * Caso o objeto nao esteja inserido na ST, uma mensagem
     * de erro é enviada para o terminal;
     *
     * @param p     Objeto do tipo Premium a editar;
     * @param nome  Novo nome do Premium (String);
     * @param Items Novo ArrayList de Items no Premium (ArrayList<Item>);
     */
    public static void editarPremiumUser(Premium p, String nome, ArrayList<Item> Items) {
        int id = p.getID();
        if (!premiums.contains(id)) {
            System.out.println("Erro Utilizador nao registado na DB!");
            return;
        }
        premiums.get(id).setNome(nome);
        premiums.get(id).setItems(Items);
    }

    /**
     * Editar objetos do tipo Admin que estão ST basics;
     * Caso o objeto nao esteja inserido na ST, uma mensagem
     * de erro é enviada para o terminal;
     *
     * @param a     Objeto do tipo Admin a editar;
     * @param nome  Novo nome do Admin (String);
     * @param Items Novo ArrayList de Items no Admin (ArrayList<Item>);
     */
    public static void editarAdminUser(Admin a, String nome, ArrayList<Item> Items) {
        int id = a.getID();
        if (!admins.contains(id)) {
            System.out.println("Erro Utilizador nao registado na DB!");
            return;
        }
        admins.get(id).setNome(nome);
        admins.get(id).setItems(Items);
    }

    /**
     * Remover objetos do tipo Basic na ST basics;
     *
     * @param b Objeto do tipo Basic a remover;
     */
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
            if (!(i instanceof TravelBug))
                wr.write(", " + i.getDescricao());
        }
        for (Item i : b.getItems()) {
            if (i instanceof TravelBug)
                wr.write(((TravelBug) i).getNome() + ", " +
                        i.getDescricao() + ", " +
                        ((TravelBug) i).getObjetivo() + "\n");
        }
        wr.close();
        basics.delete(id);
    }

    /**
     * Remover objetos do tipo Premium na ST basics;
     *
     * @param p Objeto do tipo Premium a remover;
     */
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
            if (!(i instanceof TravelBug))
                wr.write(", " + i.getDescricao());
        }
        for (Item i : p.getItems()) {
            if (i instanceof TravelBug)
                wr.write(((TravelBug) i).getNome() + ", " +
                        i.getDescricao() + ", " +
                        ((TravelBug) i).getObjetivo() + "\n");
        }
        wr.close();
        premiums.delete(id);
    }

    /**
     * Remover objetos do tipo Admin na ST basics;
     *
     * @param a Objeto do tipo Admin a remover;
     */
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
            if (!(i instanceof TravelBug))
                wr.write(", " + i.getDescricao());
        }
        for (Item i : a.getItems()) {
            if (i instanceof TravelBug)
                wr.write(((TravelBug) i).getNome() + ", " +
                        i.getDescricao() + ", " +
                        ((TravelBug) i).getObjetivo() + "\n");
        }
        wr.close();
        admins.delete(id);
    }

    /**
     * Lista todas os Utilizadores do tipo Basic que foram inseridas na ST basics;
     */
    public static void listarBasicUsers() {
        System.out.println("Basic Users: \n");
        for (Integer i : basics.keys()) {
            basics.get(i).tostring();
        }
    }

    /**
     * Lista todas os Utilizadores do tipo Premium que foram inseridas na ST premiums;
     */
    public static void listarPremiumUsers() {
        System.out.println("Premium Users: \n");
        for (Integer i : premiums.keys()) {
            premiums.get(i).tostring();
        }
    }

    /**
     * Lista todas os Utilizadores do tipo Admin que foram inseridas na ST admins;
     */
    public static void listarAdminUsers() {
        System.out.println("Admin Users: \n");
        for (Integer i : admins.keys()) {
            admins.get(i).tostring();
        }
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /*  LEITURA E ESCRITA DE FICHEIROS INFORMAÇÃO -- INPUT --  */

    /**
     * Leitura de dados de um ficheiro de INPUT, populando assim as ST's de basics, premiums e admins,
     * assim como da ST de caches, seus ArrayLists de Items, as ligacoes das caches e os travelbugs;
     *
     * @param path Caminho para o ficheiro a ler;
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

    /**
     * Encontrar de todas as ST's, o objeto que tem o nome igual ao que é passado por parametros;
     *
     * @param nome nome a procurar nas ST's;
     */
    public static Object findUser(String nome) {
        for (int i : basics.keys()) {
            if (basics.get(i).getNome().equals(nome))
                return basics.get(i);
        }
        for (int i : premiums.keys()) {
            if (premiums.get(i).getNome().equals(nome))
                return premiums.get(i);
        }
        for (int i : admins.keys()) {
            if (admins.get(i).getNome().equals(nome))
                return admins.get(i);
        }
        System.out.println("User não está registado na DB!");
        return null;
    }

    /**
     * Escrita de toda a informação presente nas ST's Basics, Premiums e Admins;
     */
    public static void escritaFicheiroTxtUtilizadores() throws IOException {
        FileWriter wr = new FileWriter(utilizadorestxt, true);
        int nUtilizadores = basics.size() + premiums.size() + admins.size();
        wr.write(String.valueOf(nUtilizadores) + "\n");
        for (Integer i : basics.keys()) {
            wr.write(basics.get(i).getID() + ", " + basics.get(i).getNome() + ", " + basics.get(i).getPerm() + "\n");
            wr.write(basics.get(i).getItems().size() + "\n");
            for (Item item : basics.get(i).getItems()) {
                wr.write(item.getDescricao() + "; ");
            }
            wr.write("\n");
        }
        for (Integer i : premiums.keys()) {
            wr.write(premiums.get(i).getID() + ", " + premiums.get(i).getNome() + ", " + premiums.get(i).getPerm() + "\n");
            wr.write(premiums.get(i).getItems().size() + "\n");
            for (Item item : premiums.get(i).getItems()) {
                wr.write(item.getDescricao() + "; ");
            }
            wr.write("\n");
        }
        for (Integer i : admins.keys()) {
            wr.write(admins.get(i).getID() + ", " + admins.get(i).getNome() + ", " + admins.get(i).getPerm() + "\n");
            wr.write(admins.get(i).getItems().size() + "\n");
            for (Item item : admins.get(i).getItems()) {
                wr.write(item.getDescricao() + "; ");
            }
            wr.write("\n");
        }
        wr.close();
    }

    /**
     * Escrita de toda a informação presente nas ST Caches;
     */
    public static void escritaFicheiroTxtCaches() throws IOException {
        FileWriter wr = new FileWriter(cachestxt, true);
        Cache c = new Cache();
        wr.write(String.valueOf(c.getRegions().size()) + "\n");
        for (String s : c.getRegions()) {
            ArrayList<Cache> rc = getCachesInRegion(s);
            wr.write(String.valueOf(rc.size()) + ", " + s + "\n");
            for (Cache cache : rc) {
                wr.write(cache.getNome() + ", " + cache.getTipo() + ", " + cache.getGPS().getLatitude() + ", " +
                        cache.getGPS().getLongitude() + ", " + String.valueOf(cache.getItems().size()));
                for (Item i : cache.getItems()) {
                    wr.write(i.getDescricao() + "; ");
                }
                wr.write("\n");
                for (int i : cache.getLogs().keys()) {
                    wr.write(cache.getLogs().get(i).toString() + "\n");
                }
                wr.write("\n");
            }

        }
        wr.close();
    }

    /*
     *   Escrita de toda a informação presente nas RedBlack TravelBugs
     */
    public static void escritaFicheiroTxtTravelBugs() throws IOException {
        FileWriter wr = new FileWriter(travelbugstxt, true);
        wr.write(travelbugs.size() + "\n");
        for (String nome : travelbugs.keys()) {
            wr.write(travelbugs.get(nome).getNome() + ", " + travelbugs.get(nome).getNomeCriador() + ", " +
                    travelbugs.get(nome).getCacheInicial() + ", " + travelbugs.get(nome).getObjetivo() + "\n");
            for (int i : travelbugs.get(nome).getHistorico().keys()) {
                wr.write(travelbugs.get(nome).getHistorico().get(i).toString() + "\n");
            }
        }
        wr.close();
    }

    /**
     * Função percorre todas os objetos do tipo Caches presentes na ST de Caches, encontrando as
     * caches que têm a mesma região que a pedida por parametro, guarda-a no ArrayList de Caches
     * retornando-o no final;
     *
     * @param Region regiao condicional para obter as Caches presentes na mesma;
     * @return ArrayList com os Objetos Cache presentes na Region;
     */
    public static ArrayList<Cache> getCachesInRegion(String Region) {
        ArrayList<Cache> cachesInRegion = new ArrayList<>();
        for (String s : caches.keys()) {
            if (caches.get(s).getRegiao().equals(Region)) {
                cachesInRegion.add(caches.get(s));
            }
        }
        return cachesInRegion;
    }
    /*---------------------------------------------------------------------------------------------------------------*/

    /*  --- PESQUISAS ---  */

    /**
     * Lista todas os Utilizadores que visitaram uma determinada Cache;
     *
     * @param cacheVisitada Objeto do tipo Cache;
     */
    public static void listarUtilizadoresCache(Cache cacheVisitada) {
        int k = 0;
        System.out.println("Utilizadores que visitaram a Cache ( " + cacheVisitada.getNome() + " ):");
        for (int i : basics.keys()) {
            if (basics.get(i).getCachesVisitadas().contains(cacheVisitada)) {
                basics.get(i).tostring();
                k++;
            }
        }
        for (int i : premiums.keys()) {
            if (premiums.get(i).getCachesVisitadas().contains(cacheVisitada)) {
                premiums.get(i).tostring();
                k++;
            }
        }
        for (int i : admins.keys()) {
            if (admins.get(i).getCachesVisitadas().contains(cacheVisitada)) {
                admins.get(i).tostring();
                k++;
            }
        }
        if (k == 0) System.out.println("Cache ainda não foi visitada por nenhum Utilizador!");
    }

    /**
     * Lista todas as Caches do tipo Premium que têm no seu ArrayList de Items, pelo menos um Item;
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

    /**
     * Listar o Top 5 de utilizadores que visitaram mais Caches num determinada intervalo de tempo;
     *
     * @param dataInicio Objeto do tipo Date;
     * @param dataFim    Objeto do tipo Date;
     */
    public static void topUtilizadores(Date dataInicio, Date dataFim) {
        int count = 0;
        Object[] UserId = new Object[5];
        Integer[] UserCount = new Integer[5];
        System.out.println("Top Utilizadores com mais Caches Visitadas de '" +
                dataInicio.getYear() + "/" + dataInicio.getMonth() + "/" + dataInicio.getDay() + " - " +
                dataInicio.getHours() + ":" + dataInicio.getMinutes() + ":" + dataInicio.getSeconds() + "' a '" + dataFim.getYear() + "/" + dataFim.getMonth() + "/" + dataFim.getDay() + " - " +
                dataFim.getHours() + ":" + dataFim.getMinutes() + ":" + dataFim.getSeconds() + "' : ");
        for (int i : basics.keys()) {
            for (Cache j : basics.get(i).getCachesVisitadas()) {
                for (Integer log : j.getLogs().keys()) {
                    if (basics.get(i).getID() == j.getLogs().get(log).getUserId()
                            && j.getLogs().get(log).getDate().compareTo(dataInicio) > 0
                            && j.getLogs().get(log).getDate().compareTo(dataFim) < 0) {
                        count++;
                    }
                }
            }
            int pos = 0;
            for (int k = 0; k < UserCount.length; k++) {
                if (UserCount[k] == null && UserId[k] == null) {
                    UserId[k] = basics.get(i);
                    UserCount[k] = count;
                    break;
                }
                if (UserCount[k] < count && UserCount[k] != null) {
                    pos = k;
                } else if ((k + 1 == UserCount.length)) {
                    UserCount[pos] = count;
                    UserId[pos] = basics.get(i);
                    break;
                }
            }
            count = 0;
        }
        for (int i : premiums.keys()) {
            for (Cache j : premiums.get(i).getCachesVisitadas()) {
                for (Integer log : j.getLogs().keys()) {
                    if (premiums.get(i).getID() == j.getLogs().get(log).getUserId()
                            && j.getLogs().get(log).getDate().compareTo(dataInicio) > 0
                            && j.getLogs().get(log).getDate().compareTo(dataFim) < 0) {
                        count++;
                    }
                }
            }
            int pos = 0;
            for (int k = 0; k < UserCount.length; k++) {
                if (UserCount[k] == null && UserId[k] == null) {
                    UserId[k] = premiums.get(i);
                    UserCount[k] = count;
                    break;
                }
                if (UserCount[k] < count && UserCount[k] != null) pos = k;
                else if ((k + 1 == UserCount.length)) {
                    UserCount[pos] = count;
                    UserId[pos] = premiums.get(i);
                    break;
                }
            }
            count = 0;
        }
        for (int i : admins.keys()) {
            for (Cache j : admins.get(i).getCachesVisitadas()) {
                for (Integer log : j.getLogs().keys()) {
                    if (admins.get(i).getID() == j.getLogs().get(log).getUserId()
                            && j.getLogs().get(log).getDate().compareTo(dataInicio) > 0
                            && j.getLogs().get(log).getDate().compareTo(dataFim) < 0) {
                        count++;
                    }
                }
            }
            int pos = 0;
            for (int k = 0; k < UserCount.length; k++) {
                if (UserCount[k] == null && UserId[k] == null) {
                    UserId[k] = admins.get(i);
                    UserCount[k] = count;
                    break;
                }
                if (UserCount[k] < count && UserCount[k] != null) pos = k;
                else if ((k + 1 == UserCount.length)) {
                    UserCount[pos] = count;
                    UserId[pos] = admins.get(i);
                    break;
                }
            }
            count = 0;
        }
        for (Object ob : UserId) {
            if (ob instanceof Admin) {
                System.out.println(((Admin) ob).getID() + ", " + ((Admin) ob).getNome());
            } else if (ob instanceof Premium) {
                System.out.println(((Premium) ob).getID() + ", " + ((Premium) ob).getNome());
            } else if (ob instanceof Basic) {
                System.out.println(((Basic) ob).getID() + ", " + ((Basic) ob).getNome());
            }
        }
    }

    /**
     * Listar os TravelBugs com mais localizações (Caches), visitadas;
     */
    public static void listarTravelBugsComMaisLocalizacoes() {
        int count = 0;
        for (String s : travelbugs.keys()) {
            for (Integer i : travelbugs.get(s).getHistorico().keys()) {
                count++;
            }
            System.out.println("O travelbug: " + travelbugs.get(s).getNome() + " percorreu " + count + " localizacoes\n");
            count = 0;
        }
    }

    /**
     *  Classe auxiliar para melhor manipulação de dados sobre distancias entre caches;
     */
    public static class ligacoesCaches {
        String geocacheInicial;
        String geocacheFinal;
        float distancia;
        int min;

        public ligacoesCaches(String geocacheInicial, String geocacheFinal, float distancia, int min) {
            this.geocacheInicial = geocacheInicial;
            this.geocacheFinal = geocacheFinal;
            this.distancia = distancia;
            this.min = min;
        }
    }

    /**
     * Listar todos os Logs de todos os TravelBugs na DB;
     */
    public static void listarLogsTravelBugs() {
        for (String nome : travelbugs.keys()) {
            for (int i : travelbugs.get(nome).getHistorico().keys())
                System.out.println(travelbugs.get(nome).getHistorico().get(i).toString());
        }
    }
}