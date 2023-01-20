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
 * @author: Ms. Namasivayam & Mr. Blick & Isabel Prado-Tucker
 * @version: 2022-2023
 */

public class ContactList
{
    // Instance variables
    ArrayList<Person> contacts;

    // Constructor
    public ContactList() {
        contacts = new ArrayList();
    }

    // Print menu options
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
        Scanner s = new Scanner(System.in);
        // Ask user if adding a student or a family member (both subclasses of Person)
        System.out.println("Select a type of contact to add:");
        System.out.println("1. Student \n2. Family Member");
        int personType = s.nextInt();
        s.nextLine();
        // Get first name, last name, and phone number
        System.out.println("Please fill in the following information:");
        System.out.println("First Name:");
        String fName = s.nextLine();
        System.out.println("Last Name:");
        String lName = s.nextLine();
        System.out.println("Phone Number:");
        String pNum = s.nextLine();
        // Ask for grade if adding a student, or relation if adding a family member
        if (personType == 1) {
            System.out.println("Grade: ");
            int grade = s.nextInt();
            s.nextLine();
            // Once have all parameter, add new Student to contacts arraylist
            contacts.add(new Student(fName, lName, pNum, grade));
        } else if (personType == 2) {
            System.out.println("Relation: ");
            String relation = s.nextLine();
            // Once have all parameter, add new Family Member to contacts arraylist
            contacts.add(new FamilyMember(fName, lName, pNum, relation));
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        // For each Person in contacts, print toString()
        for (Person p : contacts) {
            // Calls the subclasses (either student or family member) toString()
            System.out.println(p);
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // Outer for-loop runs size times through the array
        for (int pass = 1; pass < contacts.size(); pass++) {
            // Inner for-loop determines number of checks that bubble sort makes each pass through the array
            for (int comp = 0; comp < contacts.size() - pass; comp++) {
                // Check that it is sorting by the right parameter and see if objects need to swap locations
                if (sortBy == 0 && contacts.get(comp).getFirstName().compareTo(contacts.get(comp + 1).getFirstName()) > 0)
                {
                    // Swap location of the two people
                    Collections.swap(contacts, comp, comp + 1);
                } else if (sortBy == 1 && contacts.get(comp).getLastName().compareTo(contacts.get(comp + 1).getLastName()) > 0) {
                    Collections.swap(contacts, comp, comp + 1);
                } else if (sortBy == 2 && contacts.get(comp).getPhoneNumber().compareTo(contacts.get(comp + 1).getPhoneNumber()) > 0) {
                    Collections.swap(contacts, comp, comp + 1);
                }
                }
            }
    }

    /**
     * Implements binary search algorithm to find Person [Student/Family Member]
     * with a certain first name
     * @param firstName
     * @return Person
     */
    public Person searchByFirstName(String firstName) {
        // Binary search
        int min = 0;
        int max = contacts.size() - 1;
        // While still objects in array to look at
        while (min <= max) {
            // Find the middle of array segment
            int mid = min + (max - min) / 2;
            // If the person at index mid has the correct last name, return that person
            if (contacts.get(mid).getFirstName().compareTo(firstName) == 0) {
                return contacts.get(mid);
            // If the last name of the person at index mid is later in the alphabet than the
            // inputted last name, set new min to look to the right of mid
            } else if (contacts.get(mid).getFirstName().compareTo(firstName) > 0) {
                min = mid + 1;
            // Set new max to look to the left of mid if the person's last name is earlier in alphabet
            } else {
                max = mid - 1;
            }
        }
        return null;
    }

    /**
     * Implements binary search algorithm to find Person [Student/Family Member]
     * with a certain last name
     * @param lastName
     * @return Person
     */
    public Person searchByLastName(String lastName) {
        int min = 0;
        int max = contacts.size() - 1;
        // While still objects in array to look at
        while (min <= max) {
            // Find the middle of array segment
            int mid = min + (max - min) / 2;
            // If the person at index mid has the correct last name, return that person
            if (contacts.get(mid).getLastName().compareTo(lastName) == 0) {
                return contacts.get(mid);
            // If the last name of the person at index mid is later in the alphabet than the
            // inputted last name, set new min to look to the right of mid
            } else if (contacts.get(mid).getLastName().compareTo(lastName) == 1) {
                min = mid + 1;
            // Set new max to look to the left of mid if the person's last name is earlier in alphabet
            } else {
                max = mid - 1;
            }
        }
        return null;
    }

    /**
     * Implements binary search algorithm to find Person [Student/Family Member]
     * with a certain phone number
     * @param phoneNumber
     * @return Person
     */
    public Person searchByPhoneNumber(String phoneNumber) {
        int min = 0;
        int max = contacts.size() - 1;
        // While still objects in array to look at
        while (min <= max) {
            // Find the middle of array segment
            int mid = min + (max - min) / 2;
            // If the person at index mid has the correct last name, return that person
            if (contacts.get(mid).getPhoneNumber().compareTo(phoneNumber) == 0) {
                return contacts.get(mid);
            // If the last name of the person at index mid is later in the alphabet than the
            // inputted last name, set new min to look to the right of mid
            } else if (contacts.get(mid).getPhoneNumber().compareTo(phoneNumber) == 1) {
                min = mid + 1;
            // Set new max to look to the left of mid if the person's last name is earlier in alphabet
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
        // For each person in contacts
        for (Person p : contacts) {
            // Check if person is a student
            if (p instanceof Student) {
                // Print student object's toString() method
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
        printMenuOptions();

        boolean keepGoing = true;
        // While the user wants to continue
        while(keepGoing) {
            // Get menu selection from user
            int choice = s.nextInt();
            s.nextLine();
            // Exit
            if (choice == 0) {
                keepGoing = false;
            // Add new contact
            } else if (choice == 1) {
                addContact();
            // Sort by first name and print list of contacts
            } else if (choice == 2) {
                sort(0);
                printContacts();
            // Sort by last name and print list of contacts
            } else if (choice == 3) {
                sort(1);
                printContacts();
            // Sort by phone number and print list of contacts
            } else if (choice == 4) {
                sort(2);
                printContacts();
            // List all students
            } else if (choice == 5) {
                listStudents();
            // Find person with specific first name
            } else if (choice == 6) {
                System.out.println("Enter a name:");
                String name = s.nextLine();
                Person p = searchByFirstName(name);
                // Check if person not found
                if (p == null) {
                    System.out.println(name + " is not in the list.");
                } else {
                    System.out.println(p);
                }
            // Find person with specific last name
            } else if (choice == 7) {
                System.out.println("Enter a name:");
                String name = s.nextLine();
                Person p = searchByLastName(name);
                // Check if person not found
                if (p == null) {
                    System.out.println(name + " is not in the list.");
                } else {
                    System.out.println(p);
                }
            // Find person with specific phone number
            } else if (choice == 8) {
                System.out.println("Enter a phone number:");
                String number = s.nextLine();
                Person p = searchByPhoneNumber(number);
                // Check if person not found
                if (p == null) {
                    System.out.println(number + " is not in the list.");
                } else {
                    System.out.println(p);
                }
            }
            System.out.println("Next move:");
        }
    }

    /**
     * Run contact list
     * @param args
     */
    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
