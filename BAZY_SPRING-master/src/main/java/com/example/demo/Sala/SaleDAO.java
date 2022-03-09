package com.example.demo.Sala;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SaleDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Sala> list() {

        String sql = "SELECT * FROM Sale";

        List<Sala> listSala = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Sala.class));

        listSala.forEach(System.out :: println);

        return listSala;

    }
    //    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(Sala sala) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Sale").usingColumns("nr_sali","nr_dzialu", "nazwa_sali","rezerwacja_sali_od", "rezerwacja_sali_do", "ilosc_miejsc_do_siedzenia", "ilosc_komputerow", "powierzchnia");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sala);
        insertActor.execute(param);
    }

    public Sala get(int nr_sali) {

        String sql = "SELECT * FROM Sale WHERE nr_sali = ?";
        Object[] args = {nr_sali};
        Sala sala = jdbcTemplate.queryForObject(sql,args,
                BeanPropertyRowMapper.newInstance(Sala.class));
        return sala;
    }

    public Sala get1(int nr_sali) {
        Object[] args = {nr_sali};
        String sql = "SELECT * FROM Sale WHERE nr_sali = " + args[0];
        Sala sala = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Sala.class));
        return sala;
    }



    public void update(Sala sala) {
        String sql = "UPDATE Sale SET nazwa_sali=:nazwa_sali, rezerwacja_sali_od=:rezerwacja_sali_od, rezerwacja_sali_do=:rezerwacja_sali_do, ilosc_miejsc_do_siedzenia=:ilosc_miejsc_do_siedzenia, ilosc_komputerow=:ilosc_komputerow, powierzchnia=:powierzchnia WHERE nr_sali=:nr_sali";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sala);
        NamedParameterJdbcTemplate template= new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_sali){
        String sql = "DELETE FROM Sale WHERE nr_sali = ?";
        jdbcTemplate.update(sql,nr_sali);
    }





}
