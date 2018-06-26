package ga.interlli.apps.tomviagens.models;

import java.io.Serializable;

public class Poltrona implements Serializable {

    private int id;
    private Voo voo;
    private Passagem passagem;

    public Poltrona() {
    }

    public Poltrona(int id, Voo voo, Passagem passagem) {
        this.id = id;
        this.voo = voo;
        this.passagem = passagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public Passagem getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }
}
