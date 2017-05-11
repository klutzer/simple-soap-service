package com.example;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.jws.WebService;

@WebService(endpointInterface = "com.example.TestService")
public class TestServiceImpl implements TestService {

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
    public Date tomorrow(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    @Override
    public Date tomorrowDate(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    @Override
    public String upper(String str) {
        return str == null ? null : str.toUpperCase();
    }

    @Override
    public Integer plusOne(Integer number) {
        return number == null ? null : number + 1;
    }

    @Override
    public Boolean negate(Boolean b) {
        return b == null ? null : !b;
    }

}
