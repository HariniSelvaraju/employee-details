package com.ideas2it.employeedetails.service;

import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.exception.EmployeeRuntimeException;

import java.util.List;

public interface TraineeService {

    /**
     * method is used to add Trainee
     *
     * @param {@link TraineeDto} traineeDto
     *
     * @return void
     */
    void addTrainee(TraineeDto traineeDto);

    /**
     * method is used to get the list of all the trainee from Repository
     *
     * @return {@link List<TraineeDto>}
     */
    List<TraineeDto> getTraineeDetails() throws EmployeeRuntimeException;

    /**
     * method is used to add Trainee
     *
     * @param {@link int} traineeDto
     *
     * @return {@link TraineeDto}
     */
    TraineeDto getTraineeDetailsById(int id);

    /**
     * method is used to add Trainee
     *
     * @param {@link Trainee} trainee
     *
     * @return {@link boolean}
     */
    boolean deleteTraineeDetailsById(int id);

    /**
     * method is used to add Trainee
     *
     * @param {@link TraineeDto} traineeDto
     *
     * @return {@link TraineeDto}
     */
     TraineeDto updateTraineeDetails(TraineeDto traineeDto);
}
