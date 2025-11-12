package Entities;

import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String doctorId;
    private String specialization;
    private String qualification;
    private int experienceYears;
    private String departmentId;
    private double consultationFee;
    private List<String> availableSlots = new ArrayList<>();
    private List<String> assignedPatients = new ArrayList<>();

    public Doctor(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;
        this.availableSlots = availableSlots;
        this.assignedPatients = assignedPatients;
    }

    public Doctor(String doctorId, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee, List<String> availableSlots, List<String> assignedPatients) {
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;
        this.availableSlots = availableSlots;
        this.assignedPatients = assignedPatients;
    }

    public Doctor(String id, String firstName, String lastName, LocalDate dob, String gender, String phone, String email, String address, String doc, String specialization, String qualification, int experienceYears, String departmentId, double consultationFee) {
    }

    public Doctor() {

    }

    public <E> Doctor(String idDoctor, String firstName, String lastName, String idDoctor1, String specialization, String qualification, int experience, Object o, double fee, ArrayList<E> es, ArrayList<E> es1) {
    }


    public String getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(String doctorId) {
        if (HelperUtils.isValidString(doctorId))
            this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if (HelperUtils.isValidString(specialization, 3, 50))
            this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        if (HelperUtils.isValidString(qualification, 2, 50))
            this.qualification = qualification;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        if (HelperUtils.isValidNumber(experienceYears, 0, 60))
            this.experienceYears = experienceYears;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        if (HelperUtils.isValidString(departmentId))
            this.departmentId = departmentId;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        if (HelperUtils.isValidNumber(consultationFee, 0.0, 10000.0))
            this.consultationFee = consultationFee;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }
    public void setAssignedPatients(List<String> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    public void assignPatient(String patientId) {
        if (HelperUtils.isValidString(patientId) && !assignedPatients.contains(patientId)) {
            assignedPatients.add(patientId);
        }
    }

    public void removePatient(String patientId) {
        if (HelperUtils.isValidString(patientId)) {
            assignedPatients.remove(patientId);
        }
    }

    public void updateAvailability(List<String> slots) {
        this.availableSlots = HelperUtils.isNotNull(slots) ? slots : new ArrayList<>();
    }

    public void addAvailableSlot(String slot) {
        if (HelperUtils.isValidString(slot) && !availableSlots.contains(slot)) {
            availableSlots.add(slot);
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Specialization: " + specialization);
        System.out.println("Qualification: " + qualification);
        System.out.println("Experience (years): " + experienceYears);
        System.out.println("Department ID: " + departmentId);
        System.out.println("Consultation Fee: " + consultationFee);
        System.out.println("Available Slots: " + availableSlots);
        System.out.println("Assigned Patients: " + assignedPatients);
    }

    @Override
    public String toString() {
        return "Dr. " + getFirstName() + " " + getLastName() +
                " (" + specialization + ", ID: " + doctorId + ")";
    }
}
