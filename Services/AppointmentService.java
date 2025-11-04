package Services;

import Entities.Appointment;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;

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

        System.out.println("\n Upcoming Appointments (from " + today + " onwards)");
        for (Appointment a : appointmentList) {
            if (!a.getAppointmentDate().isBefore(today) && a.getStatus().equalsIgnoreCase("Scheduled")) {
                a.displayInfo();
                found = true;
            }
        }

        if (!found) System.out.println("No upcoming appointments found.");
    }

    public static void rescheduleAppointment() {
        String id = InputHandler.getStringInput("Enter Appointment ID to reschedule: ");
        Appointment app = getAppointmentById(id);

        if (app != null) {
            LocalDate newDate = InputHandler.getDateInput("Enter new Date (YYYY-MM-DD): ");
            String newTime = InputHandler.getStringInput("Enter new Time: ");
            app.reschedule(newDate, newTime);
            System.out.println("Appointment rescheduled successfully.");
        } else {
            System.out.println("Appointment not found.");
        }
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
