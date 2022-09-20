package com.ideas2it.employeedetails.repository;

import com.ideas2it.employeedetails.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Integer> {
 }
