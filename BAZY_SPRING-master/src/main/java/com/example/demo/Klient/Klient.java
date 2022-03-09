package com.example.demo.Klient;

import java.time.LocalDate;


public class Klient {

    private Long nr_klienta;
    private Long nr_adresu;
    private String imie;
    private String nazwisko;
    private String pesel;
    private LocalDate data_urodzenia;
    private String plec;
    private String nr_telefonu;
    private String e_mail;

    public Klient() {
    }

    public Klient(Long nr_klienta, Long nr_adresu, String imie, String nazwisko, String pesel, LocalDate data_urodzenia, String plec, String nr_telefonu, String e_mail) {
        super();
        this.nr_klienta = nr_klienta;
        this.nr_adresu = nr_adresu;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.data_urodzenia = data_urodzenia;
        this.plec = plec;
        this.nr_telefonu = nr_telefonu;
        this.e_mail = e_mail;
    }

    public Long getNr_klienta() {
        return nr_klienta;
    }


    public void setNr_klienta(Long nr_klienta) {
        this.nr_klienta = nr_klienta;
    }

    public Long getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(Long nr_adresu) {this.nr_adresu = nr_adresu;}

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }


    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }


    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }


    public LocalDate getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(LocalDate data_urodzenia) {this.data_urodzenia = data_urodzenia; }


    public String getPlec() { return plec; }

    public void setPlec(String plec) {
        this.plec = plec;
    }


    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }


    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }



    @Override
    public String toString() {
        return "Kleint{" +
                "nr_klienta=" + nr_klienta +
                ", imie=" + imie + '\'' +
                ", nazwisko=" + nazwisko + '\'' +
                ", data urodzenia=" + data_urodzenia + '\'' +
                ", pesel=" + pesel + '\'' +
                ", płeć=" + plec + '\'' +
                ", nr_telefonu=" + nr_telefonu + '\'' +
                ", e-mail=" + e_mail + '\'' +
                '}';}}