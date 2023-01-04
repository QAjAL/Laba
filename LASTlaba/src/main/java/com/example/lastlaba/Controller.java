package com.example.lastlaba;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class Controller {

    @FXML
    TextField surname_field, phone_field, searchSurname_field, searchPhone_field;
    @FXML
    Button add_button, edit_button, delete_button, clean_button, searchSurname_button, searchPhone_button, cleanSearcher_button, choose_btn;
    @FXML
    TableView<com.example.lastlaba.Abonent> table;
    @FXML
    TableColumn colSurname, colPhone;

    ObservableList<com.example.lastlaba.Abonent> list = FXCollections.observableArrayList();



    @FXML
    void initialize(){

        table.setEditable(true);

        colSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        list.add(new com.example.lastlaba.Abonent("Джонсон", "+375298051673"));
        list.add(new com.example.lastlaba.Abonent("Шушу", "+375291118551"));
        list.add(new com.example.lastlaba.Abonent("Тутэйшы", "+375445992110"));
        list.add(new com.example.lastlaba.Abonent("Крук","+375296937987"));
        list.add(new com.example.lastlaba.Abonent("Джонсон","+375298805545"));



        clean_button.setOnAction(e->{

            surname_field.clear();
            phone_field.clear();
        });

        cleanSearcher_button.setOnAction(e->{

            searchSurname_field.clear();
            searchPhone_field.clear();
            table.setItems(list);
        });

        add_button.setOnAction(e->{

            if(!(surname_field.getText()!="" && phone_field.getText()!="")){

                com.example.lastlaba.Errors.BlankFields();
            }
            else if(!surname_field.getText().matches("[а-яА-Яa-zA-Z ё]+")){

                com.example.lastlaba.Errors.IncorrectSurname();
                surname_field.clear();
            }
            else if(!(phone_field.getText().matches("[0-9 +]+")&& phone_field.getText().matches("^[+]\\d{12}$"))){

                com.example.lastlaba.Errors.IncorrectPhone();
                phone_field.clear();
            }
            else if(!(com.example.lastlaba.Abonent.ComparePhone(phone_field.getText(), list) == null)){

                com.example.lastlaba.Errors.UniquePhone();
                phone_field.clear();
            }
            else {
                com.example.lastlaba.Abonent abonent = new com.example.lastlaba.Abonent(surname_field.getText(), phone_field.getText());
                list.add(abonent);
                table.getSortOrder().addAll(colSurname);
            }
        });

        delete_button.setOnAction(e->{
            com.example.lastlaba.Abonent abonent = table.getSelectionModel().getSelectedItem();
            list.remove(abonent);
        });

        choose_btn.setOnAction(e->{

            com.example.lastlaba.Abonent abonent = table.getSelectionModel().getSelectedItem();
            surname_field.setText(abonent.getSurname());
            phone_field.setText(abonent.getPhoneNumber());
        });

        edit_button.setOnAction(e->{

            if(!(surname_field.getText()!="" && phone_field.getText()!="")){
                com.example.lastlaba.Errors.BlankFields();
            }
            else if(!surname_field.getText().matches("[а-яА-Яa-zA-Z]+")){
                com.example.lastlaba.Errors.IncorrectSurname();
                surname_field.clear();
            }
            else if(!(phone_field.getText().matches("[0-9 +]+") && phone_field.getText().matches("^[+]\\d{12}$"))){
                com.example.lastlaba.Errors.IncorrectPhone();
                phone_field.clear();
            }
            else{

                com.example.lastlaba.Abonent editAbonent = table.getSelectionModel().getSelectedItem();
                com.example.lastlaba.Abonent newAbonent = new com.example.lastlaba.Abonent(surname_field.getText(), phone_field.getText());
                list.remove(editAbonent);
                list.add(newAbonent);
                table.getSortOrder().addAll(colSurname);
            }
        });

        searchSurname_button.setOnAction(e->{

            ObservableList<com.example.lastlaba.Abonent> list1 = FXCollections.observableArrayList();

            if(com.example.lastlaba.Abonent.FindSurname(searchSurname_field.getText(), list) != null){
                list1 = com.example.lastlaba.Abonent.FindSurname(searchSurname_field.getText(), list);
                table.setItems(list1);
                table.getSortOrder().addAll(colSurname);
            }
            else{
               com.example.lastlaba.Errors.SurnameNotFound();
                searchSurname_field.clear();
            }
        });

        searchPhone_button.setOnAction(e->{

            ObservableList<com.example.lastlaba.Abonent> list1 = FXCollections.observableArrayList();

            if(com.example.lastlaba.Abonent.FindPhone(searchPhone_field.getText(), list) != null){

                list1 = com.example.lastlaba.Abonent.FindPhone(searchPhone_field.getText(), list);
                table.setItems(list1);
                table.getSortOrder().addAll(colSurname);
            }
            else{
               com.example.lastlaba.Errors.PhoneNotFound();
                searchPhone_field.clear();
            }
        });


        table.setItems(list);
        table.getSortOrder().addAll(colSurname);
    }
}
