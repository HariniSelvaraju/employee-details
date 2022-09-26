package com.ideas2it.employeedetails.controller;

import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.service.TrainerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    /**
     * <p>
     * this method is to add Trainer details to database
     * </p>
     */
    @PostMapping
    public TrainerDto insertTrainer(@RequestBody TrainerDto trainerDto){
        return trainerService.addTrainer(trainerDto);
    }

    /**
     * <p>
     * this method is to get Trainer By Id(primary key).
     * </p>
     */
    @GetMapping("/{id}")
    public TrainerDto getTrainerById (@PathVariable("id") int trainerId){
        return trainerService.getTrainerDetailsById(trainerId);
    }

    /**
     * <p>
     *  this method is to get all Trainer Details
     * </p>
     */
    @GetMapping
    public List<TrainerDto> getAllTrainers(){
        return trainerService.getTrainerDetails();
    }

    /**
     * <p>
     * this method is to add Trainer to database
     * </p>
     */
    @PutMapping("/update")
    public TrainerDto updateTrainer(@RequestBody TrainerDto trainerDto){
        return trainerService.updateTrainerDetails(trainerDto);
    }

    /**
     * <p>
     * this method is to delete Trainer Details
     * </p>
     */
    @DeleteMapping("/{id}")
    public String deleteTrainer(@PathVariable("id") int trainerId){
        if (trainerService.deleteTrainerDetailsById(trainerId)) {
            return "Deleted";
        } else {
            return "Try again";
        }
    }

    /**
     * <p>
     *     this method is to associate Trainee to Trainer
     * </p>
     */
    @PostMapping("/{trainerId}/{traineeId}")
    private void associateTrainerToTrainees(@PathVariable int trainerId, @PathVariable int traineeId) {
        trainerService.associateTrainerToTrainees(trainerId, traineeId);
    }
}
