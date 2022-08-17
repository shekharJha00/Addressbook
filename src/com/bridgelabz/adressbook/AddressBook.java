package com.bridgelabz.adressbook;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

 class AddressBook {
     
         static final Scanner scanner = new Scanner(System.in);
         static Set<String> emptyContacts = new HashSet<>();
         static Set<String> nonEmptyContacts = new HashSet<>();


         void createNewContact() throws Exception
         {
<<<<<<< HEAD
             System.out.print("Enter name of the contact:");
             String contactName = scanner.nextLine();
=======
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
<<<<<<< HEAD
=======

         void deleteContact() {

             System.out.print("enter contact name to delete:");
             String contactName = scanner.nextLine().trim();
>>>>>>> main
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
<<<<<<< HEAD
         void writeFile(String fileName,String content)throws Exception
         {
             FileWriter fw = new FileWriter(fileName);
             fw.write(content);
             fw.close();
             nonEmptyContacts.add(fileName);
             System.out.println("the given contents are successfully added in " + fileName);
         }
         void fillContactDetails()throws Exception
         {
             System.out.print("enter empty contact name which is going to be filed:");
             String contactName = scanner.nextLine();
             if (emptyContacts.contains(contactName))
             {
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
                 writeFile(contactName, details);
                 emptyContacts.remove(contactName);
             }
             else
             {
                 System.out.println(contactName + " is not empty contact or it is not created");
                 System.out.println("use other option 1 to create new contact or option 5 to edit already created one");
             }
=======
>>>>>>> uc4
    }
>>>>>>> main

         }

         void displayAllContacts()
         {
             boolean flag = false;
             if (emptyContacts.size() != 0)
             {
                 System.out.println("the empty contacts are:");
                 for (String contact : emptyContacts)
                 {
                     System.out.println(contact);
                 }
                 flag=true;
             }
             if (nonEmptyContacts.size() != 0)
             {
                 System.out.println("the non empty contacts are:");
                 for (String contact : nonEmptyContacts)
                 {
                     System.out.println(contact);
                 }
                 flag=true;
             }
             if(!flag)
             {
                 System.out.println("no contacts are created yet");
             }

         }
         void readFile(String fileName)throws Exception
         {
             FileReader fileReader = new FileReader(fileName);
             int character;
             while ((character = fileReader.read()) != -1)
             {
                 System.out.print((char) character);
             }
             fileReader.close();
         }
         void viewContactInfo()throws Exception
         {
             System.out.print("enter name of the contact to view:");
             String contactName = scanner.nextLine();
             if(emptyContacts.contains(contactName))
             {
                 System.out.println("please fill the contact "+ contactName+ " before viewing it");
                 return;
             }
             else if(!nonEmptyContacts.contains(contactName))
             {
                 System.out.println("please create the contact "+contactName+" before viewing it");
                 return;
             }
             System.out.println("the content of " + contactName + " is:");
             readFile(contactName);
         }
         void editContactInfo()throws Exception
         {
             System.out.print("enter name of the contact to edit:");
             String contactName = scanner.nextLine();
             if(emptyContacts.contains(contactName))
             {
                 System.out.println("please fill the contact "+ contactName + " before editing it");
                 return;
             }
             else if(!nonEmptyContacts.contains(contactName))
             {
                 System.out.println("please create the contact "+ contactName +" before editing it");
                 return;
             }
             System.out.println("The content of " + contactName + " at present is:");
             readFile(contactName);
             System.out.println("Enter the 7 lines of  new content to write:");
             StringBuilder newContentBuilder = new StringBuilder();
             for (int i = 1; i <= 7; i++)
             {
                 newContentBuilder.append(scanner.nextLine()).append("\n");
             }
             String newContent = newContentBuilder.toString();
             String option;
             do
             {
                 System.out.println("enter... S for SAVE     SA for SAVE AS      C for CANCEL");
                 option = scanner.nextLine().trim().toLowerCase();
             } while (!(option.equals("s") || option.equals("sa")));
             switch (option) {

                 case "s" -> {
                     writeFile(contactName, newContent);
                     System.out.println(contactName + " is saved with new content");
                 }

                 case "sa" -> {
                     String extension = ".csv";
                     String newContactName = contactName.replaceFirst("[.][^.]+$", "") + extension;
                     writeFile(newContactName, newContent);
                     nonEmptyContacts.add(newContactName);
                 }
                 case "c" -> System.out.println("changes are not saved");
                 default -> System.out.println("please select either S or C");
             }

         }
     }

<<<<<<< HEAD
     class AddressBookLauncher
     {
=======
        public static void main(String[] args) throws Exception {
            AddressBook addressBook = new AddressBook();
            while (true) {
                System.out.println("-----------------------------");
                System.out.println("1.create a new contact");
                System.out.println("2.fill contact details");
<<<<<<< HEAD
                System.out.println(".edit contact name");
                System.out.println("4.exit");
=======
                System.out.println("3.edit contact name");
                System.out.println("4.delete contact");
                System.out.println("5.exit");
>>>>>>> uc4
                System.out.print("enter option:");
                int option = scanner.nextInt();
                switch (option) {
                    case 1 -> addressBook.createNewContact();
                    case 2 -> addressBook.fillContactDetails();
                    case 3 -> addressBook.editContactName();
<<<<<<< HEAD
                    case 4 -> {
=======
                    case 4 -> addressBook.deleteContact();
                    case 5 -> {
>>>>>>> uc4
                        System.out.println("exiting....");
                        System.exit(0);
                    }
                    default -> System.out.println("please enter the correct choice");
                }
>>>>>>> main

         static final Scanner scanner = new Scanner(System.in);

         public static void main(String[] args) throws Exception
         {
             AddressBook addressBook = new AddressBook();
             while (true)
             {
                 System.out.println("-----------------------------");
                 System.out.println("1.create a new contact");
                 System.out.println("2.fill contact details");
                 System.out.println("3.display all contacts");
                 System.out.println("4.view contact information");
                 System.out.println("5.edit contact information");
                 System.out.println("6.exit");
                 System.out.print("enter option:");
                 String option = scanner.nextLine().trim();
                 switch (option) {
                     case "1" -> addressBook.createNewContact();
                     case "2" -> addressBook.fillContactDetails();
                     case "3" -> addressBook.displayAllContacts();
                     case "4" -> addressBook.viewContactInfo();
                     case "5" -> addressBook.editContactInfo();
                     case "6" -> {
                         System.out.println("exiting....");
                         System.exit(0);
                     }
                     default -> System.out.println("please enter the correct choice");
                 }

             }

         }
     }

