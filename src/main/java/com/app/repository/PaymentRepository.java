package com.app.repository;
import com.app.model.*;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer>{

}
