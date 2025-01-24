package Controllers;

import Entite.Commentaires;
import Service.CommentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class CommentaireController {

    @FXML
    private ListView<String> commentListView;

    private CommentService commentService;

    @FXML
    public void initialize() {
        commentService = new CommentService();
        loadComments();
    }

    private void loadComments() {
        // Load and display all comments initially
        ObservableList<String> commentItems = FXCollections.observableArrayList();
        commentService.getAllComments().forEach(comment -> {
            String formattedComment = "ID: " + comment.getId() + "\n" +
                    "Content: " + comment.getContenu() + "\n" +
                    "Client ID: " + comment.getClientId();
            commentItems.add(formattedComment);
        });
        commentListView.setItems(commentItems);
    }


    @FXML
    private void getCommentById(int commentId) {
        // Call the service to retrieve the comment by ID
        Commentaires comment = commentService.getCommentById(commentId);

        if (comment != null) {

            String formattedComment = "ID: " + comment.getId() + "\n" +
                    "Content: " + comment.getContenu() + "\n" +
                    "Client ID: " + comment.getClientId();


            ObservableList<String> commentDetails = FXCollections.observableArrayList();
            commentDetails.add(formattedComment);
            commentListView.setItems(commentDetails);
        } else {

            ObservableList<String> noComment = FXCollections.observableArrayList();
            noComment.add("No comment found with ID: " + commentId);
            commentListView.setItems(noComment);
        }
    }
}
