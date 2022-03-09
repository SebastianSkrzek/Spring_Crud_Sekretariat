package com.example.demo.Dzial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DzialyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DzialyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Dzial> list() {

        String sql = "SELECT * FROM Dzialy";

        List<Dzial> listDzial = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Dzial.class));

        listDzial.forEach(System.out :: println);

        return listDzial;

    }
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(Dzial dzial) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("dzialy").usingColumns("nr_dzialu","nazwa_dzialu", "data_powstania_dzialu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(dzial);
        insertActor.execute(param);
    }

    public Dzial get(int nr_dzialu) {

        String sql = "SELECT * FROM Dzialy WHERE nr_dzialu = ?";
        Object[] args = {nr_dzialu};
        Dzial dzial = jdbcTemplate.queryForObject(sql,args,
                BeanPropertyRowMapper.newInstance(Dzial.class));
        return dzial;
    }

    public Dzial get1(int nr_dzialu) {
        Object[] args = {nr_dzialu};
        String sql = "SELECT * FROM Dzialy WHERE nr_dzialu = " + args[0];
        Dzial dzial = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Dzial.class));
        return dzial;
    }



    public void update(Dzial dzial) {
        String sql = "UPDATE DZIALY SET nazwa_dzialu=:nazwa_dzialu, data_powstania_dzialu=:data_powstania_dzialu WHERE nr_dzialu=:nr_dzialu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(dzial);
        NamedParameterJdbcTemplate template= new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int nr_dzialu){
        String sql = "DELETE FROM DZIALY WHERE nr_dzialu = ?";
        jdbcTemplate.update(sql,nr_dzialu);
    }





}
