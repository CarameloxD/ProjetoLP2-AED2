package GeoCaching;

import java.util.ArrayList;

public class TravelBug extends Item {

    public Point GPS;

    public String Objetivo;

    public ArrayList<Log> Historico;

    //Constructor

    public TravelBug(String descricao, Utilizador utilizador, Cache cache, Point GPS, String objetivo, ArrayList<Log> historico) {
        super(descricao, utilizador, cache);
        this.GPS = GPS;
        Objetivo = objetivo;
        Historico = historico;
    }

    //Getter e Setter

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

    public ArrayList<Log> getHistorico() {
        return Historico;
    }

    public void setHistorico(ArrayList<Log> historico) {
        Historico = historico;
    }
}