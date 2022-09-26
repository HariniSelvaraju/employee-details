package com.ideas2it.employeedetails.service;

import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.exception.EmployeeRuntimeException;

import java.util.List;

/**
 * Deals with the trainer business logics.
 */
public interface TrainerService {
    TrainerDto addTrainer(TrainerDto trainerDto);

    List<TrainerDto> getTrainerDetails() throws EmployeeRuntimeException;

    TrainerDto getTrainerDetailsById(int trainerId);

    boolean deleteTrainerDetailsById(int trainerId);

    TrainerDto updateTrainerDetails(TrainerDto trainerDto);

    void associateTrainerToTrainees(int trainerId, int traineeId);

}
