import java.util.ArrayList;
import java.util.Scanner;

class Contact
{
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email)
    {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}


class ContactManager
{
    ArrayList<Contact> contacts = new ArrayList<>();


    public void addContact(String name, String phone, String email)
    {
        Contact contact = new Contact(name, phone, email);

        contacts.add(contact);

        System.out.println("Contact added successfully!");
    }


    public void viewContacts()
    {
        if(contacts.isEmpty())
        {
            System.out.println("No contacts found.");
        }
        else
        {
            System.out.println("\n========== Contact List ==========");

            for(Contact contact : contacts)
            {
                System.out.println("Name  : " + contact.name);
                System.out.println("Phone : " + contact.phone);
                System.out.println("Email : " + contact.email);
                System.out.println("----------------------------------");
            }
        }
    }


    public void updateContact(String name, String newPhone, String newEmail)
    {
        for(Contact contact : contacts)
        {
            if(contact.name.equalsIgnoreCase(name))
            {
                contact.phone = newPhone;
                contact.email = newEmail;

                System.out.println("Contact updated successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }


    public void deleteContact(String name)
    {
        for(Contact contact : contacts)
        {
            if(contact.name.equalsIgnoreCase(name))
            {
                contacts.remove(contact);

                System.out.println("Contact deleted successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }
}


public class ContactManagementSystem
{
    public static void main(String[] args)
    {
        try (Scanner scanner = new Scanner(System.in)) {
            ContactManager manager = new ContactManager();
            
            int choice;
            
            do
            {
                System.out.println("\n======= Contact Management System =======");
                System.out.println("1. Add Contact");
                System.out.println("2. View Contacts");
                System.out.println("3. Update Contact");
                System.out.println("4. Delete Contact");
                System.out.println("5. Exit");
                
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                
                scanner.nextLine();
                
                
                switch(choice)
                {
                    case 1 -> {
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        
                        System.out.print("Enter phone number: ");
                        String phone = scanner.nextLine();
                        
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();
                        
                        manager.addContact(name, phone, email);
                    }
                        
                        
                    case 2 -> manager.viewContacts();
                        
                        
                    case 3 -> {
                        System.out.print("Enter name to update: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter new phone number: ");
                        String newPhone = scanner.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine();
                        manager.updateContact(name, newPhone, newEmail);
                    }
                        
                        
                    case 4 -> {
                        System.out.print("Enter name to delete: ");
                        String name = scanner.nextLine();
                        manager.deleteContact(name);
                    }
                        
                        
                    case 5 -> System.out.println("Thank you for using Contact Management System.");
                        
                        
                    default -> System.out.println("Invalid choice!");
                }
                
            }
            while(choice != 5);
        }
    }
}