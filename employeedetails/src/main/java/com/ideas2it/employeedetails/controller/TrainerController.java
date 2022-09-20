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
    private TrainerService trainerService;
    private TrainerDto trainerDto;

    @Autowired
    public TrainerController(TrainerService trainerService, TrainerDto trainerDto){
        this.trainerService = trainerService;
        this.trainerDto = trainerDto;
    }

    /**
     * this method is to add Trainer details to database
     *
     * @param {@link TrainerDto} trainerDto
     */
    @PostMapping
    public TrainerDto insertTrainer(@RequestBody TrainerDto trainerDto){
        return trainerService.addTrainer(trainerDto);
    }

    /**
     * this method is to get Trainer By Id(primary key).
     *
     * @param {@link int} id
     *
     * @return {@link TrainerDto}
     */
    @GetMapping("/{id}")
    public TrainerDto getTrainerById (@PathVariable("id") int id){
        return trainerService.getTrainerDetailsById(id);
    }

    /**
     * this method is to get all Trainer Details
     *
     * @return {@link List<TrainerDto>}
     */
    @GetMapping
    public List<TrainerDto> getAllTrainers(){
        return trainerService.getTrainerDetails();
    }

    /**
     * this method is to add Trainer to database
     *
     * @param {@link TrainerDto} trainerDto
     *
     * @return {@link TrainerDto}
     */
    @PutMapping("/update")
    public TrainerDto updateTrainer(@RequestBody TrainerDto trainerDto){
        return trainerService.updateTrainerDetails(trainerDto);
    }

    /**
     * this method is to delete Trainer Details
     *
     * @param {@link int} id
     *
     * @return {@link String}
     */
    @DeleteMapping("/{id}")
    public String deleteTrainer(@PathVariable("id") int id){
        if (trainerService.deleteTrainerDetailsById(id)) {
            return "Deleted";
        } else {
            return "Try after sometimes";
        }
    }
}
