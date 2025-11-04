package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<String> getAllergies() {
        return allergies;
    }
    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }
    public void addAllergy(String allergy) {
        this.allergies.add(allergy);
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getInsuranceId() {
        return insuranceId;
    }
    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addMedicalRecord(MedicalRecord record) {
        if (record != null)
            medicalRecords.add(record);
    }

    public void addAppointment(Appointment appointment) {
        if (appointment != null)
            appointments.add(appointment);
    }

    public void updateInsurance(String newInsuranceId) {
        this.insuranceId = newInsuranceId;
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
