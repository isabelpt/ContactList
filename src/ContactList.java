import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class ContactList
{
    // TODO: Create your array contacts
    ArrayList<Person> contacts;
    // TODO: Write a Constructor
    public ContactList() {
        contacts = new ArrayList();
    }
    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        // TODO: Complete the addContact method
        Scanner s = new Scanner(System.in);
        System.out.println("Select a type of contact to add:");
        System.out.println("1. Student \n2. Family Member");
        int personType = s.nextInt();
        s.nextLine();
        System.out.println("Please fill in the following information:");
        System.out.println("First Name:");
        String fName = s.nextLine();
        System.out.println("Last Name:");
        String lName = s.nextLine();
        System.out.println("Phone Number:");
        String pNum = s.nextLine();
        if (personType == 1) {
            System.out.println("Grade: ");
            int grade = s.nextInt();
            s.nextLine();
            contacts.add(new Student(fName, lName, pNum, grade));
        } else if (personType == 2) {
            System.out.println("Relation: ");
            String relation = s.nextLine();
            contacts.add(new FamilyMember(fName, lName, pNum, relation));
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        // TODO: Complete the printContacts method
        for (Person p : contacts) {
            System.out.println(p);
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // TODO: Complete the sort method
            for (int pass = 1; pass < contacts.size(); pass++) {
                for (int comp = 0; comp < contacts.size() - pass; comp++) {
                    // alternatively store these statements as booleans and they that at least one of them is try and then add them
                    if (sortBy == 0 && contacts.get(comp).getFirstName().compareTo(contacts.get(comp + 1).getFirstName()) == 1)
                    {
                        //contacts.add(comp + 1, contacts.remove(comp));
                        Collections.swap(contacts, comp, comp + 1);
                    } else if (sortBy == 1 && contacts.get(comp).getLastName().compareTo(contacts.get(comp + 1).getFirstName()) == 1) {
                        //contacts.add(comp + 1, contacts.remove(comp));
                        Collections.swap(contacts, comp, comp + 1);
                    } else if (sortBy == 2 && contacts.get(comp).getPhoneNumber().compareTo(contacts.get(comp + 1).getPhoneNumber()) == 1) {
                        // If this doesn't work just use the swap method
                        //contacts.add(comp + 1, contacts.remove(comp));
                        Collections.swap(contacts, comp, comp + 1);
                    }
                }
            }
    }

    // TODO: Write searchByFirstName
    public Person searchByFirstName(String firstName) {
        // Binary search
        int min = 0;
        int max = contacts.size() - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (contacts.get(mid).getFirstName().compareTo(firstName) == 0) {
                return contacts.get(mid);
            } else if (contacts.get(mid).getFirstName().compareTo(firstName) == 1) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return null;
    }

    // TODO: Write searchByLastName
    public Person searchByLastName(String lastName) {
        int min = 0;
        int max = contacts.size() - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (contacts.get(mid).getFirstName().compareTo(lastName) == 0) {
                return contacts.get(mid);
            } else if (contacts.get(mid).getFirstName().compareTo(lastName) == 1) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return null;
    }

    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String phoneNumber) {
        int min = 0;
        int max = contacts.size() - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (contacts.get(mid).getFirstName().compareTo(phoneNumber) == 0) {
                return contacts.get(mid);
            } else if (contacts.get(mid).getFirstName().compareTo(phoneNumber) == 1) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        // TODO: Complete the listStudents method
        for (Person p : contacts) {
            if (p instanceof Student) {
                System.out.println(p);
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");

        // TODO: Complete the run method
        boolean keepGoing = true;
        while(keepGoing) {
            printMenuOptions();
            int choice = s.nextInt();
            s.nextLine();
            if (choice == 0) {
                keepGoing = false;
            } else if (choice == 1) {
                addContact();
            } else if (choice == 2) {
                sort(0);
                listStudents();
            } else if (choice == 3) {
                sort(1);
                listStudents();
            } else if (choice == 4) {
                sort(2);
                listStudents();
            } else if (choice == 5) {
                listStudents();
            } else if (choice == 6) {
                System.out.println("Enter a name:");
                String name = s.nextLine();
                Person p = searchByFirstName(name);
                if (p == null) {
                    System.out.println(name + " is not in the list.");
                } else {
                    System.out.println(p);
                }
            } else if (choice == 7) {
                System.out.println("Enter a name:");
                String name = s.nextLine();
                Person p = searchByFirstName(name);
                if (p == null) {
                    System.out.println(name + " is not in the list.");
                } else {
                    System.out.println(p);
                }
            } else if (choice == 8) {
                System.out.println("Enter a phone number:");
                String number = s.nextLine();
                Person p = searchByPhoneNumber(number);
                if (p == null) {
                    System.out.println(number + " is not in the list.");
                } else {
                    System.out.println(p);
                }
            }
        }
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
