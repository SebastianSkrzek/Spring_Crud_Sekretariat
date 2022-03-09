package com.example.demo.Klient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KlienciDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public KlienciDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Klient> list() {

        String sql = "SELECT * FROM Klienci";

        List<Klient> listKlient = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Klient.class));

        listKlient.forEach(System.out :: println);

        return listKlient;

    }
    //    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(Klient klient) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Klienci").usingColumns("nr_klienta", "nr_adresu", "imie", "nazwisko","data_urodzenia", "pesel", "plec", "nr_telefonu", "e_mail");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        insertActor.execute(param);
    }

    public Klient get(int nr_klienta) {

        String sql = "SELECT * FROM Klienci WHERE nr_klienta = ?";
        Object[] args = {nr_klienta};
        Klient klient = jdbcTemplate.queryForObject(sql,args,
                BeanPropertyRowMapper.newInstance(Klient.class));
        return klient;
    }

    public Klient get1(int nr_klienta) {
        Object[] args = {nr_klienta};
        String sql = "SELECT * FROM Klienci WHERE nr_klienta = " + args[0];
        Klient klient = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Klient.class));
        return klient;
    }



    public void update(Klient klient) {
        String sql = "UPDATE Klienci SET nr_adresu=:nr_adresu, pesel=:pesel, plec=:plec, nr_telefonu=:nr_telefonu, e_mail=:e_mail WHERE nr_klienta=:nr_klienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        NamedParameterJdbcTemplate template= new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_klienta){
        String sql = "DELETE FROM Klienci WHERE nr_klienta = ?";
        jdbcTemplate.update(sql,nr_klienta);
    }





}
