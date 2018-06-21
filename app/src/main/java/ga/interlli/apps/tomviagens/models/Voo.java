package ga.interlli.apps.tomviagens.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Voo {

    @SerializedName("id")
    private int id;

    @SerializedName("origem")
    private Aeroporto origem;

    @SerializedName("destino")
    private Aeroporto destino;

    @SerializedName("aviao")
    private Aviao aviao;

    @SerializedName("valorPassagem")
    private double valorPassagem;

    @SerializedName("dataVoo")
    private Date dataVoo;

    private List<Poltrona> poltronas;

    public Voo() {
    }

    public Voo(int id, Aeroporto origem, Aeroporto destino, Aviao aviao, double valorPassagem, Date dataVoo) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.aviao = aviao;
        this.valorPassagem = valorPassagem;
        this.dataVoo = dataVoo;
    }

    public Voo(int id, Aeroporto origem, Aeroporto destino, Aviao aviao, double valorPassagem, Date dataVoo, List<Poltrona> poltronas) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.aviao = aviao;
        this.valorPassagem = valorPassagem;
        this.dataVoo = dataVoo;
        this.poltronas = poltronas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public double getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(double valorPassagem) {
        this.valorPassagem = valorPassagem;
    }

    public Date getDataVoo() {
        return dataVoo;
    }

    public void setDataVoo(Date dataVoo) {
        this.dataVoo = dataVoo;
    }

    public List<Poltrona> getPoltronas() {
        return poltronas;
    }

    public void setPoltronas(List<Poltrona> poltronas) {
        this.poltronas = poltronas;
    }
}
