package com.example.demo.controlar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.example.demo.entity.AdminEntity;
import com.example.demo.service.AdminService;
@RequestMapping("/")
@Controller
public class Controlerwithaction 
{
	@Autowired
	private AdminService adminService;
	@GetMapping("/Submit")
	public String findByadminEmail(@RequestParam  String adminEmail ,@RequestParam String adminPassword, Model model )
	{

		AdminEntity admin=adminService.findByadminEmail( adminEmail , adminPassword);
		if(adminPassword.equals(admin.getAdminPassword()))
		{
			model.addAttribute("admin", admin);
			return "home1";
		}
		else
			model.addAttribute("error","Invalid email or password!");
		return "login";
	}


}
