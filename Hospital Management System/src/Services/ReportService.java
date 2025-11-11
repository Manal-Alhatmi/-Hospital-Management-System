package Services;

import Entities.*;
import Interface.Displayable;
import Utils.HelperUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReportService implements Displayable {
    private static List<Appointment> appointments = new ArrayList<>();
    private static List<Doctor> doctors = new ArrayList<>();
    private static List<Patient> patients = new ArrayList<>();
    private static List<Department> departments = new ArrayList<>();

    public static void setAppointments(List<Appointment> appts) {
        appointments = appts;
    }

    public static void setDoctors(List<Doctor> docs) {
        doctors = docs;
    }

    public static void setPatients(List<Patient> pats) {
        patients = pats;
    }

    public static void setDepartments(List<Department> depts) {
        departments = depts;
    }


    public static void dailyAppointmentsReport() {
        System.out.println("\nDaily Appointments Report");
        LocalDate today = LocalDate.now();
        boolean found = false;

        for (Appointment a : appointments) {
            if (a.getAppointmentDate().equals(today)) {
                a.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments scheduled today");
        }
    }

    public static void doctorPerformanceReport() {
        System.out.println("\nDoctor Performance Report");

        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        for (Doctor doc : doctors) {
            int count = 0;
            for (Appointment a : appointments) {
                if (a.getDoctorId().equalsIgnoreCase(doc.getDoctorId())) {
                    count++;
                }
            }
            System.out.println("Doctor: " + doc.getFirstName() + " " + doc.getLastName() + " | Appointments handled: " + count);
        }
    }

    public static void departmentOccupancyReport() {
        System.out.println("\nDepartment Occupancy Report");

        if (departments.isEmpty()) {
            System.out.println("No departments found.");
            return;
        }

        for (Department dept : departments) {
            int totalDoctors = 0;
            int totalPatients = 0;

            for (Doctor doc : doctors) {
                if (doc.getDepartmentId().equalsIgnoreCase(dept.getDepartmentId())) {
                    totalDoctors++;
                    totalPatients += doc.getAssignedPatients().size();
                }
            }

            System.out.println("Department: " + dept.getDepartmentName() + " | Doctors: " + totalDoctors + " | Patients: " + totalPatients + " | Bed Capacity: " + dept.getBedCapacity() + " | Available Beds: " + dept.getAvailableBeds());
        }
    }


    public static void patientStatistics() {
        System.out.println("\nPatient Statistics");
        System.out.println("Total Patients: " + patients.size());

        int inPatients = 0;
        int outPatients = 0;
        int emergencyPatients = 0;

        for (Patient p : patients) {
            if (p instanceof InPatient) {
                inPatients++;
            } else if (p instanceof OutPatient) {
                outPatients++;
            } else if (p instanceof EmergencyPatient) {
                emergencyPatients++;
            }
        }

        System.out.println("InPatients: " + inPatients);
        System.out.println("OutPatients: " + outPatients);
        System.out.println("Emergency Patients: " + emergencyPatients);
    }

    public static void emergencyCasesReport() {
        System.out.println("\nEmergency Cases Report");
        boolean found = false;

        for (Patient p : patients) {
            if (p instanceof EmergencyPatient) {
                EmergencyPatient ep = (EmergencyPatient) p;
                System.out.println("Patient: " + ep.getFirstName() + " " + ep.getLastName() + " | Emergency Type: " + ep.getEmergencyType() + " | Arrival Mode: " + ep.getArrivalMode() + " | Triage Level: " + ep.getTriageLevel());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No emergency patients found.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("ReportService manages all hospital reports.");
    }

    @Override
    public void displaySummary() {
        System.out.println("Generate daily appointments, doctor performance, department occupancy, patient statistics, and emergency reports.");
    }
}
