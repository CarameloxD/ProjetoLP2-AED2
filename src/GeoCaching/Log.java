package GeoCaching;

import java.sql.Time;
import java.sql.Date;

public class Log {
    static AtomicInteger nextId = new AtomicInteger();
    private int id;

    private Date date;

    public String Mensagem;


    //Constructor

    public Log( Date date, String mensagem, int userId, String perm) {
        id = nextId.incrementAndGet();
        this.date = date;
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
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    @Override
    public String toString() {
        return "Log{" +
                "\tRegistado em: " + date.getYear() + "/" + date.getMonth() + "/" + date.getDay() + " - " +
                date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds() + ", " + this.perm + "UserID:" +
                this.userId + " -> Mensagem: '" + Mensagem + "' }";
    }
}