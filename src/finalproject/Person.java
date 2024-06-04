package finalproject;
import java.time.LocalDate;
import java.util.Vector;

public class Person {
    private String ssn;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;
    private Vector<String> phoneNumbers;

    public Person(String ssn, String firstName, String lastName, LocalDate dob, String address) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phoneNumbers = new Vector<>();
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Vector<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Vector<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}

