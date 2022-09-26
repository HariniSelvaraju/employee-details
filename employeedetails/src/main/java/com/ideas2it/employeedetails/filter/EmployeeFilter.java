package com.ideas2it.employeedetails.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class EmployeeFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeFilter.class);

    public void doFilter(ServletRequest servletrequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOG.info("successful");
        filterChain.doFilter(servletrequest, servletResponse);
    }
}
