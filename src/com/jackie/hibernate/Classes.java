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

	//mappedBy在哪一端，哪一端就不维护关系，它成为了关系的被管理端
	//向当于hibernate中的inverse=true
	//如果采用了泛型，可以不用采用targetEntity属性
	@OneToMany(mappedBy="classes",targetEntity=Student.class)
	@JoinColumn(name="classesid")
	public Set getStudents() {
		return students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}
	
}
