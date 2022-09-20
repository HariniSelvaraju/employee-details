package com.ideas2it.employeedetails.service;

import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.exception.EmployeeRuntimeException;

import java.util.HashMap;
import java.util.List;

public interface TraineeService {

    /**
     * method is used to add Trainee
     * @param {@link TraineeDto} traineeDto
     * @return void
     */
    void addTrainee(TraineeDto traineeDto);

    /**
     * method is used to get the list of all the trainee from Dao
     * @return {@link List <TraineeDto>}
     */
    List<TraineeDto> getTraineeDetails() throws EmployeeRuntimeException;

    /**
     * method is used to add Trainee
     * @param {@link String} traineeDto
     * @return {@link TraineeDto}
     */
    TraineeDto getTraineeDetailsById(int id);

    /**
     * method is used to add Trainee
     * @param {@link Trainee} trainee
     * @return {@link boolean}
     */
    boolean deleteTraineeDetailsById(int id);

    /**
     * method is used to add Trainee
     * @param {@link String} traineeId
     * @param {@link TraineeDto} traineeDto
     * @param {@link HashMap<String, String>} traineeMap
     * @return {@link boolean}
     */
     TraineeDto updateTraineeById(TraineeDto traineeDto);
}
