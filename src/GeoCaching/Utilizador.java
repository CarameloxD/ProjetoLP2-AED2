package GeoCaching;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.SeparateChainingHashST;

import java.util.ArrayList;


public abstract class Utilizador {

    /**
     * -- ATRIBUTOS --
     */

    private int ID;

    private String Nome;

    private String perm;

    private ArrayList<Item> Items = new ArrayList<>();

    private RedBlackBST<String, TravelBug> travelbugs = new RedBlackBST<>();

    private ArrayList<Cache> cachesVisitadas = new ArrayList<>();

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- CONSTRUCTOR --
     */

    public Utilizador(int ID, String nome, String perm) {
        this.ID = ID;
        Nome = nome;
        this.perm = perm;
    }


    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- GETTERs & SETTERs --
     */

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public ArrayList<Item> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Item> items) {
        Items = items;
    }

    public ArrayList<Cache> getCachesVisitadas() {
        return cachesVisitadas;
    }

    public void setCachesVisitadas(ArrayList<Cache> cachesVisitadas) {
        this.cachesVisitadas = cachesVisitadas;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    public RedBlackBST<String, TravelBug> getTravelbugs() {
        return travelbugs;
    }

    public void tostring() {
        System.out.println("Utilizador {\n" + "\tID=" + ID + ", Nome: " + Nome + ";\n\tItems do Utilizador:");
        for (Item i : this.getItems()) {
            System.out.println("\t\t" + i.getDescricao() + ";");
        }
        if (this.getItems().isEmpty()) {
            System.out.println("\t\tUtilizador nao tem Items na sua posse!");
        }
        System.out.println("\tTravelBugs do Utilizador:");
        for (String nome : this.getTravelbugs().keys()) {
            System.out.println("\t\t" + this.getTravelbugs().get(nome).getNome() +
                    ": " + this.getTravelbugs().get(nome).getDescricao() +
                    ", " + this.getTravelbugs().get(nome).getObjetivo() +
                    ";");
        }
        if (this.getTravelbugs().isEmpty()) {
            System.out.println("\t\tUtilizador nao tem TravelBugs na sua posse!");
        }
        System.out.println("\tPermissons: " + perm + "\n}\n");
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- MANIPULAÇAO REDBLACK TRAVELBUGS --
     */

    public void addItemsUser(Item i) {
        this.Items.add(i);
    }

    public void addTravelbugsUser(TravelBug tb) {
        String name = tb.getNome();
        if (travelbugs.contains(name)) {
            System.out.println("Erro, TravelBug ja esta na posse do Utilizador!");
            return;
        }
        travelbugs.put(name, tb);
    }

    public void trocarItems(Cache c, Item itemLevar, Item itemDeixar) {
        if (itemLevar != null && itemDeixar != null) {                                        //Troca de Items com Cache
            if (c.getItems().contains(itemLevar) && this.Items.contains(itemDeixar)) {
                c.getItems().set(c.getItems().indexOf(itemLevar), itemDeixar);
                this.Items.set(this.Items.indexOf(itemDeixar), itemLevar);
            } else System.out.println("ERRO! Cache/User não contem o item pedido!");
        }
        if (itemLevar != null && itemDeixar == null) {                                          //Levar um Item da Cache
            if (c.getItems().contains(itemLevar)) {
                c.getItems().remove(itemLevar);
                this.getItems().add(itemLevar);
            } else System.out.println("ERRO! Cache não contem o item pedido!");
        }
        if (itemLevar == null && itemDeixar != null) {                                           //Colocar Item na Cache
            if (this.Items.contains(itemDeixar)) {
                c.getItems().add(itemDeixar);
                this.getItems().remove(itemDeixar);
            } else System.out.println("ERRO! User não contem o item pedido!");
        }
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- METODOS ESPECIFICOS --
     */

    public void visitarCache(Cache c, String Mensagem, Item itemDeixar, Item itemLevar) {
        trocarItems(c, itemLevar, itemDeixar);
        this.cachesVisitadas.add(c);

        LocalDateTime date = LocalDateTime.now();
        Date dateAtual = new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), date.getHour(), date.getMinute(), date.getSecond());

        Log log = new Log(dateAtual, Mensagem, this.getID(), this.getPerm());
        c.getLogs().put(log.getId(), log);
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- PESQUISAS --
     */

    //TODO TESTAR PESQUISAS USER

    public void listarCachesVisitadas(String Regiao) {
        if (this.getCachesVisitadas().isEmpty()) {
            System.out.println("Utilizador ainda não visitou uma Cache!");
            return;
        }
        if (Regiao != null) {
            int i = 0;
            for (Cache c : this.getCachesVisitadas()) {
                if (c.getRegiao().equals(Regiao)) {
                    i++;
                    System.out.println(c.getNome() + ", " + c.getTipo() + ", " + c.getGPS().getLatitude() + ", " +
                            c.getGPS().getLongitude());
                }
            }

        } else {
            for (Cache c : this.getCachesVisitadas()) {
                System.out.println(c.getNome() + ", " + c.getTipo() + ", " + c.getGPS().getLatitude() + ", " +
                        c.getGPS().getLongitude());
            }
        }
    }

    public void listarCachesNaoVisitadas(String Regiao, SeparateChainingHashST<String, Cache> caches) {
        int i = 0;
        for (String s : caches.keys()) {
            if (!this.getCachesVisitadas().contains(caches.get(s))) {
                if (Regiao != null) {
                    if (caches.get(s).getRegiao().equals(Regiao)) {
                        i++;
                        System.out.println(caches.get(s).getNome() + ", " + caches.get(s).getTipo() + ", " +
                                caches.get(s).getGPS().getLatitude() + ", " + caches.get(s).getGPS().getLongitude());
                    }
                } else {
                    System.out.println(caches.get(s).getNome() + ", " + caches.get(s).getTipo() + ", " +
                            caches.get(s).getGPS().getLatitude() + ", " + caches.get(s).getGPS().getLongitude());
                }
            }
        }
        if (i == 0) {
            System.out.println("Utilizador ja visitou Cache na região inserida!");
        }
    }
}