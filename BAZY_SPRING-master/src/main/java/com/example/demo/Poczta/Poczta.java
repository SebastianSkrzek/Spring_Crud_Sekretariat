package com.example.demo.Poczta;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;


public class Poczta {

    private Long nr_poczty;
    private String kod_poczty;
    private String poczta;

    public Poczta() {
    }

    public Poczta(Long nr_poczty, String kod_poczty, String poczta) {
        super();
        this.nr_poczty = nr_poczty;
        this.kod_poczty = kod_poczty;
        this.poczta = poczta;
    }


    public Long getNr_poczty() {
        return nr_poczty;
    }

    public void setNr_poczty(Long nr_poczty) {
        this.nr_poczty = nr_poczty;
    }

    public String getKod_poczty() {
        return kod_poczty;
    }

    public void setKod_poczty(String kod_poczty) {
        this.kod_poczty = kod_poczty;
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }

    @Override
    public String toString() {
        return "Poczta{" +
                "nr_poczty=" + nr_poczty +
                ", kod_poczty='" + kod_poczty + '\'' +
                ", poczta='" + poczta + '\'' +
                '}';
    }
}