package com.example.demo.repositary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.AdminEntity;
import com.example.demo.entity.CustomerEntity;
public interface CustomerRepositary extends JpaRepository<CustomerEntity ,Integer>{

	List<CustomerEntity> findByblouseType(String blouseType);

}
