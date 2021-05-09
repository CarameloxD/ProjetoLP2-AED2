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

    @Override
    public String toString() {
        return "Log{" +
                "\tRegistado em: " + date.getYear() + "/" + date.getMonth() + "/" + date.getDay() + " - " +
                date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + ", " + this.Info +
                " -> Mensagem: '" + Mensagem + "' }";
    }
}