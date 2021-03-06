package ga.interlli.apps.tomviagens.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Passagem implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("usuario")
    private Usuario usuario;

    @SerializedName("assento")
    private String assento;

    @SerializedName("ocupado")
    private boolean ocupado;

    public Passagem(int id, Usuario usuario, String assento, boolean ocupado) {
        this.id = id;
        this.usuario = usuario;
        this.assento = assento;
        this.ocupado = ocupado;
    }

    public Passagem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
