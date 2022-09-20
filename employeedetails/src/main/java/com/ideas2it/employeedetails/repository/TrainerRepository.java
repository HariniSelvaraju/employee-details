package com.ideas2it.employeedetails.repository;

import com.ideas2it.employeedetails.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Integer> {
 }
