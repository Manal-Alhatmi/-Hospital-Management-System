package Entities;

import java.time.LocalDate;

public class GeneralPractitioner extends Doctor {
    private boolean walkinAvailable;
    private boolean homeVisitAvailable;
    private boolean vaccinationCertified;

    public boolean isWalkinAvailable() {
        return walkinAvailable;
    }

    public void setWalkinAvailable(boolean walkinAvailable) {
        this.walkinAvailable = walkinAvailable;
    }

    public boolean isHomeVisitAvailable() {
        return homeVisitAvailable;
    }

    public void setHomeVisitAvailable(boolean homeVisitAvailable) {
        this.homeVisitAvailable = homeVisitAvailable;
    }

    public boolean isVaccinationCertified() {
        return vaccinationCertified;
    }

    public void setVaccinationCertified(boolean vaccinationCertified) {
        this.vaccinationCertified = vaccinationCertified;
    }

    public GeneralPractitioner(String id, String firstName, String lastName, LocalDate dob, String gender,
                               String phone, String email, String address,
                               String doctorId, String specialization, String qualification,
                               int experienceYears, String departmentId, double consultationFee,
                               boolean walkinAvailable, boolean homeVisitAvailable, boolean vaccinationCertified) {
        super(id, firstName, lastName, dob, gender, phone, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee);
        this.walkinAvailable = walkinAvailable;
        this.homeVisitAvailable = homeVisitAvailable;
        this.vaccinationCertified = vaccinationCertified;
    }

    public void scheduleHomeVisit(String patientId) {

    }
    public void administerVaccine(String vaccine) {

    }
}
