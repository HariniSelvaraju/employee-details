package com.ideas2it.employeedetails.repository;

import com.ideas2it.employeedetails.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee,Integer> {
}
