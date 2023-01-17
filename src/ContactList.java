import java.util.ArrayList;
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
//        if (sortBy == 0) {
//
//        } else if (sortBy == 1) {
//
//        } else {
//            for (int pass = 1; pass < contacts.size(); pass++) {
//                for (int comp = 0; comp < contacts.size() - pass; comp++) {
//                    if (contacts.get(comp).getPhoneNumber().compareTo(contacts.get(comp + 1).getPhoneNumber()) == 1) {
//                        contacts.add(comp + 1, contacts.remove(comp));
//                    }
//                }
//            }
//        }
            for (int pass = 1; pass < contacts.size(); pass++) {
                for (int comp = 0; comp < contacts.size() - pass; comp++) {
                    if (contacts.get(comp).getPhoneNumber().compareTo(contacts.get(comp + 1).getPhoneNumber()) == 1) {
                        contacts.add(comp + 1, contacts.remove(comp));
                    }
                }
            }
        }
    }

    // TODO: Write searchByFirstName
    public Person searchByFirstName(String firstName) {

    }

    // TODO: Write searchByLastName
    public Person searchByLastName(String lastName) {

    }

    // TODO: Write searchByPhoneNumber
    public Person searchByPhoneNumber(String phoneNumber) {

    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        // TODO: Complete the listStudents method
        for (Person p : contacts) {
            if (p instanceof  Student) {
                System.out.println(p);
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();

        // TODO: Complete the run method
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
