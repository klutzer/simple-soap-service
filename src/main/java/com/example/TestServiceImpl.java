package com.example;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "com.example.TestService")
//@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class TestServiceImpl implements TestService {

    @SuppressWarnings("serial")
    private static Map<Integer, Product> map = new HashMap<Integer, Product>(){{
        put(1, new Product(1, "Farinha", 3.45, true));
        put(2, new Product(2, "Leite", 2.77, true));
        put(3, new Product(3, "Pão", 1.98, false));
    }};
    
    @Override
    public Double squareDouble(Double number) {
        if (number == null) {
            return -99.99d;
        }
        return number * number;
    }

    @Override
    public Float squareFloat(Float number) {
        if (number == null) {
            return -99.99f;
        }
        return number * number;
    }

    @Override
    public String upper(String str) {
        return str == null ? null : str.toUpperCase();
    }

    @Override
    public Integer plusOne(Integer number) {
        System.out.println("Received value: " + number);
        return number == null ? null : number + 1;
    }

    @Override
    public Boolean negate(Boolean b) {
        return b == null ? null : !b;
    }

    @Override
    public Customer complex(Customer customer) {
        customer.setId(customer.getId() + 1);
        return customer;
    }
    
    @Override
    public Customer complex2(Integer id) {
        Customer customer = new Customer();
        id = id == null ? 0 : id;
        customer.setId(id);
        customer.setName("Customer " + id);
        return customer;
    }

    @Override
    public Integer countSize(String[] list) {
        if (list != null) {
            System.out.println("List size: " + list.length);
            for (String s : list) {
                System.out.println("Item: " + s);
            }
            return list.length;
        }
        return -1;
    }

    @Override
    public Date tomorrow(Date date) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }
    
    @Override
    public Product getProduct(@WebParam(name = "id") Integer id) {
        return map.get(id);
    }

    @Override
    public Long plusTwo(Long number, Long sleepInMinutes) {
        System.out.println("Sleeping "+sleepInMinutes+" minutes...");
        if (sleepInMinutes == null) {
        	sleepInMinutes = 0L;
        }
        try {
            Thread.sleep(sleepInMinutes * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sleep finish");
        if (number == null) {
            return -1L;
        }
        return number+2;
    }

    @Override
    public Product getProduct2(Product produto) {
        return map.get(produto.getId());
    }
    
    @Override
    public Customer complex3(Customer c1, Customer c2) {
        System.out.println("Customer 1: " + c1);
        System.out.println("Customer 2: " + c2);
        Customer c = new Customer();
        c.setId(c1.getId() + c2.getId());
        c.setName(c1.getName() + " - " + c2.getName());
        return c;
    }

//    @Override
//    public void returnsNothing() {
//        System.out.println("Recebido request às " + new Date() + ". Esperando 10s...");
//        try {
//            Thread.sleep(180000);
//            System.out.println("Terminou espera de 10s!");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public CustomerAgg getSame(CustomerAgg customer) {
    	return customer;
    }

    @Override
    public CustomerVIP getVip(CustomerVIP vip) {
    	return vip;
    }

    @Override
    public Integer plusNumbers(Integer n1, Integer n2) {
    	return n1 + n2;
    }

    @Override
    public Integer sum(Integer[] list) {
    	return list == null ? null : Arrays.asList(list).stream().mapToInt(v -> v).sum();
    }

    @Override
    public Customer[] listAllCustomers() {
    	return Arrays.asList(
    			new Customer(1, "John"), 
    			new Customer(2, "Peter")).toArray(new Customer[0]);
    }

    @Override
    public CustomerAgg listAllCustomersAgg() {
    	CustomerAgg agg = new CustomerAgg();
    	agg.setCustomers(Arrays.asList(listAllCustomers()));
    	return agg;
    }

}
