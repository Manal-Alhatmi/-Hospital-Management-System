package Entities;

import Utils.HelperUtils;

import java.time.LocalDate;

public class EmergencyPatient extends InPatient {
    private String emergencyType;
    private String arrivalMode;
    private int triageLevel;
    private boolean admittedViaER;

    public EmergencyPatient(String id, String firstName, String lastName, LocalDate dob, String gender,
                            String phone, String email, String address, String patientId, String bloodGroup,
                            String emergencyContact, String insuranceId,
                            LocalDate admissionDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges,
                            String emergencyType, String arrivalMode, int triageLevel, boolean admittedViaER) {

        super(id, firstName, lastName, dob, gender, phone, email, address,
                HelperUtils.isValidString(patientId) ? patientId : HelperUtils.generateId("EMP"),
                bloodGroup, emergencyContact, insuranceId,
                admissionDate, roomNumber, bedNumber, admittingDoctorId, dailyCharges);

        setEmergencyType(emergencyType);
        setArrivalMode(arrivalMode);
        setTriageLevel(triageLevel);
        setAdmittedViaER(admittedViaER);
    }

    public EmergencyPatient() {
        super();
        this.setPatientId(HelperUtils.generateId("EMP"));
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        if (HelperUtils.isValidString(emergencyType, 3, 50)) {
            this.emergencyType = emergencyType;
        }
    }

    public String getArrivalMode() {
        return arrivalMode;
    }

    public void setArrivalMode(String arrivalMode) {
        if (HelperUtils.isValidString(arrivalMode, 2, 30)) {
            this.arrivalMode = arrivalMode;
        }
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(int triageLevel) {
        if (HelperUtils.isValidNumber(triageLevel, 1, 5)) {
            this.triageLevel = triageLevel;
        }
    }

    public boolean isAdmittedViaER() {
        return admittedViaER;
    }

    public void setAdmittedViaER(boolean admittedViaER) {
        this.admittedViaER = admittedViaER;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Emergency Type: " + emergencyType);
        System.out.println("Arrival Mode: " + arrivalMode);
        System.out.println("Triage Level: " + triageLevel);
        System.out.println("Admitted via ER: " + admittedViaER);
    }
}