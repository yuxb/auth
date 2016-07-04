package com.auth.exception;


import com.alibaba.druid.support.json.JSONUtils;
import com.auth.pojo.BusinessLog;
import com.auth.util.App;
import com.auth.util.Auth;
import com.auth.vo.ResponseEntity;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * 全局业务异常处理类
 * Created by yuxb on 16/5/20.
 */

public class AuthExceptionHandler implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse respose, Object handler, Exception ex) {
        System.out.println();
        ResponseEntity re= new ResponseEntity();
        re.setCode("500");
        re.setError("false");
        re.setInfo(getRootThrowable(ex).getMessage());
        BusinessLog businessLog=new BusinessLog();
        businessLog.setId(App.generateId());
        businessLog.setContent(re.getInfo());
        businessLog.setUrl(request.getContextPath());
        businessLog.setLevel(Auth.LogLevel.ERROR);
        if(isAjaxRequest(request)){

           try {
                PrintWriter rw=respose.getWriter();
                rw.write(JSONUtils.toJSONString(re));
           }catch (IOException e){
                e.printStackTrace();
           }

           return null;
        }
        request.setAttribute("responseEntity",re);
        return new ModelAndView("/common/error");
    }
    /**
     *判断是否ajax请求
     * */
    private static boolean isAjaxRequest(HttpServletRequest request) {
        return request.getHeader("x-requested-with") != null &&
                request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest");
    }
    /**
     *获取根异常
     **/
    private static Throwable getRootThrowable(Throwable throwable){
        if(throwable.getCause()!=null){
            return getRootThrowable(throwable.getCause());
        }
        return throwable;
    }
}
