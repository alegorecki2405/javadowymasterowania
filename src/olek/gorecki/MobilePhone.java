package olek.gorecki;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        boolean exist = !myContacts.stream().anyMatch(contact1 -> contact1.getName().equals(contact.getName()));
        return exist;
    }

    public boolean updateContact(Contact old, Contact newContact) {
        int x = myContacts.indexOf(old);
        if(x==-1) {
            return false;
        }
        return true;
    }

    public boolean removeContact(Contact contact) {
        return myContacts.stream().anyMatch(contact1 -> contact1.getName().equals(contact.getName()));
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf()
    }
}
