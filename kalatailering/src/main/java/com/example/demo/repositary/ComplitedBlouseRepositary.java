package com.example.demo.repositary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ComplitedBlouseEntity;

public interface ComplitedBlouseRepositary extends JpaRepository<ComplitedBlouseEntity, Integer>
{

	List<ComplitedBlouseEntity> findByblouseType(String blouseType);

	List<?> findBycustomerNumber(long customerNumber);


}
