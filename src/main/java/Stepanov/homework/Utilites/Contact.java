package Stepanov.homework.Utilites;

public class Contact<T> implements Comparable<Contact<T>> {
    private String name;
    private T phoneNumber;

    public Contact(String name, T phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(T phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public int compareTo(Contact<T> contact) {
        return name.compareTo(contact.getName());
    }
}
