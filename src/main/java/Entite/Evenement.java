package Entite;

import java.sql.Date;

public class Evenement {
    private int id;
    private String titre;
    private String description;
    private Date date;


    public Evenement() {}


    public Evenement(int id, String titre, String description, Date date) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.date = date;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
