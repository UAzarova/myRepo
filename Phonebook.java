package lesson4;

import java.util.*;

public class Phonebook {
    private Map dictionary = new HashMap<String, ArrayList<String>>();

    @Override
    public String toString() {
        if (this.dictionary.isEmpty())
            return "Sorry, Phonebook is empty";
        else
            return "Phonebook: \n" + this.dictionary;
    }

    public void add (String lastname, String phone) {
        ArrayList<String> phones = (ArrayList<String>) this.dictionary.getOrDefault(lastname, new ArrayList<String>());
        phones.add(phone);
        this.dictionary.put(lastname, phones);
    }

    public ArrayList<String> get (String lastname) {
        return (ArrayList)this.dictionary.get(lastname);
    }

}