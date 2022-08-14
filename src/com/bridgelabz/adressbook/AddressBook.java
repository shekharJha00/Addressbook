package com.bridgelabz.adressbook;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

 class AddressBook {

    static class Addressable
    {
        static final Scanner scanner = new Scanner(System.in);
        static Set<String> emptyContacts = new HashSet<>();
        static Set<String> nonEmptyContacts = new HashSet<>();

        void createNewContact() throws Exception
        {
            System.out.print("Enter name of the contact:");
            String contactName = scanner.nextLine();
            File file = new File(contactName);
            if (file.exists())
            {
                System.out.println("contact " + file.getName() + " already exists!");
            }
            else
            {
                if (file.createNewFile())
                {
                    System.out.println("new contact " + file.getName() + " is created successfully");
                    emptyContacts.add(file.getName());
                }
                else
                {

                    System.out.println("file creation failed!");
                }
            }

        }

        void fillContactDetails() throws Exception
        {
            System.out.print("enter empty contact name which is going to be filed:");
            String contactName = scanner.nextLine();
            if (emptyContacts.contains(contactName))
            {

                FileWriter fw = new FileWriter(contactName);
                String details = "";
                System.out.print("enter first name:");
                details += scanner.nextLine() + "\n";
                System.out.print("enter last name:");
                details += scanner.nextLine() + "\n";
                System.out.print("enter address:");
                details += scanner.nextLine() + "\n";
                System.out.print("enter city:");
                details += scanner.nextLine() + "\n";
                System.out.print("enter state:");
                details += scanner.nextLine() + "\n";
                System.out.print("enter zip:");
                details += scanner.nextLine() + "\n";
                System.out.print("enter phone number:");
                details += scanner.nextLine() + "\n";
                fw.write(details);
                fw.close();
            }
            else
            {
                System.out.println(contactName + " is not empty contact or it is not created");
                System.out.println("use other option 1 to create new contact");
            }

        }

           void editContactName()
         {
            System.out.print("enter name of the contact to edit:");
            String contactName = scanner.nextLine();
            if(emptyContacts.contains(contactName))
            {
                System.out.println("please fill the contact "+ contactName + " before editing it");

            }
            else if(!nonEmptyContacts.contains(contactName))
            {
                System.out.println("please create the contact "+ contactName +" before editing it");

            }
        }
    }

    public static class AddressBookLauncher {

        static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws Exception {
            Addressable addressBook = new Addressable();
            while (true) {
                System.out.println("-----------------------------");
                System.out.println("1.create a new contact");
                System.out.println("2.fill contact details");
                System.out.println(".edit contact name");
                System.out.println("4.exit");
                System.out.print("enter option:");
                int option = scanner.nextInt();
                switch (option) {
                    case 1 -> addressBook.createNewContact();
                    case 2 -> addressBook.fillContactDetails();
                    case 3 -> addressBook.editContactName();
                    case 4 -> {
                        System.out.println("exiting....");
                        System.exit(0);
                    }
                    default -> System.out.println("please enter the correct choice");
                }

            }

        }
    }}
