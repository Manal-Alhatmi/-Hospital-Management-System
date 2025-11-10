package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Surgeon extends Doctor {
    private int surgeriesPerformed;
    private List<String> surgeryTypes = new ArrayList<>();
    private boolean operationTheatreAccess;

    public Surgeon() {

    }

    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(int surgeriesPerformed) {
        this.surgeriesPerformed = surgeriesPerformed;
    }

    public List<String> getSurgeryTypes() {
        return surgeryTypes;
    }

    public void setSurgeryTypes(List<String> surgeryTypes) {
        this.surgeryTypes = surgeryTypes;
    }

    public boolean isOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(boolean operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }

    public Surgeon(String id, String firstName, String lastName, LocalDate dob, String gender,
                   String phone, String email, String address,
                   String doctorId, String specialization, String qualification,
                   int experienceYears, String departmentId, double consultationFee,
                   boolean operationTheatreAccess) {
        super(id, firstName, lastName, dob, gender, phone, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee);
        this.operationTheatreAccess = operationTheatreAccess;
    }

    public void performSurgery(String type) {
        surgeriesPerformed = surgeriesPerformed + 1;
        surgeryTypes.add(type);
    }

    public void updateSurgeryCount(int count) {
        surgeriesPerformed = surgeriesPerformed + count;
    }
}

