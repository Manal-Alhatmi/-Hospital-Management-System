package Entities;

import Utils.HelperUtils;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentId;
    private String departmentName;
    private String headDoctorId;
    private List<String> doctors = new ArrayList<>();
    private List<String> nurses = new ArrayList<>();
    private int bedCapacity;
    private int availableBeds;

    public Department(String departmentId, String departmentName, String headDoctorId, List<String> doctors, List<String> nurses, int bedCapacity, int availableBeds) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.headDoctorId = headDoctorId;
        this.doctors = doctors;
        this.nurses = nurses;
        this.bedCapacity = bedCapacity;
        this.availableBeds = availableBeds;
    }

    public Department(String deptId, String deptName, String headDoctorId, int bedCapacity) {
    }

    public Department() {

    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        if (HelperUtils.isValidString(departmentId))
            this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        if (HelperUtils.isValidString(departmentName, 3, 50))
            this.departmentName = departmentName;
    }

    public String getHeadDoctorId() {
        return headDoctorId;
    }

    public void setHeadDoctorId(String headDoctorId) {
        if (HelperUtils.isValidString(headDoctorId))
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
        if (HelperUtils.isValidNumber(bedCapacity, 1, 1000))
            this.bedCapacity = bedCapacity;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        if (HelperUtils.isValidNumber(availableBeds, 0, bedCapacity))
            this.availableBeds = availableBeds;
    }

    public void assignDoctor(String doctorId) {
        if (doctors == null) {
            doctors = new ArrayList<>();
        }
        if (HelperUtils.isValidString(doctorId) && !doctors.contains(doctorId)) {
            doctors.add(doctorId);
        }
    }


    public void assignNurse(String nurseId) {
        if (nurses == null) {
            nurses = new ArrayList<>();
        }
        if (HelperUtils.isValidString(nurseId) && !nurses.contains(nurseId)) {
            nurses.add(nurseId);
        }
    }

    public void updateBedAvailability(int newAvailableBeds) {
        if (HelperUtils.isValidNumber(newAvailableBeds, 0, bedCapacity)) {
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