package GeoCaching;

public class Item {

    public String Descricao;

    public Utilizador utilizador;

    public Cache cache;

    //Constructor
    public Item( String descricao, Utilizador utilizador, Cache cache) {
        Descricao = descricao;
        this.utilizador = utilizador;
        this.cache = cache;
    }

    //Getter e Setter

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }
}