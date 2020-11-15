package com.m.controller.filter;


import com.m.controller.BookController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BookFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        //服务请求，强转
        HttpServletRequest hreq = (HttpServletRequest) req;
        //响应服务，强转
        HttpServletResponse hresp = (HttpServletResponse) resp;
        HttpSession session = hreq.getSession();

        String uri = hreq.getRequestURI();
        String nameSpace = uri.split("/")[2];
        String method = uri.split("/")[3];
        hreq.setCharacterEncoding("UTF-8");
         try {
             if ("book".equals(nameSpace)) {
                 BookController book = new BookController();
                 book.setRequest(hreq);
                 book.setResponse((HttpServletResponse) hresp);
                 book.setSession(session);

                 if ("list.do".equals(method)) {
                     book.list();
                 } else if ("del.do".equals(method)) {
                     book.del();
                 } else if ("toUpdate.do".equals(method)) {
                     book.toUpdate();
                 } else if ("insertOrUpdate.do".equals(method)) {
                     book.insertOrUpdate();
                 }

             }
         }catch (Exception e){
             e.printStackTrace();
         }


    }
    @Override
    public void destroy() {

    }
}
