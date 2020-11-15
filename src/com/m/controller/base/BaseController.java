package com.m.controller.base;

import com.m.controller.BookController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class BaseController {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public void list() throws ServletException, IOException, Exception {
    }

    public void del() throws Exception {
    }

    public void toUpdate() throws Exception {
    }

    public void insertOrUpdate() throws Exception {
    }

}
