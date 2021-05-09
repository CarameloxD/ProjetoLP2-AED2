package GeoCaching;

import edu.princeton.cs.algs4.RedBlackBST;

import java.time.LocalDateTime;
import java.util.Date;

public class Basic extends Premium {

    /**
     * -- CONSTRUCTOR --
     */

    public Basic(int ID, String nome, String perm) {
        super(ID, nome, perm);
    }

    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- METODOS ESPECIFICOS --
     */

    /**
     * Utilizador básico não pode criar TravelBugs, então esta função vai sobrepor a mesma da superclass.
     */

    @Override
    public void createTravelbug(RedBlackBST<String, TravelBug> travelbugs, Cache c, String descricao, String nome,
                                String Objetivo) {
        System.out.println("ERRO! { \n\tUtilizadores Basic não podem criar TravelBugs!\n\t" +
                this.getID() + ", " + this.getNome() + ", " + this.getPerm()
                + ", createTravelbug!\n}\n");
    }

    /**
     * Utilizador básico não tem acesso a Caches Premium, então esta função vai sobrepor a mesma da superclass.
     * Mesmo assim, é escrito no log que o Utilizador esteve presente na geocache.
     */

    @Override
    public void visitarCache(Cache c, String Mensagem, Item itemDeixar, Item itemLevar) {
        if (c.getTipo().equals("basic")) {
            trocarItems(c, itemLevar, itemDeixar);
        } else {
            System.out.println("ERRO! { \n\tUtilizadores Basic não têm acesso a Caches Premium!\n\t" +
                    this.getID() + ", " + this.getNome() + ", " + this.getPerm()
                    + ", visitarCache!\n}\n");
        }
        this.getCachesVisitadas().add(c);

        LocalDateTime date = LocalDateTime.now();
        Date dateAtual = new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), date.getHour(),
                date.getMinute(), date.getSecond());
        String Info = this.getNome() + ", " + this.getPerm();
        Log log = new Log(dateAtual, Info, Mensagem);
        log.setUserId(this.getID());
        c.getLogs().put(log.getId(), log);
    }
}