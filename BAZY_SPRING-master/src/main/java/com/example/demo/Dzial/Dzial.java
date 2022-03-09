package com.example.demo.Dzial;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
        import java.util.Date;


public class Dzial {

    private Long nr_dzialu;
    private String nazwa_dzialu;
    private LocalDate data_powstania_dzialu;

    public Dzial() {
    }

    public Dzial(Long nr_dzialu, String nazwa_dzialu, LocalDate data_powstania_dzialu) {
        super();
        this.nr_dzialu = nr_dzialu;
        this.nazwa_dzialu = nazwa_dzialu;
        this.data_powstania_dzialu = data_powstania_dzialu;
    }

    public Long getNr_dzialu() {
        return nr_dzialu;
    }

    public void setNr_dzialu(Long nr_dzialu) {
        this.nr_dzialu = nr_dzialu;
    }

    public String getNazwa_dzialu() {
        return nazwa_dzialu;
    }

    public void setNazwa_dzialu(String nazwa_dzialu) {
        this.nazwa_dzialu = nazwa_dzialu;
    }

    public LocalDate getData_powstania_dzialu() {
        return data_powstania_dzialu;
    }

    public void setData_powstania_dzialu(LocalDate data_powstania_dzialu) {
        this.data_powstania_dzialu = data_powstania_dzialu;
    }

    @Override
    public String toString() {
        return "Dzial{" +
                "nr_dzialu=" + nr_dzialu +
                ", nazwa_dzialu='" + nazwa_dzialu + '\'' +
                ", data_powstania_dzialu=" + data_powstania_dzialu +
                '}';
    }
}
