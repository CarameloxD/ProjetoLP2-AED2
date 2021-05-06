package GeoCaching;

import java.util.ArrayList;


public abstract class Utilizador {

    public int ID;

    public String Nome;

    public ArrayList<Item> Items;

    public void editarUtilizador(Utilizador u) {

    }

    public void eliminarUtilizador(Utilizador U) {

    }

    public void trocarItems(Cache c, int id1, int id2) { //ID1 - Item do utilizador    ID2 - Item da cache
        for(int i = 0; i < c.Items.size(); i++){
            if(c.Items.get(i).Id == id2){
                for(int j = 0; j < this.Items.size(); j++){
                    if(this.Items.get(j).Id == id1){
                        Item aux = this.Items.get(j);
                        this.Items.get(j) = c.Items.get(i);
                        c.Items.get(i) = aux;
                    }
                }
            }
        }
    }

    public void registarLog(Cache c) {

    }

    //Constructor
    public Utilizador(int ID, String nome, ArrayList items) {
        this.ID = ID;
        Nome = nome;
        Items = items;
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