package Test;

import Entite.Evenement;
import Entite.Commentaires;
import Service.EventService;
import Service.CommentService;

import java.sql.Date;

public class Test {

    public static void main(String[] args) {
        EventService eventService = new EventService();
        CommentService commentService = new CommentService();


        Evenement newEvent = new Evenement();
        newEvent.setTitre("Conference on AI");
        newEvent.setDescription("An exciting conference about AI innovations.");
        newEvent.setDate(Date.valueOf("2025-02-15"));

        System.out.println("Adding a new event:");
        try {
            eventService.addEvent(newEvent);
            System.out.println("Event added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding event: " + e.getMessage());
        }


        System.out.println("\nListing all events:");
        try {
            eventService.getAllEvents().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error retrieving events: " + e.getMessage());
        }

        // Updating an event
        System.out.println("\nUpdating the event with ID 1:");
        try {
            Evenement updatedEvent = new Evenement(1, "Updated Conference on AI", "Updated description for the AI conference.", Date.valueOf("2025-03-01"));
            eventService.updateEvent(updatedEvent);
            System.out.println("Event updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating event: " + e.getMessage());
        }


        System.out.println("\nListing all events after update:");
        try {
            eventService.getAllEvents().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error retrieving events: " + e.getMessage());
        }


        System.out.println("\nDeleting the event with ID 1:");
        try {
            eventService.deleteEvent(1);
            System.out.println("Event deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error deleting event: " + e.getMessage());
        }


        System.out.println("\nListing all events after deletion:");
        try {
            eventService.getAllEvents().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error retrieving events: " + e.getMessage());
        }

        // Test: Retrieve comment by ID
        System.out.println("\nGetting comment by ID (example ID 1):");
        try {
            Commentaires comment = commentService.getCommentById(1);
            if (comment != null) {
                System.out.println("Comment found: " + comment);
            } else {
                System.out.println("No comment found with ID 1");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving comment: " + e.getMessage());
        }
    }
}
