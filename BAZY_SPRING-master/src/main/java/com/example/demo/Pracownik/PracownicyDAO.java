package com.example.demo.Pracownik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PracownicyDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Pracownik> list() {

        String sql = "SELECT * FROM Pracownicy";

        List<Pracownik> listPracownik = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Pracownik.class));

        listPracownik.forEach(System.out :: println);

        return listPracownik;

    }
    //    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(Pracownik pracownik) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Pracownicy").usingColumns("nr_pracownika", "nr_dzialu", "nr_adresu", "imie", "nazwisko","data_urodzenia", "plec", "stanowisko", "data_zatrudnienia", "e_mail", "pesel", "waznosc_zatrudnienia", "nr_telefonu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        insertActor.execute(param);
    }

    public Pracownik get(int nr_pracownika) {

        String sql = "SELECT * FROM Pracownicy WHERE nr_pracownika = ?";
        Object[] args = {nr_pracownika};
        Pracownik pracownik = jdbcTemplate.queryForObject(sql,args,
                BeanPropertyRowMapper.newInstance(Pracownik.class));
        return pracownik;
    }

    public Pracownik get1(int nr_pracownika) {
        Object[] args = {nr_pracownika};
        String sql = "SELECT * FROM Pracownicy WHERE nr_pracownika = " + args[0];
        Pracownik pracownik = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Pracownik.class));
        return pracownik;
    }



    public void update(Pracownik pracownik) {
        String sql = "UPDATE Pracownicy SET nr_dzialu=:nr_dzialu, nr_adresu=:nr_adresu, waznosc_zatrudnienia=:waznosc_zatrudnienia, stanowisko=:stanowisko, pesel=:pesel, plec=:plec, nr_telefonu=:nr_telefonu, e_mail=:e_mail WHERE nr_pracownika=:nr_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template= new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_pracownika){
        String sql = "DELETE FROM Pracownicy WHERE nr_pracownika = ?";
        jdbcTemplate.update(sql,nr_pracownika);
    }





}
