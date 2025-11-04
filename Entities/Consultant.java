package Entities;

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

    public void scheduleConsultation(String type) {
        consultationTypes.add(type);
    }

    public void provideSecondOpinion(String caseSummary) {

    }
}
