package com.app.repository;
import com.app.model.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByEmail(String email);

}
