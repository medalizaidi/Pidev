package Controllers;

import Entite.Evenement;
import Service.EventService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EventController {
    @FXML
    private TableView<Evenement> eventTable;
    @FXML
    private TableColumn<Evenement, String> titleColumn;
    @FXML
    private TableColumn<Evenement, String> descriptionColumn;
    @FXML
    private TableColumn<Evenement, String> dateColumn;

    private EventService eventService;

    public void initialize() {
        eventService = new EventService();


        ObservableList<Evenement> events = FXCollections.observableArrayList(eventService.getAllEvents());


        titleColumn.setCellValueFactory(new PropertyValueFactory<>("titre"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));


        eventTable.setItems(events);
    }
}
