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
    private TraineeService traineeService;
    private TraineeDto traineeDto;

    @Autowired
    public TraineeController(TraineeService traineeService, TraineeDto traineeDto){
        this.traineeService = traineeService;
        this.traineeDto = traineeDto;
    }

    /**
     * this method is to add Trainee details to database
     *
     * @param {@link TraineeDto} traineeDto
     */
    @PostMapping
    public void insertTrainee(@RequestBody TraineeDto traineeDto){
        traineeService.addTrainee(traineeDto);
    }

    /**
     * this method is to get Trainee By Id(primary key).
     *
     * @param {@link int} id
     *
     * @return {@link TraineeDto}
     */
    @GetMapping("/{id}")
    public TraineeDto getTraineeById (@PathVariable("id") int id){
        return traineeService.getTraineeDetailsById(id);
    }

    /**
     * this method is to get all Trainee Details
     *
     * @return {@link List<TraineeDto>}
     */
    @GetMapping
    public List<TraineeDto> getAllTrainees(){
        return traineeService.getTraineeDetails();
    }

    /**
     * this method is to add Trainee to database
     *
     * @param {@link TraineeDto} traineeDto
     *
     * @return {@link TraineeDto}
     */
    @PutMapping("/update")
    public TraineeDto updateTrainee(@RequestBody TraineeDto traineeDto){
        return traineeService.updateTraineeDetails(traineeDto);
    }

    /**
     * this method is to delete Trainee Details
     *
     * @param {@link int} id
     *
     * @return {@link String}
     */
    @DeleteMapping("/{id}")
    public String deleteTrainee(@PathVariable("id") int id){
        if (traineeService.deleteTraineeDetailsById(id)) {
            return "Deleted";
        } else {
            return "Try again";
        }
    }
}
