package kr.ac.jejunu.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@WebFilter
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("***************** filter init ******************");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("***************** filter start ******************");

        chain.doFilter(request, response);
        System.out.println("***************** filter end ******************");

    }

    @Override
    public void destroy() {
        System.out.println("***************** filter destroy ******************");

    }
}
