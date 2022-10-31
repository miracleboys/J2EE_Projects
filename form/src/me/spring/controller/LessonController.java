package me.spring.controller;



import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import me.spring.bean.Student;

@Controller
@RequestMapping("lesson")

public class LessonController {
	SimpleDateFormat simpleTextFormatter = new SimpleDateFormat("yyy-MM-dd");
	Map hobbies = new HashMap<String, String>() {
		{
			put("01", "游泳");
            put("02", "排球");
            put("03", "乒乓球");
		}
	};
	 Map genders = new HashMap<String, String>() {
	        {
	            put("0", "女");
	            put("1", "男");
	        }
	    };
	
	@RequestMapping(value = "/index")
	public String index(Model model) throws Exception {
		{
			
			Student student = new Student();
			student.setCode("0000001");
		    student.setName("张三");
		    student.setHeight(1.8f);
		    student.setBirth(simpleTextFormatter.parse("2006-10-16")); 
		    
		    model.addAttribute("hobbies", hobbies);
			model.addAttribute("student", student);
			model.addAttribute("genders", genders); 
			
			return "index";
		}
	}
	
	@RequestMapping(value = "/showValues")
	public String showValues(@Valid Student student,BindingResult bindingResult,Model model ) {
		
		
        
		model.addAttribute("hobbies", hobbies);
		model.addAttribute("student", student);
		model.addAttribute("genders", genders); 
		return "showValues";
	}

}
