package com.auth.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by yuxb on 16/5/17.
 */
@Repository(value = "jdbcDao")
public class JdbcDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }





    public <T> List<T> query(String sql, Object[] args, int[] argTypes, RowMapper<T> rowMapper)  {
        return this.jdbcTemplate.query(sql, args, argTypes, rowMapper);
    }


    public <T> List<T> query(String sql, Object[] args, RowMapper<T> rowMapper)  {
        return this.jdbcTemplate.query(sql, args, rowMapper);
    }

    public <T> List<T> query(String sql, RowMapper<T> rowMapper)  {
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... args)  {
        return this.jdbcTemplate.query(sql, rowMapper, args);
    }


    public <T> T query(String sql, ResultSetExtractor<T> rse)  {
        return this.jdbcTemplate.query(sql, rse);
    }
    public  List queryByMap(String sql ,Map<String,?>map){
        if(null==map||map.isEmpty()){
            return this.queryForList(sql);
        }else{
            Iterator<String> it = map.keySet().iterator();
            StringBuffer queryString = new StringBuffer();
            queryString.append(sql).append(" where 1=1 ");
            Object[] values=map.values().toArray();
            String key;
            while (it.hasNext()) {
                key = it.next();
                queryString.append(" and ").append(key).append("=").append("?");
            }
            return this.queryForList(queryString.toString(),values);
        }
    }
    
    public List<Map<String, Object>> queryForList(String sql)  {
        return this.jdbcTemplate.queryForList(sql);
    }

    
    public <T> T query(String sql, ResultSetExtractor<T> rse, Object... args)  {
        return this.jdbcTemplate.query(sql, rse, args);
    }

    
    public List<Map<String, Object>> queryForList(String sql, Object... args)  {
        return this.jdbcTemplate.queryForList(sql, args);
    }

    
    public List<Map<String, Object>> queryForList(String sql, Object[] args, int[] argTypes)  {
        return this.jdbcTemplate.queryForList(sql, args, argTypes);
    }

    
    public <T> List<T> queryForList(String sql, Object[] args, int[] argTypes, Class<T> elementType)  {
        return this.jdbcTemplate.queryForList(sql, args, argTypes, elementType);
    }

    
    public <T> List<T> queryForList(String sql, Object[] args, Class<T> elementType)  {
        return this.jdbcTemplate.queryForList(sql, args, elementType);
    }

    
    public <T> List<T> queryForList(String sql, Class<T> elementType)  {
        return this.jdbcTemplate.queryForList(sql, elementType);
    }

    
    public <T> List<T> queryForList(String sql, Class<T> elementType, Object... args)  {
        return this.jdbcTemplate.queryForList(sql, elementType, args);
    }

    
    public Map<String, Object> queryForMap(String sql)  {
        return this.jdbcTemplate.queryForMap(sql);
    }

    
    public Map<String, Object> queryForMap(String sql, Object... args)  {
        return this.jdbcTemplate.queryForMap(sql, args);
    }

    
    public Map<String, Object> queryForMap(String sql, Object[] args, int[] argTypes)  {
        return this.jdbcTemplate.queryForMap(sql, args, argTypes);
    }

    
    public <T> T queryForObject(String sql, Object[] args, int[] argTypes, Class<T> requiredType)  {
        return this.jdbcTemplate.queryForObject(sql, args, argTypes, requiredType);
    }

    
    public <T> T queryForObject(String sql, Object[] args, int[] argTypes, RowMapper<T> rowMapper)  {
        return this.jdbcTemplate.queryForObject(sql, args, argTypes, rowMapper);
    }

    
    public <T> T queryForObject(String sql, Object[] args, Class<T> requiredType)  {
        return this.jdbcTemplate.queryForObject(sql, args, requiredType);
    }

    
    public <T> T queryForObject(String sql, Object[] args, RowMapper<T> rowMapper)  {
        return this.jdbcTemplate.queryForObject(sql, args, rowMapper);
    }

    
    public <T> T queryForObject(String sql, Class<T> requiredType)  {
        return this.jdbcTemplate.queryForObject(sql, requiredType);
    }

    
    public <T> T queryForObject(String sql, Class<T> requiredType, Object... args)  {
        return this.jdbcTemplate.queryForObject(sql, requiredType, args);
    }

    
    public <T> T queryForObject(String sql, RowMapper<T> rowMapper)  {
        return this.jdbcTemplate.queryForObject(sql, rowMapper);
    }

    
    public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args)  {
        return this.jdbcTemplate.queryForObject(sql, rowMapper, args);
    }


    public SqlRowSet queryForRowSet(String sql)  {
        return this.jdbcTemplate.queryForRowSet(sql);
    }

    
    public SqlRowSet queryForRowSet(String sql, Object... args)  {
        return this.jdbcTemplate.queryForRowSet(sql, args);
    }

    
    public SqlRowSet queryForRowSet(String sql, Object[] args, int[] argTypes)  {
        return this.jdbcTemplate.queryForRowSet(sql, args, argTypes);
    }

    
    public int update(String sql, Object[] args, int[] argTypes)  {
        return this.jdbcTemplate.update(sql, args, argTypes);
    }
    public int update(String sql, Object... args)  {
        return this.jdbcTemplate.update(sql, args);
    }
    public int[] batchUpdate(String sql, List<Object[]> batchArgs, int[] argTypes)  {
        return this.jdbcTemplate.batchUpdate(sql, batchArgs, argTypes);
    }


    public int[] batchUpdate(String sql, List<Object[]> batchArgs)  {
        return this.jdbcTemplate.batchUpdate(sql, batchArgs);
    }


    public int[] batchUpdate(String... sql)  {
        return this.jdbcTemplate.batchUpdate(sql);
    }

    public <T> T execute(ConnectionCallback<T> action)  {
        return this.jdbcTemplate.execute(action);
    }

    public void execute(String sql)  {
        this.jdbcTemplate.execute(sql);
    }
    
}
