package GeoCaching;

public class Admin extends Utilizador{

    /**
     * -- CONSTRUCTOR --
     */

    public Admin(int ID, String nome, String perm) {
        super(ID, nome, perm);
    }

    public void removerCache() {

    }

    public TravelBug listarTodosTravelBugs() {
        return null;
    }

    /*public void listarLogsCache(Cache cache) {
       for(Log log : cache.getLogs())
            System.out.println(log.date.toString() + log.Time.toString() + log.Mensagem);
        for(int i = 0; i < cache.getLogs().size(); i++)
            System.out.println(cache.getLogs().get(i).date.toString() + cache.getLogs().get(i).Time.toString() + cache.getLogs().get(i).Mensagem);
    }
}