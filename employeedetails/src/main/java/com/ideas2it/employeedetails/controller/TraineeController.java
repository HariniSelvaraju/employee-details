package com.ideas2it.employeedetails.controller;

import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.dto.TrainerDto;
import com.ideas2it.employeedetails.service.TraineeService;
import com.ideas2it.employeedetails.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainee")
public class TraineeController {
    private TraineeService traineeService;
    private TraineeDto traineeDto;

    @Autowired
    public TraineeController(TraineeService traineeService, TraineeDto traineeDto){
        this.traineeService = traineeService;
        this.traineeDto = traineeDto;
    }

    @PostMapping
    public void insertTrainee(@RequestBody TraineeDto traineeDto){
        traineeService.addTrainee(traineeDto);
    }

    @GetMapping("/{id}")
    public TraineeDto getTraineeById (@PathVariable("id") int id){
        return traineeService.getTraineeDetailsById(id);
    }

    @GetMapping
    public List<TraineeDto> getAllTrainees(){
        return traineeService.getTraineeDetails();
    }

    @PutMapping("/update")
    public TraineeDto updateTrainee(@RequestBody TraineeDto traineeDto){
        return traineeService.updateTraineeById(traineeDto);
    }

    @DeleteMapping("/{id}")
    public String deleteTrainee(@PathVariable("id") int id){
        if (traineeService.deleteTraineeDetailsById(id)) {
            return "Deleted";
        } else {
            return "Try again";
        }
    }
}
