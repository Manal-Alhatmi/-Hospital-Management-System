package Main;

import Entities.*;
import Services.*;
import java.util.Scanner;

public class HospitalManagementApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addSampleDataForAll();
        int mainChoice = 0;
        while (mainChoice != 8) {
            System.out.println("\n Welcome to the Hospital Management System!");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Nurse Management");
            System.out.println("4. Appointment Management");
            System.out.println("5. Medical Records Management");
            System.out.println("6. Department Management");
            System.out.println("7. Reports and Statistics");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            mainChoice = scanner.nextInt();
            scanner.nextLine();

            if (mainChoice == 1) {
                patientMenu();
            } else if (mainChoice == 2) {
                doctorMenu();
            } else if (mainChoice == 3) {
                nurseMenu();
            } else if (mainChoice == 4) {
                appointmentMenu();
            } else if (mainChoice == 5) {
                medicalRecordMenu();
            } else if (mainChoice == 6) {
                departmentMenu();
            } else if (mainChoice == 7) {
                reportsMenu();
            } else if (mainChoice == 8) {
                System.out.println("Exiting system.. Goodbye!");
            } else {
                System.out.println("Invalid choice. Please try again");
            }
        }
    }


    private static void patientMenu() {
        int choice = 0;
        while (choice != 10) {
            System.out.println("\nPatient Management");
            System.out.println("1. Register New Patient");
            System.out.println("2. Register InPatient");
            System.out.println("3. Register OutPatient");
            System.out.println("4. Register Emergency Patient");
            System.out.println("5. View All Patients");
            System.out.println("6. Search Patient");
            System.out.println("7. Update Patient Information");
            System.out.println("8. Remove Patient");
            System.out.println("9. View Patient Medical History");
            System.out.println("10. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                PatientService.addPatient();
            } else if (choice == 2) {
                PatientService.addPatient();
            } else if (choice == 3) {
                PatientService.addPatient();
            } else if (choice == 4) {
                PatientService.addPatient();
            } else if (choice == 5) {
                PatientService.displayAllPatients();
            } else if (choice == 6) {
                PatientService.searchPatientsByName();
            } else if (choice == 7) {
                PatientService.editPatient();
            } else if (choice == 8) {
                PatientService.removePatient();
            } else if (choice == 9) {
                PatientService.viewPatientMedicalHistory();
            } else if (choice == 10) {
                System.out.println("Returning to Main Menu...");
            } else {
                System.out.println("Invalid choice");
            }
        }
    }


    private static void doctorMenu() {
        int choice = 0;
        while (choice != 11) {
            System.out.println("\nDoctor Management");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Surgeon");
            System.out.println("3. Add Consultant");
            System.out.println("4. Add General Practitioner");
            System.out.println("5. View All Doctors");
            System.out.println("6. Search Doctor by Specialization");
            System.out.println("7. View Available Doctors");
            System.out.println("8. Assign Patient to Doctor");
            System.out.println("9. Update Doctor Information");
            System.out.println("10. Remove Doctor");
            System.out.println("11. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
               DoctorService.addDoctor();
            } else if (choice == 2) {
                DoctorService.addDoctor();
            } else if (choice == 3) {
                DoctorService.addDoctor();
            } else if (choice == 4) {
                DoctorService.addDoctor();
            } else if (choice == 5) {
                DoctorService.displayAllDoctors();
            } else if (choice == 6) {
                DoctorService.searchDoctorBySpecialization();
            } else if (choice == 7) {
                DoctorService.viewAvailableDoctors();
            } else if (choice == 8) {
                DoctorService.assignPatientToDoctor();
            } else if (choice == 9) {
                DoctorService.editDoctor();
            } else if (choice == 10) {
                DoctorService.removeDoctor();
            } else if (choice == 11) {
                System.out.println("Returning to Main Menu...");
            } else {
                System.out.println("Invalid choice");
            }
        }
    }


    private static void nurseMenu() {
        int choice = 0;
        while (choice != 8) {
            System.out.println("\nNurse Management");
            System.out.println("1. Add Nurse");
            System.out.println("2. View All Nurses");
            System.out.println("3. View Nurses by Department");
            System.out.println("4. View Nurses by Shift");
            System.out.println("5. Assign Nurse to Patient");
            System.out.println("6. Update Nurse Information");
            System.out.println("7. Remove Nurse");
            System.out.println("8. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                NurseService.addNurse();
            } else if (choice == 2) {
                NurseService.displayAllNurses();
            } else if (choice == 3) {
                NurseService.viewNursesByDepartment();
            } else if (choice == 4) {
                NurseService.viewNursesByShift();
            } else if (choice == 5) {
                NurseService.assignNurseToPatient();
            } else if (choice == 6) {
                NurseService.editNurse();
            } else if (choice == 7) {
                NurseService.removeNurse();
            } else if (choice == 8) {
                System.out.println("Returning to Main Menu");
            } else {
                System.out.println("Invalid choice");
            }
        }
    }


    private static void appointmentMenu() {
        int choice = 0;
        while (choice != 10) {
            System.out.println("\nAppointment Management");
            System.out.println("1. Schedule New Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. View Appointments by Patient");
            System.out.println("4. View Appointments by Doctor");
            System.out.println("5. View Appointments by Date");
            System.out.println("6. Reschedule Appointment");
            System.out.println("7. Cancel Appointment");
            System.out.println("8. Complete Appointment");
            System.out.println("9. View Upcoming Appointments");
            System.out.println("10. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                AppointmentService.scheduleAppointment();
            } else if (choice == 2) {
                AppointmentService.displayAllAppointments();
            } else if (choice == 3) {
                AppointmentService.viewAppointmentsByPatient();
            } else if (choice == 4) {
                AppointmentService.viewAppointmentsByDoctor();
            } else if (choice == 5) {
                AppointmentService.viewAppointmentsByDate();
            } else if (choice == 6) {
                AppointmentService.rescheduleAppointment();
            } else if (choice == 7) {
                AppointmentService.cancelAppointment();
            } else if (choice == 8) {
                AppointmentService.completeAppointment();
            } else if (choice == 9) {
                AppointmentService.viewUpcomingAppointments();
            } else if (choice == 10) {
                System.out.println("Returning to Main Menu...");
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    private static void medicalRecordMenu() {
        int choice = 0;
        while (choice != 8) {
            System.out.println("\nMedical Records Management");
            System.out.println("1. Create Medical Record");
            System.out.println("2. View All Records");
            System.out.println("3. View Records by Patient");
            System.out.println("4. View Records by Doctor");
            System.out.println("5. Update Medical Record");
            System.out.println("6. Delete Medical Record");
            System.out.println("7. Generate Patient History Report");
            System.out.println("8. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                MedicalRecordService.createMedicalRecord();
            } else if (choice == 2) {
                MedicalRecordService.displayAllRecords();
            } else if (choice == 3) {
                MedicalRecordService.viewRecordsByPatient();
            } else if (choice == 4) {
                MedicalRecordService.viewRecordsByDoctor();
            } else if (choice == 5) {
                MedicalRecordService.updateMedicalRecord();
            } else if (choice == 6) {
                MedicalRecordService.deleteMedicalRecord();
            } else if (choice == 7) {
                MedicalRecordService.generatePatientHistoryReport();
            } else if (choice == 8) {
                System.out.println("Returning to Main Menu...");
            } else {
                System.out.println("Invalid choice");
            }
        }
    }


    private static void departmentMenu() {
        int choice = 0;
        while (choice != 8) {
            System.out.println("\n Department Management");
            System.out.println("1. Add Department");
            System.out.println("2. View All Departments");
            System.out.println("3. View Department Details");
            System.out.println("4. Assign Doctor to Department");
            System.out.println("5. Assign Nurse to Department");
            System.out.println("6. Update Department Information");
            System.out.println("7. View Department Statistics");
            System.out.println("8. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                DepartmentService.addDepartment();
            } else if (choice == 2) {
                DepartmentService.displayAllDepartments();
            } else if (choice == 3) {
                DepartmentService.viewDepartmentDetails();
            } else if (choice == 4) {
                DepartmentService.assignDoctorToDepartment();
            } else if (choice == 5) {
                DepartmentService.assignNurseToDepartment();
            } else if (choice == 6) {
                DepartmentService.editDepartment();
            } else if (choice == 7) {
                DepartmentService.viewDepartmentStatistics();
            } else if (choice == 8) {
                System.out.println("Returning to Main Menu...");
            } else {
                System.out.println("Invalid choice");
            }
        }
    }


    private static void reportsMenu() {
        int choice = 0;
        while (choice != 6) {
            System.out.println("\n Reports and Statistics");
            System.out.println("1. Daily Appointments Report");
            System.out.println("2. Doctor Performance Report");
            System.out.println("3. Department Occupancy Report");
            System.out.println("4. Patient Statistics");
            System.out.println("5. Emergency Cases Report");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                ReportService.dailyAppointmentsReport();
            } else if (choice == 2) {
                ReportService.doctorPerformanceReport();
            } else if (choice == 3) {
                ReportService.departmentOccupancyReport();
            } else if (choice == 4) {
                ReportService.patientStatistics();
            } else if (choice == 5) {
                ReportService.emergencyCasesReport();
            } else if (choice == 6) {
                System.out.println("Returning to Main Menu");
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
    public static void addSampleDataForAll() {
        DepartmentService.addSampleDepartments();
        DoctorService.addSampleDoctors();
        NurseService.addSampleNurses();
        PatientService.addSamplePatients();
        AppointmentService.addSampleAppointments();
        MedicalRecordService.addSampleMedicalRecords();
        linkSampleData();
    }

    public static void linkSampleData() {
        for (int i = 0; i < DoctorService.doctorList.size(); i++) {
            Doctor doctor = DoctorService.doctorList.get(i);
            Department dept = DepartmentService.departmentList.get(i % DepartmentService.departmentList.size());
            doctor.setDepartmentId(dept.getDepartmentId());
            dept.getDoctors().add(doctor.getDoctorId());
        }
        for (int i = 0; i < NurseService.nurseList.size(); i++) {
            Nurse nurse = NurseService.nurseList.get(i);
            Department dept = DepartmentService.departmentList.get(i % DepartmentService.departmentList.size());
            nurse.setDepartmentId(dept.getDepartmentId());
            dept.getNurses().add(nurse.getNurseId());
        }
        for (int i = 0; i < PatientService.patientList.size(); i++) {
            Patient patient = PatientService.patientList.get(i);
            Doctor doctor = DoctorService.doctorList.get(i % DoctorService.doctorList.size());
            doctor.getAssignedPatients().add(patient.getPatientId());

            Nurse nurse = NurseService.nurseList.get(i % NurseService.nurseList.size());
            nurse.getAssignedPatients().add(patient.getPatientId());

            if (patient instanceof InPatient inPatient) {
                inPatient.setAdmittingDoctorId(doctor.getDoctorId());
            } else if (patient instanceof EmergencyPatient emergencyPatient) {
                emergencyPatient.setAdmittingDoctorId(doctor.getDoctorId());
            } else if (patient instanceof OutPatient outPatient) {
                outPatient.setPreferredDoctorId(doctor.getDoctorId());
            }
        }
        System.out.println(" linking completed successfully");
    }
}
