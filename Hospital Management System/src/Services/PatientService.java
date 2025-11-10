package Services;

import Entities.*;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    static final List<Patient> patientList = new ArrayList<>();

    public static void addPatient() {
        System.out.println("\nRegister New Patient");
        Patient newPatient = new Patient();
        newPatient.setFirstName(InputHandler.getStringInput("Enter First Name: "));
        newPatient.setLastName(InputHandler.getStringInput("Enter Last Name: "));
        newPatient.setDateOfBirth(InputHandler.getDateInput("Enter Date of Birth : "));
        newPatient.setGender(InputHandler.getStringInput("Enter Gender (M/F): "));
        newPatient.setPhoneNumber(InputHandler.getStringInput("Enter Phone Number: "));
        newPatient.setEmail(InputHandler.getStringInput("Enter Email: "));
        newPatient.setAddress( InputHandler.getStringInput("Enter Address: "));
        newPatient.setBloodGroup(InputHandler.getStringInput("Enter Blood Group: "));
        newPatient.setEmergencyContact(InputHandler.getStringInput("Enter Emergency Contact: "));
        newPatient.setInsuranceId(InputHandler.getStringInput("Enter Insurance ID (or N/A): "));
        newPatient.setPatientId(HelperUtils.generateId("PAT"));
        save(newPatient);
    }

    public static void save(Patient patient) {
        if (patient == null) {
            System.out.println("Invalid patient data. Patient not saved.");
            return;
        }
        if (patient.getPatientId() == null || patient.getPatientId().isEmpty()) {
            patient.setPatientId(HelperUtils.generateId("PAT"));
        }

        patientList.add(patient);
        System.out.println("Patient saved successfully with ID: " + patient.getPatientId());
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
        System.out.println("\n All Registered Patients");
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
        System.out.println("\n Displaying First " + limit + " Patients");
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

    public static void addSamplePatients() {
        // Regular Patients (3)
        for (int i = 0; i < 3; i++) {
            Patient patient = new Patient();
            patient.setId("PER-PAT" + (i + 1));
            patient.setPatientId("PAT00" + (i + 1));
            patient.setFirstName("Regular" + i);
            patient.setLastName("Al Mahrouqi");
            patient.setGender(i % 2 == 0 ? "Male" : "Female");
            patient.setDateOfBirth(LocalDate.of(1990 + i, (i % 12) + 1, (i % 27) + 1));
            patient.setPhoneNumber("9000000" + i);
            patient.setEmail("regular" + i + "@example.com");
            patient.setAddress("Muscat, Oman - Block " + i);
            patient.setBloodGroup(i % 2 == 0 ? "O+" : "A+");
            patient.setAllergies(List.of(i % 2 == 0 ? "None" : "Dust"));
            patient.setEmergencyContact("9333000" + i);
            patient.setRegistrationDate(LocalDate.now().minusDays(i));
            patient.setInsuranceId("INS-R" + i);
            patientList.add(patient);
        }

        // InPatients (3)
        for (int i = 0; i < 3; i++) {
            InPatient patient = new InPatient();
            patient.setId("PER-INP" + (i + 1));
            patient.setPatientId("INP00" + (i + 1));
            patient.setFirstName("InPatient" + i);
            patient.setLastName("Al Hinai");
            patient.setGender(i % 2 == 0 ? "Male" : "Female");
            patient.setDateOfBirth(LocalDate.of(1985 + i, (i % 12) + 1, (i % 27) + 1));
            patient.setPhoneNumber("9111111" + i);
            patient.setEmail("inpatient" + i + "@example.com");
            patient.setAddress("Sohar, Oman - Building " + i);
            patient.setBloodGroup(i % 2 == 0 ? "B+" : "AB+");
            patient.setAllergies(List.of("None"));
            patient.setEmergencyContact("9444000" + i);
            patient.setRegistrationDate(LocalDate.now().minusDays(i + 1));
            patient.setInsuranceId("INS-I" + i);
            patient.setRoomNumber("R" + (100 + i));
            patient.setBedNumber("B" + (i + 1));
            patient.setAdmissionDate(LocalDate.now().minusDays(i));
            patient.setDischargeDate(LocalDate.now().plusDays(2));
            patient.setAdmittingDoctorId("DOC00" + ((i % 8) + 1));
            patient.setDailyCharges(200.0 + (i * 50.0));
            patientList.add(patient);
        }

        // OutPatients (2)
        for (int i = 0; i < 2; i++) {
            OutPatient patient = new OutPatient();
            patient.setId("PER-OUT" + (i + 1));
            patient.setPatientId("OUT00" + (i + 1));
            patient.setFirstName("OutPatient" + i);
            patient.setLastName("Al Balushi");
            patient.setGender(i % 2 == 0 ? "Female" : "Male");
            patient.setDateOfBirth(LocalDate.of(1995 + i, (i % 12) + 1, (i % 27) + 1));
            patient.setPhoneNumber("9222222" + i);
            patient.setEmail("outpatient" + i + "@example.com");
            patient.setAddress("Nizwa, Oman - Street " + i);
            patient.setBloodGroup(i % 2 == 0 ? "A+" : "O+");
            patient.setAllergies(List.of("Pollen"));
            patient.setEmergencyContact("9555000" + i);
            patient.setRegistrationDate(LocalDate.now().minusDays(i + 2));
            patient.setInsuranceId("INS-O" + i);
            patient.setLastVisitDate(LocalDate.now().minusDays(i));
            patient.setVisitCount(i + 1);
            patientList.add(patient);
        }

        // Emergency Patients (2)
        for (int i = 0; i < 2; i++) {
            EmergencyPatient patient = new EmergencyPatient();
            patient.setId("PER-EMP" + (i + 1));
            patient.setPatientId("EMP00" + (i + 1));
            patient.setFirstName("EmergencyPatient" + i);
            patient.setLastName("Al Maskari");
            patient.setGender(i % 2 == 0 ? "Male" : "Female");
            patient.setDateOfBirth(LocalDate.of(1992 + i, (i % 12) + 1, (i % 27) + 1));
            patient.setPhoneNumber("9333333" + i);
            patient.setEmail("emergency" + i + "@example.com");
            patient.setAddress("Salalah, Oman - Block " + i);
            patient.setBloodGroup(i % 2 == 0 ? "B-" : "A-");
            patient.setAllergies(List.of("None"));
            patient.setEmergencyContact("9666000" + i);
            patient.setRegistrationDate(LocalDate.now().minusDays(i + 3));
            patient.setInsuranceId("INS-E" + i);
            patient.setAdmissionDate(LocalDate.now());
            patient.setDischargeDate(LocalDate.now().plusDays(1));
            patient.setRoomNumber("ER-" + (200 + i));
            patient.setBedNumber("E" + (i + 1));
            patient.setAdmittingDoctorId("DOC00" + ((i % 8) + 1));
            patient.setDailyCharges(350.0 + (i * 75.0));
            patient.setAdmittedViaER(true);
            patient.setEmergencyType(i % 2 == 0 ? "Accident" : "Heart Attack");
            patient.setArrivalMode(i % 2 == 0 ? "Ambulance" : "Walk-in");
            patient.setTriageLevel((i % 3) + 1);
            patientList.add(patient);
        }
        System.out.println("=== Sample Patients Added Successfully ===");
    }
}
