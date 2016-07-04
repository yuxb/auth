package com.auth.vo;

import com.auth.exception.InvalidAttributeValueException;
import com.auth.util.Auth;
import lombok.Data;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuxb on 16/6/5.
 */
@Data
public class SearchFilter {

    private int pageNo=1;
    private int pageSize=20;
    private List<QueryField> queryFieldList=new ArrayList<>();
    public SearchFilter add(QueryField queryField){
        queryFieldList.add(queryField);
        return this;
    }

    private SearchFilter() {

    }

    private SearchFilter(List<QueryField> queryFieldList) {
        this.queryFieldList = queryFieldList;
    }
    public static SearchFilter newInstance() {

        SearchFilter instance = new SearchFilter();
        return instance;
    }

    public static SearchFilter newInstance(List<QueryField> queryFieldList) {

        SearchFilter instance= new SearchFilter(queryFieldList);
        return instance;
    }

    /**
     * 获取查询对象
     * @param clazz
     * @return
     */
    public DetachedCriteria getDetachedCriteria(Class clazz){
        DetachedCriteria detachedCriteria=DetachedCriteria.forClass(clazz);
        for (QueryField queryField:queryFieldList){
            String key = queryField.getKey();
            String type=queryField.getType();
            if (Auth.QueryType.LIKE.equals(type)) {
                detachedCriteria.add(Restrictions.like(key, "%" + queryField.getValue().trim() + "%"));
            } else if (Auth.QueryType.EQ.equals(type)) {
                if(Auth.JavaDataType.LONG.equals(type)){
                    detachedCriteria.add(Restrictions.eq(key, Long.parseLong(queryField.getValue().trim())));
                }else if(Auth.JavaDataType.INTEGER.equals(type)){
                    detachedCriteria.add(Restrictions.eq(key, Integer.parseInt(queryField.getValue().trim())));
                }else{
                    detachedCriteria.add(Restrictions.eq(key, queryField.getValue().trim()));
                }
            } else if (Auth.QueryType.GE.equals(type)) {
                detachedCriteria.add(Restrictions.ge(key, queryField.getValue().trim()));
            } else if (Auth.QueryType.GT.equals(type)) {
                detachedCriteria.add(Restrictions.gt(key, queryField.getValue().trim()));
            } else if (Auth.QueryType.LE.equals(type)) {
                detachedCriteria.add(Restrictions.le(key, queryField.getValue().trim()));
            } else if (Auth.QueryType.LT.equals(type)) {
                detachedCriteria.add(Restrictions.lt(key, queryField.getValue().trim()));
            } else if (Auth.QueryType.IN.equals(type)) {
                detachedCriteria.add(Restrictions.in(key, queryField.getValue().trim().split(",")));
            }else{
                throw new InvalidAttributeValueException("不可知的数据库查询条件["+type+"]");
            }
        }
        return detachedCriteria;
    }

    /**
     * 获取hql查询过滤条件,注意原hql 需自行拼接1=1 或者其他条件,此处全部加上了and
     * @return
     */
    public String getHqlFilter(){
        StringBuffer sb=new StringBuffer();
        for (QueryField queryField:queryFieldList) {
            sb.append(" and ").append(queryField.getKey()).append(queryField.getType()).append("?");
        }
        return sb.toString();
    }

    /**
     * 获取hql过滤条件所对应的值,即条件中 ? 号所对应的值
     * @return
     */
    public Object[] getHqlFilterValues(){
       List<Object> valueList=new ArrayList<>(queryFieldList.size());
        for(QueryField queryFiled:queryFieldList){
            valueList.add(queryFiled.getValue().trim());
        }
        return valueList.toArray();
    }
}
