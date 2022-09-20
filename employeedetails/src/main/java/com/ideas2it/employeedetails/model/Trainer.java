package com.ideas2it.employeedetails.model;

import com.ideas2it.employeedetails.constant.EmployeeConstants;

import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table(name ="trainer")
public class Trainer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "trainer_id",nullable = false)
    private String trainerId;

    @Column(name = "trainer_name",nullable = false)
    private String trainerName;

    @Column
    private String designation;

    @Column(name = "contact_number")
    private Long contactNumber;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column
    private String address;

    @Column
    private Float cgpa;

    @Column
    private String gender;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column
    private int experience;

    public Trainer() {}

    public Trainer(int id,String trainerId, String trainerName, String designation,
                   Long contactNumber,String emailId, LocalDate dateOfBirth,
                   String address,Float cgpa, String gender,
                   String bloodGroup,String maritalStatus, int experience) {
        this.id = id;
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.designation = designation;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.cgpa = cgpa;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.maritalStatus = maritalStatus;
        this.experience = experience;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerId() {
        return trainerId ;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
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

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }
}
