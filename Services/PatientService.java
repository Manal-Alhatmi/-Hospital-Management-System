package Services;

import Entities.MedicalRecord;
import Entities.Patient;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private static final List<Patient> patientList = new ArrayList<>();


    public static void addPatient() {
        System.out.println("\nRegister New Patient");

        String firstName = InputHandler.getStringInput("Enter First Name: ");
        String lastName = InputHandler.getStringInput("Enter Last Name: ");
        LocalDate dob = InputHandler.getDateInput("Enter Date of Birth : ");
        String gender = InputHandler.getStringInput("Enter Gender (M/F): ");
        String phone = InputHandler.getStringInput("Enter Phone Number: ");
        String email = InputHandler.getStringInput("Enter Email: ");
        String address = InputHandler.getStringInput("Enter Address: ");
        String bloodGroup = InputHandler.getStringInput("Enter Blood Group: ");
        String emergencyContact = InputHandler.getStringInput("Enter Emergency Contact: ");
        String insuranceId = InputHandler.getStringInput("Enter Insurance ID (or N/A): ");
        String patientId = HelperUtils.generateId("PAT");

        Patient newPatient = new Patient(
                HelperUtils.generateId("PER"),firstName, lastName, dob, gender, phone, email, address, patientId, bloodGroup, new ArrayList<>(), emergencyContact,
                LocalDate.now(), insuranceId, new ArrayList<>(), new ArrayList<>()
        );

        save(newPatient);
    }


    public static void save(Patient patient) {
        if (HelperUtils.isNotNull(patient)) {
            patientList.add(patient);
            System.out.println("Patient saved successfully with ID: " + patient.getPatientId());
        } else {
            System.out.println(" Invalid patient data");
        }
    }


    public static void editPatient() {
        System.out.println("\nUpdate Patient Information");
        String id = InputHandler.getStringInput("Enter Patient ID to edit: ");

        Patient patient = getPatientById(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("Editing patient: " + patient.getFirstName() + " " + patient.getLastName());
        String firstName = InputHandler.getStringInput("Enter New First Name : ");
        if (HelperUtils.isValidString(firstName))
            patient.setFirstName(firstName);

        String lastName = InputHandler.getStringInput("Enter New Last Name: ");
        if (HelperUtils.isValidString(lastName))
            patient.setLastName(lastName);

        String phone = InputHandler.getStringInput("Enter New Phone: ");
        if (HelperUtils.isValidString(phone))
            patient.setPhoneNumber(phone);

        String address = InputHandler.getStringInput("Enter New Address: ");
        if (HelperUtils.isValidString(address))
            patient.setAddress(address);

        System.out.println("Patient updated successfully.");
    }


    public static void removePatient() {
        System.out.println("\nRemove Patient");
        String id = InputHandler.getStringInput("Enter Patient ID to remove: ");
        Patient patient = getPatientById(id);

        if (HelperUtils.isNotNull(patient)) {
            patientList.remove(patient);
            System.out.println("Patient removed successfully.");
        } else {
            System.out.println(" Patient not found.");
        }
    }


    public static void displayAllPatients() {
        System.out.println("\n--- All Registered Patients ---");
        if (patientList.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        for (Patient p : patientList) {
            p.displayInfo();
        }
    }


    public static Patient getPatientById(String id) {
        for (Patient p : patientList) {
            if (p.getPatientId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }


    public static void searchPatientsByName() {
        System.out.println("\nSearch Patient");
        String keyword = InputHandler.getStringInput("Enter Patient Name: ").toLowerCase();

        boolean found = false;
        for (Patient p : patientList) {
            if (HelperUtils.isValidString(p.getFirstName()) && p.getFirstName().toLowerCase().contains(keyword)) {
                p.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients found with the given name.");
        }
    }


    public static void viewPatientMedicalHistory() {
        System.out.println("\n--- View Patient Medical History ---");
        String patientId = InputHandler.getStringInput("Enter Patient ID: ");
        Patient patient = getPatientById(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("Medical History for " + patient.getFirstName() + " " + patient.getLastName());
        boolean found = false;
        for (MedicalRecord record : MedicalRecordService.records) {
            if (record.getPatientId().equalsIgnoreCase(patientId)) {
                record.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println(" No medical records found for this patient.");
        }
    }


    public static boolean checkIfPatientIdExit(String id){
        for (Patient p : patientList) {
            if (p.getPatientId().equalsIgnoreCase(id))
                return true;
        } return false;
    }
}
