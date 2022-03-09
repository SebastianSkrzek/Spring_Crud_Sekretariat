package com.example.demo.Spotkanie;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class Spotkanie {


    private Long nr_spotkania;
    private Long nr_pracownika;
    private Long nr_sali;
    private LocalDateTime data_rozpoczecia_spotkania;
    private LocalDateTime data_zakonczenia_spotkania;


    public Spotkanie() {
    }

    public Spotkanie(Long nr_spotkania, Long nr_pracownika, Long nr_sali, LocalDateTime data_rozpoczecia_spotkania, LocalDateTime data_zakonczenia_spotkania) {
        super();
        this.nr_spotkania = nr_spotkania;
        this.nr_pracownika = nr_pracownika;
        this.nr_sali = nr_sali;
        this.data_rozpoczecia_spotkania = data_rozpoczecia_spotkania;
        this.data_zakonczenia_spotkania = data_zakonczenia_spotkania;
    }

    public Long getNr_spotkania() {
        return nr_spotkania;
    }

    public void setNr_spotkania(Long nr_spotkania) {
        this.nr_spotkania = nr_spotkania;
    }

    public Long getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(Long nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }

    public Long getNr_sali() {
        return nr_sali;
    }

    public void setNr_sali(Long nr_sali) {
        this.nr_sali = nr_sali;
    }

    public LocalDateTime getData_rozpoczecia_spotkania() {
        return data_rozpoczecia_spotkania;
    }

    public void setData_rozpoczecia_spotkania(LocalDateTime data_rozpoczecia_spotkania) {
        this.data_rozpoczecia_spotkania = data_rozpoczecia_spotkania;
    }

    public LocalDateTime getData_zakonczenia_spotkania() {
        return data_zakonczenia_spotkania;
    }

    public void setData_zakonczenia_spotkania(LocalDateTime data_zakonczenia_spotkania) {
        this.data_zakonczenia_spotkania = data_zakonczenia_spotkania;
    }

    @Override
    public String toString() {
        return "Spotkanie{" +
                "nr_spotkania=" + nr_spotkania +
                ", nr_pracownika='" + nr_pracownika + '\'' +
                ", nr_sali='" + nr_sali + '\'' +
                ", data_rozpoczecia_spotkania=" + data_rozpoczecia_spotkania +
                ", data_zakonczenia_spotkania=" + data_zakonczenia_spotkania +
                '}';
    }
}
