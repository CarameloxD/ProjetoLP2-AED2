package GeoCaching;

import edu.princeton.cs.algs4.RedBlackBST;

import java.sql.Date;
import java.sql.Time;

public class TravelBug extends Item {

    private String nome;

    private Point GPS;

    private String Objetivo;

    private RedBlackBST<Integer, Log> Historico = new RedBlackBST<>();

    //Constructor
    public TravelBug(String nome, String descricao, Point GPS, String objetivo) {
        super(descricao);
        this.nome = nome;
        this.GPS = GPS;
        Objetivo = objetivo;
    }

    //Getter e Setter

    public Point getGPS() {
        return GPS;
    }

    public void setGPS(Point GPS) {
        this.GPS = GPS;
    }

    public String getObjetivo() {
        return Objetivo;
    }

    public void setObjetivo(String objetivo) {
        Objetivo = objetivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RedBlackBST<Integer, Log> getHistorico() {
        return Historico;
    }

    public void setHistorico(RedBlackBST<Integer, Log> historico) {
        Historico = historico;
    }

    public void addHistorico(Log log) {
        Integer id = log.getId();
        if (Historico.contains(id)) {
            System.out.println("Erro a adicionar, nao existe historico");
            return;
        }
        Historico.put(id, log);
    }

    public void removeHistorico(Log log) {
        if (Historico.contains(log.getId())) {
            Historico.delete(log.getId());
        } else System.out.println("Erro a remover, nao existe historico");
    }

    public void editarHistorico(Log log, int id, Date date, Time time, String mensagem) {
        Integer ID = log.getId();
        if (Historico.contains(ID)) {
            Historico.get(ID).setId(id);
            Historico.get(ID).setDate(date);
            Historico.get(ID).setTime(time);
            Historico.get(ID).setMensagem(mensagem);
        }
    }

    public void listarHistorico() {
        System.out.println("Historico: \n");
        for (Integer log : Historico.keys()) {
            System.out.println(Historico.get(log).toString());
        }
    }
}