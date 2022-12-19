package com.tms.cars.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
public class HeaderFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (((HttpServletRequest) request).getMethod().equalsIgnoreCase("get")) {
            chain.doFilter(request, response);
        }
        String headerName = ((HttpServletRequest) request).getHeader("userName");

        if (headerName == null) {
            throw new ServletException("Enter your name");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
