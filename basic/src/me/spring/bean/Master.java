package me.spring.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class Master {
	@NotNull
	@Size(min = 1, max = 10, message = "姓名必须包含1至10个字符")
	private String name;
	
	@Pattern(regexp = "^1(3\\d|4[5-9]|5[0-35-9]|6[567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$", message = "手机号格式有误")
	private String number;
	
	@Email(message = "Email格式有误")
	@Size(min = 1, message = "Email不能为空")
	private String email;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Master(String name, String number, String email) {
		this.name = name;
		this.number = number;
		this.email = email;
	}


	public Master() {
	}
	
}
