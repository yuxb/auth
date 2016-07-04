package com.auth.dao;

import com.auth.vo.Page;
import org.hibernate.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by yuxb on 16/5/16.
 */
@Repository(value = "hibernateDao")
public class HibernateDao {

    @Autowired
    private SessionFactory sessionFactory;

    public HibernateDao() {

    }

    public <T extends Serializable> void save(T t) {
        this.getSession().save(t);
    }

    /**
     * <保存或者更新实体>
     *
     * @param t 实体
     */

    public <T extends Serializable> void saveOrUpdate(T t) {
        this.getSession().saveOrUpdate(t);
    }

    /**
     * <load>
     * <加载实体的load方法>
     *
     * @param id 实体的id
     * @return 查询出来的实体
     */
    public final <T extends Serializable> T load(Class<T> c, Long id) {
        T load = (T) this.getSession().load(c, id);
        return load;
    }

    /**
     * <get>
     * <查找的get方法>
     *
     * @param id 实体的id
     * @return 查询出来的实体
     */
    public <T extends Serializable> T get(Class<T> c, Long id) {
        T load = (T) this.getSession().get(c, id);
        return load;
    }

    /**
     * <contains>
     *
     * @param t 实体
     * @return 是否包含
     */
    public <T extends Serializable> boolean contains(T t) {
        return this.getSession().contains(t);
    }

    /**
     * <delete>
     * <删除表中的t数据>
     *
     * @param t 实体
     */
    public <T extends Serializable> void delete(T t) {
        this.getSession().delete(t);
    }

    /**
     * <根据ID删除数据>
     *
     * @param id 实体id
     * @return 是否删除成功
     */
    public <T extends Serializable> boolean deleteById(Class<T> c, Long id) {
        T t = get(c, id);
        if (t == null) {
            return false;
        }
        delete(t);
        return true;
    }

    /**
     * <删除所有>
     *
     * @param entities 实体的Collection集合
     */
    public <T extends Serializable> void deleteAll(Collection<T> entities) {
        for (Object entity : entities) {
            this.getSession().delete(entity);
        }
    }

    /**
     * <执行Hql语句>
     *
     * @param hql    hql
     * @param values 不定参数数组
     */
    public void queryHql(String hql, Object... values) {
        Query query = this.getSession().createQuery(hql);
        setParam(query, values);
        query.executeUpdate();
    }

    /**
     * <执行Sql语句>
     *
     * @param sql    sql
     * @param values 不定参数数组
     */
    public void querySql(String sql, Object... values) {
        Query query = this.getSession().createSQLQuery(sql);
        setParam(query, values);
        query.executeUpdate();
    }

    private void setParam(Query query, Object[] values) {
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
    }

    /**
     * <根据HQL语句查找唯一实体>
     *
     * @param hqlString HQL语句
     * @param values    不定参数的Object数组
     * @return 查询实体
     */
    public <T extends Serializable> T getByHQL(String hqlString, Object... values) {
        Query query = this.getSession().createQuery(hqlString);
        setParam(query, values);
        return (T) query.uniqueResult();
    }

    /**
     * <根据SQL语句查找唯一实体>
     *
     * @param sqlString SQL语句
     * @param values    不定参数的Object数组
     * @return 查询实体
     */
    public <T extends Serializable> T getBySQL(String sqlString, Object... values) {
        Query query = this.getSession().createSQLQuery(sqlString);

        setParam(query, values);
        return (T) query.uniqueResult();
    }

    /**
     * <根据HQL语句，得到对应的list>
     *
     * @param hqlString HQL语句
     * @param values    不定参数的Object数组
     * @return 查询多个实体的List集合
     */
    public <T extends Serializable> List<T> getListByHQL(String hqlString, Object... values) {
        Query query = this.getSession().createQuery(hqlString);
        setParam(query, values);
        return query.list();
    }

    /**
     * <根据SQL语句，得到对应的list>
     *
     * @param sqlString HQL语句
     * @param values    不定参数的Object数组
     * @return 查询多个实体的List集合
     */
    public <T extends Serializable> List<T> getListBySQL(String sqlString, Object... values) {
        Query query = this.getSession().createSQLQuery(sqlString);
        setParam(query, values);
        return query.list();
    }


    /**
     * <refresh>
     *
     * @param t 实体
     */
    public <T extends Serializable> void refresh(T t) {
        this.getSession().refresh(t);
    }

    /**
     * <update>
     *
     * @param t 实体
     */
    public <T extends Serializable> void update(T t) {
        this.getSession().update(t);
    }

    /**
     * <根据HQL得到记录数>
     *
     * @param hql    HQL语句
     * @param values 不定参数的Object数组
     * @return 记录总数
     */
    public Long countByHql(String hql, Object... values) {
        Query query = this.getSession().createQuery(hql);
        setParam(query, values);
        return (Long) query.uniqueResult();
    }

    /**
     * <HQL分页查询>
     *
     * @param hql      HQL语句
     * @param countHql 查询记录条数的HQL语句
     * @param pageNo   下一页
     * @param pageSize 一页总条数
     * @param values   不定Object数组参数
     * @return Page封装类，里面包含了页码的信息以及查询的数据List集合
     */
    public <T extends Serializable> Page<T> findPageByFetchedHql(String hql, String countHql,
                                                                 int pageNo, int pageSize, Object... values) {
        Page<T> retValue = new Page<T>();
        Query query = this.getSession().createQuery(hql);
        setParam(query, values);
        int currentPage = pageNo > 1 ? pageNo : 1;
        retValue.setCurrentPage(currentPage);
        retValue.setPageSize(pageSize);
        if (countHql == null) {
            ScrollableResults results = query.scroll();
            results.last();
            retValue.setTotalCount(results.getRowNumber() + 1);// 设置总记录数
        } else {
            Long count = countByHql(countHql, values);
            retValue.setTotalCount(count.intValue());
        }
        retValue.resetPageNo();
        List<T> itemList = query.setFirstResult((currentPage - 1) * pageSize).setMaxResults(pageSize).list();
        if (itemList == null) {
            itemList = new ArrayList<T>();
        }
        retValue.setResults(itemList);

        return retValue;
    }
    public <T extends Serializable> List<T> getALl(Class c){
        return this.getListByHQL("from "+c.getSimpleName());
    }

    public <T extends Serializable> List<T>findByMap(Class c, Map<String,?>map){
        if(null==map||map.isEmpty()){
            return this.getALl(c);
        }else{
            Iterator<String> it = map.keySet().iterator();
            StringBuffer queryString = new StringBuffer();
            queryString.append("from ").append(c.getSimpleName()).append(" where 1=1 ");
            String key;
            Object[] values=map.values().toArray();
            while (it.hasNext()) {
                key = it.next();
                queryString.append(" and ").append(key).append("=").append("?");
            }
            return this.getListByHQL(queryString.toString(),values);
        }
    }

    public <T extends Serializable> Page<T> queryPageByHql(String hql,int  pageNo,int pageSize){
        Session session=this.sessionFactory.getCurrentSession();
        Query query=session.createQuery(hql);
        int totalCount=query.list().size();
        if(totalCount<=0){
            return  new Page<T>();
        }else {
            query.setFirstResult(pageNo).setMaxResults(pageSize);
            List items = query.list();
            return new  Page( pageNo,  pageSize,  totalCount, (List<T>) items);
        }
    }

    public Page queryPage(final DetachedCriteria detachedCriteria, final List<Order> orders,
                          final int pageSize, final int pageNo, final boolean distinctRootEntity,
                          final boolean isOffset) {
                Criteria criteria = detachedCriteria.getExecutableCriteria(this.getSession());
                int totalCount = ((Integer) criteria.setProjection(Projections.rowCount())
                        .uniqueResult()).intValue();
                if (totalCount < 1) {
                    return new Page();
                } else {
                    criteria.setProjection(null);
                    if (orders != null && orders.size() > 0) {
                        for (Order order : orders) {
                            criteria.addOrder(order);
                        }
                    }

                    if (distinctRootEntity) {
                        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                    }
                    if (isOffset) {
                        criteria.setFirstResult(pageNo);
                        criteria.setMaxResults(pageSize);
                    } else {
                        criteria.setFirstResult(pageNo);
                        criteria.setMaxResults(totalCount);
                    }
                    List items = criteria.list();
                    return new Page(pageNo, totalCount, pageSize, items);
                }


    }
    /**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @return session
     */
    public Session getSession() {
        //需要开启事物，才能得到CurrentSession
        return sessionFactory.getCurrentSession();
    }

    /**
     * 设置每行批处理参数
     *
     * @param ps
     * @param pos  ?占位符索引，从0开始
     * @param data
     * @throws SQLException
     * @see [类、类#方法、类#成员]
     */
    private void setParameter(PreparedStatement ps, int pos, Object data)
            throws SQLException {
        if (data == null) {
            ps.setNull(pos + 1, Types.VARCHAR);
            return;
        }
        Class dataCls = data.getClass();
        if (String.class.equals(dataCls)) {
            ps.setString(pos + 1, (String) data);
        } else if (boolean.class.equals(dataCls)) {
            ps.setBoolean(pos + 1, ((Boolean) data));
        } else if (int.class.equals(dataCls)) {
            ps.setInt(pos + 1, (Integer) data);
        } else if (double.class.equals(dataCls)) {
            ps.setDouble(pos + 1, (Double) data);
        } else if (Date.class.equals(dataCls)) {
            Date val = (Date) data;
            ps.setTimestamp(pos + 1, new Timestamp(val.getTime()));
        } else if (BigDecimal.class.equals(dataCls)) {
            ps.setBigDecimal(pos + 1, (BigDecimal) data);
        } else {
            // 未知类型
            ps.setObject(pos + 1, data);
        }

    }


}
