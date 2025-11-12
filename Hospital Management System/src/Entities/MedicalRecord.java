package Entities;

import Utils.HelperUtils;
import java.time.LocalDate;

public class MedicalRecord {
    private String recordId;
    private String patientId;
    private String doctorId;
    private LocalDate visitDate;
    private String diagnosis;
    private String prescription;
    private String testResults;
    private String notes;



    public MedicalRecord(String recordId, String patientId, String doctorId, LocalDate visitDate,
                         String diagnosis, String prescription, String testResults, String notes) {
        setRecordId(HelperUtils.isValidString(recordId) ? recordId : HelperUtils.generateId("MR"));
        setPatientId(patientId);
        setDoctorId(doctorId);
        setVisitDate(visitDate);
        setDiagnosis(diagnosis);
        setPrescription(prescription);
        setTestResults(testResults);
        setNotes(notes);
    }

    public MedicalRecord(String patientId, String doctorId, String diagnosis, String prescription) {
        this(HelperUtils.generateId("MR"), patientId, doctorId, LocalDate.now(), diagnosis, prescription, "Pending", "No additional notes"
        );
    }

    public MedicalRecord() {

    }


    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = HelperUtils.isValidString(recordId) ? recordId : HelperUtils.generateId("MR");
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (HelperUtils.isValidString(patientId)) {
            this.patientId = patientId;
        } else {
            System.out.println("Invalid patient ID. Assigning default generated ID.");
            this.patientId = HelperUtils.generateId("PAT");
        }
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = HelperUtils.isValidString(doctorId) ? doctorId : HelperUtils.generateId("DOC");
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        if (HelperUtils.isNotNull(visitDate)) {
            this.visitDate = visitDate;
        } else {
            System.out.println("Visit date not provided, defaulting to current date.");
            this.visitDate = LocalDate.now();
        }
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = HelperUtils.isValidString(diagnosis) ? diagnosis : "Unknown Diagnosis";
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = HelperUtils.isValidString(prescription) ? prescription : "No Prescription";
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = HelperUtils.isValidString(testResults) ? testResults : "Not Available";
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = HelperUtils.isValidString(notes) ? notes : "No Notes Recorded";
    }


    public void displayInfo() {
        System.out.println("\n --- Medical Record Details ---");
        System.out.println("Record ID: " + recordId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Visit Date: " + visitDate);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Prescription: " + prescription);
        System.out.println("Test Results: " + testResults);
        System.out.println("Notes: " + notes);
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "recordId='" + recordId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", visitDate=" + visitDate +
                ", diagnosis='" + diagnosis + '\'' +
                ", prescription='" + prescription + '\'' +
                ", testResults='" + testResults + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
