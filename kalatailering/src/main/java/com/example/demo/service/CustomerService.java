package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.entity.ComPicoFallEntity;
import com.example.demo.entity.ComSareeEntity;
import com.example.demo.entity.ComplitedBlouseEntity;
import com.example.demo.entity.CostomerPicoFallEntity;
import com.example.demo.entity.CoustomerSareeEntity;
import com.example.demo.entity.CustomerEntity;

public interface CustomerService {
	/* blouse ---------------------------------------------------------------*/

	List<CustomerEntity>  findByblouseType(String blouseType);

	CustomerEntity findBycustomerId(int customerId);

	void addaddblouse(CustomerEntity customerEntity);

	void update(CustomerEntity customerEntity);

	void convertAndSave(CustomerEntity cum);

	void deletProductbyid(int customerId);

	List<ComplitedBlouseEntity> findByblouseTypes(String blouseType);

	ComplitedBlouseEntity findBycustomerIds(int customerId);
	/*picoFall--------------------------------------------------------------- */

	void addapicofall(CostomerPicoFallEntity costomerPicoFallEntity);

	List<CostomerPicoFallEntity> fifindAllProduct();

	CostomerPicoFallEntity findBycustomerIdss(int customerId);

	void convertAndSave1(CostomerPicoFallEntity pic);

	void deletProductbyids(int customerId);

	List<ComPicoFallEntity> findAllProduct();
	/* saree -------------------------------------------------------------------*/

	List<CoustomerSareeEntity> findAllSaree();

	void addaSaree(CoustomerSareeEntity coustomerSareeEntity);

	CoustomerSareeEntity findBycustomerIds1(int customerId);

	void deletProductbyids1(int costomerId);

	void convertAndSave2(CoustomerSareeEntity saree);

	List<ComSareeEntity> findAllcomSaree();

	Map<String, List<?>> findbynumber(long number);

	


}
