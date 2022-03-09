package com.example.demo.Spotkanie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpotkaniaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SpotkaniaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Spotkanie> list() {

        String sql = "SELECT * FROM Spotkania";

        List<Spotkanie> listSpotkanie = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Spotkanie.class));

        listSpotkanie.forEach(System.out :: println);

        return listSpotkanie;

    }
    //    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(Spotkanie spotkanie) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Spotkania").usingColumns("nr_spotkania", "nr_sali","nr_pracownika", "data_rozpoczecia_spotkania", "data_zakonczenia_spotkania");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(spotkanie);
        insertActor.execute(param);
    }

    public Spotkanie get(int nr_spotkania) {

        String sql = "SELECT * FROM Spotkania WHERE nr_spotkania = ?";
        Object[] args = {nr_spotkania};
        Spotkanie spotkanie = jdbcTemplate.queryForObject(sql,args,
                BeanPropertyRowMapper.newInstance(Spotkanie.class));
        return spotkanie;
    }

    public Spotkanie get1(int nr_spotkania) {
        Object[] args = {nr_spotkania};
        String sql = "SELECT * FROM Spotkania WHERE nr_spotkania = " + args[0];
        Spotkanie spotkanie = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Spotkanie.class));
        return spotkanie;
    }



    public void update(Spotkanie spotkanie) {
        String sql = "UPDATE Spotkanie SET nr_pracownika=:nr_pracownika, nr_sali=:nr_sali, data_rozpoczecia_spotkania=:data_rozpoczenia_spotkania,data_zakonczenia_spotkania=:data_zakonczenia_spotkania WHERE nr_spotkania=:nr_spotkania";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(spotkanie);
        NamedParameterJdbcTemplate template= new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_spotkania){
        String sql = "DELETE FROM Spotkania WHERE nr_spotkania = ?";
        jdbcTemplate.update(sql,nr_spotkania);
    }





}
