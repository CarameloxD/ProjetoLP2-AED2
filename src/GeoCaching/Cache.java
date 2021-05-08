package GeoCaching;

import edu.princeton.cs.algs4.RedBlackBST;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;


public class Cache {

    private String nome;

    private String regiao;

    private Point GPS;

    private ArrayList<Item> Items = new ArrayList<>();

    private String PontoInteresse;

    private String Dificuldade;

    private String Tipo;

    private RedBlackBST<Integer, Log> logs = new RedBlackBST<>();

    //Constructor
    public Cache(String nome, String regiao, Point GPS, String pontoInteresse, String dificuldade, String tipo) {
        this.nome = nome;
        this.regiao = regiao;
        this.GPS = GPS;
        PontoInteresse = pontoInteresse;
        Dificuldade = dificuldade;
        Tipo = tipo;
    }

    //Getter e Setter
    public String getNome() {
        return nome;
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

    public void setItems(ArrayList<Item> items) {
        Items = items;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}