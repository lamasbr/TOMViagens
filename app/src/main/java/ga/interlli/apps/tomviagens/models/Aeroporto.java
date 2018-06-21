package ga.interlli.apps.tomviagens.models;

public class Aeroporto {

    private int id;
    private String cidade;
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
