package Entities;

import Utils.HelperUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private String notes;

    public Appointment(String appointmentId, String patientId, String doctorId,
                       LocalDate appointmentDate, String appointmentTime,
                       String status, String reason, String notes) {
        this.appointmentId = HelperUtils.isValidString(appointmentId)
                ? appointmentId : HelperUtils.generateId("APT");
        setPatientId(patientId);
        setDoctorId(doctorId);
        setAppointmentDate(appointmentDate);
        setAppointmentTime(appointmentTime);
        setStatus(status);
        setReason(reason);
        setNotes(notes);
    }

    public Appointment() {
    }


    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        if (HelperUtils.isValidString(appointmentId))
            this.appointmentId = appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (HelperUtils.isValidString(patientId))
            this.patientId = patientId;
        else
            System.out.println("Invalid patient ID.");
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        if (HelperUtils.isValidString(doctorId))
            this.doctorId = doctorId;
        else
            System.out.println("Invalid doctor ID.");
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        if (HelperUtils.isNotNull(appointmentDate))
            this.appointmentDate = appointmentDate;
        else
            this.appointmentDate = LocalDate.now();
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        if (HelperUtils.isValidString(appointmentTime))
            this.appointmentTime = appointmentTime;
        else
            System.out.println("Invalid appointment time.");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (HelperUtils.isValidString(status))
            this.status = HelperUtils.capitalize(status);
        else
            this.status = "Pending";
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        if (HelperUtils.isValidString(reason))
            this.reason = reason;
        else
            this.reason = "General Checkup";
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        if (HelperUtils.isValidString(notes))
            this.notes = notes;
        else
            this.notes = "";
    }


    public void reschedule(LocalDate newDate, String newTime) {
        if (HelperUtils.isNotNull(newDate) && HelperUtils.isValidString(newTime)) {
            this.appointmentDate = newDate;
            this.appointmentTime = newTime;
            this.status = "Rescheduled";
        } else {
            System.out.println("Invalid reschedule details.");
        }
    }

    public void cancel() {
        this.status = "Cancelled";
    }

    public void complete() {
        this.status = "Completed";
    }

    public void displayInfo() {
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Date: " + appointmentDate + " | Time: " + appointmentTime);
        System.out.println("Status: " + status);
        System.out.println("Reason: " + reason);
        System.out.println("Notes: " + notes);
    }

    public void addNotes(String notes) {
        if (HelperUtils.isValidString(notes)) {
            this.notes = (HelperUtils.isNull(this.notes) ? "" : this.notes + "\n") + notes;
            System.out.println("Notes added: " + notes);
        }
    }

    public void addNotes(String notes, String addedBy) {
        if (HelperUtils.isValidString(notes) && HelperUtils.isValidString(addedBy)) {
            String entry = "[" + addedBy + "]: " + notes;
            this.notes = (HelperUtils.isNull(this.notes) ? "" : this.notes + "\n") + entry;
            System.out.println("Notes added by " + addedBy);
        }
    }

    public void addNotes(String notes, String addedBy, LocalDateTime timestamp) {
        if (HelperUtils.isValidString(notes) && HelperUtils.isValidString(addedBy) && HelperUtils.isNotNull(timestamp)) {
            String entry = "[" + timestamp + " - " + addedBy + "]: " + notes;
            this.notes = (HelperUtils.isNull(this.notes) ? "" : this.notes + "\n") + entry;
            System.out.println("Notes added by " + addedBy + " at " + timestamp);
        }
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}