package com.bridgelabz.adressbook;
import java.io.File;
import java.util.Scanner;
public class AddressBook {


    static class addressBook
    {

        static final Scanner scanner = new Scanner(System.in);


        void createNewContact() throws Exception {
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
                }
                else
                {
                    System.out.println("file creation failed!");
                }
            }

        }
    }

    public static class AddressBookLauncher {
        // class variable
        static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws Exception
        {
            addressBook addressBook = new addressBook();
            while (true)
            {
                System.out.println("-----------------------------");
                System.out.println("1.create a new contact");
                System.out.println("2.exit");
                System.out.print("enter option:");
                int option = scanner.nextInt();
                switch (option) {
                    case 1 -> addressBook.createNewContact();
                    case 2 -> {
                        System.out.println("exiting....");
                        System.exit(0);
                    }
                    default -> System.out.println("please enter the correct choice");
                }

            }

        }
    }
}
