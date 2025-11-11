package Services;

import Entities.Nurse;
import Entities.Patient;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NurseService {
    static List<Nurse> nurseList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static Nurse addInput() {
        String id = InputHandler.getStringInput("Enter Person ID: ");
        String firstName = InputHandler.getStringInput("Enter First Name: ");
        String lastName = InputHandler.getStringInput("Enter Last Name: ");
        String gender = InputHandler.getStringInput("Enter Gender: ");
        String phone = InputHandler.getStringInput("Enter Phone Number: ");
        String email = InputHandler.getStringInput("Enter Email: ");
        String address = InputHandler.getStringInput("Enter Address: ");
        String departmentId = InputHandler.getStringInput("Enter Department ID: ");
        String shift = InputHandler.getStringInput("Enter Shift (Morning/Evening/Night): ");
        String qualification = InputHandler.getStringInput("Enter Qualification: ");
        String nurseId =HelperUtils.generateId("NUR");

        return new Nurse(id, firstName, lastName, null, gender, phone, email, address,
                nurseId, departmentId, shift, qualification, new ArrayList<>());
    }

    public static void save(Nurse nurse) {
        if (nurse != null) {
            nurseList.add(nurse);
            System.out.println("Nurse saved successfully with ID: " + nurse.getNurseId());
        } else {
            System.out.println("Invalid nurse data, not saved.");
        }
    }

    public static void addNurse() {
        Nurse newNurse = addInput();
        save(newNurse);
    }


    public static void displayAllNurses() {
        if (nurseList.isEmpty()) {
            System.out.println("No nurses found.");
        } else {
            for (Nurse n : nurseList) {
                n.displayInfo();
            }
        }
    }

    public static Nurse getNurseById(String id) {
        for (Nurse n : nurseList) {
            if (n.getNurseId().equalsIgnoreCase(id))
                return n;
        }
        return null;
    }

    public static void viewNursesByDepartment() {
        String deptId = InputHandler.getStringInput("Enter Department ID: ");
        boolean found = false;
        for (Nurse n : nurseList) {
            if (n.getDepartmentId().equalsIgnoreCase(deptId)) {
                n.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No nurses found in department: " + deptId);
    }

    public static void viewNursesByShift() {
        String shift = InputHandler.getStringInput("Enter Shift (Morning/Evening/Night): ");
        boolean found = false;
        for (Nurse n : nurseList) {
            if (n.getShift().equalsIgnoreCase(shift)) {
                n.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No nurses found in " + shift + " shift.");
    }


    public static void editInput(Nurse nurse) {
        System.out.println("Editing Nurse: " + nurse.getFirstName() + " " + nurse.getLastName());

        String firstName = InputHandler.getStringInput("Enter new First Name"+ nurse.getFirstName());
        if (!firstName.isEmpty())
            nurse.setFirstName(firstName);

        String lastName = InputHandler.getStringInput("Enter new Last Name"+ nurse.getLastName());
        if (!lastName.isEmpty())
            nurse.setLastName(lastName);

        String phone = InputHandler.getStringInput("Enter new Phone"+ nurse.getPhoneNumber());
        if (!phone.isEmpty())
            nurse.setPhoneNumber(phone);

        String departmentId = InputHandler.getStringInput("Enter new Department ID" + nurse.getDepartmentId());
        if (!departmentId.isEmpty())
            nurse.setDepartmentId(departmentId);

        String shift = InputHandler.getStringInput("Enter new Shift"+ nurse.getShift());
        if (!shift.isEmpty())
            nurse.setShift(shift);

        String qualification = InputHandler.getStringInput("Enter new Qualification"+ nurse.getQualification());
        if (!qualification.isEmpty())
            nurse.setQualification(qualification);
    }

    public static void editNurse() {
        String id = InputHandler.getStringInput("Enter Nurse ID to edit: ");
        Nurse nurse = getNurseById(id);
        if (nurse != null) {
            editInput(nurse);
            System.out.println("Nurse updated successfully.");
        } else {
            System.out.println("Nurse not found.");
        }
    }


    public static void removeNurse() {
        String id = InputHandler.getStringInput("Enter Nurse ID to remove: ");
        Nurse nurse = getNurseById(id);
        if (nurse != null) {
            nurseList.remove(nurse);
            System.out.println("Nurse removed successfully.");
        } else {
            System.out.println("Nurse not found.");
        }
    }


    public static void assignNurseToPatient() {
        String nurseId = InputHandler.getStringInput("Enter Nurse ID: ");
        Nurse nurse = getNurseById(nurseId);
        if (nurse == null) {
            System.out.println("Nurse not found.");
            return;
        }

        String patientId = InputHandler.getStringInput("Enter Patient ID to assign: ");
        nurse.assignPatient(patientId);
        System.out.println("Nurse " + nurse.getFirstName() + " assigned to Patient ID " + patientId);
    }

    public static boolean checkIfNurseExists(String id) {
        for (Nurse n : nurseList) {
            if (n.getNurseId().equalsIgnoreCase(id))
                return true;
        }
        return false;
    }

    public static void addSampleNurses() {
        for (int i = 0; i < 5; i++) {
            Nurse nurse = new Nurse();
            nurse.setId(HelperUtils.generateId("PER"));
            nurse.setNurseId("NUR00" + (i + 1));
            nurse.setFirstName("Nurse" + (i + 1));
            nurse.setLastName("Al Amri");
            nurse.setGender(i % 2 == 0 ? "Female" : "Male");
            nurse.setDateOfBirth(LocalDate.of(1990 + i, (i % 12) + 1, (i % 27) + 1));
            nurse.setPhoneNumber("7944444" + i);
            nurse.setEmail("nurse" + (i + 1) + "@hospital.com");
            nurse.setAddress("Salalah, Oman - District " + i);
            nurse.setShift(i % 3 == 0 ? "Morning" : i % 3 == 1 ? "Evening" : "Night");
            nurse.setQualification(i % 2 == 0 ? "BSc Nursing" : "Diploma Nursing");
            nurseList.add(nurse);
        }
        System.out.println("=== Sample Nurses Added Successfully ===");
    }
}
