package GeoCaching;

import java.util.ArrayList;


public abstract class Utilizador {

    public int ID;

    public String Nome;

    private ArrayList<Item> Items = new ArrayList<>();

    public void editarUtilizador(Utilizador u) {

    }

    public void eliminarUtilizador(Utilizador U) {

    }

    public void registarLog(Cache c) {

    }

    //Constructor
    public Utilizador(int ID, String nome) {
        this.ID = ID;
        Nome = nome;
    }

    public void trocarItems(Cache c, Item i1, Item i2) {
        if (c.Items.contains(i1)) {
            c.Items.set(c.Items.indexOf(i1), i2);
            this.Items.set(this.Items.indexOf(i2), i1);
        }
    }

    //Getter e Setter
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

    public ArrayList getItems() {
      return Items;
    }

    public void setItems(ArrayList items) {
        Items = items;
    }
}