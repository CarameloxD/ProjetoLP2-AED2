package GeoCaching;

import java.sql.Time;
import java.sql.Date;

public class Log {
    static AtomicInteger nextId = new AtomicInteger();
    private int id;

    private Date date;

    private String Info;

    public String Mensagem;


    //Constructor

    public Log(Date date, String info, String mensagem) {
        id = nextId.incrementAndGet();
        this.date = date;
        this.Info = info;
        Mensagem = mensagem;
        this.userId = userId;
        this.perm = perm;
    }

    //Getter e Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String mensagem) {
        Mensagem = mensagem;
    }

    public int getUserId() {
        return UserID;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public void setUserId(int userID) {
        UserID = userID;
    }

    public String getCacheTravelBug() {
        for(String s : caches.keys())
            if(caches.get(s).getLogs().contains(this.getId()))
                return caches.get(s).getNome();
        for(String s : travelbugs.keys())
            if(travelbugs.get(s).getHistorico().contains(this.getId()))
                return travelbugs.get(s).getNome();
        return null;
    }

    public String getData() {
        return date.getYear() + ", " + date.getMonth() + ", " + date.getDay() + ", " + date.getHours() + ", " +
                date.getMinutes() + ", " + date.getSeconds();
    }
    /*---------------------------------------------------------------------------------------------------------------*/

    /**
     * -- ToString --
     */

    @Override
    public String toString() {
        return date.getYear() + ", " + date.getMonth() + ", " + date.getDay() + ", " +
                date.getHours() + ", " + date.getMinutes() + ", " + date.getSeconds() + ", " + this.Info +
                ", " + Mensagem + "\n";
    }
}