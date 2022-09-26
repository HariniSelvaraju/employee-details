package com.ideas2it.employeedetails.service.impl;

import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.helper.TrainerHelper;
import com.ideas2it.employeedetails.model.Trainee;
import com.ideas2it.employeedetails.model.Trainer;
import com.ideas2it.employeedetails.repository.TrainerRepository;
import com.ideas2it.employeedetails.service.TraineeService;
import com.ideas2it.employeedetails.service.TrainerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainerServiceImpl implements TrainerService {
    private final TrainerRepository trainerRepository;
    private final TraineeService traineeService;

     @Autowired
     public TrainerServiceImpl(TrainerRepository trainerRepository, TraineeService traineeService){
         this.trainerRepository = trainerRepository;
         this.traineeService = traineeService;
     }
    /**
     * <p>
     *     This method is used to set traineeDto objects to trainee.
     * </p>
     */
    public TrainerDto addTrainer(TrainerDto trainerDto) {
        return TrainerHelper.changeTrainerToDto(trainerRepository.save(TrainerHelper.changeDtoToTrainer(trainerDto)));
    }

    /**
     * <p>
     *     This method is used to get all trainee details from database.
     * </p>
     */
    public List<TrainerDto> getTrainerDetails() {
        final Logger LOG = LoggerFactory.getLogger(TrainerServiceImpl.class);
        List<Trainer> trainers = trainerRepository.findAll();
        if(trainers.isEmpty()){
            LOG.info("There is no Trainer Details Present");
        }
        return trainers.stream().
                map(trainer -> TrainerHelper.changeTrainerToDto(trainer)
                ).collect(Collectors.toList());
    }

    /**
     * <p>
     *     This method is used to get a trainee details by Id(primary key in database)
     * </p>
     */
    public TrainerDto getTrainerDetailsById(int trainerId) {
        TrainerDto trainerDto = null;
        Optional<Trainer> trainer = trainerRepository.findById(trainerId);
        if(trainer.isPresent()) {
            trainerDto = TrainerHelper.changeTrainerToDto(trainer.get());
        }
        return trainerDto;
    }

    /**
     * <p>
     *     This method is used to delete a trainee details by Id(primary key in database)
     * </p>
     */
    public boolean deleteTrainerDetailsById(int trainerId) {
        Optional<Trainer> trainer = trainerRepository.findById(trainerId);
        if(trainer.isPresent()) {
            trainerRepository.delete(trainer.get());
            return true;
        }
        return false;
    }

    /**
     * <p>
     *     This method is used to update trainee details
     * </p>
     */
    public TrainerDto updateTrainerDetails(TrainerDto trainerDto) {
        return TrainerHelper.changeTrainerToDto(trainerRepository.save(TrainerHelper.changeDtoToTrainer(trainerDto)));
    }

    @Override
    public void associateTrainerToTrainees(int trainerId, int traineeId) {
        Optional<Trainer> trainer = trainerRepository.findById(trainerId);
        if (trainer.isPresent()) {
            Trainer trainer_details = trainer.get();
            Trainee trainee = traineeService.getTraineeForTrainerService(traineeId);
            if (trainee != null) {
                trainer_details.getTrainees().add(trainee);
                trainerRepository.save(trainer_details);
            }
        }
    }
}

