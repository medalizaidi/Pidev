package Service;

import Entite.Evenement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventService {
    private static final String URL = "jdbc:mysql://localhost:3306/pidev";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public void addEvent(Evenement evenement) {
        String query = "INSERT INTO evenement (titre, description, date) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, evenement.getTitre());
            stmt.setString(2, evenement.getDescription());
            stmt.setDate(3, evenement.getDate());

            stmt.executeUpdate();
            System.out.println("Event added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error adding event: " + e.getMessage());
        }
    }


    public List<Evenement> getAllEvents() {
        List<Evenement> events = new ArrayList<>();
        String query = "SELECT * FROM evenement";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String titre = rs.getString("titre");
                String description = rs.getString("description");
                Date date = rs.getDate("date");

                Evenement evenement = new Evenement(id, titre, description, date);
                events.add(evenement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving events: " + e.getMessage());
        }
        return events;
    }

    public void deleteEvent(int id) {
        String query = "DELETE FROM evenement WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Event deleted successfully!");
            } else {
                System.out.println("No event found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error deleting event: " + e.getMessage());
        }
    }

    public void updateEvent(Evenement evenement) {
        String query = "UPDATE evenement SET titre = ?, description = ?, date = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, evenement.getTitre());
            stmt.setString(2, evenement.getDescription());
            stmt.setDate(3, evenement.getDate());
            stmt.setInt(4, evenement.getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Event updated successfully!");
            } else {
                System.out.println("No event found with ID: " + evenement.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error updating event: " + e.getMessage());
        }
    }

}
