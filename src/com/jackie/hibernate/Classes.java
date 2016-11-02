package com.jackie.hibernate;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_classes")
public class Classes {
	
	private int id;
	
	private String name;
	
	private Set students;

	@Id 
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//mappedBy����һ�ˣ���һ�˾Ͳ�ά����ϵ������Ϊ�˹�ϵ�ı������
	//����hibernate�е�inverse=true
	//��������˷��ͣ����Բ��ò���targetEntity����
	@OneToMany(mappedBy="classes",targetEntity=Student.class)
	@JoinColumn(name="classesid")
	public Set getStudents() {
		return students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}
	
}
