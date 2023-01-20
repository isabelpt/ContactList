/**
 * A subclass of Person that represents a Student
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick & Isabel Prado-Tucker
 * @version: 2022-2023
 */

public class Student extends Person{
    // Instance variables
    private int grade;

    // Constructor
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Getter method
    public int getGrade() {
        return grade;
    }

    // Overrides Person's toString() to include grade level
    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
