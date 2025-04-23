package com.example.demo.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AdminEntity;
import com.example.demo.entity.ComPicoFallEntity;
import com.example.demo.entity.ComSareeEntity;
import com.example.demo.entity.ComplitedBlouseEntity;
import com.example.demo.entity.CostomerPicoFallEntity;
import com.example.demo.entity.CoustomerSareeEntity;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.repositary.ComPicoFallRepositary;
import com.example.demo.repositary.ComSareeRepositary;
import com.example.demo.repositary.ComplitedBlouseRepositary;
import com.example.demo.repositary.CostomerPicoFallRepositary;
import com.example.demo.repositary.CoustomerSareeRepositary;
import com.example.demo.repositary.CustomerRepositary;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceimpl implements CustomerService {
	/* blouse ----------------------------------------------------------------------------------------------------------------*/
	@Autowired
	private CustomerRepositary  customerRepositary ;
	@Autowired
	private ComplitedBlouseRepositary  complitedBlouseRepositary;
	@Override 
	public List<CustomerEntity> findByblouseType(String blouseType) {
		return customerRepositary.findByblouseType(blouseType);
	}

	@Override
	public CustomerEntity findBycustomerId(int customerId) {
		Optional<CustomerEntity> optional=customerRepositary.findById(customerId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else {
			throw new RuntimeException("fail to find");

		}
	}

	@Override
	public void addaddblouse(CustomerEntity customerEntity) {

		customerRepositary.save(customerEntity);
	}

	@Override
	public void update(CustomerEntity customerEntity) {
		customerRepositary.save(customerEntity);

	}

	@Override
	public void convertAndSave(CustomerEntity cum) {
		ComplitedBlouseEntity completedBlouse = new ComplitedBlouseEntity();
		completedBlouse.setCustomerId(cum.getCustomerId());
		completedBlouse.setCustomerName(cum.getCustomerName());
		completedBlouse.setCustomerNumber(cum.getCustomerNumber());
		completedBlouse.setCustomerPrice(cum.getCustomerPrice());
		completedBlouse.setSleeveType(cum.getSleeveType());
		completedBlouse.setSleeveLength(cum.getSleeveLength());
		completedBlouse.setSleeveAround(cum.getSleeveAround());
		completedBlouse.setArmHole(cum.getArmHole());
		completedBlouse.setBlouseType(cum.getBlouseType());
		completedBlouse.setBlouseLengt(cum.getBlouseLengt());
		completedBlouse.setSHoulder(cum.getSHoulder());
		completedBlouse.setFrontNeckDepth(cum.getFrontNeckDepth());
		completedBlouse.setBackNeckDepth(cum.getBackNeckDepth());
		completedBlouse.setChest(cum.getChest());
		completedBlouse.setWaist(cum.getWaist());
		completedBlouse.setReceivedDate(cum.getReceivedDate());
		completedBlouse.setDeliverydDate(cum.getDeliverydDate());
		complitedBlouseRepositary.save(completedBlouse);
	}

	@Override
	public void deletProductbyid(int customerId) {
		Optional<CustomerEntity>	optional=customerRepositary.findById(customerId);
		if(optional.isPresent())
		{
			CustomerEntity customerEntity = optional.get();
			customerRepositary.delete(customerEntity);

		}
		else
		{
			throw new RuntimeException("fail to delete");
		}

	}

	@Override
	public List<ComplitedBlouseEntity> findByblouseTypes(String blouseType) {

		return complitedBlouseRepositary.findByblouseType(blouseType);
	}

	@Override
	public ComplitedBlouseEntity findBycustomerIds(int customerId) {
		Optional<ComplitedBlouseEntity> optional=complitedBlouseRepositary.findById(customerId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else {
			throw new RuntimeException("fail to find");

		}
	}
	/* picoFall------------------------------------------------------------------------------------------------------------ */
	@Autowired
	private CostomerPicoFallRepositary  costomerPicoFallRepositary;
	@Autowired
	private ComPicoFallRepositary comPicoFallRepositary;
	@Override
	public void addapicofall(CostomerPicoFallEntity costomerPicoFallEntity) {
		costomerPicoFallRepositary.save(costomerPicoFallEntity);

	}

	@Override
	public List<CostomerPicoFallEntity> fifindAllProduct() {
		List<CostomerPicoFallEntity> list=costomerPicoFallRepositary.findAll();
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list;
		}

	}

	@Override
	public CostomerPicoFallEntity findBycustomerIdss(int customerId) {
		Optional<CostomerPicoFallEntity> optional=costomerPicoFallRepositary.findById(customerId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else {
			throw new RuntimeException("fail to find");

		}
	}

	@Override
	public void convertAndSave1(CostomerPicoFallEntity pic) {
		ComPicoFallEntity completedpicoFall = new ComPicoFallEntity();
		completedpicoFall.setCostomerId(pic.getCostomerId());
		completedpicoFall.setCostomerName(pic.getCostomerName());
		completedpicoFall.setCostomerNumber(pic.getCostomerNumber());
		completedpicoFall.setPrice(pic.getPrice());
		completedpicoFall.setReceivedDate(pic.getReceivedDate());
		completedpicoFall.setDeliverydDate(pic.getDeliverydDate());
		completedpicoFall.setPico(pic.getPico());
		completedpicoFall.setFall(pic.getFall());
		comPicoFallRepositary.save(completedpicoFall);

	}

	@Override
	public void deletProductbyids(int customerId) {
		Optional<CostomerPicoFallEntity> optional=costomerPicoFallRepositary.findById(customerId);
		if(optional.isPresent())
		{
			CostomerPicoFallEntity customerEntity = optional.get();
			costomerPicoFallRepositary.delete(customerEntity);

		}

	}

	@Override
	public List<ComPicoFallEntity> findAllProduct() {
		List<ComPicoFallEntity> list=comPicoFallRepositary.findAll();
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list;
		}

	}
	/* saree-------------------------------------------------------------------------------------------------------------------------------------*/
	@Autowired
	private CoustomerSareeRepositary coustomerSareeRepositary;
	@Autowired
	private ComSareeRepositary comSareeRepositary;
	@Override
	public List<CoustomerSareeEntity> findAllSaree() {

		List<CoustomerSareeEntity> list=coustomerSareeRepositary.findAll();
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list;
		}

	}

	@Override
	public void addaSaree(CoustomerSareeEntity coustomerSareeEntity) {
		coustomerSareeRepositary.save(coustomerSareeEntity);	
	}

	@Override
	public CoustomerSareeEntity findBycustomerIds1(int customerId) {
		Optional<CoustomerSareeEntity> optional=coustomerSareeRepositary.findById(customerId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else {
			throw new RuntimeException("fail to find");

		}
	}

	@Override
	public void deletProductbyids1(int costomerId) {
		Optional<CoustomerSareeEntity> optional=coustomerSareeRepositary.findById(costomerId);
		if(optional.isPresent())
		{
			CoustomerSareeEntity customerEntity = optional.get();
			coustomerSareeRepositary.delete(customerEntity);

		}

	}

	@Override
	public void convertAndSave2(CoustomerSareeEntity saree) {
		ComSareeEntity comSareeEntity= new ComSareeEntity();
		comSareeEntity.setCostomerId(saree.getCostomerId());
		comSareeEntity.setCustomerName(saree.getCustomerName());
		comSareeEntity.setCustomerNumber(saree.getCustomerNumber());
		comSareeEntity.setPrice(saree.getPrice());
		comSareeEntity.setKuchuType(saree.getKuchuType());
		comSareeEntity.setReceivedDate(saree.getReceivedDate());
		comSareeEntity.setDeliverydDate(saree.getDeliverydDate());
		comSareeRepositary.save(comSareeEntity);
		

	}

	@Override
	public List<ComSareeEntity> findAllcomSaree() {
		List<ComSareeEntity> list=comSareeRepositary.findAll();
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list;
		}
	}
	/* Billing-------------------------------------------------------------------------------------------------------------------------------------*/

	@Override
	public Map<String, List<?>> findbynumber(long number) {
		Map<String, List<?>> result = new HashMap<>();
        result.put("complitedBlouse", complitedBlouseRepositary.findBycustomerNumber(number));
        result.put("comPicoFall", comPicoFallRepositary.findBycostomerNumber(number));
        result.put("comSaree", comSareeRepositary.findBycustomerNumber(number));
        
		return result;
	}


}
