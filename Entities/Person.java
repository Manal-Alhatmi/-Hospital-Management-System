package Entities;

import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;

    public Person(String id, String firstName, String lastName, LocalDate dateOfBirth,
                  String gender, String phoneNumber, String email, String address) {
        this.id = HelperUtils.isNotNull(id) ? id : HelperUtils.generateId("PER");
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setAddress(address);
    }

    public Person() {
        this.id = HelperUtils.generateId("PER");
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = HelperUtils.isNotNull(id) ? id : HelperUtils.generateId("PER");
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        if (HelperUtils.isValidString(firstName, 2))
            this.firstName = HelperUtils.capitalize(firstName);
        else
            this.firstName = "Unknown";
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        if (HelperUtils.isValidString(lastName, 2))
            this.lastName = HelperUtils.capitalize(lastName);
        else
            this.lastName = "Unknown";
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        while (true) {
            if (dateOfBirth.isBefore(LocalDate.now())) {
                this.dateOfBirth = dateOfBirth;
                break;
            } else {
                System.out.println(" Invalid date of birth. Please enter a valid past date (yyyy-MM-dd):");
                dateOfBirth = InputHandler.getDateInput("Enter Date of Birth (yyyy-MM-dd): ");
            }
        }
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        while (HelperUtils.isNull(gender) || !(gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F"))) {
            gender = InputHandler.getStringInput("Invalid gender. Please enter 'Male' or 'Female': ");
        }
        this.gender = gender;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        if (HelperUtils.isValidString(phoneNumber, 8, 15))
            this.phoneNumber = phoneNumber;
        else
            this.phoneNumber = "N/A";
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (HelperUtils.isValidString(email) && email.contains("@"))
            this.email = email;
        else
            this.email = "N/A";
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        if (HelperUtils.isValidString(address, 3))
            this.address = address;
        else
            this.address = "N/A";
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("DOB: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + id + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (HelperUtils.isNull(o) || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
