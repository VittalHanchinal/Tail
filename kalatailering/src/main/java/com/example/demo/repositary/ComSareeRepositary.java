package com.example.demo.repositary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ComSareeEntity;

public interface ComSareeRepositary extends JpaRepository<ComSareeEntity, Integer> {

	
	List<?> findBycustomerNumber(long customerNumber);

}
