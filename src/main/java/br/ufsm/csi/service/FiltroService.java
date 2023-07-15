package br.ufsm.csi.service;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class FiltroService implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
       if(req.getSession().getAttribute("login") != null && req.getSession().getAttribute("login").equals("true") && req.getRequestURI().endsWith("index.jsp")){
           System.out.println("Entrou aqui");
           response.sendRedirect(req.getContextPath()+"/principal");
       }else if((req.getSession().getAttribute("login") == null || !req.getSession().getAttribute("login").equals("true")) && (
               req.getRequestURI().endsWith("principal") || req.getRequestURI().endsWith("edicao") || req.getRequestURI().endsWith("addFilme") || req.getRequestURI().endsWith("genero") || req.getRequestURI().endsWith("addgenero") || req.getRequestURI().endsWith("addSala")
               || req.getRequestURI().endsWith("sala")
//                       ||  req.getRequestURI().endsWith("viewFilme")

       )){
            System.out.println("Nao foi permitido a entrada nas paginas sem login");
            response.sendRedirect(req.getContextPath()+"/index.jsp");
        }
       else{
           filterChain.doFilter(servletRequest,servletResponse);
       }
    }

    @Override
    public void destroy() {

    }
}
