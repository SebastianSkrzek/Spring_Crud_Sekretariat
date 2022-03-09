package com.example.demo.Pracownik;

import java.time.LocalDate;


public class Pracownik {

    private Long nr_pracownika;
    private Long nr_dzialu;
    private Long nr_adresu;
    private String imie;
    private String nazwisko;
    private LocalDate data_urodzenia;
    private String plec;
    private String stanowisko;
    private LocalDate data_zatrudnienia;
    private String e_mail;
    private String pesel;
    private LocalDate waznosc_zatrudnienia;
    private String nr_telefonu;


    public Pracownik() {
    }

    public Pracownik(Long nr_pracownika, Long nr_dzialu, Long nr_adresu, String imie, String nazwisko, LocalDate data_urodzenia, String plec, String stanowisko, LocalDate data_zatrudnienia, String e_mail, String pesel, LocalDate waznosc_zatrudnienia, String nr_telefonu) {
        super();
        this.nr_pracownika = nr_pracownika;
        this.nr_dzialu = nr_dzialu;
        this.nr_adresu = nr_adresu;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.plec = plec;
        this.stanowisko = stanowisko;
        this.data_zatrudnienia = data_zatrudnienia;
        this.e_mail = e_mail;
        this.pesel = pesel;
        this.waznosc_zatrudnienia = waznosc_zatrudnienia;
        this.nr_telefonu = nr_telefonu;
    }

    public Long getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(Long nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }

    public Long getNr_dzialu() {
        return nr_dzialu;
    }

    public void setNr_dzialu(Long nr_dzialu) {
        this.nr_dzialu = nr_dzialu;
    }

    public Long getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(Long nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

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

    public LocalDate getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(LocalDate data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public LocalDate getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(LocalDate data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public LocalDate getWaznosc_zatrudnienia() {
        return waznosc_zatrudnienia;
    }

    public void setWaznosc_zatrudnienia(LocalDate waznosc_zatrudnienia) {
        this.waznosc_zatrudnienia = waznosc_zatrudnienia;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "nr_pracownika=" + nr_pracownika +
                ", nr_dzialu=" + nr_dzialu +
                ", nr_adresu=" + nr_adresu +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_urodzenia=" + data_urodzenia +
                ", plec='" + plec + '\'' +
                ", stanowisko='" + stanowisko + '\'' +
                ", data_zatrudnienia=" + data_zatrudnienia +
                ", e_mail='" + e_mail + '\'' +
                ", pesel='" + pesel + '\'' +
                ", waznosc_zatrudnienia=" + waznosc_zatrudnienia +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                '}';
    }
}