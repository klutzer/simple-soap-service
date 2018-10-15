package com.example;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author erico.lutzer
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customers")
public class CustomerAgg {

    @XmlElement(name = "customers")
    private List<Customer> customers;
    
    private List<CustomerVIP> vips;

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

	public List<CustomerVIP> getVips() {
		return vips;
	}

	public void setVips(List<CustomerVIP> vips) {
		this.vips = vips;
	}
}
