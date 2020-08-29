package com.ebay.ironbank;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Evgeny Borisov
 */
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class AuthorizationHeaderFixFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        System.out.println(req.getRequestURI());
        MutableHttpServletRequest mutableRequest =
                new MutableHttpServletRequest((HttpServletRequest) servletRequest,servletRequest.getReader().lines().collect(Collectors.joining()));




        filterChain.doFilter(mutableRequest, servletResponse);
    }

    final class MutableHttpServletRequest extends HttpServletRequestWrapper {
        private String body;

        public MutableHttpServletRequest(HttpServletRequest request, String body) {
            super(request);
            this.body = body;
        }

        @Override
        public BufferedReader getReader() throws IOException {

            BufferedReader bufferedReader = new BufferedReader(new StringReader(body.toLowerCase()));

            return bufferedReader;
        }

    }
}
