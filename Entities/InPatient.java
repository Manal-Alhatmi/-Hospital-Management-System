package Entities;

import Interface.Billable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class InPatient extends Patient implements Billable {
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges;

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getAdmittingDoctorId() {
        return admittingDoctorId;
    }

    public void setAdmittingDoctorId(String admittingDoctorId) {
        this.admittingDoctorId = admittingDoctorId;
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(double dailyCharges) {
        this.dailyCharges = dailyCharges;
    }

    public InPatient(String id, String firstName, String lastName, LocalDate dob, String gender,
                     String phone, String email, String address, String patientId, String bloodGroup,
                     String emergencyContact, String insuranceId,
                     LocalDate admissionDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges) {
        super(id, firstName, lastName, dob, gender, phone, email, address, patientId, bloodGroup, emergencyContact, insuranceId);
        this.admissionDate = admissionDate;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }

    public long calculateStayDuration() {
        LocalDate end = dischargeDate == null ? LocalDate.now() : dischargeDate;
        return ChronoUnit.DAYS.between(admissionDate, end);
    }

    @Override
    public double calculateCharges() {
        return calculateStayDuration() * dailyCharges;
    }

    @Override
    public void generateBill() {
        System.out.println("Generating bill for In-Patient: " + getFirstName() + " " + getLastName());
        System.out.println("Stay Duration: " + calculateStayDuration() + " days");
    }


    @Override
    public void processPayment(double amount) {
        System.out.println("Processed payment of $" + amount);
    }

    public void discharge(LocalDate d) {
        this.dischargeDate = d;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Admission: " + admissionDate + " | Room: " + roomNumber + " | Bed: " + bedNumber);
    }
}
