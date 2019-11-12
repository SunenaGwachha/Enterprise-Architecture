package com.miniproject.springbatch.model;

public class UserCSV {

  
   
    private String first;
    private String last;
    private Double gpa;
    private Integer age;

   

    public UserCSV(String first, String last, Double gpa, Integer age) {
		super();
		this.first = first;
		this.last = last;
		this.gpa = gpa;
		this.age = age;
	}

	public UserCSV() {
    }

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
