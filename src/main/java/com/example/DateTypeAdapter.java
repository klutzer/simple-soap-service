package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateTypeAdapter extends XmlAdapter<String, LocalDate> {

    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v, dateFormat);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return dateFormat.format(v);
    }

}
