package Service;

import Entite.Personne;
import Utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicePersonne implements IService<Personne> {

    private Connection con= DataSource.getInstance().getCon();

    private Statement st;


    public ServicePersonne() {

        try {
            st=con.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    @Override
    public void ajouter(Personne personne) throws SQLException {
        String req = "INSERT INTO `personne` (`id`, `nom`, `prenom`, `age`) VALUES (NULL, '"+personne.getNom()+"', '"+personne.getPrenom()+"', '"+personne.getAge()+"');";

        st.executeUpdate(req);
    }

    @Override
    public void supprimer(Personne personne) throws SQLException {

    }

    @Override
    public void update(Personne personne) throws SQLException {

    }

    @Override
    public Personne findById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Personne> getAll() throws SQLException {

        List<Personne> list = new ArrayList<>();

        ResultSet rs=st.executeQuery("SELECT * FROM personne;");
        while (rs.next()) {
            int id=rs.getInt(1);
            String nom=rs.getString("nom");
            String prenom=rs.getString("prenom");
            int age=rs.getInt("age");

            list.add(new Personne(id,nom,prenom,age));
        }

        return list;
    }
}
