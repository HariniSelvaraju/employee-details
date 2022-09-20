package com.ideas2it.employeedetails.helper;

import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.model.Trainer;

import org.springframework.stereotype.Component;


@Component
public class TrainerHelper {

    public static Trainer changeDtoToTrainer(TrainerDto trainerDto) {
        Trainer trainer = new Trainer(trainerDto.getId(),
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
        return trainer;
    }

    public static TrainerDto changeTrainerToDto(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto( trainer.getId(),
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
        return trainerDto;
    }
}