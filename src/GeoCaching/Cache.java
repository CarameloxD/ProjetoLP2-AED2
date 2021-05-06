package GeoCaching;

import java.util.ArrayList;


public class Cache {

    public Integer Id;

    public Point GPS;

    public ArrayList<Item> Items;

    public String PontoInteresse;

    public String Dificuldade;

    //Constructor
    public Cache(Integer id, Point GPS, ArrayList<Item> items, String pontoInteresse, String dificuldade) {
        Id = id;
        this.GPS = GPS;
        Items = items;
        PontoInteresse = pontoInteresse;
        Dificuldade = dificuldade;
    }


    //Getter e Setter

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Point getGPS() {
        return GPS;
    }

    public void setGPS(Point GPS) {
        this.GPS = GPS;
    }

    public ArrayList getItems() {
        return Items;
    }

    public void setItems(ArrayList items) {
        Items = items;
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

}