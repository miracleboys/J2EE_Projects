package me.spring.bean;



import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public class Pet {
	@Size(min=1,max=10,message="名称必须包含1至10个字符")
	private String name;
	@Max(value=20,message="宠物年龄应该不超过20岁")
	@Min(value=0,message="宠物年龄应该不小于0岁")
	private int age;
	private String type = "01";
	private String gender = "02";
	private String[] service = new String[] {"01","03"};
	@NotBlank(message="宠物主页不能为空")
	@URL(message="宠物主页地址不合法")
	private String webPage;
	@Size(min=1,max=10,message="姓名必须包含1至10个字符")
	private String master;
	
//	@NotNull(message = "手机号格式有误")
//	@Size(min = 11, max = 11, message = "手机号格式有误")
	@Pattern(regexp ="^[1][3,4,5,6,7,8,9][0-9]{9}$", message="手机号格式有误")
	private String phone;
	
	@NotBlank(message="Email不能为空")
	@Email(message="Email格式有误")
	private String mail;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getService() {
		return service;
	}
	public void setService(String[] service) {
		this.service = service;
	}
	public String getWebPage() {
		return webPage;
	}
	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String master) {
		this.master = master;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	}
	
	
	
	

