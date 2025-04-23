package com.example.demo.repositary;

import java.util.Optional;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AdminEntity;


public interface AdminRepositary extends JpaRepository<AdminEntity ,Integer>{
	Optional<AdminEntity>findByadminEmail(String adminEmail);

}
