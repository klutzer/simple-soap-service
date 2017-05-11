package com.example;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@SOAPBinding(style = Style.DOCUMENT)
@WebService
public interface TestService {

    @WebMethod
    public Double squareDouble(Double number);

    @WebMethod
    public Float squareFloat(Float number);

    @WebMethod
    @XmlJavaTypeAdapter(DateTimeTypeAdapter.class)
    public Date tomorrow(@WebParam(name = "givenDateTime") @XmlJavaTypeAdapter(DateTimeTypeAdapter.class) Date date);

    @WebMethod
    @XmlJavaTypeAdapter(DateTypeAdapter.class)
    public Date tomorrowDate(@WebParam(name = "givenDate") @XmlJavaTypeAdapter(DateTypeAdapter.class) Date date);

    @WebMethod
    public String upper(String str);

    @WebMethod
    public Integer plusOne(Integer number);

    @WebMethod
    public Boolean negate(Boolean b);
}
