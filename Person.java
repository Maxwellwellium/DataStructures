public class Person {
    private String firstName;
    private String lastName;
    public Person() {}

    // getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    // setters
    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
        System.out.println("the first name is now: " + this.firstName);
    }
    public void setLastName(String newLastName) {
        this.lastName = newLastName;
        System.out.println("the last name is now: " + this.lastName);
    }
}
