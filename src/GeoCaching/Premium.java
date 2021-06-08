package GeoCaching;

public class Premium extends Admin {

    /**
     * -- CONSTRUCTOR --
     */

    public Premium(int ID, String nome, String perm) {
        super(ID, nome, perm);
    }
    public Premium(String nome, String perm) { super(nome, perm);}
}