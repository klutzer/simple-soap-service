package com.example;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlJavaTypeAdapter(DateTypeAdapter.class)
@XmlType(name = "")
public class DateWrapper {

    @XmlSchemaType(name = "date")
    private LocalDate date;

    public DateWrapper(LocalDate date) {
        this.date = date;
    }

    public DateWrapper() {
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
