package com.auth.interceptor;

import com.auth.util.ServletUtil;
import com.auth.pojo.User;
import com.auth.util.Util;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by yuxb on 16/6/6.
 */

public class HibernateInterceptor extends EmptyInterceptor {
    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        for (int index = 0, n = propertyNames.length; index < n; index++) {
            if ("createTime".equals(propertyNames[index])) {
                state[index] =LocalDateTime.now();
            } else if ("createUser".equals(propertyNames[index])) {
                User user= (User)ServletUtil.getSession().getAttribute("user");
                if(Util.notNull(user)){
                    state[index]=user.getId();
                }


            }
        }
        return true;
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {

        for (int index=0,n=propertyNames.length;index<n;index++){


        }
        return true;
    }
}
