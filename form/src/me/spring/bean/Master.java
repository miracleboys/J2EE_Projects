package me.spring.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class Master {
	@Size(min=1,max=10,message="名称必须包含1至10个字符")
	private String name;
	@Pattern(regexp ="^[1][3,4,5,7,8][0-9]{9}$", message="手机号格式有误")
	private String phone;
	@NotNull(message="Email不能为空")
	@Email(message="Email格式有误")
	private String mail;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
