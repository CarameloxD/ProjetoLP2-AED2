package GeoCaching;

public class TravelBug extends Item {

    public Point GPS;

    public String Objetivo;

    public Utilizador utilizador;

    public void CriarObjetivo() {
    }

    public Utilizador UtilizadorAtual() {
        return null;
    }

    //Constructor

    public TravelBug(Integer id, String descricao, Utilizador utilizador, Cache cache, Point GPS, String objetivo, Utilizador utilizador1) {
        super(id, descricao, utilizador, cache);
        this.GPS = GPS;
        Objetivo = objetivo;
        this.utilizador = utilizador1;
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

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
}