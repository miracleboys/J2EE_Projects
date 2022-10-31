package me.spring.controller;

import java.util.Map;

import javax.validation.Valid;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import me.spring.bean.Master;
import me.spring.bean.Pet;

@Controller
@RequestMapping("/pet")
public class PetController {
	Map types = new HashMap<String, String>(){
		{
			put("01","狗");
			put("02","猫");
		}
	};
	Map genders = new HashMap<String,String>(){
		{
			put("01","母");
			put("02","公");
		}
	};
	Map services = new HashMap<String,String>(){
		{
			put("01","喂食");
			put("02","陪玩");
			put("03","遛弯");
		}
	};

	
	@RequestMapping("/fillOutForm")
	public String fillOutForm(Model model) {
		Pet pet = new Pet();
		pet.setName("菲菲");
		pet.setAge(-10);
		pet.setWebPage("www.baidu.com");
		pet.setMaster("12345678910");
		pet.setPhone("125478");
		pet.setMail("123");
		
		model.addAttribute("pet", pet);
		model.addAttribute("types", types);
		model.addAttribute("genders", genders);
		model.addAttribute("services", services);
		
		
		
		return "fillOutForm";
	}
	
	
	@RequestMapping("/formResult")
	public String formResult(@Valid Pet pet,BindingResult bindingResult, Model model) {
		
		model.addAttribute("pet", pet);
		model.addAttribute("types", types);
		model.addAttribute("genders", genders);
		model.addAttribute("services", services);
		return "formResult";
	}
	
	
}
