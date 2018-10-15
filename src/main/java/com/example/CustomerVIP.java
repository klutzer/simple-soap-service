package com.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerVIP {

	private String name;
	private Customer dependent;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer getDependent() {
		return dependent;
	}
	public void setDependent(Customer dependent) {
		this.dependent = dependent;
	}
}
