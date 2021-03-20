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
        for(int i = 0;i<myContacts.size();i++) {
            if(myContacts.get(i).getName().equals(contact.getName())) {
                return false;
            }
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact old, Contact newContact) {
        int x = myContacts.indexOf(old);
        if(x==-1) {
            return false;
        }
        return true;
    }

    public boolean removeContact(Contact contact) {
        if(findContact(contact)!=-1){
            return true;
        }
        return false;
    }

    private int findContact(Contact contact) {
        for(int i = 0;i<myContacts.size();i++) {
            if(myContacts.get(i).getName() == contact.getName()) {
                return i;
            }
        }
        return -1;
    }

    private int findContact(String name) {
        for(int i=0;i<myContacts.size();i++) {
            if(myContacts.get(i).getName() == name) {
                return i;
            }
        }
        return -1;
    }
    public Contact queryContact(String name) {
        for(int i=0;i<myContacts.size();i++) {
            if(myContacts.get(i).getName() == name) {
                return myContacts.get(i);
            }
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for(int i =0;i<myContacts.size();i++) {
            Contact x = myContacts.get(i);
            System.out.println(i+". "+x.getName()+" -> "+x.getPhoneNumber());
        }
    }
}
