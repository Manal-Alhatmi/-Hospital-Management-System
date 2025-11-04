package Services;

import Entities.Department;
import Interface.Manageable;
import Utils.InputHandler;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService implements Manageable {
    static ArrayList<Department> departmentList = new ArrayList<>();

    public static Department addInput() {
        System.out.println("Add New Department");
        String deptId = InputHandler.getStringInput("Enter Department ID: ");
        String deptName = InputHandler.getStringInput("Enter Department Name: ");
        String headDoctorId = InputHandler.getStringInput("Enter Head Doctor ID: ");
        int bedCapacity = InputHandler.getIntInput("Enter Total Bed Capacity: ");

        return new Department(deptId, deptName, headDoctorId, bedCapacity);
    }

    public static void save(Department department) {
        if (department != null) {
            departmentList.add(department);
            System.out.println("Department saved successfully with ID: " + department.getDepartmentId());
        } else {
            System.out.println("Invalid department data, not saved.");
        }
    }

    public static void addDepartment() {
        Department dept = addInput();
        save(dept);
    }

    public static void editDepartment() {
        String id = InputHandler.getStringInput("Enter Department ID to edit: ");
        Department dept = getDepartmentById(id);
        if (dept == null) {
            System.out.println("Department not found.");
            return;
        }

        String newName = InputHandler.getStringInput("Enter new Department Name: ");
        if (!newName.isEmpty())
            dept.setDepartmentName(newName);

        String newHead = InputHandler.getStringInput("Enter new Head Doctor ID: ");
        if (!newHead.isEmpty())
            dept.setHeadDoctorId(newHead);

        int newBeds = InputHandler.getIntInput("Enter new Bed Capacity: ");
        if (newBeds > 0)
            dept.setBedCapacity(newBeds);

        System.out.println("Department updated successfully.");
    }

    public static void displayAllDepartments() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments found.");
        } else {
            for (Department d : departmentList) {
                d.displayInfo();
            }
        }
    }

    public static void viewDepartmentDetails() {
        String id = InputHandler.getStringInput("Enter Department ID: ");
        Department dept = getDepartmentById(id);
        if (dept != null) {
            System.out.println("\n Department Details");
            dept.displayInfo();
        } else {
            System.out.println("Department not found.");
        }
    }

    public static void assignDoctorToDepartment() {
        String deptId = InputHandler.getStringInput("Enter Department ID: ");
        Department dept = getDepartmentById(deptId);

        if (dept == null) {
            System.out.println("Department not found.");
            return;
        }

        String doctorId = InputHandler.getStringInput("Enter Doctor ID to assign: ");
        dept.assignDoctor(doctorId);
        System.out.println("Doctor " + doctorId + " assigned to Department " + dept.getDepartmentName());
    }

    public static void assignNurseToDepartment() {
        String deptId = InputHandler.getStringInput("Enter Department ID: ");
        Department dept = getDepartmentById(deptId);

        if (dept == null) {
            System.out.println("Department not found.");
            return;
        }

        String nurseId = InputHandler.getStringInput("Enter Nurse ID to assign: ");
        dept.assignNurse(nurseId);
        System.out.println("Nurse " + nurseId + " assigned to Department " + dept.getDepartmentName());
    }

    public static void viewDepartmentStatistics() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments available.");
            return;
        }

        System.out.println("\nDepartment Statistics");
        for (Department d : departmentList) {
            System.out.println("Department Name: " + d.getDepartmentName());
            System.out.println("Head Doctor ID: " + d.getHeadDoctorId());
            System.out.println("Total Doctors: " + d.getDoctors().size());
            System.out.println("Total Nurses: " + d.getNurses().size());
            System.out.println("Bed Capacity: " + d.getBedCapacity());
            System.out.println("Available Beds: " + d.getAvailableBeds());
        }
    }

    public static void deleteDepartment() {
        String id = InputHandler.getStringInput("Enter Department ID to delete: ");
        boolean found = false;

        for (int i = 0; i < departmentList.size(); i++) {
            Department d = departmentList.get(i);
            if (d.getDepartmentId().equalsIgnoreCase(id)) {
                departmentList.remove(i);
                found = true;
                System.out.println("Department deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Department not found.");
        }
    }

    public static Department getDepartmentById(String id) {
        for (Department d : departmentList) {
            if (d.getDepartmentId().equalsIgnoreCase(id)) {
                return d;
            }
        }
        return null;
    }

    @Override
    public void add(Object entity) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<Department> getAll() {
        return departmentList;
    }
}
