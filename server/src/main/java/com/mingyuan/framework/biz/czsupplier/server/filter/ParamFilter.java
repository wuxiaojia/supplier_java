package com.mingyuan.framework.biz.czsupplier.server.filter;

import com.mingyuan.framework.biz.czsupplier.server.bean.ReqParamWrapper;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Order(1)
@WebFilter(filterName = "param filter", urlPatterns = {"/*"})
public class ParamFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        ReqParamWrapper reqParamWrapper = new ReqParamWrapper(request);
        filterChain.doFilter(reqParamWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
