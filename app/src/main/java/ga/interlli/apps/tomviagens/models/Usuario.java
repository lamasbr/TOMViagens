package ga.interlli.apps.tomviagens.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Usuario {

    @SerializedName("id")
    private int id;

    @SerializedName("nome")
    private String nome;

    @SerializedName("email")
    private String email;

    @SerializedName("login")
    private String login;

    @SerializedName("senha")
    private String  senha;

    @SerializedName("ativo")
    private boolean ativo;

    @SerializedName("passagens")
    private List<Passagem> passagens;

    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String login, String senha, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
    }

    public Usuario(String nome, String email, String login, String senha, boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
    }

    public Usuario(int id, String nome, String email, String login, String senha, boolean ativo, List<Passagem> passagens) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
        this.passagens = passagens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }
}
