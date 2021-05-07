package GeoCaching;

import java.sql.Time;
import java.sql.Date;

public class Log {
    public Date date;

    public Time Time;

    public String Mensagem;


    //Constructor

    public Log(Date date, java.sql.Time time, String mensagem) {
        this.date = date;
        Time = time;
        Mensagem = mensagem;
    }

    //Getter e Setter
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