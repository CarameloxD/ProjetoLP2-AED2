package GeoCaching;

import java.sql.Time;
import java.sql.Date;

public class Log {
    private int id;

    private Date date;

    private Time Time;

    public String Mensagem;


    //Constructor
    public Log(int id, Date date, Time time, String mensagem) {
        this.id = id;
        this.date = date;
        Time = time;
        Mensagem = mensagem;
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

    public Time getTime() {
        return Time;
    }

    public void setTime(Time time) {
        Time = time;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String mensagem) {
        Mensagem = mensagem;
    }
}