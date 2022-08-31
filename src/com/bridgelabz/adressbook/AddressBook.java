package com.bridgelabz.adressbook;

import java.util.*;

public class AddressBook {
    static Scanner scanner = new Scanner(System.in);
    HashMap<String, LinkedList<ContactsDetails>> contactBook = new HashMap<>();
    public void showMenu() {
        try {
            while (true) {
                System.out.println("""
                        1. Crate New address book\s
                        2. Continue with existing address book\s
                        3. Show All address books\s
                        4. Search person by location in all address book\s
                        5. Search Phone number by Name\s
                        6. Exit""");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter a name for Address book");
                        String newBook = scanner.next();
                        LinkedList<ContactsDetails> contactList = new LinkedList<>();
                        if (contactBook.containsKey(newBook))
                            System.out.println("Book already exists");
                        else
                            createContact(contactList, contactBook, newBook);
                    }
                    case 2 -> {
                        System.out.println(contactBook.keySet());
                        System.out.println("Which address book do you want to access?");
                        String existingBook = scanner.next();
                        if (contactBook.containsKey(existingBook)) {
                            LinkedList<ContactsDetails> contactList = contactBook.get(existingBook);
                            createContact(contactList, contactBook, existingBook);
                        } else
                            System.out.println("Book not found");
                    }
                    case 3 -> {
                        int serialNo = 1;
                        for (String book : contactBook.keySet()) {
                            System.out.println(serialNo + ". " + book);
                            serialNo++;
                        }
                        System.out.println("\n" + contactBook);
                    }
                    case 4 -> {
                        System.out.println("Enter Name of City or State");
                        String nameForLocation = scanner.next();
                        searchByLocation(nameForLocation);
                    }
                    case 5 -> {
                        System.out.println("Enter first Name");
                        String nameForContact = scanner.next();
                        getContactNo(nameForContact);
                    }
                    default -> System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public Hashtable<String, List<String>> searchByLocation(String nameForLocation) {
        try {
            Hashtable<String, List<String>> searchResult = new Hashtable<>();
            List<String> contactList;
            for (String keyOfBook : contactBook.keySet()) {
                contactList = new ArrayList<>();
                for (int index = 0; index < contactBook.get(keyOfBook).size(); index++) {

                    if (contactBook.get(keyOfBook).get(index).getCity().equals(nameForLocation))
                        contactList.add(contactBook.get(keyOfBook).get(index).getFirst_name());

                    if (contactBook.get(keyOfBook).get(index).getState().equals(nameForLocation))
                        contactList.add(contactBook.get(keyOfBook).get(index).getFirst_name());
                }
                if (!contactList.isEmpty())
                    searchResult.put(keyOfBook, contactList);
            }
            System.out.println(searchResult);
            return searchResult;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    private void getContactNo(String nameOfContact) {
        try {
            for (String keyOfBook : contactBook.keySet()) {
                for (int index = 0; index < contactBook.get(keyOfBook).size(); index++) {
                    if (contactBook.get(keyOfBook).get(index).getFirst_name().equals(nameOfContact)) {

                        String lastName = contactBook.get(keyOfBook).get(index).getLast_name();
                        String phone = contactBook.get(keyOfBook).get(index).getPhone_number();

                        System.out.println(keyOfBook + " : " + nameOfContact + " " + lastName + " --> " + phone);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void createContact(LinkedList<ContactsDetails> contactList, HashMap<String, LinkedList<ContactsDetails>> contactBook, String addressBook) {
        try {
            boolean run = true;
            while (run) {
                System.out.println("""
                        1. Add a New contact detail\s
                        2. Show All contact\s
                        3. Update a contact\s
                        4. Delete a contact\s
                        0. Exit\s
                        """);
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        LinkedList<ContactsDetails> multiContactInBook = addContact(contactList);
                        contactBook.put(addressBook, multiContactInBook);
                    }
                    case 2 -> displayContact(contactList);
                    case 3 -> updateContact(contactList);
                    case 4 -> deleteContact(contactList);
                    default -> run = false;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
    }
    private void displayContact(LinkedList<ContactsDetails> contactList) {
        try {
            System.out.println("All contact -> " + contactList.size());
            System.out.println(contactList);
        } catch (Exception e) {
            System.out.println("List is Empty");
        }
    }
    private int searchName(String searchName, LinkedList<ContactsDetails> contactList) {
        try {
            for (int index = 0; index < contactList.size(); index++) {
                if (contactList.get(index).getFirst_name().equals(searchName))
                    return index;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
    private LinkedList<ContactsDetails> addContact(LinkedList<ContactsDetails> contactList) {
        try {
            System.out.println("Enter the details \n" + "First Name :");
            String firstName = scanner.next();
            int existingName = searchName(firstName, contactList);
            if (existingName == -1) {
                ContactsDetails contactInfo = new ContactsDetails();
                contactInfo.setFirstname(firstName);

                System.out.println("Last Name :");
                String lastName = scanner.next();
                contactInfo.setLastname(lastName);

                System.out.println("Phone Number :");
                String phone = scanner.next();
                contactInfo.setPhone(phone);

                System.out.println("Email :");
                String email = scanner.next();
                contactInfo.setEmail(email);

                System.out.println("City :");
                String city = scanner.next();
                contactInfo.setCity(city);

                System.out.println("State :");
                String state = scanner.next();
                contactInfo.setState(state);

                System.out.println("Zip Code :");
                String zipcode = scanner.next();
                contactInfo.setZipcode(zipcode);

                contactList.add(contactInfo);
            } else
                System.out.println("Name already exists");
        } catch (InputMismatchException e) {
            System.out.println("Please provide correct information");
        }
        return contactList;
    }
    private void updateContact(LinkedList<ContactsDetails> contactList) {
        try {
            System.out.println("Enter the name of the person you want to update the contact of");
            String searchName = scanner.next();
            int editName = searchName(searchName, contactList);

            if (editName == -1)
                System.out.println("Name not found");
            else {
                ContactsDetails contactInfo = contactList.get(editName);
                System.out.println(contactInfo);

                System.out.println("""
                        What do you want to update\s
                        1. First Name\s
                        2. Last Name\s
                        3. Phone Number\s
                        4. email\s
                        5. City\s
                        6. State\s
                        7. Zip code\s""");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter new First Name");
                        String newFirstName = scanner.next();
                        contactInfo.setFirstname(newFirstName);
                    }
                    case 2 -> {
                        System.out.println("Enter new Last Name");
                        String newLastName = scanner.next();
                        contactInfo.setLastname(newLastName);
                    }
                    case 3 -> {
                        System.out.println("Enter new Phone Number");
                        String newPhone = scanner.next();
                        contactInfo.setPhone(newPhone);
                    }
                    case 4 -> {
                        System.out.println("Enter new Email");
                        String newEmail = scanner.next();
                        contactInfo.setEmail(newEmail);
                    }
                    case 5 -> {
                        System.out.println("Enter new City");
                        String newCity = scanner.next();
                        contactInfo.setCity(newCity);
                    }
                    case 6 -> {
                        System.out.println("Enter new State");
                        String newState = scanner.next();
                        contactInfo.setState(newState);
                    }
                    case 7 -> {
                        System.out.println("Enter new Zip code");
                        String newZipcode = scanner.next();
                        contactInfo.setZipcode(newZipcode);
                    }
                }
                System.out.println("Updated Successfully");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void deleteContact(LinkedList<ContactsDetails> contactList) {
        try {
            System.out.println("Enter the person name you want to delete the contact details of");
            String searchName = scanner.next();
            int deleteName = searchName(searchName, contactList);

            if (deleteName == -1)
                System.out.println("Name not found");
            else {
                contactList.remove(deleteName);
                System.out.println("Deleted Successfully");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}