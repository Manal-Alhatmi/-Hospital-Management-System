package Entities;

import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        while (!HelperUtils.isValidString(firstName, 2)) {
            System.out.println("Failed first name entry. Please enter a valid first name (at least 2 characters):");
            firstName = scanner.nextLine();
        }

        this.firstName = HelperUtils.capitalize(firstName);
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        Scanner scanner = new Scanner(System.in);

        while (!HelperUtils.isValidString(lastName, 2)) {
            System.out.println("Failed last name entry. Please enter a valid last name (at least 2 characters):");
            lastName = scanner.nextLine();
        }

        this.lastName = HelperUtils.capitalize(lastName);
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
            gender = InputHandler.getStringInput("Invalid gender. Please enter 'M' or 'F': ");
        }
        this.gender = gender;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        Scanner scanner = new Scanner(System.in);

        while (!HelperUtils.isValidString(phoneNumber, 8, 15) || !phoneNumber.matches("\\d{8,15}")) {
            System.out.println("Failed phone number entry. Please enter a valid phone number (8-15 digits):");
            phoneNumber = scanner.nextLine();
        }

        this.phoneNumber = phoneNumber;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Scanner scanner = new Scanner(System.in);
        while (!HelperUtils.isValidString(email) || !email.contains("@")) {
            System.out.println("Failed email entry. Please enter a valid email:");
            email = scanner.nextLine();
        }
        this.email = email;
    }


    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        Scanner scanner = new Scanner(System.in);

        while (!HelperUtils.isValidString(address, 3)) {
            System.out.println("Failed address entry. Please enter a valid address (at least 3 characters):");
            address = scanner.nextLine();
        }

        this.address = address;
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
