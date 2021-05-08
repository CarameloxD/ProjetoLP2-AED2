package GeoCaching;

public class Item {

    private String Descricao;

    //Constructor
    public Item( String descricao) {
        Descricao = descricao;
    }

    //Getter e Setter

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}