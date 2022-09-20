package com.ideas2it.employeedetails.controller;

import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public TrainerDto insertTrainer(@RequestBody TrainerDto trainerDto){
        return trainerService.addTrainer(trainerDto);
    }

    @GetMapping("/{id}")
    public TrainerDto getTrainerById (@PathVariable("id") int id){
        return trainerService.getTrainerDetailsById(id);
    }

    @GetMapping
    public List<TrainerDto> getAllTrainers(){
        return trainerService.getTrainerDetails();
    }

    @PutMapping("/update")
    public TrainerDto updateTrainer(@RequestBody TrainerDto trainerDto){
        return trainerService.updateTrainerById(trainerDto);
    }

    @DeleteMapping("/{id}")
    public String deleteTrainer(@PathVariable("id") int id){
        if (trainerService.deleteTrainerDetailsById(id)) {
            return "Deleted";
        } else {
            return "Try after sometimes";
        }
    }
}
