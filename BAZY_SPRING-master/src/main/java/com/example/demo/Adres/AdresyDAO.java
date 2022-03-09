package com.example.demo.Adres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Adres> list() {

        String sql = "SELECT * FROM Adresy";

        List<Adres> listKlient = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Adres.class));

        listKlient.forEach(System.out :: println);

        return listKlient;

    }
    //    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(Adres adres) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("adresy").usingColumns("nr_adresu","nr_poczty", "miasto","ulica", "nr_domu", "nr_lokalu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        insertActor.execute(param);
    }

    public Adres get(int nr_adresu) {

        String sql = "SELECT * FROM ADRESY WHERE nr_adresu = ?";
        Object[] args = {nr_adresu};
        Adres adres = jdbcTemplate.queryForObject(sql,args,
                BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }

    public Adres get1(int nr_adresu) {
        Object[] args = {nr_adresu};
        String sql = "SELECT * FROM ADRESY WHERE nr_adresu = " + args[0];
        Adres adres = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }



    public void update(Adres adres) {
        String sql = "UPDATE ADRESY SET nr_poczty=:ne_poczty, miasto=:miasto, ulica=:ulica, nr_domu=:nr_domu, ne_lokalu=:ne_lokalu WHERE nr_adresu=:nr_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        NamedParameterJdbcTemplate template= new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_adresu){
        String sql = "DELETE FROM ADRESY WHERE nr_adresu = ?";
        jdbcTemplate.update(sql,nr_adresu);
    }}



