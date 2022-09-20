package com.ideas2it.employeedetails.service.impl;

import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.exception.EmployeeRuntimeException;
import com.ideas2it.employeedetails.helper.TrainerHelper;
import com.ideas2it.employeedetails.model.Trainer;
import com.ideas2it.employeedetails.repository.TrainerRepository;
import com.ideas2it.employeedetails.service.TrainerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainerServiceImpl implements TrainerService {
    private TrainerRepository trainerRepository;
    private TrainerHelper trainerHelper;
    private TrainerDto trainerDto;

     @Autowired
     public TrainerServiceImpl(TrainerRepository trainerRepository, TrainerDto trainerDto, TrainerHelper trainerHelper){
         this.trainerRepository = trainerRepository;
         this.trainerDto = trainerDto;
         this.trainerHelper = trainerHelper;
     }
    /**
     *
     * This method is used to set traineeDto objects to trainee.
     *
     * @param {@link TrainerDto} trainerDto
     *
     * @return void
     */
    public TrainerDto addTrainer(TrainerDto trainerDto) {
        return TrainerHelper.changeTrainerToDto(trainerRepository.save(TrainerHelper.changeDtoToTrainer(trainerDto)));
    }

    /**
     *
     * This method is used to get all trainee details from database.
     *
     * @return {@link List<TrainerDto>}
     */
    public List<TrainerDto> getTrainerDetails() throws EmployeeRuntimeException {
        List<Trainer> trainers = trainerRepository.findAll();
        if(trainers.isEmpty()){
            throw new EmployeeRuntimeException("No Details Found Here!");
        } else {
            return trainers.stream().
                    map(trainer -> {
                        return TrainerHelper.changeTrainerToDto(trainer);
                    }).collect(Collectors.toList());
        }
    }

    /**
     *
     * This method is used to get a trainee details by Id(primary key in database)
     *
     * @param {@link int} id
     *
     * @return {@link TrainerDto}
     */
    public TrainerDto getTrainerDetailsById(int id) {
        Trainer trainer = trainerRepository.findById(id).get();
        return TrainerHelper.changeTrainerToDto(trainer);
    }

    /**
     * This method is used to delete a trainee details by Id(primary key in database)
     *
     * @param {@link int} id
     *
     * @return {@link boolean}
     */
    public boolean deleteTrainerDetailsById(int id) {
        Optional<Trainer> trainer = trainerRepository.findById(id);
        if(trainer != null) {
            trainerRepository.delete(trainer.get());
            return true;
        }
        return false;
    }

    /**
     *
     * This method is used to update trainee details
     *
     * @param {@link int} id
     *
     * @param {@link TrainerDto} trainerDto
     *
     * @return {@link TrainerDto}
     */
    public TrainerDto updateTrainerDetails(TrainerDto trainerDto) {
        return TrainerHelper.changeTrainerToDto(trainerRepository.save(TrainerHelper.changeDtoToTrainer(trainerDto)));
    }
}

