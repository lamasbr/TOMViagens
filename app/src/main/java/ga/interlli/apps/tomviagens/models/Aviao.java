package ga.interlli.apps.tomviagens.models;

import com.google.gson.annotations.SerializedName;

public class Aviao {

    @SerializedName("id")
    private int id;

    @SerializedName("prefixo")
    private String prefixo;

    @SerializedName("modelo")
    private String modelo;

    @SerializedName("capacidade")
    private int capacidade;

    public Aviao() {
    }

    public Aviao(int id, String prefixo, String modelo, int capacidade) {
        this.id = id;
        this.prefixo = prefixo;
        this.modelo = modelo;
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
