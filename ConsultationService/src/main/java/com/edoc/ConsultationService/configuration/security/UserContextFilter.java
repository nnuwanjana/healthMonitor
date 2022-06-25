package com.edoc.ConsultationService.configuration.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

@Component
public class UserContextFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Principal principal = ((HttpServletRequest) request).getUserPrincipal();
        UserPrincipal userPrincipal = (UserPrincipal) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        UserContextHolder.getContext().setUserId(userPrincipal.getUserId());
        chain.doFilter(httpServletRequest, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
