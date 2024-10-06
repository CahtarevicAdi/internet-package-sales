package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import java.util.Optional;

public class InternetPackageController {

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> nameColumn;

    @FXML
    private TableColumn<Person, String> addressColumn;

    @FXML
    private TableColumn<Person, String> speedColumn;

    @FXML
    private TableColumn<Person, String> dataColumn;

    @FXML
    private TableColumn<Person, String> contractColumn;

    @FXML
    private TableColumn<Person, Void> deleteColumn;

    @FXML
    private ComboBox<String> speedComboBox;

    @FXML
    private ComboBox<String> dataComboBox;

    @FXML
    private ComboBox<String> contractComboBox;

    @FXML
    private TextField nameField;

    @FXML
    private TextField addressField;

    @FXML
    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        speedComboBox.getItems().addAll("2 Mbit/s", "5 Mbit/s", "10 Mbit/s", "20 Mbit/s", "50 Mbit/s", "100 Mbit/s");
        dataComboBox.getItems().addAll("1 GB", "5 GB", "10 GB", "100 GB", "Flat");
        contractComboBox.getItems().addAll("One year", "Two year");

        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        speedColumn.setCellValueFactory(cellData -> cellData.getValue().speedProperty());
        dataColumn.setCellValueFactory(cellData -> cellData.getValue().dataProperty());
        contractColumn.setCellValueFactory(cellData -> cellData.getValue().contractProperty());

        deleteColumn.setCellFactory(new Callback<TableColumn<Person, Void>, TableCell<Person, Void>>() {
            @Override
            public TableCell<Person, Void> call(TableColumn<Person, Void> param) {
                return new TableCell<Person, Void>() {
                    private final Button deleteButton = new Button("Delete");

                    {
                        deleteButton.setOnAction(e -> {
                            Person person = getTableView().getItems().get(getIndex());
                            showConfirmationDialog(person);
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(deleteButton);
                        }
                    }
                };
            }
        });

        personTableView.setItems(personList);
    }

    @FXML
    private void handleSaveButtonAction() {
        String name = nameField.getText();
        String address = addressField.getText();
        String speed = speedComboBox.getValue();
        String data = dataComboBox.getValue();
        String contract = contractComboBox.getValue();

        if (name.isEmpty() || address.isEmpty() || speed == null || data == null || contract == null) {
            showErrorDialog("Please fill in all fields.");
            return;
        }

        Person newPerson = new Person(name, address, speed, data, contract);
        personList.add(newPerson);

        nameField.clear();
        addressField.clear();
        speedComboBox.getSelectionModel().clearSelection();
        dataComboBox.getSelectionModel().clearSelection();
        contractComboBox.getSelectionModel().clearSelection();
    }

    private void showConfirmationDialog(Person person) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Deletion confirmation");
        alert.setHeaderText("Are you sure you want to delete this user?");
        alert.setContentText("Name: " + person.getName());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            personList.remove(person);
        }
    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
