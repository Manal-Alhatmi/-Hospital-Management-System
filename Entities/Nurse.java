package Entities;

import java.util.ArrayList;
import java.util.List;

public class Nurse extends Person {
    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;
    private List<String> assignedPatients;

    public Nurse(String id, String firstName, String lastName, java.time.LocalDate dob,
                 String gender, String phoneNumber, String email, String address,
                 String nurseId, String departmentId, String shift, String qualification,
                 List<String> assignedPatients) {
        super(id, firstName, lastName, dob, gender, phoneNumber, email, address);
        this.nurseId = nurseId;
        this.departmentId = departmentId;
        this.shift = shift;
        this.qualification = qualification;
        this.assignedPatients = (assignedPatients != null) ? assignedPatients : new ArrayList<>();
    }

    public Nurse(String id, String firstName, String lastName, String nurseId, String departmentId, String shift) {
        this(id, firstName, lastName, null, null, null, null, null, nurseId, departmentId, shift, null, null);
    }

    public String getNurseId() {
        return nurseId;
    }
    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }

    public String getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getShift() {
        return shift;
    }
    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void assignPatient(String patientId) {
        if (patientId != null && !assignedPatients.contains(patientId))
            assignedPatients.add(patientId);
    }

    public void removeAssignedPatient(String patientId) {
        assignedPatients.remove(patientId);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("NurseID: " + nurseId);
        System.out.println("DepartmentID: " + departmentId);
        System.out.println("Shift: " + shift);
        System.out.println("Qualification: " + qualification);
        System.out.println("Assigned Patients: " + assignedPatients);
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " (Nurse " + nurseId + ")";
    }
}
