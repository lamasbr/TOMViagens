package ga.interlli.apps.tomviagens.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("nome")
    private String nome;

    @SerializedName("email")
    private String email;

    @SerializedName("login")
    private String login;

    @SerializedName("senha")
    private String senha;

    @SerializedName("token")
    private String token;

    @SerializedName("ativo")
    private boolean ativo = true;

    @SerializedName("passagens")
    private List<Passagem> passagens;

    public Usuario() {
        this.passagens = new ArrayList<>();
    }

    public Usuario(int id, String nome, String email, String token) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.token = token;
        this.passagens = new ArrayList<>();
    }

    public Usuario(int id, String nome, String email, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.passagens = new ArrayList<>();
    }

    public Usuario(int id, String nome, String email, String token, List<Passagem> passagens) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.token = token;
        this.passagens = passagens;
    }

    public Usuario(int id, String nome, String email, String login, String senha, String token, boolean ativo, List<Passagem> passagens) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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