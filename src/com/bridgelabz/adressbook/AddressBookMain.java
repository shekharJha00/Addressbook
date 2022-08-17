package com.bridgelabz.adressbook;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

 public class AddressBookMain {
    ArrayList<ContactsDetails> contactDetails = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, ArrayList<ContactsDetails>> hashmap = new HashMap<>();
    static AddressBookMain addContact = new AddressBookMain();

    public static void main(String[] args) {
        addContact.createAddressBook();
    }


    public void addContactDetails() {

        ContactsDetails contactsdetails = new ContactsDetails();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Name of person:");
        contactsdetails.setFirstname(sc.next());
        System.out.println("Enter the Last Name of person:");
        contactsdetails.setLastname(sc.next());
        System.out.println("Enter the Address Name of person:");
        contactsdetails.setAddress(sc.next());
        System.out.println("Enter the City Name of person:");
        contactsdetails.setCity(sc.next());
        System.out.println("Enter the State Name of person:");
        contactsdetails.setState(sc.next());
        System.out.println("Enter the Email of person:");
        contactsdetails.setEmail(sc.next());
        System.out.println("Enter the Zip code of person:");
        contactsdetails.setZip(sc.nextInt());
        System.out.println("Enter the Phone number of person:");
        contactsdetails.setPhonenumber(sc.nextInt());

        contactDetails.add(contactsdetails);
        System.out.println("***********");
        System.out.println(contactsdetails);
    }


    public void editContactDetails() {

        System.out.println("Confirm your first name to edit details: ");
        String name = sc.next();

        for (int i = 0; i < contactDetails.size(); i++) {
            if (contactDetails.get(i).getFirstname().equals(name)) {
                System.out.println("Select form below to change: ");
                System.out.println(
                        "\n1.First Name\n2.Last Name\n3.Address\n4.city\n5.State\n6.Email\n7.Zip\n8.Phone number");
                int edit = sc.nextInt();

                switch (edit) {
                    case 1 -> {
                        System.out.println("Enter first name");
                        contactDetails.get(i).setFirstname(sc.next());
                    }
                    case 2 -> {
                        System.out.println("Enter Last name");
                        contactDetails.get(i).setLastname(sc.next());
                    }
                    case 3 -> {
                        System.out.println("Enter address");
                        contactDetails.get(i).setAddress(sc.next());
                    }
                    case 4 -> {
                        System.out.println("Enter city");
                        contactDetails.get(i).setCity(sc.next());
                    }
                    case 5 -> {
                        System.out.println("Enter state");
                        contactDetails.get(i).setState(sc.next());
                    }
                    case 6 -> {
                        System.out.println("Enter email");
                        contactDetails.get(i).setEmail(sc.next());
                    }
                    case 7 -> {
                        System.out.println("Enter Zip");
                        contactDetails.get(i).setZip(sc.nextInt());
                    }
                    case 8 -> {
                        System.out.println("Enter phone number");
                        contactDetails.get(i).setPhonenumber(sc.nextInt());
                    }
                }

                System.out.println(contactDetails);

            } else
                System.out.println("Enter valid First name");
        }

    }


    public void deleteContactDetails() {

        System.out.println("Confirm your first name to edit details: ");
        String name = sc.next();

        for (int i = 0; i < contactDetails.size(); i++) {
            if (contactDetails.get(i).getFirstname().equals(name)) {
                System.out.println("Select form below to change: ");

                contactDetails.remove(i);
            }
        }
        System.out.println(contactDetails);
    }


    public void createAddressBook() {

        while (true) {
            System.out.println("Choose what you want to do: ");
            System.out.println(
                    "1.Create new address book.\n 2.Edit existing address book.\n 3.Display all address books.\n 4.exit");
            int choose = sc.nextInt();

            if (choose == 4) {
                System.out.println("Exited");
                break;
            }

            switch (choose) {
                case 1 -> {
                    System.out.println("Enter the name of address book: ");
                    String address_name = sc.next();


                    if (hashmap.containsKey(address_name)) {
                        System.out.println("Address book name exits, enter different name");
                        break;
                    }
                    contactDetails = new ArrayList<>();
                    while (true) {
                        int choose1;
                        System.out.println("Choose what you want to do: ");
                        System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact.\n4.Exit");
                        choose1 = sc.nextInt();
                        if (choose1 == 4) {
                            System.out.println("Exited");
                            break;
                        }
                        switch (choose1) {
                            case 1 -> addContact.addContactDetails();
                            case 2 -> addContact.editContactDetails();
                            case 3 -> addContact.deleteContactDetails();
                            default -> System.out.println("Choose valid option");
                        }
                        hashmap.put(address_name, contactDetails);
                        System.out.println(hashmap);
                    }
                }
                case 2 -> {
                    System.out.println("Enter the name of address book: ");
                    String address_name_old = sc.next();


                    if (hashmap.containsKey(address_name_old)) {

                        contactDetails = new ArrayList<>();
                        contactDetails = hashmap.get(address_name_old);
                        while (true) {
                            System.out.println("Choose what you want to do: ");
                            System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact.\n4.Exit");
                            int choose2 = sc.nextInt();
                            if (choose2 == 4) {
                                System.out.println("Exited");
                                break;
                            }
                            switch (choose2) {
                                case 1 -> addContact.addContactDetails();
                                case 2 -> addContact.editContactDetails();
                                case 3 -> addContact.deleteContactDetails();
                                default -> System.out.println("Choose valid option");
                            }
                            hashmap.put(address_name_old, contactDetails);
                            System.out.println(hashmap);
                        }
                    } else {
                        System.out.println("Enter valid address book name");
                    }
                }
                case 3 -> System.out.println(hashmap);
                default -> System.out.println("Enter valid option");
            }
        }
    }        }