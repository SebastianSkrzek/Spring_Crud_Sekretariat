package com.example.demo.Poczta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PocztyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PocztyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Poczta> list() {

        String sql = "SELECT * FROM Poczty";

        List<Poczta> listPoczta = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Poczta.class));

        listPoczta.forEach(System.out :: println);

        return listPoczta;

    }
    //    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(Poczta poczta) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Poczty").usingColumns("nr_poczty","kod_poczty","poczta");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczta);
        insertActor.execute(param);
    }

    public Poczta get(int nr_poczty) {

        String sql = "SELECT * FROM Poczty WHERE nr_poczty = ?";
        Object[] args = {nr_poczty};
        Poczta poczta = jdbcTemplate.queryForObject(sql,args,
                BeanPropertyRowMapper.newInstance(Poczta.class));
        return poczta;
    }

    public Poczta get1(int nr_poczty) {
        Object[] args = {nr_poczty};
        String sql = "SELECT * FROM Poczty WHERE nr_poczty = " + args[0];
        Poczta poczta = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Poczta.class));
        return poczta;
    }



    public void update(Poczta poczta) {
        String sql = "UPDATE Poczty SET kod_poczty=:kod_poczty, poczta=:poczta WHERE nr_poczty=:nr_poczty";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(poczta);
        NamedParameterJdbcTemplate template= new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_poczty){
        String sql = "DELETE FROM Poczty WHERE nr_poczty = ?";
        jdbcTemplate.update(sql,nr_poczty);
    }





}
