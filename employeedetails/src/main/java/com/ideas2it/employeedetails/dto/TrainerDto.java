package com.ideas2it.employeedetails.dto;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
public class TrainerDto {
    private int idTrainer;
    private String trainerId;
    private String trainerName;
    private String designation;
    private Long contactNumber;
    private String emailId;
    private LocalDate dateOfBirth;
    private String address;
    private Float cgpa;
    private String gender;
    private String bloodGroup;
    private String maritalStatus;
    private int experience;
    private List<TraineeDto> traineesDto = new ArrayList<>();

    public TrainerDto(int idTrainer,String trainerId, String trainerName, String designation,
                      Long contactNumber, String emailId, LocalDate dateOfBirth,
                      String address, Float cgpa, String gender, String bloodGroup,
                      String maritalStatus, int experience) {
        this.idTrainer = idTrainer;
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

    public int getId() {
        return idTrainer;
    }

    public void setId(int idTrainer) {
        this.idTrainer = idTrainer;
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

    public List<TraineeDto> getTraineesDto() {
        return traineesDto;
    }

    public void setTraineesDto(List<TraineeDto> traineesDto) {
        this.traineesDto = traineesDto;
    }

}