package com.ideas2it.employeedetails.service.impl;

import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.exception.EmployeeRuntimeException;
import com.ideas2it.employeedetails.helper.TraineeHelper;
import com.ideas2it.employeedetails.helper.TrainerHelper;
import com.ideas2it.employeedetails.model.Trainee;
import com.ideas2it.employeedetails.model.Trainer;
import com.ideas2it.employeedetails.repository.TraineeRepository;
import com.ideas2it.employeedetails.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TraineeServiceImpl implements TraineeService {
    private TraineeRepository traineeRepository;
    private TraineeHelper traineeHelper;
    private TraineeDto traineeDto;

    @Autowired
    public TraineeServiceImpl(TraineeRepository traineeRepository, TraineeDto traineeDto, TraineeHelper traineeHelper){
        this.traineeRepository = traineeRepository;
        this.traineeDto = traineeDto;
        this.traineeHelper = traineeHelper;
    }
    /**
     *
     * This method is used to set traineeDto objects to trainee.
     *
     * @param {@link TraineeDto} traineeDto
     *
     * @return void
     */
    public void addTrainee(TraineeDto traineeDto) {
        traineeRepository.save(TraineeHelper.changeDtoToTrainee(traineeDto));
    }

    /**
     *
     * This method is used to get all trainee details from database.
     *
     * @return {@link List<TraineeDto>}
     */
    public List<TraineeDto> getTraineeDetails() throws EmployeeRuntimeException {
        List<Trainee> trainees = traineeRepository.findAll();
        if(trainees.isEmpty()){
            throw new EmployeeRuntimeException("No Details Found Here!");
        } else {
            return trainees.stream().
                    map(trainee -> {
                        return TraineeHelper.changeTraineeToDto(trainee);
                    }).collect(Collectors.toList());
        }
    }

    /**
     *
     * This method is used to get a trainee details by Id(primary key in database)
     *
     * @param {@link String} TrainerId
     *
     * @return {@link TraineeDto}
     */
    public TraineeDto getTraineeDetailsById(int id) {
        Trainee trainee = traineeRepository.findById(id).get();
        return TraineeHelper.changeTraineeToDto(trainee);
    }

    /**
     * This method is used to delete a trainee details by Id.
     *
     * @param {@link int} TrainerId
     * @return {@link boolean}
     */
    public boolean deleteTraineeDetailsById(int id) {
        Optional<Trainee> trainee = traineeRepository.findById(id);
        if(trainee.isPresent()) {
            traineeRepository.delete(trainee.get());
            return true;
        }
        return false;
    }

    /**
     *
     * This method is used to update trainee details by Id.
     *
     * @param {@link int} id
     * @param {@link TraineeDto} traineeDto
     *
     * @return boolean
     */
    public TraineeDto updateTraineeDetails(TraineeDto traineeDto) {
        return TraineeHelper.changeTraineeToDto(traineeRepository.save(TraineeHelper.changeDtoToTrainee(traineeDto)));
    }


}
