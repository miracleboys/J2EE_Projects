package me.spring.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {
	@NotNull
    @Size(min=6,max =7,message="学号为7个字符")
	private String code;
	private String name;
	private String gender = "0";
	private Date birth;
	private float height;

	private String[] myHobby =  new String[]{"01","03"};

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String[] getMyHobby() {
		return myHobby;
	}

	public void setMyHobby(String[] myHobby) {
		this.myHobby = myHobby;
	}
	


}
