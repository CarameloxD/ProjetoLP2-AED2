package GeoCaching;

import java.util.ArrayList;


public class Cache {

    public Integer Id;

    public Point GPS;

    public ArrayList<Item> Items = new ArrayList<>();

    public String PontoInteresse;

    public String Dificuldade;

    public ArrayList<Log> Logs;

    //Constructor

    public Cache(Integer id, Point GPS,  String pontoInteresse, String dificuldade, ArrayList<Log> logs) {
        Id = id;
        this.GPS = GPS;
        PontoInteresse = pontoInteresse;
        Dificuldade = dificuldade;
        Logs = logs;
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

    public ArrayList<Log> getLogs() {
        return Logs;
    }

    public void setLogs(ArrayList<Log> logs) {
        Logs = logs;
    }
}