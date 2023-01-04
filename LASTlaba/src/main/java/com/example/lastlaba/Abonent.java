package com.example.lastlaba;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Iterator;

public class Abonent {

    private String surname;
    private String phoneNumber;

    public Abonent(String surname, String phoneNumber) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }


    public static Abonent ComparePhone(String phone, ObservableList<Abonent> list){

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Abonent abonent = (Abonent) iterator.next();
            if(abonent.getPhoneNumber().equals(phone)){
                return abonent;
            }
        }
        return null;
    }

    public static ObservableList<Abonent> FindSurname(String surname, ObservableList<Abonent> list){

        ObservableList<Abonent> list1 = FXCollections.observableArrayList();

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Abonent abonent = (Abonent) iterator.next();
            if(abonent.getSurname().toLowerCase().equals(surname.toLowerCase())){

                list1.add(abonent);
            }
        }

        boolean result = list1.isEmpty();
        if(result) return null;


        return list1;
    }

    public static ObservableList<Abonent> FindPhone(String phone, ObservableList<Abonent> phoneBook){

        ObservableList<Abonent> list1 = FXCollections.observableArrayList();

        Iterator iterator = phoneBook.iterator();
        while (iterator.hasNext()){
            Abonent abonent = (Abonent) iterator.next();
            if(abonent.getPhoneNumber().equals(phone)){
                list1.add(abonent);
            }
        }
        boolean result = list1.isEmpty();
        if(result) return null;

        return list1;
    }
}