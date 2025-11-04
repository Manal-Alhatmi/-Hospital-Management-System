package Entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentId;
    private String departmentName;
    private String headDoctorId;
    private List<String> doctors;
    private List<String> nurses;
    private int bedCapacity;
    private int availableBeds;

    public Department(String departmentId, String departmentName, String headDoctorId,
                      List<String> doctors, List<String> nurses, int bedCapacity, int availableBeds) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headDoctorId = headDoctorId;
        this.doctors = (doctors != null) ? doctors : new ArrayList<>();
        this.nurses = (nurses != null) ? nurses : new ArrayList<>();
        this.bedCapacity = bedCapacity;
        this.availableBeds = availableBeds;
    }

    public Department(String departmentId, String departmentName, String headDoctorId, int bedCapacity) {
        this(departmentId, departmentName, headDoctorId, null, null, bedCapacity, bedCapacity);
    }


    public String getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHeadDoctorId() {
        return headDoctorId;
    }
    public void setHeadDoctorId(String headDoctorId) {
        this.headDoctorId = headDoctorId;
    }

    public List<String> getDoctors() {
        return doctors;
    }
    public List<String> getNurses() {
        return nurses;
    }

    public int getBedCapacity() {
        return bedCapacity;
    }
    public void setBedCapacity(int bedCapacity) {
        this.bedCapacity = bedCapacity;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }
    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }

    public void assignDoctor(String doctorId) {
        if (doctorId != null && !doctors.contains(doctorId))
            doctors.add(doctorId);
    }

    public void assignNurse(String nurseId) {
        if (nurseId != null && !nurses.contains(nurseId))
            nurses.add(nurseId);
    }

    public void updateBedAvailability(int newAvailableBeds) {
        if (newAvailableBeds >= 0 && newAvailableBeds <= bedCapacity) {
            this.availableBeds = newAvailableBeds;
        }
    }

    public void displayInfo() {
        System.out.println("Department ID: " + departmentId);
        System.out.println("Name: " + departmentName);
        System.out.println("Head Doctor ID: " + headDoctorId);
        System.out.println("Doctors: " + doctors);
        System.out.println("Nurses: " + nurses);
        System.out.println("Bed Capacity: " + bedCapacity);
        System.out.println("Available Beds: " + availableBeds);
    }
}
