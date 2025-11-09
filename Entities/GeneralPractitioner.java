package Entities;

import Utils.HelperUtils;
import java.time.LocalDate;

public class GeneralPractitioner extends Doctor {
    private boolean walkinAvailable;
    private boolean homeVisitAvailable;
    private boolean vaccinationCertified;

    public GeneralPractitioner(String id, String firstName, String lastName, LocalDate dob, String gender,
                               String phone, String email, String address,
                               String doctorId, String specialization, String qualification,
                               int experienceYears, String departmentId, double consultationFee,
                               boolean walkinAvailable, boolean homeVisitAvailable, boolean vaccinationCertified) {

        super(id, firstName, lastName, dob, gender, phone, email, address,
                HelperUtils.isValidString(doctorId) ? doctorId : HelperUtils.generateId("DOC"),
                specialization, qualification, experienceYears, departmentId, consultationFee);

        setWalkinAvailable(walkinAvailable);
        setHomeVisitAvailable(homeVisitAvailable);
        setVaccinationCertified(vaccinationCertified);
    }

    public GeneralPractitioner() {
        super();
        setDoctorId(HelperUtils.generateId("DOC"));
    }


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


    public void scheduleHomeVisit(String patientId) {
        if (HelperUtils.isValidString(patientId)) {
            System.out.println("Home visit scheduled for patient: " + patientId);
        } else {
            System.out.println("Invalid patient ID for home visit scheduling.");
        }
    }

    public void administerVaccine(String vaccine) {
        if (HelperUtils.isValidString(vaccine)) {
            System.out.println("Vaccine '" + vaccine + "' administered successfully.");
        } else {
            System.out.println(" Invalid vaccine name.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Walk-in Available: " + walkinAvailable);
        System.out.println("Home Visit Available: " + homeVisitAvailable);
        System.out.println("Vaccination Certified: " + vaccinationCertified);
    }
}
