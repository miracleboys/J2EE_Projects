package me.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import me.spring.bean.Master;
import me.spring.bean.Pet;
@Controller
@RequestMapping("/homework")
public class HomeworkController {
	Map genders = new HashMap<Integer, String>() {
        {
            put(0, "母");
            put(1, "公");
        }
    };
    Map kinds = new HashMap<Integer, String>() {
        {
            put(0, "鸡");
            put(1, "猫");
            put(2, "鸟");
            put(3, "蛇");
            put(4, "仓鼠");
            put(5, "金鱼");
            put(6, "狗");
        }
    };
    Map petServices = new HashMap<String, String>() {
        {
            put("01", "唱");
            put("02", "跳");
            put("03", "rap");
            put("04", "篮球");
        }
    };
    
    Map gendersAmerican = new HashMap<Integer, String>() {
        {
            put(0, "Female");
            put(1, "Male");
        }
    };
    Map kindsAmerican = new HashMap<Integer, String>() {
        {
            put(0, "Chicken");
            put(1, "Cat");
            put(2, "Bird");
            put(3, "Snake");
            put(4, "Hamster");
            put(5, "Goldfish");
            put(6, "Dog");
        }
    };
    Map petServicesAmerican = new HashMap<String, String>() {
        {
            put("01", "Sing");
            put("02", "Dance");
            put("03", "rap");
            put("04", "Basketball");
        }
    };
    
    Map gendersJapan = new HashMap<Integer, String>() {
        {
            put(0, "雌");
            put(1, "雄");
        }
    };
    Map kindsJapan = new HashMap<Integer, String>() {
        {
            put(0, "鶏");
            put(1, "猫");
            put(2, "鳥");
            put(3, "へび");
            put(4, "ハムスター");
            put(5, "金鱼");
            put(6, "犬");
        }
    };
    Map petServicesJapan = new HashMap<String, String>() {
        {
            put("01", "歌を歌う");
            put("02", "ダンス");
            put("03", "ラップ");
            put("04", "バスケットボール");
        }
    };
    
    
    @RequestMapping(value = "/text")
    public String homework(@RequestParam(defaultValue="zh_CN") String lang,HttpServletRequest request, Model model) throws Exception {    
    	String[] langSplit = lang.split("_"); 
        Locale locale = new Locale(langSplit[0],langSplit[1]);
        request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME , locale);
        request.getSession().setAttribute("lang", lang);
    	
    	Pet pet = new Pet();
    	Master master = new Master();
    	pet.setName("荔枝鸡");
    	pet.setAge(10);
    	pet.setKind(0);
    	pet.setGender(1);
    	pet.setIndexPage("www.baidu.com");
    	
    	master.setName("ikun");
    	master.setNumber("18900147612");
    	master.setEmail("12512@qq.com");
    	pet.setMaster(master);
    	
        model.addAttribute("pet", pet);
        model.addAttribute("locale",locale);
        model.addAttribute("lang",lang); 
        if(lang.equals("zh_CN")) {
        	model.addAttribute("petServices", petServices); 
            model.addAttribute("kinds", kinds); 
            model.addAttribute("genders", genders);
        }else if(lang.equals("ja_JP")) {
        	model.addAttribute("petServices", petServicesJapan); 
            model.addAttribute("kinds", kindsJapan); 
            model.addAttribute("genders", gendersJapan);
        }else if(lang.equals("en_US")) {
        	model.addAttribute("petServices", petServicesAmerican); 
            model.addAttribute("kinds", kindsAmerican); 
            model.addAttribute("genders", gendersAmerican);
        }
        
        
        return "form/homework";
    }
    
    //显示结果
    @RequestMapping(value = "/showHomework")
    public String showHomework(@Valid Pet pet, BindingResult bindingResult, @RequestParam(defaultValue="zh_CN") String lang, HttpServletRequest request, Model model) {
    	lang = (String)request.getSession().getAttribute("lang");
    	 Map<String, Object> errorsMap = new HashMap<>();
         //是否有校验错误
         if (bindingResult.hasErrors()) {
             System.out.println("有校验错误！！！");
             List<FieldError> errors = bindingResult.getFieldErrors();
             for (FieldError fieldError : errors) {
                 System.out.println("错误消息提示：" + fieldError.getDefaultMessage()); //错误信息
                 System.out.println("错误的字段是：" + fieldError.getField());          //错误字段
                 System.out.println(fieldError);
                 errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
             }
             model.addAttribute("errorInfo", errorsMap);
         } 
         
		String[] langSplit = lang.split("_"); 
		Locale locale = new Locale(langSplit[0],langSplit[1]);
		request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME , locale);
         
		model.addAttribute("pet", pet);   
		model.addAttribute("locale",locale);
		model.addAttribute("lang",lang);
		
	   if(lang.equals("zh_CN")) {
        	model.addAttribute("petServices", petServices); 
            model.addAttribute("kinds", kinds); 
            model.addAttribute("genders", genders);
        }else if(lang.equals("ja_JP")) {
        	model.addAttribute("petServices", petServicesJapan); 
            model.addAttribute("kinds", kindsJapan); 
            model.addAttribute("genders", gendersJapan);
        }else if(lang.equals("en_US")) {
        	model.addAttribute("petServices", petServicesAmerican); 
            model.addAttribute("kinds", kindsAmerican); 
            model.addAttribute("genders", gendersAmerican);
        }
		
		return "form/showHomework";
    }
}
