package Entities;

import Interface.Billable;
import Utils.HelperUtils;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class InPatient extends Patient implements Billable {
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges;


    public InPatient() {
        super();
        setPatientId(HelperUtils.generateId("PAT"));
    }

    public InPatient(String id, String firstName, String lastName, LocalDate dob, String gender,
                     String phone, String email, String address, String patientId, String bloodGroup,
                     String emergencyContact, String insuranceId,
                     LocalDate admissionDate, String roomNumber, String bedNumber,
                     String admittingDoctorId, double dailyCharges) {

        super(id, firstName, lastName, dob, gender, phone, email, address,
                HelperUtils.isValidString(patientId) ? patientId : HelperUtils.generateId("PAT"),
                bloodGroup, emergencyContact, insuranceId);

        setAdmissionDate(admissionDate);
        setRoomNumber(roomNumber);
        setBedNumber(bedNumber);
        setAdmittingDoctorId(admittingDoctorId);
        setDailyCharges(dailyCharges);
    }


    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        if (HelperUtils.isNull(admissionDate)) {
            System.out.println("Admission date cannot be null. Using today's date as default.");
            this.admissionDate = LocalDate.now();
        } else {
            this.admissionDate = admissionDate;
        }
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        if (HelperUtils.isNotNull(dischargeDate)) {
            this.dischargeDate = dischargeDate;
        } else {
            System.out.println(" Discharge date not set (still admitted).");
        }
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = HelperUtils.isValidString(roomNumber) ? roomNumber : "N/A";
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = HelperUtils.isValidString(bedNumber) ? bedNumber : "N/A";
    }

    public String getAdmittingDoctorId() {
        return admittingDoctorId;
    }

    public void setAdmittingDoctorId(String admittingDoctorId) {
        this.admittingDoctorId = HelperUtils.isValidString(admittingDoctorId)
                ? admittingDoctorId
                : HelperUtils.generateId("DOC");
    }

    public double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(double dailyCharges) {
        this.dailyCharges = HelperUtils.isPositiveNumber(dailyCharges) ? dailyCharges : 100.0;
    }


    public long calculateStayDuration() {
        LocalDate end = HelperUtils.isNotNull(dischargeDate) ? dischargeDate : LocalDate.now();
        return ChronoUnit.DAYS.between(admissionDate, end);
    }

    @Override
    public double calculateCharges() {
        return calculateStayDuration() * dailyCharges;
    }

    @Override
    public void generateBill() {
        System.out.println("\nGenerating Bill for In-Patient: " + getFirstName() + " " + getLastName());
        System.out.println("Stay Duration: " + calculateStayDuration() + " days");
        System.out.println("Total Charges: $" + calculateCharges());
    }

    @Override
    public void processPayment(double amount) {
        if (HelperUtils.isPositiveNumber(amount)) {
            System.out.println("Processed payment of $" + amount);
        } else {
            System.out.println(" Invalid payment amount.");
        }
    }

    public void discharge(LocalDate d) {
        if (HelperUtils.isNotNull(d)) {
            this.dischargeDate = d;
            System.out.println("Patient discharged on: " + d);
        } else {
            System.out.println(" Invalid discharge date.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Admission: " + admissionDate +
                " | Discharge: " + (HelperUtils.isNotNull(dischargeDate) ? dischargeDate : "Still Admitted"));
        System.out.println("Room: " + roomNumber + " | Bed: " + bedNumber);
        System.out.println("Admitting Doctor ID: " + admittingDoctorId);
        System.out.println("Daily Charges: $" + dailyCharges);
    }
}
