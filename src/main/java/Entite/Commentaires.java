package Entite;

public class Commentaires {
    private int id;
    private String contenu;
    private int clientId;


    public Commentaires() {}
    public Commentaires(int id, String contenu, int clientId) {
        this.id = id;
        this.contenu = contenu;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", contenu='" + contenu + '\'' +
                ", clientId=" + clientId +
                '}';
    }
}
