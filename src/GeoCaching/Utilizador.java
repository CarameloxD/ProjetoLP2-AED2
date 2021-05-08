package GeoCaching;

import edu.princeton.cs.algs4.RedBlackBST;

import java.util.ArrayList;


public abstract class Utilizador {

    private int ID;

    private String Nome;

    private String perm;

    private ArrayList<Item> Items = new ArrayList<>();

    private RedBlackBST<String, TravelBug> travelbugs = new RedBlackBST<>();


    //Constructor
    public Utilizador(int ID, String nome, String perm) {
        this.ID = ID;
        Nome = nome;
        this.perm = perm;
    }

    public void trocarItems(Cache c, Item i1, Item i2) {
        if (c.getItems().contains(i1)) {
            c.getItems().set(c.getItems().indexOf(i1), i2);
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

    public ArrayList<Item> getItems() {
        return Items;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    public void setItems(ArrayList<Item> items) {
        Items = items;
    }

    public RedBlackBST<String, TravelBug> getTravelbugs() {
        return travelbugs;
    }

    public void addItemsUser(Item i) {
        this.Items.add(i);
    }

    public void addTravelbugsUser(TravelBug tb) {
        String name = tb.getNome();
        if (travelbugs.contains(name)) {
            System.out.println("Erro, TravelBug ja esta na posse do Utilizador!");
            return;
        }
        travelbugs.put(name, tb);
    }

    public void tostring() {
        System.out.println("Utilizador {\n" + "\tID=" + ID + ", Nome: " + Nome + ";\n\tItems do Utilizador:");
        for (Item i : this.getItems()) {
            System.out.println("\t\t" + i.getDescricao() + ";");
        }
        if (this.getItems().isEmpty()) {
            System.out.println("\t\tUtilizador nao tem Items na sua posse!");
        }
        System.out.println("\tTravelBugs do Utilizador:");
        for (String nome : this.getTravelbugs().keys()) {
            if (nome != null) {
                System.out.println("\t\t" + this.getTravelbugs().get(nome).getNome() +
                        ": " + this.getTravelbugs().get(nome).getDescricao() +
                        ", " + this.getTravelbugs().get(nome).getObjetivo() +
                        ";");
            }
        }
        if (this.getTravelbugs().isEmpty()) {
            System.out.println("\t\tUtilizador nao tem TravelBugs na sua posse!");
        }
        System.out.println("\tPermissons: " + perm + "\n}\n\n");
    }
}