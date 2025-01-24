package Service;

import Entite.Commentaires;
import Utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentService {

    // Retrieve all comments
    public List<Commentaires> getAllComments() {
        List<Commentaires> comments = new ArrayList<>();
        String query = "SELECT * FROM commentaire";

        try (Connection conn = DataSource.getInstance().getCon();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Commentaires comment = new Commentaires(
                        rs.getInt("id"),
                        rs.getString("contenu"),
                        rs.getInt("client_id")
                );
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }


    public Commentaires getCommentById(int commentId) {
        String query = "SELECT * FROM commentaires WHERE id = ?";
        Commentaires comment = null;

        try (Connection conn = DataSource.getInstance().getCon();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, commentId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                comment = new Commentaires(
                        rs.getInt("id"),
                        rs.getString("contenu"),
                        rs.getInt("client_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }
}
