package com.ideas2it.employeedetails.service.impl;

import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.exception.EmployeeRuntimeException;
import com.ideas2it.employeedetails.helper.TraineeHelper;
import com.ideas2it.employeedetails.model.Trainee;
import com.ideas2it.employeedetails.repository.TraineeRepository;
import com.ideas2it.employeedetails.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TraineeServiceImpl implements TraineeService {

    private final TraineeRepository traineeRepository;

    @Autowired
    public TraineeServiceImpl(TraineeRepository traineeRepository){
        this.traineeRepository = traineeRepository;
    }
    /**
     * <p>
     *     This method is used to set traineeDto objects to trainee.
     * </p>
     */
    public TraineeDto addTrainee(TraineeDto traineeDto) {
        return TraineeHelper.changeTraineeToDto(traineeRepository.save(TraineeHelper.changeDtoToTrainee(traineeDto)));
    }

    /**
     * <p>
     *     This method is used to get all trainee details from database.
     * </p>
     */
    public List<TraineeDto> getTraineeDetails() throws EmployeeRuntimeException {
        List<Trainee> trainees = traineeRepository.findAll();
        if(trainees.isEmpty()){
            throw new EmployeeRuntimeException("No Details Found Here!");
        } else {
            return trainees.stream().
                    map(trainee ->
                            TraineeHelper.changeTraineeToDto(trainee)
                    ).collect(Collectors.toList());
        }
    }

    /**
     * <p>
     *     This method is used to get a trainee details by Id(primary key in database)
     * </p>
     */
    public TraineeDto getTraineeDetailsById(int traineeId) {
        TraineeDto traineeDto = null;
        Optional<Trainee> trainee = traineeRepository.findById(traineeId);
        if(trainee.isPresent()) {
            traineeDto = TraineeHelper.changeTraineeToDto(trainee.get());
        }
        return traineeDto;
    }

    /**
     * <p>
     *     This method is used to delete a trainee details by Id.
     * </p>
     */
    public boolean deleteTraineeDetailsById(int traineeId) {
        Optional<Trainee> trainee = traineeRepository.findById(traineeId);
        if(trainee.isPresent()) {
            traineeRepository.delete(trainee.get());
            return true;
        }
        return false;
    }

    /**
     * <p>
     *     This method is used to update trainee details by Id.
     * </p>
     */
    public TraineeDto updateTraineeDetails(TraineeDto traineeDto) {
        return TraineeHelper.changeTraineeToDto(traineeRepository.save(TraineeHelper.changeDtoToTrainee(traineeDto)));
    }

    public Trainee getTraineeForTrainerService(int traineeId) {
        Optional<Trainee> traineeOptional = traineeRepository.findById(traineeId);
        Trainee trainee = null;
        if (traineeOptional.isPresent()) {
            trainee = traineeOptional.get();
            System.out.println("yes");
        }
        System.out.println("no");
        return trainee;
    }

}
