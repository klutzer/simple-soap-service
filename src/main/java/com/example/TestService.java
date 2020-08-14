package com.example;

import java.time.LocalDate;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
@WebService
public interface TestService {

    @WebMethod
    public Double squareDouble(Double number);

    @WebMethod
    public Float squareFloat(Float number);

    @WebMethod
    public String upper(@WebParam(name = "string") String str);

    @WebMethod
    public Integer plusOne(@WebParam(name = "n1") Integer number);

    @WebMethod
    public Integer plusNumbers(@WebParam(name = "n1") Integer n1, @WebParam(name = "n2") Integer n2);

    @WebMethod
    public Integer sum(@WebParam(name = "list") Integer[] list);

    @WebMethod
    public Boolean negate(Boolean b);

    @WebMethod
    @WebResult(name = "customer")
    public Customer complex(@WebParam(name = "customer") Customer customer);

    @WebMethod
    @WebResult(name = "customer")
    public Customer complex2(@WebParam(name = "id") Integer id);

    @WebMethod
    @WebResult(name = "returnedCustomer")
    public Customer complex3(@WebParam(name = "customer1") Customer c1, @WebParam(name = "customer2") Customer c2);

    @WebMethod
    @WebResult(name = "product")
    public Product getProduct(@WebParam(name = "id") Integer id);

    @WebMethod
    @WebResult(name = "product")
    public Product getProduct2(@WebParam(name = "product") Product produto);

    @WebMethod
    public Integer countSize(@WebParam(name = "list") String[] list);

    @WebMethod
    public Date tomorrow(@WebParam(name = "givenDate") Date date);

    @WebMethod
    public Long plusTwo(@WebParam(name = "n1") Long number, @WebParam(name = "sleepInMinutes") Long sleepInMinutes);

    @WebMethod
    @WebResult(name = "customerList")
    public CustomerAgg getSame(@WebParam(name = "customerList") CustomerAgg customer);

    @WebMethod
    @WebResult(name = "vip")
    public CustomerVIP getVip(@WebParam(name = "vip") CustomerVIP vips);

    @WebMethod
    @WebResult(name = "customers")
    public Customer[] listAllCustomers();

    @WebMethod
    @WebResult(name = "customerAgg")
    public CustomerAgg listAllCustomersAgg();

    @WebMethod
    @WebResult(name = "date")
    public String now();

    @WebMethod
    @XmlJavaTypeAdapter(DateTimeTypeAdapter.class)
    public Date plusHours(@WebParam(name = "givenDateTime") @XmlJavaTypeAdapter(DateTimeTypeAdapter.class) Date date, @WebParam(name = "hours") Integer hours);

    @WebMethod
    @XmlJavaTypeAdapter(DateTypeAdapter.class)
    public LocalDate plusDays(@WebParam(name = "givenDate") @XmlJavaTypeAdapter(DateTypeAdapter.class) LocalDate date, @WebParam(name = "days") Integer days);

    //	@WebMethod
    //	@Oneway
    //	public void returnsNothing();

}
