package GeoCaching;

import edu.princeton.cs.algs4.RedBlackBST;

import java.sql.Date;
import java.util.ArrayList;

public class Cache {

    /**
     * -- ATRIBUTOS --
     */

    private String nome;

    private String regiao;

    private Point GPS = new Point();

    private ArrayList<Item> Items = new ArrayList<>();

    private String PontoInteresse;

    private String Dificuldade;

    private String Tipo;

    private static ArrayList<String> regions = new ArrayList<>();

    private RedBlackBST<Integer, Log> logs = new RedBlackBST<>();

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- CONSTRUCTORs --
     */

    public Cache(String nome, String regiao, float latitude, float longitude, String pontoInteresse,
                 String dificuldade, String tipo) {
        this.nome = nome;
        this.regiao = regiao;
        this.GPS.setLatitude(latitude);
        this.GPS.setLongitude(longitude);
        PontoInteresse = pontoInteresse;
        Dificuldade = dificuldade;
        Tipo = tipo;
        if (!regions.contains(regiao)) {
            regions.add(regiao);
        }
    }

    public Cache() {
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- GETTERs & SETTERs --
     */

    public void setItems(java.util.ArrayList<GeoCaching.Item> items) {
        Items = items;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<String> getRegions() {
        return regions;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Point getGPS() {
        return GPS;
    }

    public void setGPS(Point GPS) {
        this.GPS = GPS;
    }

    public ArrayList<Item> getItems() {
        return Items;
    }

    public String getPontoInteresse() {
        return PontoInteresse;
    }

    public void setPontoInteresse(String pontoInteresse) {
        PontoInteresse = pontoInteresse;
    }

    public String getDificuldade() {
        return Dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        Dificuldade = dificuldade;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public RedBlackBST<Integer, Log> getLogs() {
        return logs;
    }

    public int getN_items() {
        return Items.size();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void tostring() {
        System.out.println(this.getNome() + ", " + this.getRegiao() + ", " +
                this.getGPS().getLatitude() + ", " + this.getGPS().getLongitude()
                + ", " + this.getPontoInteresse() + ", " + this.getDificuldade() +
                ", " + this.getTipo());

        if (!this.getItems().isEmpty()) listaritems();
        else System.out.print("\n");
    }

    public Float getLatitude() {
        return this.getGPS().getLatitude();
    }

    public void setLatitude(Float latitude) {
        this.GPS.setLatitude(latitude);
    }

    public Float getLongitude() {
        return this.getGPS().getLongitude();
    }

    public String getDescricaoItems() {
        String result = "";
        for (Item i : this.getItems())
            result = result.concat(i.getDescricao() + "; ");
        return result;
    }

    public void setLongitude(Float longitude) {
        this.GPS.setLongitude(longitude);
    }
    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- METODOS ESPECIFICOS --
     */

    /**
     * Adiciona logs à RedBlackST de logs.
     *
     * @param log log que sera adicionado ao RedblackST
     */
    public void addLogs(Log log) {
        Integer id = log.getId();
        if (logs.contains(id)) {
            System.out.println("Erro, nao existe logs na cache");
            return;
        }
        logs.put(id, log);
    }

    /**
     * Edita/altera os valores do log.
     *
     * @param log      log a ser editado;
     * @param id       novo id;
     * @param date     nova data;
     * @param mensagem nova mensagem;
     */

    public void editarLog(Log log, int id, Date date, String mensagem) {
        Integer ID = log.getId();
        if (logs.contains(ID)) {
            logs.get(ID).setId(id);
            logs.get(ID).setDate(date);
            logs.get(ID).setMensagem(mensagem);
        } else System.out.println("ERRO! Nao existe o Log com o Id inserido!");
    }

    /**
     * Remove o log desejado.
     *
     * @param log       Log a ser removido.
     */

    public void removelogs(Log log) {
        if (logs.contains(log.getId())) {
            logs.delete(log.getId());
        } else System.out.println("Erro, nao existe o log");
    }

    /**
     * Lista todos os logs, no ecra, existentes na RedBlackST.
     */

    public void listarlogs() {
        System.out.println("Logs:");
        for (Integer log : logs.keys()) {
            System.out.println("Id:" + logs.get(log).getId() + " - " + logs.get(log).toString());
        }
    }

    /**
     * Lista todos os items no ecra.
     */

    public void listaritems() {
        System.out.print("Items:  ");
        for (Item i : this.getItems()) {
            System.out.print(i.getDescricao() + "; ");
        }
        System.out.println("\n");
    }
}