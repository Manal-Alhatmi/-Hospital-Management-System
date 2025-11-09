package Entities;

import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Consultant extends Doctor {
    private List<String> consultationTypes = new ArrayList<>();
    private boolean onlineConsultationAvailable;
    private int consultationDuration;

    public Consultant(String id, String firstName, String lastName, LocalDate dob, String gender,
                      String phone, String email, String address,
                      String doctorId, String specialization, String qualification,
                      int experienceYears, String departmentId, double consultationFee,
                      boolean onlineConsultationAvailable, int consultationDuration) {
        super(id, firstName, lastName, dob, gender, phone, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee);
        this.onlineConsultationAvailable = onlineConsultationAvailable;
        this.consultationDuration = consultationDuration;
    }
    public void setConsultationDuration(int consultationDuration) {
        if (HelperUtils.isValidNumber(consultationDuration, 10, 120))
            this.consultationDuration = consultationDuration;
        else {
            this.consultationDuration = 30; // default duration
            System.out.println("Invalid consultation duration. Default (30 mins) applied.");
        }
    }

    public int getConsultationDuration() {
        return consultationDuration;
    }

    public boolean isOnlineConsultationAvailable() {
        return onlineConsultationAvailable;
    }

    public void setOnlineConsultationAvailable(boolean onlineConsultationAvailable) {
        this.onlineConsultationAvailable = onlineConsultationAvailable;
    }

    public List<String> getConsultationTypes() {
        return consultationTypes;
    }

    public void addConsultationType(String type) {
        if (HelperUtils.isValidString(type))
            consultationTypes.add(HelperUtils.capitalize(type));
        else
            System.out.println("Invalid consultation type. Not added.");
    }

    public void scheduleConsultation(String type) {
        if (HelperUtils.isValidString(type)) {
            consultationTypes.add(HelperUtils.capitalize(type));
            System.out.println("Consultation scheduled for type: " + type);
        } else {
            System.out.println("Invalid consultation type.");
        }
    }

    public void provideSecondOpinion(String caseSummary) {
        if (HelperUtils.isValidString(caseSummary, 10)) {
            System.out.println("Providing second opinion on case: " + caseSummary);
        } else {
            System.out.println("Case summary too short or invalid.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Online Consultation: " + (onlineConsultationAvailable ? "Available" : "Not Available"));
        System.out.println("Consultation Duration: " + consultationDuration + " minutes");
        System.out.println("Consultation Types: " + (HelperUtils.isEmptyList(consultationTypes) ? "None" : consultationTypes));
    }
}