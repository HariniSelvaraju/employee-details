package com.ideas2it.employeedetails.helper;

import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.model.Trainee;
import com.ideas2it.employeedetails.model.Trainer;

import java.util.List;

public class TrainerHelper {


    /**
     * <p>
     *     this method is to convert TrainerDto to Trainer
     * </p>
     */
    public static Trainer changeDtoToTrainer(TrainerDto trainerDto) {
        return new Trainer(trainerDto.getId(),
                trainerDto.getTrainerId(),
                trainerDto.getTrainerName(),
                trainerDto.getDesignation(),
                trainerDto.getContactNumber(),
                trainerDto.getEmailId(),
                trainerDto.getDateOfBirth(),
                trainerDto.getAddress(),
                trainerDto.getCgpa(),
                trainerDto.getGender(),
                trainerDto.getBloodGroup(),
                trainerDto.getMaritalStatus(),
                trainerDto.getExperience());
    }


    /**
     * <p>
     *     this method is to convert Trainer to TrainerDto
     * </p>
     */
    public static TrainerDto changeTrainerToDto(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto(trainer.getId(),
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
        List<Trainee> trainees = trainer.getTrainees();
        if (!trainees.isEmpty()) {
            for (Trainee trainee : trainees) {
                trainerDto.getTraineesDto().add(convertTraineeWithAssociation(trainee));
            }
        }
        return trainerDto;
    }
    public static TraineeDto convertTraineeWithAssociation(Trainee trainee) {
        return new TraineeDto(trainee.getId(),
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
    }
}