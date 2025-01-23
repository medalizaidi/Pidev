package Controllers;

import Entite.Personne;
import Service.ServicePersonne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AfficherPersonneController {

    @FXML
    private TableColumn<Personne, Integer> colage;

    @FXML
    private TableColumn<Personne, Integer> colid;

    @FXML
    private TableColumn<Personne, String> colnom;

    @FXML
    private TableColumn<Personne, String> colpren;

    @FXML
    private TableView<Personne> tablev;

    @FXML
    void initialize() {

        ServicePersonne ser=new ServicePersonne();
        try {
            List<Personne> list=ser.getAll();
            ObservableList<Personne> ob= FXCollections.observableList(list);
            tablev.setItems(ob);
            colid.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("id"));
            colage.setCellValueFactory(new PropertyValueFactory<Personne,Integer>("age"));
            colnom.setCellValueFactory(new PropertyValueFactory<Personne,String>("nom"));
            colpren.setCellValueFactory(new PropertyValueFactory<Personne,String>("prenom"));

        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    @FXML
    void Back(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/AjouterPersonne.fxml"));
        Parent root=loader.load();
        tablev.getScene().setRoot(root);
    }
}