package ga.interlli.apps.tomviagens.models;

public class UsuarioLogin {

    private String login;
    private String senha;

    public UsuarioLogin() {
    }

    public UsuarioLogin(String login, String senha) {
        this.login = login;
        this.senha = senha;
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
}
