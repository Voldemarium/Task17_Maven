package Stepanov.homework;

import Stepanov.homework.Utilites.Contact;
import Stepanov.homework.Utilites.ContactsBook;

public class Main {
    public static void main(String[] args) {
        ContactsBook<String> contactsBook = new ContactsBook<String>()
                .add(new Contact<>("Sveta", "6666"))
                .add(new Contact<>("Anya", "001"))
                .add(new Contact<>("Kolya", "+78973466655"))
                .add(new Contact<>("Zara", "+790222222222"))
                .add(new Contact<>("Vlad", "+790111111111"))
                .add(new Contact<>("Vladimir", "+7901333333333"));

        System.out.println("находим контакт по телефону: " + contactsBook.getByPhone("+790222222222"));

        contactsBook.removeByPhone("+78973466655");

        System.out.println("Лист контактов, сортированный  по имени" + contactsBook.listSortContactsByName());

        contactsBook.searchBy(contact -> contact.getPhoneNumber().equals("001"));
        contactsBook.searchBy(contact -> contact.getName().equals("Zara"));
        contactsBook.searchBy(contact -> contact.getName().equals("Sveta") && contact.getPhoneNumber().equals("6666"));

        contactsBook.searchBy("Zara");
        contactsBook.searchBy("*eta");
        contactsBook.searchBy("V*d");
        contactsBook.searchBy("V*a*g");

    }
}