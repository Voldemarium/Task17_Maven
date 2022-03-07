package Stepanov.homework.Utilites;

import java.util.*;
import java.util.function.Predicate;

public class ContactsBook<T> {
    private Map<T, Contact<T>> contactMap = new HashMap<>();

    public Map<T, Contact<T>> getContactMap() {
        return contactMap;
    }

    public void setContactMap(Map<T, Contact<T>> contactMap) {
        this.contactMap = contactMap;
    }

    public ContactsBook<T> add(Contact<T> contact) {
        contactMap.put(contact.getPhoneNumber(), contact);
        return this;
    }

    public Contact<T> getByPhone(T phone) {
        return contactMap.get(phone);
    }

    public void removeByPhone(T phone) {
        if (contactMap.get(phone) != null) {
            contactMap.remove(phone);
            System.out.println("Contact deleted");
        } else {
            throw new MyException("There is no contact: " + phone);
        }
    }

    //получение списка контактов в отсортированном по имени виде
    public List<Contact<T>> listSortContactsByName() {
        List<Contact<T>> list = new ArrayList<>(contactMap.values());
        Collections.sort(list);
        return list;
    }

    //получение списка контактов на экране, удовлетворяющим предикату, в отсортированном виде
    public void searchBy(Predicate<Contact<T>> pred) {
        List<Contact<T>> list = new ArrayList<>();
        for (Contact<T> contact : contactMap.values()) {
            if (pred.test(contact)) {
                list.add(contact);
            }
        }
        Collections.sort(list);
        System.out.println("Найдены контакты по предикату " + list);
    }

    public void searchBy(String searchName) {
        if (searchName.contains("*")) {
            int numberStar = searchName.indexOf("*");
            String startsName = searchName.substring(0, numberStar);
            String endsName = searchName.substring(numberStar + 1, searchName.length());
            if (!endsName.contains("*")) {
                searchBy(contact -> contact.getName().startsWith(startsName) && contact.getName().endsWith(endsName));
            } else {
                System.out.println("В имени содержится более одной *");
            }
        } else {
            searchBy(contact -> contact.getName().equals(searchName));
        }

//        int sumStar = 0;
//        int numberStar = 0;
//        for (int i = 0; i < searchName.length(); i++) {
//            if (searchName.charAt(i) == '*') {
//                sumStar += 1;
//                numberStar = i;
//            }
//        }
//        if (sumStar > 1) {
//            System.out.println("В имени содержится более одной *");
//        } else {
//            String startsName = String.valueOf(searchName.subSequence(0, numberStar));
//            String endsName = String.valueOf(searchName.subSequence(numberStar + 1, searchName.length()));
//            searchBy(contact -> contact.getName().startsWith(startsName) && contact.getName().endsWith(endsName));
//        }


    }
}
