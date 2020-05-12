package com.skoczewski;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Hello", urlPatterns = {"/api/*"})
public class HelloServlet extends HttpServlet {
    private static final String NAME_PARAM = "name";

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private HelloService service = new HelloService();

    /**
     * Servlet container need it
     */
    public HelloServlet() {}

    public HelloServlet(HelloService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Request with parameters: " + req.getParameterMap());
        resp.getWriter().write(service.prepareGreeting(req.getParameter(NAME_PARAM)));

    }
}
