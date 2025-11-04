package Services;

import Entities.Doctor;
import Entities.Patient;
import Interface.Manageable;
import Utils.InputHandler;

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

        return new Doctor(idDoctor, firstName, lastName, idDoctor, specialization, qualification, experience, null, fee, new ArrayList<>(), new ArrayList<>()
        );
    }


    public static void save(Doctor doctor) {
        if (doctor != null) {
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
        boolean found = false;

        for (Doctor d : doctorList) {
            if (d.getSpecialization() != null && d.getSpecialization().equalsIgnoreCase(spec)) {
                d.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No doctors found with that specialization.");
        }
    }


    public static void viewAvailableDoctors() {
        System.out.println(" Available Doctors");
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
            String patientId = InputHandler.getStringInput("Enter Patient ID to assign or  'q' : ");
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

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<Doctor> getAll() {
        return doctorList;

    }
}
