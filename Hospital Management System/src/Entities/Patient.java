package Entities;

import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Patient extends Person {
    private String patientId;
    private String bloodGroup;
    private List<String> allergies;
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List<MedicalRecord> medicalRecords;
    private List<Appointment> appointments;

    public Patient(String id, String firstName, String lastName, LocalDate dateOfBirth,
                   String gender, String phoneNumber, String email, String address,
                   String patientId, String bloodGroup, List<String> allergies,
                   String emergencyContact, LocalDate registrationDate, String insuranceId,
                   List<MedicalRecord> medicalRecords, List<Appointment> appointments) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.allergies = (allergies != null) ? allergies : new ArrayList<>();
        this.emergencyContact = emergencyContact;
        this.registrationDate = (registrationDate != null) ? registrationDate : LocalDate.now();
        this.insuranceId = insuranceId;
        this.medicalRecords = (medicalRecords != null) ? medicalRecords : new ArrayList<>();
        this.appointments = (appointments != null) ? appointments : new ArrayList<>();
    }


    public Patient(String id, String firstName, String lastName, LocalDate dob,
                   String phoneNumber, String email, String address, String patientId) {
        this(id, firstName, lastName, dob, null, phoneNumber, email, address,
                patientId, null, null, null, LocalDate.now(), null, null, null);
    }

    public Patient(String id, String firstName, String lastName, LocalDate dob,
                   String gender, String phone, String email, String address,
                   String patientId, String bloodGroup, String emergencyContact, String insuranceId) {
        this(id, firstName, lastName, dob, gender, phone, email, address,
                patientId, bloodGroup, new ArrayList<>(), emergencyContact,
                LocalDate.now(), insuranceId, new ArrayList<>(), new ArrayList<>());
    }

    public Patient(String patientId, String firstName, String lastName) {
        this(patientId, firstName, lastName, LocalDate.now(), null, null, null, null,
                patientId, null, null, null);
    }

    public Patient(String p001, String salim, String alHabsi, LocalDate of, String male, String number, String mail, String muscat, String regular) {
    }

    public Patient() {

    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (!HelperUtils.isValidString(patientId)) {
            this.patientId = HelperUtils.generateId("PAT");
        } else {
            this.patientId = patientId.trim();
        }
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        List<String> validGroups = List.of("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
        while (bloodGroup == null || !validGroups.contains(bloodGroup.toUpperCase())) {
            System.out.println("Invalid blood group. Please enter a valid type (A+, A-, B+, B-, AB+, AB-, O+, O-):");
            bloodGroup = InputHandler.getStringInput("Enter Blood Group: ");
        }
        this.bloodGroup = bloodGroup;
    }


    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = HelperUtils.isNotNull(allergies) ? allergies : new ArrayList<>();
    }

    public void addAllergy(String allergy) {
        if (HelperUtils.isValidString(allergy)) {
            if (this.allergies == null) this.allergies = new ArrayList<>();
            this.allergies.add(allergy.trim());
        }
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }
    public void setEmergencyContact(String emergencyContact) {
        Scanner scanner = new Scanner(System.in);

        while (!HelperUtils.isValidString(emergencyContact, 8, 15) || !emergencyContact.matches("\\d{8,15}")) {
            System.out.println("Failed emergency contact entry. Please enter a valid number (8-15 digits):");
            emergencyContact = scanner.nextLine();
        }

        this.emergencyContact = emergencyContact.trim();
    }


    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = HelperUtils.isNotNull(registrationDate) ? registrationDate : LocalDate.now();
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        if (HelperUtils.isValidString(insuranceId, 3, 15)) {
            this.insuranceId = insuranceId.trim().toUpperCase();
        } else {
            this.insuranceId = "N/A";
        }
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addMedicalRecord(MedicalRecord record) {
        if (HelperUtils.isNotNull(record)) {
            this.medicalRecords.add(record);
        }
    }

    public void addAppointment(Appointment appointment) {
        if (HelperUtils.isNotNull(appointment)) {
            this.appointments.add(appointment);
        }
    }

    public void updateInsurance(String newInsuranceId) {
        setInsuranceId(newInsuranceId);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Patient ID: " + patientId);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Emergency Contact: " + emergencyContact);
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Insurance ID: " + insuranceId);
        System.out.println("Allergies: " + allergies);
        System.out.println("Medical Records Count: " + medicalRecords.size());
        System.out.println("Appointments Count: " + appointments.size());
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " (Patient ID: " + patientId + ")";
    }
}
