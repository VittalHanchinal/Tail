package com.example.demo.controlar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/")
@Controller
public class Controlar {
	@GetMapping("/")
	public String home()
	{
		return "home1";
	}
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	@GetMapping("/add")
	public String add(@RequestParam String adminName,@RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String blouseType, Model model)
	{
		model.addAttribute("adminName" ,adminName);
		model.addAttribute("adminEmail" ,adminEmail);
		model.addAttribute("adminPassword" ,adminPassword);
		model.addAttribute("blouseType",blouseType);

		return "blouseform";
	}
	@GetMapping("/blouse")
	public String blouse(@RequestParam String adminName,@RequestParam String adminEmail, @RequestParam String adminPassword, Model model)
	{
		model.addAttribute("adminName" ,adminName);
		model.addAttribute("adminEmail" ,adminEmail);
		model.addAttribute("adminPassword" ,adminPassword);		
		return "blouse";
	}
	@GetMapping("/Churidar")
	public String churidar(@RequestParam String adminName ,@RequestParam String adminEmail, @RequestParam String adminPassword,Model model) {
		model.addAttribute("adminName" ,adminName);
		model.addAttribute("adminEmail" ,adminEmail);
		model.addAttribute("adminPassword" ,adminPassword);
		return "churidar";	}
	@GetMapping("/Lehenga")
	public String lehenga(@RequestParam String adminName,@RequestParam String adminEmail, @RequestParam String adminPassword,Model model) {
		model.addAttribute("adminName" ,adminName);
		model.addAttribute("adminEmail" ,adminEmail);
		model.addAttribute("adminPassword" ,adminPassword);
		return "lehenga";
	}
	@GetMapping("/addPico")
	public String addpico(@RequestParam String adminName,@RequestParam String adminEmail, @RequestParam String adminPassword, Model model) {
		model.addAttribute("adminName" ,adminName);
		model.addAttribute("adminEmail" ,adminEmail);
		model.addAttribute("adminPassword" ,adminPassword);		return "picoform";
	}
	@GetMapping("/addSaree")
	public String addSaree(@RequestParam String adminName,@RequestParam String adminEmail, @RequestParam String adminPassword,Model model) {
		model.addAttribute("adminName" ,adminName);
		model.addAttribute("adminEmail" ,adminEmail);
		model.addAttribute("adminPassword" ,adminPassword);		return "sareeform";
	}
	@GetMapping("/addChuridar")
	public String addchuridar(@RequestParam String adminName,@RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String salwartype, Model model)
	{
		model.addAttribute("adminName" ,adminName);
		model.addAttribute("adminEmail" ,adminEmail);
		model.addAttribute("adminPassword" ,adminPassword);
		model.addAttribute("salwartype",salwartype);
		return "churidarform";
	}
	@GetMapping("/addLehenga")
	public String addlehenga(@RequestParam String adminName,@RequestParam String adminEmail, @RequestParam String adminPassword, @RequestParam String lehengaType, Model model)
	{
		model.addAttribute("adminName" ,adminName);
		model.addAttribute("adminEmail" ,adminEmail);
		model.addAttribute("adminPassword" ,adminPassword);
		model.addAttribute("lehengaType",lehengaType);

		return "lehengaform";
	}
	@GetMapping("/Billing")
	public String Billing(@RequestParam String adminName,@RequestParam String adminEmail, @RequestParam String adminPassword, Model model)
	{
		model.addAttribute("adminName" ,adminName);
		model.addAttribute("adminEmail" ,adminEmail);
		model.addAttribute("adminPassword" ,adminPassword);
		

		return "billing";
	}


}
