package Entities;

import java.time.LocalDate;

public class OutPatient extends Patient {
    private int visitCount;
    private LocalDate lastVisitDate;
    private String preferredDoctorId;

    public OutPatient() {

    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public LocalDate getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getPreferredDoctorId() {
        return preferredDoctorId;
    }

    public void setPreferredDoctorId(String preferredDoctorId) {
        this.preferredDoctorId = preferredDoctorId;
    }

    public OutPatient(String id, String firstName, String lastName, LocalDate dob, String gender,
                      String phone, String email, String address, String patientId, String bloodGroup,
                      String emergencyContact, String insuranceId) {
        super(id, firstName, lastName, dob, gender, phone, email, address, patientId, bloodGroup, emergencyContact, insuranceId);
        this.visitCount = 0;
    }

    public void scheduleFollowUp() {
        visitCount++;
        lastVisitDate = LocalDate.now();
    }
    public void updateVisitCount(int increment) {
        visitCount += increment;
    }
}
