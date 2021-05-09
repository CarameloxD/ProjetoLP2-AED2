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

    public void tostring() {
        System.out.println("Utilizador {\n" + "\tID=" + ID + ", Nome: " + Nome + ", Perm: "
                + perm + ";\n\tItems do Utilizador:");
        for (Item i : this.getItems()) {
            if (!(i instanceof TravelBug))
                System.out.println("\t\t" + i.getDescricao() + ";");
        }
        if (this.getItems().isEmpty()) {
            System.out.println("\t\tUtilizador nao tem Items na sua posse!");
            System.out.println("\n}\n");
            return;
        }
        System.out.println("\tTravelBugs do Utilizador:");
        for (Item i : this.getItems()) {
            if (i instanceof TravelBug)
                System.out.println("\t\t" + ((TravelBug) i).getNome() + ": " + i.getDescricao() + ", " +
                        ((TravelBug) i).getGPS().getLatitude() + ", " + ((TravelBug) i).getGPS().getLongitude() +
                        ", " + ((TravelBug) i).getObjetivo() + ";");
        }
        System.out.println("\n}\n");
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- MANIPULAÇAO REDBLACK TRAVELBUGS --
     */

    public void createTravelbug(RedBlackBST<String, TravelBug> travelbugs, Cache c, String descricao, String nome,
                                String Objetivo) {
        TravelBug tb = new TravelBug(nome, this.getNome(), descricao, c.getGPS().getLatitude(),
                c.getGPS().getLongitude(), c.getNome(), Objetivo);
        if (travelbugs.contains(nome) || this.getItems().contains(tb)) {
            System.out.println("Erro, TravelBug ja existe na DB!");
            return;
        }
        c.getItems().add(tb);
        travelbugs.put(nome, tb);
    }

    public void trocarItems(Cache c, Item itemLevar, Item itemDeixar) {
        if (itemLevar != null && itemDeixar != null) {                                        //Troca de Items com Cache
            if (c.getItems().contains(itemLevar) && this.Items.contains(itemDeixar)) {
                c.getItems().set(c.getItems().indexOf(itemLevar), itemDeixar);
                this.Items.set(this.Items.indexOf(itemDeixar), itemLevar);
                if (c.getItems().get(c.getItems().indexOf(itemDeixar)) instanceof TravelBug) {
                    ((TravelBug) c.getItems().get(c.getItems().indexOf(itemDeixar))).setGPS(c.getGPS());
                }
                if (this.getItems().get(this.getItems().indexOf(itemLevar)) instanceof TravelBug) {
                    ((TravelBug) this.getItems().get(this.getItems().indexOf(itemLevar))).setGPS(null);
                }
            } else System.out.println("ERRO! Cache/User não contem o item pedido!");
        }
        if (itemLevar != null && itemDeixar == null) {                                          //Levar um Item da Cache
            if (c.getItems().contains(itemLevar)) {
                c.getItems().remove(itemLevar);
                this.getItems().add(itemLevar);
                if (this.getItems().get(this.getItems().indexOf(itemLevar)) instanceof TravelBug) {
                    ((TravelBug) this.getItems().get(this.getItems().indexOf(itemLevar))).setGPS(null);
                }
            } else System.out.println("ERRO! Cache não contem o item pedido!");
        }
        if (itemLevar == null && itemDeixar != null) {                                           //Colocar Item na Cache
            if (this.Items.contains(itemDeixar)) {
                c.getItems().add(itemDeixar);
                this.getItems().remove(itemDeixar);
                if (c.getItems().get(c.getItems().indexOf(itemDeixar)) instanceof TravelBug) {
                    ((TravelBug) c.getItems().get(c.getItems().indexOf(itemDeixar))).setGPS(c.getGPS());
                }
            } else System.out.println("ERRO! User não contem o item pedido!");
        }
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- METODOS ESPECIFICOS --
     */

    /**
     * Simula a Visita de uma Cache por parte de um utilizador, como tal é possivel a troca
     * de Items com a Cache, a escrita de uma mensagem no Log criado ao ser visitada a Cache
     *
     * @param c          Objeto do tipo Cache a visitar/interagir pelo Utilizador;
     * @param Mensagem   Mensagem que será escrita no log (null se não quiser deixar mensagem);
     * @param itemLevar  Item a ser retirado da cache (null se não levar nenhum Item da Cache);
     * @param itemDeixar Item a ser deixado na cache  (null se não deixar nenhum Item na Cache);
     */
    public void visitarCache(Cache c, String Mensagem, Item itemDeixar, Item itemLevar) {
        trocarItems(c, itemLevar, itemDeixar);
        this.cachesVisitadas.add(c);
        LocalDateTime date = LocalDateTime.now();
        Date dateAtual = new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), date.getHour(),
                date.getMinute(), date.getSecond());
        String Info = this.Nome + ", " + this.perm;
        Log log = new Log(dateAtual, Info, Mensagem);
        log.setUserId(this.getID());
        c.getLogs().put(log.getId(), log);
        for (Item i : this.getItems()) {
            if (i instanceof TravelBug) {
                log.setInfo(Info + ", Passou pela Cache: " + c.getNome());
                ((TravelBug) i).getHistorico().put(log.getId(), log);
            }
        }
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- PESQUISAS --
     */

    /**
     * Listar todas as Caches visitadas por um determinado utilizador;
     *
     * @param Regiao Regiao restringe a localização das caches a serem imprimidas
     *               (Opcional (null se nao quiser listar as caches nao visitadas pela mesma) );
     */
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

    /**
     * Listar todas as Caches nao visitadas por um determinado utilizador;
     *
     * @param caches DB onde estao armazenadas todas as Caches;
     * @param Regiao Regiao restringe a localização das caches a serem imprimidas
     *               (Opcional (null se nao quiser listar as caches nao visitadas pela mesma) );
     */
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