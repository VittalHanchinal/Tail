package com.example.demo.controlar;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.ComplitedBlouseEntity;
import com.example.demo.entity.CostomerPicoFallEntity;
import com.example.demo.entity.CoustomerSareeEntity;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.service.CustomerService;
import com.example.demo.entity.ComPicoFallEntity;
import com.example.demo.entity.ComSareeEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/")
@Controller
public class ControlarCustomer
{

	@Autowired
	private CustomerService customerService;

	/* blouse ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@GetMapping("/addmeasurements")
	public String findByblouseType(@RequestParam String adminName,@RequestParam String adminEmail,@RequestParam String blouseType, @RequestParam String adminPassword, Model model) 
	{
		System.out.println("Fetching data for blouseType: " + blouseType);
		List<CustomerEntity> cum=customerService.findByblouseType(blouseType);
		for(CustomerEntity c :cum) 
			System.out.println(c.getCustomerName());
		model.addAttribute("cum",cum);
		model.addAttribute("adminName",adminName);
		model.addAttribute("adminEmail",adminEmail);
		model.addAttribute("adminPassword",adminPassword);
		model.addAttribute("blouseType",blouseType);
		return "addmeasurements";
	}
	@GetMapping("/view")
	public String getMethodName(@RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String adminName,@RequestParam int customerId,Model model)
	{
		CustomerEntity cum=customerService.findBycustomerId(customerId);
		model.addAttribute("cum",cum);
		model.addAttribute("adminName",adminName);
		model.addAttribute("adminEmail",adminEmail);
		model.addAttribute("adminPassword",adminPassword);
		return "view";
	}
	@GetMapping("/view1")
	public String getMethodNames(@RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String adminName,@RequestParam int customerId,Model model)
	{
		ComplitedBlouseEntity cum1=customerService.findBycustomerIds(customerId);
		model.addAttribute("cum1",cum1);
		model.addAttribute("adminName",adminName);
		model.addAttribute("adminEmail",adminEmail);
		model.addAttribute("adminPassword",adminPassword);
		return "view";
	}

	@PostMapping("/addblouse")
	public String addaddblouse(@ModelAttribute CustomerEntity customerEntity,  @RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String adminName ,@RequestParam String blouseType,Model model) 
	{
		customerService.addaddblouse(customerEntity);
		return "redirect:/addmeasurements?adminEmail=" + adminEmail + "&adminPassword=" + adminPassword + "&adminName=" + adminName + "&blouseType=" + blouseType;
	}
	@GetMapping("/Find")
	public String findByid(@RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String adminName,@RequestParam int customerId,Model model)
	{
		CustomerEntity cum=customerService.findBycustomerId(customerId);
		model.addAttribute("cum",cum);
		model.addAttribute("adminName",adminName);
		model.addAttribute("adminEmail",adminEmail);
		model.addAttribute("adminPassword",adminPassword);
		return "UpDate";
	}
	@PostMapping("/Update")
	public String update(@ModelAttribute CustomerEntity customerEntity,  @RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String adminName ,@RequestParam String blouseType,Model model) 
	{
		customerService.update(customerEntity);
		return "redirect:/addmeasurements?adminEmail=" + adminEmail + "&adminPassword=" + adminPassword + "&adminName=" + adminName + "&blouseType=" + blouseType;
	}
	@GetMapping("/completed")
	public String FindByid(@RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String adminName,@RequestParam int customerId, @RequestParam String blouseType, RedirectAttributes redirectAttributes)
	{
		CustomerEntity cum=customerService.findBycustomerId(customerId);
		redirectAttributes.addFlashAttribute("cum", cum);
		redirectAttributes.addAttribute("adminEmail", adminEmail);
		redirectAttributes.addAttribute("adminPassword", adminPassword);
		redirectAttributes.addAttribute("adminName", adminName);
		redirectAttributes.addAttribute("blouseType", blouseType);
		return "redirect:/Move";
	}
	@GetMapping("/Move")
	public String addblouse( @RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String adminName ,@RequestParam String blouseType,  @ModelAttribute("cum") CustomerEntity cum,Model model) 
	{
		customerService.deletProductbyid(cum.getCustomerId());
		customerService.convertAndSave(cum);

		return "redirect:/addmeasurements?adminEmail=" + adminEmail + "&adminPassword=" + adminPassword + "&adminName=" + adminName + "&blouseType=" + blouseType;
	}
	@GetMapping("/Com")
	public String findByblouseTypes(@RequestParam String adminName,@RequestParam String adminEmail,@RequestParam String blouseType, @RequestParam String adminPassword, Model model) 
	{
		System.out.println("Fetching data for blouseType: " + blouseType);
		List<ComplitedBlouseEntity> cum1=customerService.findByblouseTypes(blouseType);
		for(ComplitedBlouseEntity c :cum1) 
			System.out.println(c.getCustomerName());
		model.addAttribute("cum1",cum1);
		model.addAttribute("adminName",adminName);
		model.addAttribute("adminEmail",adminEmail);
		model.addAttribute("adminPassword",adminPassword);
		model.addAttribute("blouseType",blouseType);
		return "addmeasurements";
	}
	/* picoFall ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@PostMapping("/picofall")
	public String addapicofall(@ModelAttribute CostomerPicoFallEntity costomerPicoFallEntity,  @RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String adminName ,Model model) 
	{
		customerService.addapicofall(costomerPicoFallEntity);
		return "redirect:/Pico?adminEmail=" + adminEmail + "&adminPassword=" + adminPassword + "&adminName=" + adminName ;
	}
	@GetMapping("/Pico")
	public String findAll(@RequestParam String adminName,@RequestParam String adminEmail, @RequestParam String adminPassword, Model model) 
	{
		try {
			List<CostomerPicoFallEntity> pic=customerService.fifindAllProduct();
			for(CostomerPicoFallEntity c :pic) 
				System.out.println(c.getCostomerId());
			model.addAttribute("pic",pic);
			model.addAttribute("adminName" ,adminName);
			model.addAttribute("adminEmail" ,adminEmail);
			model.addAttribute("adminPassword" ,adminPassword);		
			return "pico";
		} catch (Exception e) {
			model.addAttribute("adminName" ,adminName);
			model.addAttribute("adminEmail" ,adminEmail);
			model.addAttribute("adminPassword" ,adminPassword);		
			return "pico";
		}



	}
	@GetMapping("/ChangeStatus")
	public String FindByidss(@RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String adminName,@RequestParam int customerId, RedirectAttributes redirectAttributes)
	{
		CostomerPicoFallEntity pic=customerService.findBycustomerIdss(customerId);
		System.out.println(pic.getCostomerId());
		redirectAttributes.addFlashAttribute("pic", pic);
		redirectAttributes.addAttribute("adminEmail", adminEmail);
		redirectAttributes.addAttribute("adminPassword", adminPassword);
		redirectAttributes.addAttribute("adminName", adminName);
		return "redirect:/pass";
	}
	@GetMapping("/pass")
	public String add( @RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String adminName , @ModelAttribute("pic") CostomerPicoFallEntity pic,Model model) 
	{

		customerService.deletProductbyids(pic.getCostomerId());
		customerService.convertAndSave1(pic);


		return "redirect:/Pico?adminEmail=" + adminEmail + "&adminPassword=" + adminPassword + "&adminName=" + adminName ;
	}
	@GetMapping("/com")
	public String findAlls(@RequestParam String adminName,@RequestParam String adminEmail, @RequestParam String adminPassword, Model model) 
	{
		List<ComPicoFallEntity> pic1=customerService.findAllProduct();
		for(ComPicoFallEntity c :pic1) 
			System.out.println(c.getCostomerId());
		model.addAttribute("pic1",pic1);
		model.addAttribute("adminName" ,adminName);
		model.addAttribute("adminEmail" ,adminEmail);
		model.addAttribute("adminPassword" ,adminPassword);		
		return "pico";
	}
	/* saree--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@GetMapping("/Saree")
	public String saree(@RequestParam String adminName,@RequestParam String adminEmail, @RequestParam String adminPassword,Model model) {
		try {
			List<CoustomerSareeEntity> saree=customerService.findAllSaree();
			for(CoustomerSareeEntity c :saree) 
				System.out.println(c.getCostomerId());
			model.addAttribute("saree",saree);
			model.addAttribute("adminName" ,adminName);
			model.addAttribute("adminEmail" ,adminEmail);
			model.addAttribute("adminPassword" ,adminPassword);		
			return "saree";
		} catch (Exception e) {
			model.addAttribute("adminName" ,adminName);
			model.addAttribute("adminEmail" ,adminEmail);
			model.addAttribute("adminPassword" ,adminPassword);		
			return "saree";
		}
	}
	@PostMapping("/addSaree")
	public String addaSaree(@ModelAttribute CoustomerSareeEntity coustomerSareeEntity,  @RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String adminName ,Model model) 
	{
		customerService.addaSaree(coustomerSareeEntity);
		return "redirect:/Saree?adminEmail=" + adminEmail + "&adminPassword=" + adminPassword + "&adminName=" + adminName ;
	}
	@GetMapping("/Change")
	public String FindByids1(@RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String adminName,@RequestParam int customerId, RedirectAttributes redirectAttributes)
	{
		CoustomerSareeEntity Saree=customerService.findBycustomerIds1(customerId);
		System.out.println(Saree.getCostomerId());
		redirectAttributes.addFlashAttribute("Saree", Saree);
		redirectAttributes.addAttribute("adminEmail", adminEmail);
		redirectAttributes.addAttribute("adminPassword", adminPassword);
		redirectAttributes.addAttribute("adminName", adminName);
		return "redirect:/pass1";
	}
	@GetMapping("/pass1")
	public String addcomsaree( @RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String adminName , @ModelAttribute("Saree") CoustomerSareeEntity Saree,Model model) 
	{

		customerService.deletProductbyids1(Saree.getCostomerId());
		customerService.convertAndSave2(Saree);


		return "redirect:/Saree?adminEmail=" + adminEmail + "&adminPassword=" + adminPassword + "&adminName=" + adminName ;
	}
	@GetMapping("/ComSaree")
	public String findAlls1(@RequestParam String adminName,@RequestParam String adminEmail, @RequestParam String adminPassword, Model model) 
	{
		List<ComSareeEntity> saree1=customerService.findAllcomSaree();
		for(ComSareeEntity c :saree1) 
			System.out.println(c.getCostomerId());
		model.addAttribute("saree1",saree1);
		model.addAttribute("adminName" ,adminName);
		model.addAttribute("adminEmail" ,adminEmail);
		model.addAttribute("adminPassword" ,adminPassword);		
		return "saree";
	}
	/* salwar ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@GetMapping("/addsalwar")
	public String findBysalwar(@RequestParam String adminName,@RequestParam String adminEmail,@RequestParam String salwartype, @RequestParam String adminPassword, Model model) 
	{

		model.addAttribute("adminName",adminName);
		model.addAttribute("adminEmail",adminEmail);
		model.addAttribute("adminPassword",adminPassword);
		model.addAttribute("salwartype",salwartype);
		return "addchuridarmejerment";
	}

	/* lehenga -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@GetMapping("/addlehenga")
	public String findBylehenga(@RequestParam String adminName,@RequestParam String adminEmail,@RequestParam String lehengaType, @RequestParam String adminPassword, Model model) 
	{

		model.addAttribute("adminName",adminName);
		model.addAttribute("adminEmail",adminEmail);
		model.addAttribute("adminPassword",adminPassword);
		model.addAttribute("lehengaType",lehengaType);
		return "addlehengamejerments";
	}

	/* Billing -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@GetMapping("/search")
	public String findBynumber(@RequestParam String adminName,@RequestParam String adminEmail,@RequestParam long Number, @RequestParam String adminPassword, Model model) 
	{
		System.out.println("Fetching data for blouseType: " + Number);

		Map<String, List<?>> data = customerService.findbynumber(Number);
		System.out.println(data.get("comSaree"));
		System.out.println(data.get("comPicoFall"));
		System.out.println(data.get("complitedBlouse"));
		model.addAttribute("ComSareeEntity", data.get("comSaree"));
		model.addAttribute("ComPicoFallEntity", data.get("comPicoFall"));
		model.addAttribute("ComplitedBlouseEntity", data.get("complitedBlouse"));
		model.addAttribute("adminName",adminName);
		model.addAttribute("adminEmail",adminEmail);
		model.addAttribute("adminPassword",adminPassword);

		return "billing";
	}

}





