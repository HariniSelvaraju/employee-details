package com.ideas2it.employeedetails.service;

import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.exception.EmployeeRuntimeException;
import com.ideas2it.employeedetails.model.Trainee;

import java.util.List;

/**
 * Deals with the trainee business logics.
 */
public interface TraineeService {
    TraineeDto addTrainee(TraineeDto traineeDto);

    List<TraineeDto> getTraineeDetails() ;

    TraineeDto getTraineeDetailsById(int traineeId);

    boolean deleteTraineeDetailsById(int traineeId);

    TraineeDto updateTraineeDetails(TraineeDto traineeDto);

    Trainee getTraineeForTrainerService(int traineeId);
}
