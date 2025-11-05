package Services;

import Entities.*;
import Interface.Manageable;
import Utils.HelperUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SampleDataService {

    public static void populateAllSampleData() {
        System.out.println("\nPOPULATING SAMPLE DATA");

        // Clear existing data
        clearAllData();

        populateDepartments();
        populateDoctors();
        populateNurses();
        populatePatients();
        populateAppointments();
        populateMedicalRecords();

        System.out.println("\nSAMPLE DATA POPULATION COMPLETE!");
        displayDataStatistics();
    }

    private static void clearAllData() {
        DepartmentService.departmentList.clear();
        DoctorService.doctorList.clear();
        NurseService.nurseList.clear();
        PatientService.patientList.clear();
        AppointmentService.appointmentList.clear();
        MedicalRecordService.records.clear();
    }

    private static void populateDepartments() {
        System.out.println("\nCreating Departments...");

        DepartmentService.save(new Department("DEP1", "Cardiology", "DOC1", 20));
        DepartmentService.save(new Department("DEP2", "Neurology", "DOC2", 15));
        DepartmentService.save(new Department("DEP3", "Emergency", "DOC3", 10));
        DepartmentService.save(new Department("DEP4", "Pediatrics", "DOC2", 12));
        DepartmentService.save(new Department("DEP5", "Orthopedics", "DOC5", 18));

        System.out.println("Created " + DepartmentService.departmentList.size() + " departments");
    }

    private static void populateDoctors() {
        System.out.println("\nCreating Doctors...");

        // Create doctors
        DoctorService.save(new Doctor("PER-DOC1", "Ahmed", "Hassan", LocalDate.of(1975, 5, 15), "Male", "555-0101", "ahmed.hassan@hospital.com", "123 Main St, Muscat", "DOC1", "Cardiologist", "MD", 10, "Cardiology", 80.0, new ArrayList<>(), new ArrayList<>()));
        DoctorService.save(new Doctor("PER-DOC2", "Fatima", "Ali", LocalDate.of(1980, 8, 22), "Female", "555-0102", "fatima.ali@hospital.com", "456 Oak Ave, Sohar", "DOC2", "Neurologist", "PhD", 8, "Neurology", 90.0, new ArrayList<>(), new ArrayList<>()));
        DoctorService.save(new Doctor("PER-DOC3", "Khalid", "Saeed", LocalDate.of(1985, 3, 10), "Male", "555-0103", "khalid.saeed@hospital.com", "789 Pine Rd, Nizwa", "DOC3", "Emergency Physician", "MBBS", 5, "Emergency", 50.0, new ArrayList<>(), new ArrayList<>()));
        DoctorService.save(new Doctor("PER-DOC4", "Huda", "Rashid", LocalDate.of(1978, 11, 5), "Female", "555-0104", "huda.rashid@hospital.com", "321 Elm St, Ibri", "DOC4", "Cardiologist", "MD", 7, "Cardiology", 85.0, new ArrayList<>(), new ArrayList<>()));
        DoctorService.save(new Doctor("PER-DOC5", "Mohammed", "Saleh", LocalDate.of(1970, 7, 30), "Male", "555-0105", "mohammed.saleh@hospital.com", "654 Maple Dr, Muscat", "DOC5", "Orthopedic Surgeon", "MBBS", 12, "Orthopedics", 70.0, new ArrayList<>(), new ArrayList<>()));
        DoctorService.save(new Doctor("PER-DOC6", "Layla", "Hamad", LocalDate.of(1990, 2, 14), "Female", "555-0106", "layla.hamad@hospital.com", "987 Cedar Ln, Sohar", "DOC6", "General Practitioner", "MD", 4, "General", 60.0, new ArrayList<>(), new ArrayList<>()));
        DoctorService.save(new Doctor("PER-DOC7", "Yusuf", "Nasser", LocalDate.of(1965, 9, 18), "Male", "555-0107", "yusuf.nasser@hospital.com", "147 Birch St, Nizwa", "DOC7", "Cardiologist", "PhD", 15, "Cardiology", 95.0, new ArrayList<>(), new ArrayList<>()));
        DoctorService.save(new Doctor("PER-DOC8", "Amina", "Saeed", LocalDate.of(1972, 12, 8), "Female", "555-0108", "amina.saeed@hospital.com", "258 Spruce Ave, Ibri", "DOC8", "Emergency Surgeon", "MD", 9, "Emergency", 75.0, new ArrayList<>(), new ArrayList<>()));

        System.out.println("Created " + DoctorService.doctorList.size() + " doctors");
    }

    private static void populateNurses() {
        System.out.println("\nCreating Nurses...");

        NurseService.save(new Nurse("NUR1", "Aisha", "Rahman", LocalDate.of(1992, 3, 5), "Female", "987654321", "aisha@nurse.com", "Muscat", "NUR1", "DEP1", "Morning", "BSc Nursing", new ArrayList<>()));
        NurseService.save(new Nurse("NUR2", "Omar", "Sultan", LocalDate.of(1989, 9, 22), "Male", "912345678", "omar@nurse.com", "Sohar", "NUR2", "DEP2", "Evening", "BSc Nursing", new ArrayList<>()));
        NurseService.save(new Nurse("NUR3", "Maha", "Hameed", LocalDate.of(1995, 2, 18), "Female", "998877665", "maha@nurse.com", "Nizwa", "NUR3", "DEP3", "Night", "Diploma Nursing", new ArrayList<>()));
        NurseService.save(new Nurse("NUR4", "Saeed", "Hilal", LocalDate.of(1990, 11, 10), "Male", "911223344", "saeed@nurse.com", "Ibri", "NUR4", "DEP1", "Morning", "BSc Nursing", new ArrayList<>()));
        NurseService.save(new Nurse("NUR5", "Hanan", "Khalid", LocalDate.of(1994, 7, 30), "Female", "922334455", "hanan@nurse.com", "Muscat", "NUR5", "DEP2", "Evening", "BSc Nursing", new ArrayList<>()));

        System.out.println("Created " + NurseService.nurseList.size() + " nurses");
    }

    private static void populatePatients() {
        System.out.println("\nCreating Patients...");
        PatientService.save(new Patient("P001", "Salim", "Al Habsi", LocalDate.of(1990, 5, 10), "Male", "923456789", "salim@mail.com", "Muscat"));
        PatientService.save(new Patient("P002", "Maryam", "Al Rashdi", LocalDate.of(1985, 7, 22), "Female", "987654321", "maryam@mail.com", "Nizwa"));
        PatientService.save(new Patient("P003", "Omar", "Saeed", LocalDate.of(1999, 3, 12), "Male", "955667788", "omar@mail.com", "Sohar"));
        PatientService.save(new Patient("P004", "Aisha", "Hassan", LocalDate.of(1978, 1, 18), "Female", "912233445", "aisha@mail.com", "Ibri"));
        PatientService.save(new Patient("P005", "Huda", "Nasser", LocalDate.of(2001, 4, 15), "Female", "933224455", "huda@mail.com", "Muscat"));
        PatientService.save(new Patient("P006", "Saeed", "Ali", LocalDate.of(1993, 12, 8), "Male", "911009988", "saeed@mail.com", "Barka"));
        PatientService.save(new Patient("P007", "Fatma", "Saleh", LocalDate.of(1988, 6, 19), "Female", "977665544", "fatma@mail.com", "Rustaq"));
        PatientService.save(new Patient("P008", "Nasser", "Yahya", LocalDate.of(1975, 8, 2), "Male", "933221100", "nasser@mail.com", "Ibri"));
        PatientService.save(new Patient("P009", "Maha", "Khalfan", LocalDate.of(1997, 10, 23), "Female", "966554433", "maha@mail.com", "Sohar"));
        PatientService.save(new Patient("P010", "Yusuf", "Hilal", LocalDate.of(1983, 2, 9), "Male", "911223300", "yusuf@mail.com", "Muscat"));

        System.out.println("Created " + PatientService.patientList.size() + " patients");
    }

    private static void populateAppointments() {
        System.out.println("\nCreating Appointments...");

        // Clear any existing appointments
        AppointmentService.appointmentList.clear();

        // Create appointments
        createAppointmentDirect("APP001", "P001", "DOC1", LocalDate.now().plusDays(1), "09:00", "Scheduled", "General Checkup", "");
        createAppointmentDirect("APP002", "P002", "DOC2", LocalDate.now().plusDays(2), "10:30", "Scheduled", "Consultation", "");
        createAppointmentDirect("APP003", "P003", "DOC3", LocalDate.now().plusDays(3), "11:00", "Scheduled", "Emergency", "");
        createAppointmentDirect("APP004", "P004", "DOC4", LocalDate.now().plusDays(4), "09:00", "Scheduled", "Follow-up", "");
        createAppointmentDirect("APP005", "P005", "DOC5", LocalDate.now().plusDays(5), "12:00", "Scheduled", "Surgery", "");
        createAppointmentDirect("APP006", "P006", "DOC6", LocalDate.now().plusDays(6), "14:00", "Scheduled", "Checkup", "");
        createAppointmentDirect("APP007", "P007", "DOC7", LocalDate.now().plusDays(7), "11:15", "Scheduled", "Consultation", "");
        createAppointmentDirect("APP008", "P008", "DOC8", LocalDate.now().plusDays(8), "15:30", "Scheduled", "Emergency", "");
        createAppointmentDirect("APP009", "P009", "DOC2", LocalDate.now().plusDays(9), "08:30", "Scheduled", "Therapy", "");
        createAppointmentDirect("APP010", "P010", "DOC3", LocalDate.now().plusDays(10), "14:00", "Scheduled", "Checkup", "");
        createAppointmentDirect("APP011", "P001", "DOC4", LocalDate.now().plusDays(11), "10:00", "Scheduled", "Follow-up", "");
        createAppointmentDirect("APP012", "P002", "DOC5", LocalDate.now().plusDays(12), "13:00", "Scheduled", "Consultation", "");
        createAppointmentDirect("APP013", "P003", "DOC6", LocalDate.now().plusDays(13), "16:00", "Scheduled", "Checkup", "");
        createAppointmentDirect("APP014", "P004", "DOC7", LocalDate.now().plusDays(14), "09:30", "Scheduled", "Therapy", "");
        createAppointmentDirect("APP015", "P005", "DOC8", LocalDate.now().plusDays(15), "11:45", "Scheduled", "Surgery", "");

        System.out.println("Created " + AppointmentService.appointmentList.size() + " appointments");
    }

    private static void createAppointmentDirect(String appointmentId, String patientId, String doctorId,
                                                LocalDate date, String time, String status, String reason, String notes) {
        Appointment appointment = new Appointment(appointmentId, patientId, doctorId, date, time, status, reason, notes);
        AppointmentService.appointmentList.add(appointment);
    }

    private static void populateMedicalRecords() {
        System.out.println("\nCreating Medical Records...");

        // Clear existing records
        MedicalRecordService.records.clear();

        // Add medical records
        MedicalRecordService.records.add(new MedicalRecord("MR001", "P001", "DOC1", LocalDate.now().minusDays(10), "Flu", "Rest", "Normal", "Routine check"));
        MedicalRecordService.records.add(new MedicalRecord("MR002", "P002", "DOC2", LocalDate.now().minusDays(9), "Migraine", "Painkillers", "Stable", "Follow-up"));
        MedicalRecordService.records.add(new MedicalRecord("MR003", "P003", "DOC3", LocalDate.now().minusDays(8), "Fever", "Paracetamol", "Improving", "Check temp daily"));
        MedicalRecordService.records.add(new MedicalRecord("MR004", "P004", "DOC4", LocalDate.now().minusDays(7), "Hypertension", "Medication", "Stable", "Diet control"));
        MedicalRecordService.records.add(new MedicalRecord("MR005", "P005", "DOC5", LocalDate.now().minusDays(6), "Fracture", "Surgery", "Recovering", "Physical therapy"));
        MedicalRecordService.records.add(new MedicalRecord("MR006", "P006", "DOC6", LocalDate.now().minusDays(5), "Asthma", "Inhaler", "Stable", "Avoid triggers"));
        MedicalRecordService.records.add(new MedicalRecord("MR007", "P007", "DOC7", LocalDate.now().minusDays(4), "Diabetes", "Insulin", "Controlled", "Monthly check"));
        MedicalRecordService.records.add(new MedicalRecord("MR008", "P008", "DOC8", LocalDate.now().minusDays(3), "Accident", "Surgery", "Critical", "ICU"));
        MedicalRecordService.records.add(new MedicalRecord("MR009", "P009", "DOC2", LocalDate.now().minusDays(2), "Cold", "Rest", "Normal", "Follow-up"));
        MedicalRecordService.records.add(new MedicalRecord("MR010", "P010", "DOC3", LocalDate.now().minusDays(1), "Back Pain", "Massage", "Improving", "Light exercise"));
        MedicalRecordService.records.add(new MedicalRecord("MR011", "P001", "DOC4", LocalDate.now().minusDays(12), "Allergy", "Antihistamine", "Improving", "Avoid dust"));
        MedicalRecordService.records.add(new MedicalRecord("MR012", "P002", "DOC5", LocalDate.now().minusDays(15), "Surgery", "Operation", "Recovering", "Rest"));

        System.out.println("Created " + MedicalRecordService.records.size() + " medical records");
    }

    private static void displayDataStatistics() {
        System.out.println("\nDATA STATISTICS");
        System.out.println("Departments: " + DepartmentService.departmentList.size());
        System.out.println("Doctors: " + DoctorService.doctorList.size());
        System.out.println("Nurses: " + NurseService.nurseList.size());
        System.out.println("Patients: " + PatientService.patientList.size());
        System.out.println("Appointments: " + AppointmentService.appointmentList.size());
        System.out.println("Medical Records: " + MedicalRecordService.records.size());
    }

    // TEST SECTION
    public static void testAllFeatures() {
        System.out.println("\nTESTING CRUD AND OOP FEATURES");

        // Test CRUD
        System.out.println("\n1. DISPLAY ALL DOCTORS");
        DoctorService.displayAllDoctors();

        System.out.println("\n2. DISPLAY ALL DEPARTMENTS");
        DepartmentService.displayAllDepartments();

        System.out.println("\n3. DISPLAY ALL APPOINTMENTS");
        AppointmentService.displayAllAppointments();

        System.out.println("\n4. DISPLAY ALL NURSES");
        NurseService.displayAllNurses();

        System.out.println("\n5. DISPLAY ALL MEDICAL RECORDS");
        MedicalRecordService.displayAllRecords();

        System.out.println("\n6. DISPLAY ALL PATIENTS ");
        PatientService.displayAllPatients();

        // Test Overloading
        System.out.println("\n7. TESTING OVERLOADED METHODS");
        System.out.println("Creating appointments with different parameter combinations:");
        AppointmentService.createAppointment("P006", "DOC3", LocalDate.now().plusDays(16));
        AppointmentService.createAppointment("P006", "DOC3", LocalDate.now().plusDays(16), "09:45");
        System.out.println("Overloaded methods working correctly");

        // Test Interface
        System.out.println("\n8. TESTING INTERFACE IMPLEMENTATION");
        Manageable doctorManage = new DoctorService();
        List<?> doctors = doctorManage.getAll();
        System.out.println("Doctors retrieved via Manageable interface: " + doctors.size());

        // Testing Helper Utils
        System.out.println("\n9. TESTING HELPER UTILITIES");

        // Test string validation
        String testStr = "hello";
        System.out.println("isValidString('hello', 3, 10): " + HelperUtils.isValidString(testStr, 3, 10));

        // Test ID generation overloads
        System.out.println("generateId(): " + HelperUtils.generateId());
        System.out.println("generateId('PAT'): " + HelperUtils.generateId("PAT"));
        System.out.println("generateId('PAT', 6): " + HelperUtils.generateId("PAT", 6));
        System.out.println("generateId('PAT', 'SUF'): " + HelperUtils.generateId("PAT", "SUF"));

        // Test number validation
        System.out.println("isValidNumber(5, 1, 10): " + HelperUtils.isValidNumber(5, 1, 10));
        System.out.println("isValidNumber(15, 1, 10): " + HelperUtils.isValidNumber(15, 1, 10));

        // Test date validation
        System.out.println("isValidDate('2025-11-04'): " + HelperUtils.isValidDate("2025-11-04"));
        System.out.println("isFutureDate(LocalDate.now().plusDays(2)): " + HelperUtils.isFutureDate(LocalDate.now().plusDays(2)));
        System.out.println("isPastDate(LocalDate.now().minusDays(2)): " + HelperUtils.isPastDate(LocalDate.now().minusDays(2)));

        // Test capitalization
        System.out.println("capitalize('ali'): " + HelperUtils.capitalize("ali"));

        // Test age validation
        LocalDate birthDate = LocalDate.of(1990, 5, 10);
        System.out.println("isValidAge(birthDate): " + HelperUtils.isValidAge(birthDate));

        // Verify inheritance/polymorphism
        System.out.println("\n10. TESTING INHERITANCE & POLYMORPHISM");
        Person p = new Doctor();
        if (p instanceof Doctor)
            System.out.println("Polymorphism works: Doctor is a Person.");

        // Test actual polymorphism with real objects
        Person doctorPerson = DoctorService.getDoctorById("DOC1");
        Person nursePerson = NurseService.getNurseById("NUR1");

        Person patientPerson = null;
        if (!PatientService.patientList.isEmpty()) {
            patientPerson = PatientService.patientList.get(0);
        }

        System.out.println("Doctor as Person: " + (doctorPerson != null));
        System.out.println("Nurse as Person: " + (nursePerson != null));
        System.out.println("Patient as Person: " + (patientPerson != null && patientPerson instanceof Patient));

        System.out.println("\nALL TESTS COMPLETED SUCCESSFULLY");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Hospital Management System!");
        populateAllSampleData();
        testAllFeatures();
        System.out.println("\nHospital Management System is ready!");
    }
}