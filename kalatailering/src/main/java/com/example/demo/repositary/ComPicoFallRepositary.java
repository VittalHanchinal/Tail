package com.example.demo.repositary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ComPicoFallEntity;

public interface ComPicoFallRepositary extends JpaRepository<ComPicoFallEntity, Integer> {

	List<?> findBycostomerNumber(long costomerNumber);

}
