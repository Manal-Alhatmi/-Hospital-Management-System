package Entities;

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
    private List<String> availableSlots;
    private List<String> assignedPatients;

    public Doctor(String id, String firstName, String lastName, LocalDate dob,
                  String gender, String phoneNumber, String email, String address,
                  String doctorId, String specialization, String qualification,
                  int experienceYears, String departmentId, double consultationFee,
                  List<String> availableSlots, List<String> assignedPatients) {
        super(id, firstName, lastName, dob, gender, phoneNumber, email, address);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;
        this.availableSlots = (availableSlots != null) ? availableSlots : new ArrayList<>();
        this.assignedPatients = (assignedPatients != null) ? assignedPatients : new ArrayList<>();
    }

    public Doctor(String id, String firstName, String lastName, String doctorId,
                  String specialization, String qualification, int experienceYears,
                  String departmentId, double consultationFee) {
        this(id, firstName, lastName, null, null, null, null, null,
                doctorId, specialization, qualification, experienceYears,
                departmentId, consultationFee, null, null);
    }

    public Doctor(String id, String firstName, String lastName, LocalDate dob,
                  String gender, String phone, String email, String address,
                  String doctorId, String specialization, String qualification,
                  int experienceYears, String departmentId, double consultationFee) {
        this(id, firstName, lastName, dob, gender, phone, email, address,
                doctorId, specialization, qualification, experienceYears,
                departmentId, consultationFee, new ArrayList<>(), new ArrayList<>());
    }

    public Doctor(String doctorId, String firstName, String specialization) {
        this(null, firstName, null, null, null, null, null, null,
                doctorId, specialization, null, 0, null, 0.0,
                new ArrayList<>(), new ArrayList<>());
    }

    public Doctor() {

    }

    public <E> Doctor(String doc2, String fatima, String ali, String doc21, String consultant, String phD, int i, String neurology, double v, ArrayList<E> es, ArrayList<E> es1) {
    }

    public String getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public double getConsultationFee() {
        return consultationFee;
    }
    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }
    public List<String> getAssignedPatients() {
        return assignedPatients; }

    public void assignPatient(String patientId) {
        if (patientId != null && !assignedPatients.contains(patientId))
            assignedPatients.add(patientId);
    }

    public void removePatient(String patientId) {
        assignedPatients.remove(patientId);
    }

    public void updateAvailability(List<String> slots) {
        this.availableSlots = (slots != null) ? slots : new ArrayList<>();
    }

    public void addAvailableSlot(String slot) {
        if (slot != null && !availableSlots.contains(slot))
            availableSlots.add(slot);
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
