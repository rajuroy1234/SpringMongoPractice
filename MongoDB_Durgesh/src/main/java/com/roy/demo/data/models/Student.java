package com.roy.demo.data.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="students")
public class Student {
	@Id
	private int data;
	private String name, city, college;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public Student(int data, String name, String city, String college) {
		super();
		this.data = data;
		this.name = name;
		this.city = city;
		this.college = college;
	}
	
	
	
}
