package GeoCaching;

import edu.princeton.cs.algs4.RedBlackBST;

import java.sql.Date;
import java.sql.Time;

public class TravelBug extends Item {

    private String nome;

    private String nomeCriador;

    private Point GPS;

    private String cacheInicial;

    private String Objetivo;

    private RedBlackBST<Integer, Log> Historico = new RedBlackBST<>();

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- CONSTRUCTOR --
     */

    public TravelBug(String nome, String nomeCriador, String descricao, float latitude, float longitude,
                     String CacheInicial, String objetivo) {
        super(descricao);
        this.nome = nome;
        this.nomeCriador = nomeCriador;
        this.GPS = new Point(latitude, longitude);
        this.cacheInicial = CacheInicial;
        Objetivo = objetivo;
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- GETTERs & SETTERs --
     */

    public String getCacheInicial() {
        return cacheInicial;
    }

    public void setCacheInicial(String cacheInicial) {
        this.cacheInicial = cacheInicial;
    }

    public String getNomeCriador() {
        return nomeCriador;
    }

    public void setNomeCriador(String nomeCriador) {
        this.nomeCriador = nomeCriador;
    }

    public Point getGPS() {
        return GPS;
    }

    public void setGPS(Point GPS) {
        this.GPS = GPS;
    }

    public String getObjetivo() {
        return Objetivo;
    }

    public void setObjetivo(String objetivo) {
        Objetivo = objetivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RedBlackBST<Integer, Log> getHistorico() {
        return Historico;
    }

    public void setHistorico(RedBlackBST<Integer, Log> historico) {
        Historico = historico;
    }
}