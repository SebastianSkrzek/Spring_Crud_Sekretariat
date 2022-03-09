package com.example.demo;


import com.example.demo.Adres.Adres;
import com.example.demo.Adres.AdresyDAO;
import com.example.demo.Dzial.Dzial;
import com.example.demo.Dzial.DzialyDAO;
import com.example.demo.Klient.KlienciDAO;
import com.example.demo.Klient.Klient;
import com.example.demo.Poczta.Poczta;
import com.example.demo.Poczta.PocztyDAO;
import com.example.demo.Pracownik.PracownicyDAO;
import com.example.demo.Pracownik.Pracownik;
import com.example.demo.Sala.Sala;
import com.example.demo.Sala.SaleDAO;
import com.example.demo.Spotkanie.SpotkaniaDAO;
import com.example.demo.Spotkanie.Spotkanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@Controller
public class AppController implements WebMvcConfigurer {
    //////////////
    //////////////
    //dzialy
    @Autowired
    private DzialyDAO daoDzial;

    @RequestMapping("/dzialy")
    public String viewDzialy(Model model) {

        List<Dzial> listDzial = daoDzial.list();
        model.addAttribute("listDzial", listDzial);
        return "dzialy";
    }

    @RequestMapping("/newDzial")
    public String showNewFormDzialy(Model model) {

        Dzial dzial = new Dzial();
        model.addAttribute("dzial",dzial);

        return "dzialy_new_form";
    }

    @RequestMapping(value = "/saveDzial", method = RequestMethod.POST)
    public String saveDzial(@ModelAttribute("dzial") Dzial dzial, Model model) {

        daoDzial.save(dzial);

        List<Dzial> listDzial = daoDzial.list();
        model.addAttribute("listDzial", listDzial);

        return "dzialy";
    }

    @RequestMapping("/editDzial/{numer_dzialu}")
    public ModelAndView showEditFormDzial(@PathVariable(name = "numer_dzialu") int numer_dzialu) {
        ModelAndView mav = new ModelAndView("dzialy_edit_form");
        Dzial dzial = daoDzial.get(numer_dzialu);
        mav.addObject("dzial", dzial);

        return mav;

    }

    @RequestMapping(value = "/updateDzial", method = RequestMethod.POST)
    public String updateDzial(@ModelAttribute("dzial") Dzial dzial, Model model) {
        daoDzial.update(dzial);

        List<Dzial> listDzial = daoDzial.list();
        model.addAttribute("listDzial", listDzial);

        return "dzialy";

    }

    @RequestMapping("/deleteDzial/{nr_dzialu}")
    public String deleteDzial(@PathVariable(name = "nr_dzialu") int nr_dzialu, Model model) {
        daoDzial.delete(nr_dzialu);

        List<Dzial> listDzial = daoDzial.list();
        model.addAttribute("listDzial", listDzial);

        return "dzialy";

    }





    //////////////
    //////////////
    //pracownicy
    @Autowired
    private PracownicyDAO daoPracownik;

    @RequestMapping("/pracownicy")
    public String viewPracownicy(Model model) {

        List<Pracownik> listPracownik = daoPracownik.list();
        model.addAttribute("listPracownik", listPracownik);
        return "pracownicy";
    }

    @RequestMapping("/newPracownik")
    public String showNewFormPracownicy(Model model) {

        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownik", pracownik);

        return "pracownicy_new_form";
    }

    @RequestMapping(value = "/savePracownik", method = RequestMethod.POST)
    public String savePracownik(@ModelAttribute("pracownik") Pracownik pracownik, Model model) {

        daoPracownik.save(pracownik);

        List<Pracownik> listPracownik = daoPracownik.list();
        model.addAttribute("listPracownik", listPracownik);

        return "pracownicy";
    }

    @RequestMapping("/editPracownik/{numer_pracownika}")
    public ModelAndView showEditFormPracownicy(@PathVariable(name = "numer_pracownika") int numer_pracownika) {
        ModelAndView mav = new ModelAndView("pracownicy_edit_form");
        Pracownik pracownik = daoPracownik.get(numer_pracownika);
        mav.addObject("pracownik", pracownik);

        return mav;

    }

    @RequestMapping(value = "/updatePracownik", method = RequestMethod.POST)
    public String updatePracownik(@ModelAttribute("pracownik") Pracownik pracownik, Model model) {
        daoPracownik.update(pracownik);

        List<Pracownik> listPracownik = daoPracownik.list();
        model.addAttribute("listPracownik", listPracownik);

        return "pracownicy";

    }

    @RequestMapping("/deletePracownik/{nr_pracownika}")
    public String deletePracownik(@PathVariable(name = "nr_pracownika") int nr_pracownika, Model model) {
        daoPracownik.delete(nr_pracownika);

        List<Pracownik> listPracownik = daoPracownik.list();
        model.addAttribute("listPracownik", listPracownik);

        return "pracownicy";

    }




//////////
    ///////////
//    Klienci


    @Autowired
    private KlienciDAO daoKlient;

    @RequestMapping("/klienci")
    public String viewKlienci(Model model) {

        List<Klient> listKlient = daoKlient.list();
        model.addAttribute("listKlient", listKlient);
        return "klienci";
    }

    @RequestMapping("/newKlient")
    public String showNewFormKlienci(Model model) {

        Klient klient = new Klient();
        model.addAttribute("klient", klient);

        return "klienci_new_form";
    }

    @RequestMapping(value = "/saveKlient", method = RequestMethod.POST)
    public String saveKlient(@ModelAttribute("klient") Klient klient, Model model) {

        daoKlient.save(klient);

        List<Klient> listklient = daoKlient.list();
        model.addAttribute("listKlient", listklient);

        return "klienci";
    }

    @RequestMapping("/editKlient/{numer_klienta}")
    public ModelAndView showEditFormKlienci(@PathVariable(name = "numer_klienta") int numer_klienta) {
        ModelAndView mav = new ModelAndView("edit_form_klient");
        Klient klient = daoKlient.get(numer_klienta);
        mav.addObject("klient", klient);

        return mav;

    }

    @RequestMapping(value = "/updateKlient", method = RequestMethod.POST)
    public String updateKlient(@ModelAttribute("klient") Klient klient, Model model) {
        daoKlient.update(klient);

        List<Klient> listKlient = daoKlient.list();
        model.addAttribute("listKlient", listKlient);

        return "klienci";

    }

    @RequestMapping("/deleteKlient/{nr_klienta}")
    public String deleteKlient(@PathVariable(name = "nr_klienta") int nr_klienta, Model model) {
        daoKlient.delete(nr_klienta);

        List<Klient> listKlient = daoKlient.list();
        model.addAttribute("listKlient", listKlient);

        return "klienci";

    }


    //////////
    ///////////
//    Spotkania


    @Autowired
    private SpotkaniaDAO daoSpotkanie;

    @RequestMapping("/spotkania")
    public String viewSpotkania(Model model) {

        List<Spotkanie> listSpotkanie = daoSpotkanie.list();
        model.addAttribute("listKlient", listSpotkanie);
        return "klienci";
    }

    @RequestMapping("/newSpotkanie")
    public String showNewFormSpotkania(Model model) {

        Spotkanie spotkanie = new Spotkanie();
        model.addAttribute("spotkanie", spotkanie);

        return "spotkania_new_form";
    }

    @RequestMapping(value = "/saveSpotkanie", method = RequestMethod.POST)
    public String saveSpotkanie(@ModelAttribute("spotkanie") Spotkanie spotkanie, Model model) {

        daoSpotkanie.save(spotkanie);

        List<Spotkanie> listSpotkanie = daoSpotkanie.list();
        model.addAttribute("listSpotkanie", listSpotkanie);

        return "spotkania";
    }

    @RequestMapping("/editSpotkanie/{numer_spotkania}")
    public ModelAndView showEditFormSpotkania(@PathVariable(name = "numer_spotkania") int numer_spotkania) {
        ModelAndView mav = new ModelAndView("spotkania_edit_form");
        Spotkanie spotkanie = daoSpotkanie.get(numer_spotkania);
        mav.addObject("spotkanie", spotkanie);

        return mav;

    }

    @RequestMapping(value = "/updateSpotkanie", method = RequestMethod.POST)
    public String updateKlient(@ModelAttribute("spotkanie") Spotkanie spotkanie, Model model) {
        daoSpotkanie.update(spotkanie);

        List<Spotkanie> listSpotkanie = daoSpotkanie.list();
        model.addAttribute("listSpotkanie", listSpotkanie);

        return "spotkania";

    }

    @RequestMapping("/deleteSpotkanie/{nr_spotkania}")
    public String deleteSpotkanie(@PathVariable(name = "nr_spotkania") int nr_spotkania, Model model) {
        daoSpotkanie.delete(nr_spotkania);

        List<Spotkanie> listSpotkanie = daoSpotkanie.list();
        model.addAttribute("listSpotkanie", listSpotkanie);

        return "spotkania";

    }


    //////////
    ///////////
//    Adresy


    @Autowired
    private AdresyDAO daoAdres;

    @RequestMapping("/adresy")
    public String viewAdresy(Model model) {

        List<Adres> listAdres = daoAdres.list();
        model.addAttribute("listAdres", listAdres);
        return "adresy";
    }

    @RequestMapping("/newAdres")
    public String showNewFormAdres(Model model) {

        Adres adres = new Adres();
        model.addAttribute("adres", adres);

        return "adresy_new_form";
    }

    @RequestMapping(value = "/saveAdres", method = RequestMethod.POST)
    public String saveAdres(@ModelAttribute("adres") Adres adres, Model model) {

        daoAdres.save(adres);

        List<Adres> listAdres = daoAdres.list();
        model.addAttribute("listAdres", listAdres);

        return "adresy";
    }

    @RequestMapping("/editAdres/{numer_adresu}")
    public ModelAndView showEditFormAdres(@PathVariable(name = "numer_adresu") int numer_adresu) {
        ModelAndView mav = new ModelAndView("adresy_edit_form");
        Adres adres = daoAdres.get(numer_adresu);
        mav.addObject("adres", adres);

        return mav;

    }

    @RequestMapping(value = "/updateAdres", method = RequestMethod.POST)
    public String updateKlient(@ModelAttribute("adres") Adres adres, Model model) {
        daoAdres.update(adres);

        List<Adres> listAdres = daoAdres.list();
        model.addAttribute("listAdres", listAdres);

        return "adresy";

    }

    @RequestMapping("/deleteAdres/{nr_adresu}")
    public String deleteAdres(@PathVariable(name = "nr_adresu") int nr_adresu, Model model) {
        daoAdres.delete(nr_adresu);

        List<Adres> listAdres = daoAdres.list();
        model.addAttribute("listAdres", listAdres);

        return "adresy";

    }


//////////
    ///////////
//    Sale


    @Autowired
    private SaleDAO daoSala;

    @RequestMapping("/sale")
    public String viewSale(Model model) {

        List<Sala> listSala = daoSala.list();
        model.addAttribute("listSala", listSala);
        return "sale";
    }

    @RequestMapping("/newSala")
    public String showNewFormSala(Model model) {

        Sala sala = new Sala();
        model.addAttribute("sala", sala);

        return "sale_new_form";
    }

    @RequestMapping(value = "/saveSala", method = RequestMethod.POST)
    public String saveSala(@ModelAttribute("sala") Sala sala, Model model) {

        daoSala.save(sala);

        List<Sala> listSala = daoSala.list();
        model.addAttribute("listSala", listSala);

        return "sale";
    }

    @RequestMapping("/editSala/{numer_sali}")
    public ModelAndView showEditFormSala(@PathVariable(name = "numer_sali") int numer_sali) {
        ModelAndView mav = new ModelAndView("sale_edit_form");
        Sala sala = daoSala.get(numer_sali);
        mav.addObject("sala", sala);

        return mav;

    }

    @RequestMapping(value = "/updateSala", method = RequestMethod.POST)
    public String updateSala(@ModelAttribute("sala") Sala sala, Model model) {
        daoSala.update(sala);

        List<Sala> listSala = daoSala.list();
        model.addAttribute("listSala", listSala);

        return "sale";

    }

    @RequestMapping("/deleteSala/{nr_sali}")
    public String deleteSala(@PathVariable(name = "nr_sali") int nr_sali, Model model) {
        daoSala.delete(nr_sali);

        List<Sala> listSala = daoSala.list();
        model.addAttribute("listSala", listSala);

        return "sale";

    }

    //////////
    ///////////
//    Poczty

    @Autowired
    private PocztyDAO daoPoczta;

    @RequestMapping("/poczty")
    public String viewPoczty(Model model) {

        List<Poczta> listPoczta = daoPoczta.list();
        model.addAttribute("listPoczta", listPoczta);
        return "poczty";
    }

    @RequestMapping("/newPoczta")
    public String showNewFormPoczta(Model model) {

        Poczta poczta = new Poczta();
        model.addAttribute("poczta", poczta);

        return "poczty_new_form";
    }

    @RequestMapping(value = "/savePoczta", method = RequestMethod.POST)
    public String savePoczta(@ModelAttribute("poczta") Poczta poczta, Model model) {

        daoPoczta.save(poczta);

        List<Poczta> listPoczta = daoPoczta.list();
        model.addAttribute("listPoczta", listPoczta);

        return "poczty";
    }

    @RequestMapping("/editPoczta/{numer_poczty}")
    public ModelAndView showEditFormPoczta(@PathVariable(name = "numer_poczty") int numer_poczty) {
        ModelAndView mav = new ModelAndView("poczty_edit_form");
        Poczta poczta = daoPoczta.get(numer_poczty);
        mav.addObject("poczta", poczta);

        return mav;

    }

    @RequestMapping(value = "/updatePoczta", method = RequestMethod.POST)
    public String updatePoczta(@ModelAttribute("poczta") Poczta poczta, Model model) {
        daoPoczta.update(poczta);

        List<Poczta> listPoczta = daoPoczta.list();
        model.addAttribute("listPoczta", listPoczta);

        return "poczty";

    }

    @RequestMapping("/deletePoczta/{nr_poczty}")
    public String deletePoczta(@PathVariable(name = "nr_poczty") int nr_poczty, Model model) {
        daoPoczta.delete(nr_poczty);

        List<Poczta> listPoczta = daoPoczta.list();
        model.addAttribute("listPoczta", listPoczta);

        return "poczty";

    }


    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
    }
}
