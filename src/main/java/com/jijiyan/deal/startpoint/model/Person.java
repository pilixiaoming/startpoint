package com.jijiyan.deal.startpoint.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "personTable")
public class Person {
	@Column(length = 20, nullable = false, name = "personName")
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Enumerated(EnumType.STRING)
	@Column(length = 6)
	private Gender gender;
	
	@Lob
	private String info;
	@Lob
	@Basic(fetch=FetchType.LAZY) //lazy loading
	private Byte[] file;
	
	@Transient //不加入数据库表
	private String imagepath;

	public Person() {
	}

	public Person(String name, Date birthday, Gender gender, String info) {
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.info = info;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Byte[] getFile() {
		return file;
	}

	public void setFile(Byte[] file) {
		this.file = file;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
}
