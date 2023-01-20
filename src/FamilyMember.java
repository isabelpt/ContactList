/**
 * A subclass of Person that represents a Family Member
 *
 * Created for Menlo School CS2
 *
 * @author: Isabel Prado-Tucker
 * @version: 2022-2023
 */
public class FamilyMember extends Person {
    // Instance variables
    private String relation;

    // Constructor
    public FamilyMember(String firstName, String lastName, String phoneNumber, String relation) {
        super(firstName, lastName, phoneNumber);
        this.relation = relation;
    }

    // Getter method
    public String getRelation() {
        return relation;
    }

    // Override Person's toString() to add relation
    @Override
    public String toString() {
        return super.toString() + " Relation: " + relation;
    }
}
