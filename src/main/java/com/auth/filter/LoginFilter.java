package com.auth.filter;

import com.auth.util.Auth;
import com.auth.util.Util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by yuxb on 16/6/22.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        String ctxPath = req.getContextPath();
        if (Util.notNull(req.getSession().getAttribute(Auth.CURRENT_USER)) || isLogin(uri, ctxPath)) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher("/renderLogin").forward(request, response);
        }
    }

    private boolean isLogin(String uri, String ctxPath) {
        return uri.startsWith(ctxPath + "/login") || uri.startsWith(ctxPath + "/renderLogin")
                || uri.startsWith(ctxPath + "/common/index")
                || uri.startsWith(ctxPath+"/resources");
    }

    @Override
    public void destroy() {
        //Do nothing
    }
}
