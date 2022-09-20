package com.ideas2it.employeedetails.service;

import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.exception.EmployeeRuntimeException;

import java.util.List;

public interface TrainerService {
    /**
     * method is used to add Trainer
     *
     * @param {@link TrainerDto} trainerDto
     *
     * @return void
     */
    TrainerDto addTrainer(TrainerDto trainerDto);

    /**
     * method is used to get the list of all the trainer from Dao
     *
     * @return {@link List<TrainerDto>}
     */
    List<TrainerDto> getTrainerDetails() throws EmployeeRuntimeException;

    /**
     * method is used to add Trainer
     *
     * @param {@link int} trainerDto
     *
     * @return {@link TrainerDto}
     */
    TrainerDto getTrainerDetailsById(int id);

    /**
     * method is used to add Trainer
     *
     * @param {@link Trainer} trainer
     *
     * @return {@link boolean}
     */
    boolean deleteTrainerDetailsById(int id);

    /**
     * method is used to add Trainer
     *
     * @param {@link TrainerDto} trainerDto
     *
     * @return {@link TrainerDto}
     */
    TrainerDto updateTrainerDetails(TrainerDto trainerDto);

}
