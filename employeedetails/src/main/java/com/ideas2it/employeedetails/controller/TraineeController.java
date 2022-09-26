package com.ideas2it.employeedetails.controller;

import com.ideas2it.employeedetails.dto.TraineeDto;
import com.ideas2it.employeedetails.service.TraineeService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/trainee")
public class TraineeController {
    private final TraineeService traineeService;

    @Autowired
    public TraineeController(TraineeService traineeService){
        this.traineeService = traineeService;
    }

    /**
     * <p>
     * this method is to add Trainee details to database
     * </p>
     */
    @PostMapping
    public TraineeDto insertTrainee(@RequestBody TraineeDto traineeDto){
        return traineeService.addTrainee(traineeDto);
    }

    /**
     * <p>
     * this method is to get Trainee By Id(primary key).
     * </p>
     */
    @GetMapping("/{id}")
    public TraineeDto getTraineeById (@PathVariable("id") int traineeId){
        return traineeService.getTraineeDetailsById(traineeId);
    }

    /**
     * <p>
     * this method is to get all Trainee Details
     * </p>
     */
    @GetMapping
    public List<TraineeDto> getAllTrainees(){
        return traineeService.getTraineeDetails();
    }

    /**
     * <p>
     * this method is to add Trainee to database
     * </p>
     */
    @PutMapping("/update")
    public TraineeDto updateTrainee(@RequestBody TraineeDto traineeDto){
        return traineeService.updateTraineeDetails(traineeDto);
    }

    /**
     * <p>
     *     this method is to delete Trainee Details
     * </p>
     */
    @DeleteMapping("/{id}")
    public String deleteTrainee(@PathVariable("id") int traineeId){
        if (traineeService.deleteTraineeDetailsById(traineeId)) {
            return "Deleted";
        } else {
            return "Try again";
        }
    }
}
