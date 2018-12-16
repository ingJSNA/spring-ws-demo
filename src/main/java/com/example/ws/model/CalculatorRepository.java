package com.example.ws.model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CalculatorRepository extends JpaRepository<Operation, Long> {

}
