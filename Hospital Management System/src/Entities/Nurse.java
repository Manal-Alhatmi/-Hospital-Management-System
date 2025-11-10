package Entities;

import Utils.HelperUtils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Nurse extends Person {
    private String nurseId;
    private String departmentId;
    private String shift;
    private String qualification;
    private List<String> assignedPatients;


    public Nurse(String id, String firstName, String lastName, LocalDate dob,
                 String gender, String phoneNumber, String email, String address,
                 String nurseId, String departmentId, String shift, String qualification,
                 List<String> assignedPatients) {

        super(id, firstName, lastName, dob, gender, phoneNumber, email, address);
        setNurseId(HelperUtils.isValidString(nurseId) ? nurseId : HelperUtils.generateId("NUR"));
        setDepartmentId(departmentId);
        setShift(shift);
        setQualification(qualification);

        if (HelperUtils.isNotNull(assignedPatients)) {
            this.assignedPatients = assignedPatients;
        } else {
            this.assignedPatients = new ArrayList<>();
        }
    }

    public Nurse() {

    }

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = HelperUtils.isValidString(nurseId) ? nurseId : HelperUtils.generateId("NUR");
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = HelperUtils.isValidString(departmentId) ? departmentId : "DEPT-UNKNOWN";
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = HelperUtils.isValidString(shift) ? shift : "Not Assigned";
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = HelperUtils.isValidString(qualification) ? qualification : "Unspecified";
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void assignPatient(String patientId) {
        if (HelperUtils.isValidString(patientId) && !assignedPatients.contains(patientId)) {
            assignedPatients.add(patientId);
        } else {
            System.out.println(" Invalid or duplicate patient ID. Assignment skipped.");
        }
    }

    public void removeAssignedPatient(String patientId) {
        if (HelperUtils.isValidString(patientId) && assignedPatients.contains(patientId)) {
            assignedPatients.remove(patientId);
        } else {
            System.out.println("Cannot remove — invalid or non-existent patient ID.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Nurse ID: " + nurseId);
        System.out.println("Department ID: " + departmentId);
        System.out.println("Shift: " + shift);
        System.out.println("Qualification: " + qualification);
        System.out.println("Assigned Patients: " + assignedPatients);
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " (Nurse ID: " + nurseId + ")";
    }
}
