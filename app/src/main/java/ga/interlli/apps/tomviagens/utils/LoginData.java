package ga.interlli.apps.tomviagens.utils;

public class LoginData {

    private String login;
    private String senha;

    public LoginData() {
    }

    public LoginData(String login, String senha) {
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
