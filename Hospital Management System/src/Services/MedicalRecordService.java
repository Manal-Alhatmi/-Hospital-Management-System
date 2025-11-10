package Services;

import Entities.MedicalRecord;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordService {
    public static List<MedicalRecord> records = new ArrayList<>();

    public static MedicalRecord inputRecord() {
        System.out.println("\nCreate New Medical Record");

        String recordId = InputHandler.getStringInput("Enter Record ID: ");
        String patientId = InputHandler.getStringInput("Enter Patient ID: ");
        String doctorId = InputHandler.getStringInput("Enter Doctor ID: ");
        String diagnosis = InputHandler.getStringInput("Enter Diagnosis: ");
        String prescription = InputHandler.getStringInput("Enter Prescription: ");
        String testResults = InputHandler.getStringInput("Enter Test Results: ");
        String notes = InputHandler.getStringInput("Enter Notes: ");
        LocalDate visitDate = InputHandler.getDateInput("Enter Visit Date (YYYY-MM-DD): ");

        return new MedicalRecord(recordId, patientId, doctorId, visitDate,
                diagnosis, prescription, testResults, notes);
    }

    public static void createMedicalRecord() {
        MedicalRecord record = inputRecord();
        if (record != null) {
            records.add(record);
            System.out.println("Medical record added successfully.");
        } else {
            System.out.println(" Failed to create medical record.");
        }
    }


    public static void displayAllRecords() {
        System.out.println("\nAll Medical Records");
        if (records.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (MedicalRecord r : records) {
                r.displayInfo();
            }
        }
    }

    public static void viewRecordsByPatient() {
        String pid = InputHandler.getStringInput("Enter Patient ID: ");
        boolean found = false;

        for (MedicalRecord r : records) {
            if (r.getPatientId().equalsIgnoreCase(pid)) {
                r.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No records found for patient ID: " + pid);
    }

    public static void viewRecordsByDoctor() {
        String did = InputHandler.getStringInput("Enter Doctor ID: ");
        boolean found = false;

        for (MedicalRecord r : records) {
            if (r.getDoctorId().equalsIgnoreCase(did)) {
                r.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No records found for doctor ID: " + did);
    }


    public static void updateMedicalRecord() {
        String id = InputHandler.getStringInput("Enter Record ID to update: ");
        boolean updated = false;

        for (MedicalRecord r : records) {
            if (r.getRecordId().equalsIgnoreCase(id)) {
                System.out.println("Editing Record ID: " + id);

                String newDiagnosis = InputHandler.getStringInput("Enter new Diagnosis " + r.getDiagnosis());
                if (!newDiagnosis.isEmpty())
                    r.setDiagnosis(newDiagnosis);

                String newPrescription = InputHandler.getStringInput("Enter new Prescription " + r.getPrescription());
                if (!newPrescription.isEmpty())
                    r.setPrescription(newPrescription);

                String newTestResults = InputHandler.getStringInput("Enter new Test Results" + r.getTestResults());
                if (!newTestResults.isEmpty())
                    r.setTestResults(newTestResults);

                String newNotes = InputHandler.getStringInput("Enter new Notes" + r.getNotes());
                if (!newNotes.isEmpty())
                    r.setNotes(newNotes);

                updated = true;
                System.out.println("Record updated successfully.");
                break;
            }
        }

        if (!updated) System.out.println(" Record not found.");
    }


    public static void deleteMedicalRecord() {
        String id = InputHandler.getStringInput("Enter Record ID to delete: ");
        boolean found = false;

        for (int i = 0; i < records.size(); i++) {
            MedicalRecord record = records.get(i);
            if (record.getRecordId().equalsIgnoreCase(id)) {
                records.remove(i);
                System.out.println("Record deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Record not found.");
        }
    }



    public static void generatePatientHistoryReport() {
        String pid = InputHandler.getStringInput("Enter Patient ID for report: ");
        boolean found = false;

        System.out.println("\n Medical History Report for Patient ID: " + pid );
        for (MedicalRecord r : records) {
            if (r.getPatientId().equalsIgnoreCase(pid)) {
                r.displayInfo();
                found = true;
            }
        }

        if (!found)
            System.out.println("No medical history found for this patient.");
    }

    public static void addSampleMedicalRecords() {
        for (int i = 0; i < 12; i++) {
            MedicalRecord record = new MedicalRecord();
            record.setRecordId("MR00" + (i + 1));
            record.setPatientId(i < 3 ? "PAT00" + (i + 1) : i < 6 ? "INP00" + (i - 2) : i < 8 ? "OUT00" + (i - 5) : "EMP00" + (i - 7));
            record.setDoctorId("DOC00" + ((i % 8) + 1));
            record.setVisitDate(LocalDate.now().minusDays(i + 1));
            record.setDiagnosis("Diagnosis " + (i + 1));
            record.setPrescription("Prescription " + (i + 1));
            record.setTestResults("Test Results " + (i + 1));
            record.setNotes("Medical record notes " + (i + 1));
            records.add(record);
        }
        System.out.println("=== Sample Medical Records Added Successfully ===");
    }
}
