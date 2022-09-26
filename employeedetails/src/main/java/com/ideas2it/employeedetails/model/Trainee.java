package com.ideas2it.employeedetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="trainee")
public class Trainee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id",nullable = false)
    private int trainerId;

    @Column(name = "trainee_id",nullable = false)
    private String employeeId;

    @Column(name = "trainee_name",nullable = false)
    private String traineeName;

    @Column(name = "designation")
    private String designation;

    @Column(name = "contact_number")
    private Long contactNumber;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "cgpa")
    private Float cgpa;

    @Column(name = "gender")
    private String gender;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "batch")
    private int batch;

    @ManyToMany(mappedBy="trainees")
    private List<Trainer> trainers = new ArrayList<>();

    public Trainee(){}

    public Trainee(int trainerId, String employeeId, String traineeName, String designation,
                   Long contactNumber, String emailId, LocalDate dateOfBirth,
                   String address, Float cgpa, String gender, String bloodGroup,
                   String maritalStatus, String taskName, int batch) {
        this.trainerId = trainerId;
        this.employeeId = employeeId;
        this.traineeName = traineeName;
        this.designation = designation;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.cgpa = cgpa;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.maritalStatus = maritalStatus;
        this.taskName = taskName;
        this.batch = batch;
    }

    public void setId(int trainerId) {
        this.trainerId = trainerId;
    }

    public int getId() {
        return trainerId;
    }

    public void setTraineeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTraineeId() {
        return employeeId ;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getBatch() {
        return batch;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }
}

