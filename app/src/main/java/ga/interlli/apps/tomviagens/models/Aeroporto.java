package ga.interlli.apps.tomviagens.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Aeroporto implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("cidade")
    private String cidade;

    @SerializedName("aeroporto")
    private String aeroporto;

    public Aeroporto() {
    }

    public Aeroporto(int id, String cidade, String aeroporto) {
        this.id = id;
        this.cidade = cidade;
        this.aeroporto = aeroporto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getAeroporto() {
        return aeroporto;
    }

    public void setAeroporto(String aeroporto) {
        this.aeroporto = aeroporto;
    }
}
