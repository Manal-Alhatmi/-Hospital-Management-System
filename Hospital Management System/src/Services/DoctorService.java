package Services;

import Entities.*;
import Interface.Manageable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService implements Manageable {
    static ArrayList<Doctor> doctorList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static Doctor addInput() {
        String idDoctor = InputHandler.getStringInput("Enter Doctor ID: ");
        String firstName = InputHandler.getStringInput("Enter First Name: ");
        String lastName = InputHandler.getStringInput("Enter Last Name: ");
        String specialization = InputHandler.getStringInput("Enter Specialization: ");
        String qualification = InputHandler.getStringInput("Enter Qualification: ");
        int experience = InputHandler.getIntInput("Enter Years of Experience: ");
        double fee = InputHandler.getDoubleInput("Enter Consultation Fee: ");
        String phone = InputHandler.getStringInput("Enter Phone Number: ");

        return new Doctor(idDoctor, firstName, lastName, idDoctor, specialization, qualification, experience, null, fee, new ArrayList<>(), new ArrayList<>());
    }

    public static void save(Doctor doctor) {
        if (doctor != null) {
            if (doctor.getDoctorId() == null || doctor.getDoctorId().isEmpty()) {
                doctor.setDoctorId("DOC");
            }
            doctorList.add(doctor);
            System.out.println("Doctor saved successfully with ID: " + doctor.getDoctorId());
        } else {
            System.out.println("Invalid doctor data, not saved.");
        }
    }


    public static void addDoctor() {
        Doctor newDoctor = addInput();
        save(newDoctor);
    }

    public static void searchDoctor(String specialization) {
        boolean found = false;
        for (Doctor d : doctorList) {
            if (d.getSpecialization() != null && d.getSpecialization().equalsIgnoreCase(specialization)) {
                d.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No doctor found with specialization: " + specialization);
        }
    }

    public static void searchDoctor(String name, String specialization) {
        boolean found = false;
        for (Doctor d : doctorList) {
            boolean matchesName = (d.getFirstName() + " " + d.getLastName()).toLowerCase().contains(name.toLowerCase());
            boolean matchesSpec = d.getSpecialization() != null && d.getSpecialization().equalsIgnoreCase(specialization);

            if (matchesName && matchesSpec) {
                d.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No doctor found with name '" + name + "' and specialization '" + specialization + "'.");
        }
    }


    public static void removeDoctor(Doctor doctor) {
        if (doctorList.remove(doctor)) {
            System.out.println("Doctor " + doctor.getDoctorId() + " removed successfully (by object).");
        } else {
            System.out.println("Doctor not found in the list.");
        }
    }


    public static void editDoctor() {
        String id = InputHandler.getStringInput("Enter Doctor ID to edit: ");
        Doctor doctor = getDoctorById(id);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        String newName = InputHandler.getStringInput("Enter new First Name: ");
        if (!newName.isEmpty())
            doctor.setFirstName(newName);

        String newSpec = InputHandler.getStringInput("Enter new Specialization : ");
        if (!newSpec.isEmpty())
            doctor.setSpecialization(newSpec);

        String newPhone = InputHandler.getStringInput("Enter new Phone: ");
        if (!newPhone.isEmpty())
            doctor.setPhoneNumber(newPhone);

        System.out.println("Doctor updated successfully.");
    }

    public static void removeDoctor() {
        String id = InputHandler.getStringInput("Enter Doctor ID to remove: ");
        boolean found = false;

        for (int i = 0; i < doctorList.size(); i++) {
            Doctor d = doctorList.get(i);
            if (d.getDoctorId().equalsIgnoreCase(id)) {
                doctorList.remove(i);
                System.out.println("Doctor removed successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Doctor not found.");
        }
    }

    public static void displayAllDoctors() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            for (Doctor d : doctorList) {
                d.displayInfo();
            }
        }
    }

    public static Doctor getDoctorById(String id) {
        for (Doctor d : doctorList) {
            if (d.getDoctorId().equalsIgnoreCase(id)) {
                return d;
            }
        }
        return null;
    }

    public static void searchDoctorBySpecialization() {
        String spec = InputHandler.getStringInput("Enter specialization to search: ");
        searchDoctor(spec);
    }

    public static void viewAvailableDoctors() {
        System.out.println("Available Doctors:");
        boolean found = false;

        for (Doctor d : doctorList) {
            if (d.getAvailableSlots() != null && !d.getAvailableSlots().isEmpty()) {
                d.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No doctors currently available.");
        }
    }

    public static void assignPatientToDoctor() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors available to assign.");
            return;
        }

        String doctorId = InputHandler.getStringInput("Enter Doctor ID to assign patient: ");
        Doctor selectedDoctor = getDoctorById(doctorId);
        if (selectedDoctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        while (true) {
            String patientId = InputHandler.getStringInput("Enter Patient ID to assign or 'q' to quit: ");
            if (patientId.equalsIgnoreCase("q")) {
                break;
            }

            if (PatientService.checkIfPatientIdExit(patientId)) {
                selectedDoctor.assignPatient(patientId);
                System.out.println("Patient " + patientId + " assigned to Doctor " + selectedDoctor.getDoctorId());
            } else {
                System.out.println("Patient ID not found.");
            }
        }
    }


    @Override
    public void add(Object entity) {
        if (entity instanceof Doctor doctor) {
            save(doctor);
        }
    }

    @Override
    public void remove(String id) {
        Doctor doctor = getDoctorById(id);
        if (doctor != null) {
            doctorList.remove(doctor);
            System.out.println("Doctor removed (from Manageable interface).");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    @Override
    public List<Doctor> getAll() {
        return doctorList;
    }

    public static void addSampleDoctors() {
        // Surgeons (3)
        for (int i = 0; i < 3; i++) {
            Surgeon doctor = new Surgeon();
            doctor.setId(HelperUtils.generateId("PER"));
            doctor.setDoctorId("DOC00" + (i + 1));
            doctor.setFirstName("Surgeon" + (i + 1));
            doctor.setLastName("Ali");
            doctor.setGender(i % 2 == 0 ? "Male" : "Female");
            doctor.setDateOfBirth(LocalDate.of(1975 + i, (i % 12) + 1, (i % 27) + 1));
            doctor.setPhoneNumber("7911111" + i);
            doctor.setEmail("surgeon" + (i + 1) + "@hospital.com");
            doctor.setAddress("Muscat, Oman - Area " + i);
            doctor.setSpecialization(i == 0 ? "Cardiac Surgery" : i == 1 ? "Neuro Surgery" : "General Surgery");
            doctor.setQualification("MD");
            doctor.setExperienceYears(10 + i);
            doctor.setDepartmentId("DEPT" + (i + 1));
            doctor.setConsultationFee(150.0 + (i * 25));
            doctor.setSurgeriesPerformed(100 + (i * 50));
            doctor.setOperationTheatreAccess(true);
            doctorList.add(doctor);
        }

        // Consultants (3)
        for (int i = 0; i < 3; i++) {
            Consultant doctor = new Consultant();
            doctor.setId(HelperUtils.generateId("PER"));
            doctor.setDoctorId("DOC00" + (i + 4));
            doctor.setFirstName("Consultant" + (i + 1));
            doctor.setLastName("Al Hinai");
            doctor.setGender(i % 2 == 0 ? "Female" : "Male");
            doctor.setDateOfBirth(LocalDate.of(1978 + i, (i % 12) + 1, (i % 27) + 1));
            doctor.setPhoneNumber("7922222" + i);
            doctor.setEmail("consultant" + (i + 1) + "@hospital.com");
            doctor.setAddress("Sohar, Oman - Block " + i);
            doctor.setSpecialization(i == 0 ? "Cardiology" : i == 1 ? "Neurology" : "Emergency Medicine");
            doctor.setQualification("PhD");
            doctor.setExperienceYears(8 + i);
            doctor.setDepartmentId("DEPT" + (i + 1));
            doctor.setConsultationFee(120.0 + (i * 20));
            doctor.setOnlineConsultationAvailable(i % 2 == 0);
            doctor.setConsultationDuration(45);
            doctorList.add(doctor);
        }

        // General Practitioners (2)
        for (int i = 0; i < 2; i++) {
            GeneralPractitioner doctor = new GeneralPractitioner();
            doctor.setId(HelperUtils.generateId("PER"));
            doctor.setDoctorId("DOC00" + (i + 7));
            doctor.setFirstName("GP" + (i + 1));
            doctor.setLastName("Al Rawahi");
            doctor.setGender(i % 2 == 0 ? "Male" : "Female");
            doctor.setDateOfBirth(LocalDate.of(1985 + i, (i % 12) + 1, (i % 27) + 1));
            doctor.setPhoneNumber("7933333" + i);
            doctor.setEmail("gp" + (i + 1) + "@hospital.com");
            doctor.setAddress("Nizwa, Oman - Street " + i);
            doctor.setSpecialization("General Practice");
            doctor.setQualification("MBBS");
            doctor.setExperienceYears(5 + i);
            doctor.setConsultationFee(80.0 + (i * 10));
            doctor.setWalkinAvailable(true);
            doctor.setHomeVisitAvailable(i % 2 == 0);
            doctor.setVaccinationCertified(true);
            doctorList.add(doctor);
        }
        System.out.println("=== Sample Doctors Added Successfully ===");
    }
}
