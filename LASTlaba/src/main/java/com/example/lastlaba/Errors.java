
package com.example.lastlaba;

import javafx.scene.control.Alert;

public class Errors {

    public static void BlankFields(){

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Заполните все поля и повторите попытку ввода");
        alert.setTitle("Ошибка");
        alert.showAndWait();
    }

    public static void SurnameNotFound(){

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Абонента с такой фамилией нет в справочнике");
        alert.setTitle("Ошибка");
        alert.showAndWait();
    }

    public static void PhoneNotFound(){

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Абонента с таким номером телефона нет в справочнике");
        alert.setTitle("Ошибка");
        alert.showAndWait();
    }

    public static void IncorrectSurname(){

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Некорректный ввод. Заполните поле 'Фамилия' ещё раз");
        alert.setTitle("Ошибка");
        alert.showAndWait();
    }

    public static void IncorrectPhone(){

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Некорректный ввод. Заполните поле 'Номер телефона' ещё раз");
        alert.setTitle("Ошибка");
        alert.showAndWait();
    }

    public static void UniquePhone(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Абонент с таким номером телефона уже существует. Заполните поле 'Номер телефона' ещё раз");
        alert.setTitle("Ошибка");
        alert.showAndWait();
    }
}
