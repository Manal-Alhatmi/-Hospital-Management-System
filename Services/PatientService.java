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
                HelperUtils.generateId("PER"),
                firstName, lastName, dob, gender, phone, email, address,
                patientId, bloodGroup, new ArrayList<>(), emergencyContact,
                LocalDate.now(), insuranceId, new ArrayList<>(), new ArrayList<>()
        );

        save(newPatient);
    }

    public static void save(Patient patient) {
        if (HelperUtils.isNotNull(patient)) {
            patientList.add(patient);
            System.out.println("Patient saved successfully with ID: " + patient.getPatientId());
        } else {
            System.out.println("Invalid patient data");
        }
    }

    public static void addPatient(String firstName, String lastName, String phone) {
        String patientId = HelperUtils.generateId("PAT");
        Patient newPatient = new Patient(
                HelperUtils.generateId("PER"),
                firstName, lastName, LocalDate.now(), "N/A", phone,
                "N/A", "N/A", patientId, "N/A",
                new ArrayList<>(), "N/A", LocalDate.now(), "N/A",
                new ArrayList<>(), new ArrayList<>()
        );
        patientList.add(newPatient);
        System.out.println("Patient added with minimal info (ID: " + patientId + ")");
    }

    public static void addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) {
        String patientId = HelperUtils.generateId("PAT");
        Patient newPatient = new Patient(
                HelperUtils.generateId("PER"),
                firstName, lastName, LocalDate.now(), "N/A", phone, email,
                "N/A", patientId, bloodGroup, new ArrayList<>(), "N/A",
                LocalDate.now(), "N/A", new ArrayList<>(), new ArrayList<>()
        );
        patientList.add(newPatient);
        System.out.println("Patient added with blood group and email (ID: " + patientId + ")");
    }

    public static void addPatient(Patient patient) {
        if (HelperUtils.isNotNull(patient)) {
            patientList.add(patient);
            System.out.println("Full patient object added successfully (ID: " + patient.getPatientId() + ")");
        } else {
            System.out.println("Invalid patient object.");
        }
    }

    public static void searchPatients(String keyword) {
        boolean found = false;
        String lowerKeyword = keyword.toLowerCase();
        for (Patient p : patientList) {
            if ((p.getFirstName() != null && p.getFirstName().toLowerCase().contains(lowerKeyword))
                    || (p.getLastName() != null && p.getLastName().toLowerCase().contains(lowerKeyword))
                    || (p.getPhoneNumber() != null && p.getPhoneNumber().toLowerCase().contains(lowerKeyword))
                    || (p.getEmail() != null && p.getEmail().toLowerCase().contains(lowerKeyword))
                    || (p.getBloodGroup() != null && p.getBloodGroup().toLowerCase().contains(lowerKeyword))) {
                p.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No patients found matching keyword: " + keyword);
    }

    public static void searchPatients(String firstName, String lastName) {
        boolean found = false;
        for (Patient p : patientList) {
            if (p.getFirstName().equalsIgnoreCase(firstName) && p.getLastName().equalsIgnoreCase(lastName)) {
                p.displayInfo();
                found = true;
            }
        }
        if (!found)
            System.out.println("No patients found with name: " + firstName + " " + lastName);
    }

    public static void displayPatients() {
        if (patientList.isEmpty()) {
            System.out.println("No patients available to display.");
            return;
        }
        System.out.println("\n--- All Registered Patients ---");
        for (Patient p : patientList) {
            p.displayInfo();
        }
    }

    public static void displayPatients(String filter) {
        boolean found = false;
        for (Patient p : patientList) {
            if ((p.getBloodGroup() != null && p.getBloodGroup().equalsIgnoreCase(filter))
                    || (p.getGender() != null && p.getGender().equalsIgnoreCase(filter))) {
                p.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No patients found matching filter: " + filter);
    }

    public static void displayPatients(int limit) {
        System.out.println("\n--- Displaying First " + limit + " Patients ---");
        if (patientList.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        for (int i = 0; i < Math.min(limit, patientList.size()); i++) {
            patientList.get(i).displayInfo();
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
            System.out.println("Patient not found.");
        }
    }

    public static void displayAllPatients() {
        System.out.println("\nAll Registered Patients");
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
        System.out.println("\nView Patient Medical History");
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
            System.out.println("No medical records found for this patient.");
        }
    }

    public static boolean checkIfPatientIdExit(String id) {
        for (Patient p : patientList) {
            if (p.getPatientId().equalsIgnoreCase(id))
                return true;
        }
        return false;
    }
}
