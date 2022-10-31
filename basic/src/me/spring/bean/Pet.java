package me.spring.bean;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

public class Pet {
	@NotNull
	@Size(min = 1, max = 10, message = "名称必须包含1至10个字符")
	private String name;	//昵称
	
	@NotNull
	@Min(value = 0, message = "宠物年龄应该不小于0岁")
	@Max(value = 20, message = "宠物年龄应该不超过20岁")
	private Integer age;	//年龄
	
	private int kind;	//宠物种类
	private int gender;	    //性别
	private String[] petService = new String[]{"01","03"};	//宠物服务
	
	@Size(min = 1, message = "宠物主页不能为空")
	@URL(message="宠物主页地址不合法")
	private String indexPage; //宠物主页
	
	@Valid
	private Master master;	//宠物主人信息
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getKind() {
		return kind;
	}
	public void setKind(Integer kind) {
		this.kind = kind;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String[] getPetService() {
		return petService;
	}
	public void setPetService(String[] petService) {
		this.petService = petService;
	}
	public String getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(String indexPage) {
		this.indexPage = indexPage;
	}
	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}
	public Pet(String name, Integer age, Integer kind, int gender, String[] petService, String indexPage,
			Master master) {
		this.name = name;
		this.age = age;
		this.kind = kind;
		this.gender = gender;
		this.petService = petService;
		this.indexPage = indexPage;
		this.master = master;
	}
	public Pet() {
	}
	
	
}
