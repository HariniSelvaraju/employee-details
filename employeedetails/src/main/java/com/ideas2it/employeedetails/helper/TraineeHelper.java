package com.ideas2it.employeedetails.helper;

import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.model.Trainee;
import com.ideas2it.employeedetails.model.Trainer;

import java.util.List;

public class TraineeHelper {
    /**
     * <p>
     *     this method is to convert TraineeDto to Trainee
     * </p>
     */
    public static Trainee changeDtoToTrainee(TraineeDto traineeDto) {
        return new Trainee(traineeDto.getId(),
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
    }

    /**
     * <p>
     *     this method is to convert Trainee to TraineeDto
     * </p>
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
        List<Trainer> trainers = trainee.getTrainers();
        if (!trainers.isEmpty()) {
            for (Trainer trainer : trainers) {
                traineeDto.getTrainersDto().add(convertTrainerWithAssociation(trainer));
            }
        }
        return traineeDto;
    }

    public static TrainerDto convertTrainerWithAssociation(Trainer trainer) {
        return new TrainerDto(trainer.getId(),
                trainer.getTrainerId(),
                trainer.getTrainerName(),
                trainer.getDesignation(),
                trainer.getContactNumber(),
                trainer.getEmailId(),
                trainer.getDateOfBirth(),
                trainer.getAddress(),
                trainer.getCgpa(),
                trainer.getGender(),
                trainer.getBloodGroup(),
                trainer.getMaritalStatus(),
                trainer.getExperience());
    }
}
