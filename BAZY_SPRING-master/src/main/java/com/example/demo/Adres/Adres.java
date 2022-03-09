package com.example.demo.Adres;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;


public class Adres {

    private Long nr_adresu;
    private Long nr_poczty;
    private String miasto;
    private String ulica;
    private String nr_domu;
    private String nr_lokalu;

    public Adres() {
    }

    public Adres(Long nr_adresu, Long nr_poczty, String miasto, String ulica, String nr_domu, String nr_lokalu) {
        super();
        this.nr_adresu = nr_adresu;
        this.nr_poczty = nr_poczty;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nr_domu = nr_domu;
        this.nr_lokalu = nr_lokalu;
    }

    public Long getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(Long nr_adresu) {
        this.nr_adresu = nr_adresu;
    }


    public Long getNr_poczty() {
        return nr_poczty;
    }

    public void setNr_poczty(Long nr_poczty) {
        this.nr_poczty = nr_poczty;
    }


    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }


    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }


    public String getNr_domu() {
        return nr_domu;
    }

    public void setNr_domu(String nr_domu) {
        this.nr_domu = nr_domu;
    }


    public String getNr_lokalu() {
        return nr_lokalu;
    }

    public void setNr_lokalu(String nr_lokalu) {
        this.nr_lokalu = nr_lokalu;
    }



    @Override
    public String toString() {
        return "Adres{" +
                "nr_adresu=" + nr_adresu +
                ", nr_poczty=" + nr_poczty + '\'' +
                ", miasto=" + miasto +
                ", uiica=" + ulica + '\'' +
                ", nr_domu" + nr_domu + '\'' +
                ", nr_lokalu=" + nr_lokalu + '\'' +
                '}';
    }
}
