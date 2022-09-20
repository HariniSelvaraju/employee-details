package com.ideas2it.employeedetails.helper;

import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.model.Trainee;

import org.springframework.stereotype.Component;

@Component
public class TraineeHelper {
    /**
     * this method is to convert TrainerDto to Trainer
     *
     * @param traineeDto
     *
     * @return Trainee
     */
    public static Trainee changeDtoToTrainee(TraineeDto traineeDto) {
        Trainee trainee = new Trainee(traineeDto.getId(),
                traineeDto.getTraineeId(),
                traineeDto.getTraineeName(),
                traineeDto.getDesignation(),
                traineeDto.getContactNumber(),
                traineeDto.getEmailId(),
                traineeDto.getDateOfBirth(),
                traineeDto.getAddress(),
                traineeDto.getCgpa(),
                traineeDto.getGender(),
                traineeDto.getBloodGroup(),
                traineeDto.getMaritalStatus(),
                traineeDto.getTaskName(),
                traineeDto.getBatch());
        return trainee;
    }

    /**
     * this method is to convert Trainer to TrainerDto
     *
     * @param trainee
     *
     * @return TraineeDto
     */
    public static TraineeDto changeTraineeToDto(Trainee trainee ) {
        TraineeDto traineeDto = new TraineeDto(trainee.getId(),
                trainee.getTraineeId(),
                trainee.getTraineeName(),
                trainee.getDesignation(),
                trainee.getContactNumber(),
                trainee.getEmailId(),
                trainee.getDateOfBirth(),
                trainee.getAddress(),
                trainee.getCgpa(),
                trainee.getGender(),
                trainee.getBloodGroup(),
                trainee.getMaritalStatus(),
                trainee.getTaskName(),
                trainee.getBatch());
        return traineeDto;
    }
}
