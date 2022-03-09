package com.example.demo.Sala;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class Sala {

    private Long nr_sali;
    private Long nr_dzialu;
    private String nazwa_sali;
    private LocalDateTime rezerwacja_sali_od;
    private LocalDateTime rezerwacja_sali_do;
    private Integer ilosc_miejsc_do_siedzenia;
    private Integer ilosc_komputerow;
    private Double powierzchnia;

    public Sala() {
    }

    public Sala(Long nr_sali, Long nr_dzialu, String nazwa_sali, LocalDateTime rezerwacja_sali_od, LocalDateTime rezerwacja_sali_do, Integer ilosc_miejsc_do_siedzenia, Integer ilosc_komputerow, Double powierzchnia) {
        super();
        this.nr_sali = nr_sali;
        this.nr_dzialu = nr_dzialu;
        this.nazwa_sali = nazwa_sali;
        this.rezerwacja_sali_od = rezerwacja_sali_od;
        this.rezerwacja_sali_do = rezerwacja_sali_do;
        this.ilosc_miejsc_do_siedzenia = ilosc_miejsc_do_siedzenia;
        this.ilosc_komputerow = ilosc_komputerow;
        this.powierzchnia = powierzchnia;
    }

    public Long getNr_sali() {
        return nr_sali;
    }

    public void setNr_sali(Long nr_sali) {
        this.nr_sali = nr_sali;
    }


    public Long getNr_dzialu() {
        return nr_dzialu;
    }

    public void setNr_dzialu(Long nr_dzialu) {
        this.nr_dzialu = nr_dzialu;
    }


    public String getNazwa_sali() {
        return nazwa_sali;
    }

    public void setNazwa_sali(String nazwa_sali) {
        this.nazwa_sali = nazwa_sali;
    }


    public LocalDateTime getRezerwacja_sali_od() {
        return rezerwacja_sali_od;
    }

    public void setRezerwacja_sali_od(LocalDateTime rezerwacja_sali_od) {
        this.rezerwacja_sali_od = rezerwacja_sali_od;
    }


    public LocalDateTime getRezerwacja_sali_do() {
        return rezerwacja_sali_do;
    }

    public void setRezerwacja_sali_do(LocalDateTime rezerwacja_sali_do) {
        this.rezerwacja_sali_do = rezerwacja_sali_do;
    }


    public Integer getIlosc_miejsc_do_siedzenia() {
        return ilosc_miejsc_do_siedzenia;
    }

    public void setIlosc_miejsc_do_siedzenia(Integer ilosc_miejsc_do_siedzenia) {
        this.ilosc_miejsc_do_siedzenia = ilosc_miejsc_do_siedzenia;
    }


    public Integer getIlosc_komputerow() {
        return ilosc_komputerow;
    }

    public void setIlosc_komputerow(Integer ilosc_komputerow) {
        this.ilosc_komputerow = ilosc_komputerow;
    }


    public Double getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(Double powierzchnia) {
        this.powierzchnia = powierzchnia;
    }



    @Override
    public String toString() {
        return "Sala{" +
                "nr_sali=" + nr_sali +
                ", nr_dzialu=" + nr_dzialu + '\'' +
                ", nazwa_sali=" + nazwa_sali + '\'' +
                ", rezerwacja_sali_od=" + rezerwacja_sali_od + '\'' +
                ", rezerwacja_sali_do=" + rezerwacja_sali_do +
                ", ilosc_miejsc_do_siedzenia=" + ilosc_miejsc_do_siedzenia + '\'' +
                ", ilosc_komputerow" + ilosc_komputerow + '\'' +
                ", powierzchnia=" + powierzchnia + '\'' +
                '}';
    }
}
