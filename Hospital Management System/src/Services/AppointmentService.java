package Services;

import Entities.Appointment;
import Utils.InputHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentService {
    static ArrayList<Appointment> appointmentList = new ArrayList<>();


    public static Appointment addInput() {
        System.out.println("\nSchedule New Appointment");

        String patientId = InputHandler.getStringInput("Enter Patient ID: ");
        String doctorId = InputHandler.getStringInput("Enter Doctor ID: ");
        LocalDate date = InputHandler.getDateInput("Enter Appointment Date (YYYY-MM-DD): ");
        String time = InputHandler.getStringInput("Enter Appointment Time : ");
        String reason = InputHandler.getStringInput("Enter Reason for Visit: ");
        String notes = InputHandler.getStringInput("Enter Notes: ");

        String appointmentId = "APP-" + (appointmentList.size() + 1);

        return new Appointment(appointmentId, patientId, doctorId, date, time, "Scheduled", reason, notes);
    }

    public static void save(Appointment appointment) {
        if (appointment != null) {
            appointmentList.add(appointment);
            System.out.println("Appointment saved successfully with ID: " + appointment.getAppointmentId());
        } else {
            System.out.println("Invalid appointment data, not saved.");
        }
    }

    public static void scheduleAppointment() {
        Appointment newApp = addInput();
        save(newApp);
    }


    public static Appointment createAppointment(String patientId, String doctorId, LocalDate date) {
        String appointmentId = "APP-" + (appointmentList.size() + 1);
        Appointment app = new Appointment(appointmentId, patientId, doctorId, date, "09:00", "Scheduled", "General Checkup", "");
        appointmentList.add(app);
        System.out.println("Appointment created (basic info).");
        return app;
    }

    public static Appointment createAppointment(String patientId, String doctorId, LocalDate date, String time) {
        String appointmentId = "APP-" + (appointmentList.size() + 1);
        Appointment app = new Appointment(appointmentId, patientId, doctorId, date, time, "Scheduled", "General", "");
        appointmentList.add(app);
        System.out.println("Appointment created with time specified");
        return app;
    }

    public static void createAppointment(Appointment appointment) {
        if (appointment != null) {
            appointmentList.add(appointment);
            System.out.println("Appointment created from full object");
        } else {
            System.out.println("Invalid appointment object");
        }
    }

    public static void rescheduleAppointment() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Appointment ID: ");
        String appointmentId = sc.nextLine();

        System.out.print("Enter new date (yyyy-MM-dd): ");
        LocalDate newDate = LocalDate.parse(sc.nextLine());

        System.out.print("Enter new time (HH:mm): ");
        String newTime = sc.nextLine();

        rescheduleAppointment(appointmentId, newDate, newTime);
    }


    public void rescheduleAppointment(String appointmentId, LocalDate newDate) {
        Appointment app = getAppointmentById(appointmentId);
        if (app != null) {
            app.reschedule(newDate, app.getAppointmentTime());
            System.out.println("Appointment rescheduled to new date: " + newDate);
        } else {
            System.out.println("Appointment not found.");
        }
    }

    public static void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime) {
        Appointment app = getAppointmentById(appointmentId);
        if (app != null) {
            app.reschedule(newDate, newTime);
            System.out.println("Appointment rescheduled to: " + newDate + " at " + newTime);
        } else {
            System.out.println("Appointment not found");
        }
    }

    public void rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason) {
        if (appointment != null) {
            appointment.reschedule(newDate, newTime);
            appointment.addNotes("Rescheduled Reason: " + reason, "System", LocalDateTime.now());
            System.out.println("Appointment rescheduled with reason: " + reason);
        } else {
            System.out.println("Invalid appointment provided");
        }
    }

    public static void displayAppointments(LocalDate date) {
        boolean found = false;
        for (Appointment app : appointmentList) {
            if (app.getAppointmentDate().equals(date)) {
                app.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No appointments found for: " + date);
    }

    public static void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate) {
        boolean found = false;
        for (Appointment app : appointmentList) {
            if (app.getDoctorId().equalsIgnoreCase(doctorId) && !app.getAppointmentDate().isBefore(startDate) && !app.getAppointmentDate().isAfter(endDate)) {
                app.displayInfo();
                found = true;
            }
        }
        if (!found)
            System.out.println("No appointments found for doctor " + doctorId + " between " + startDate + " and " + endDate);
    }


    public static void displayAllAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment app : appointmentList) {
            app.displayInfo();
        }
    }

    public static void viewAppointmentsByPatient() {
        String pid = InputHandler.getStringInput("Enter Patient ID: ");
        boolean found = false;

        for (Appointment app : appointmentList) {
            if (app.getPatientId().equalsIgnoreCase(pid)) {
                app.displayInfo();
                found = true;
            }
        }

        if (!found) System.out.println("No appointments found for that patient.");
    }

    public static void viewAppointmentsByDoctor() {
        String did = InputHandler.getStringInput("Enter Doctor ID: ");
        boolean found = false;

        for (Appointment app : appointmentList) {
            if (app.getDoctorId().equalsIgnoreCase(did)) {
                app.displayInfo();
                found = true;
            }
        }

        if (!found) System.out.println("No appointments found for that doctor.");
    }

    public static void viewAppointmentsByDate() {
        LocalDate date = InputHandler.getDateInput("Enter Appointment Date (YYYY-MM-DD): ");
        boolean found = false;

        for (Appointment app : appointmentList) {
            if (app.getAppointmentDate().equals(date)) {
                app.displayInfo();
                found = true;
            }
        }

        if (!found) System.out.println("No appointments found for that date.");
    }

    public static void viewUpcomingAppointments() {
        LocalDate today = LocalDate.now();
        boolean found = false;

        System.out.println("\nUpcoming Appointments (from " + today + " onwards)");
        for (Appointment a : appointmentList) {
            if (!a.getAppointmentDate().isBefore(today) && a.getStatus().equalsIgnoreCase("Scheduled")) {
                a.displayInfo();
                found = true;
            }
        }

        if (!found) System.out.println("No upcoming appointments found.");
    }

    public static void cancelAppointment() {
        String id = InputHandler.getStringInput("Enter Appointment ID to cancel: ");
        Appointment app = getAppointmentById(id);

        if (app != null) {
            app.cancel();
            System.out.println("Appointment cancelled successfully.");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    public static void completeAppointment() {
        String id = InputHandler.getStringInput("Enter Appointment ID to mark as completed: ");
        Appointment app = getAppointmentById(id);

        if (app != null) {
            app.complete();
            System.out.println("Appointment marked as completed.");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    public static void deleteAppointment() {
        String id = InputHandler.getStringInput("Enter Appointment ID to delete: ");
        boolean found = false;

        for (int i = 0; i < appointmentList.size(); i++) {
            Appointment app = appointmentList.get(i);
            if (app.getAppointmentId().equalsIgnoreCase(id)) {
                appointmentList.remove(i);
                found = true;
                System.out.println("Appointment deleted successfully.");
                break;
            }
        }

        if (!found) System.out.println("Appointment not found.");
    }

    public static Appointment getAppointmentById(String id) {
        for (Appointment app : appointmentList) {
            if (app.getAppointmentId().equalsIgnoreCase(id))
                return app;
        }
        return null;
    }

}
