package GeoCaching;

import java.sql.Time;

public class Log {

    public Time Time;

    public String Mensagem;

    public Cache cache;

    //Constructor
    public Log(Time time, String mensagem, Cache cache) {
        Time = time;
        Mensagem = mensagem;
        this.cache = cache;
    }

    //Getter e Setter
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

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }
}