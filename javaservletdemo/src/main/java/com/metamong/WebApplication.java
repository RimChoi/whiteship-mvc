package com.metamong;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebApplication implements WebApplicationInitializer {
    /**
     * Q. WebApplicationContext 에 Servlet Context 를 설정한 이유
     * A. DispatcherServlet 에 ServletContext 가 설정되어 있더라도,
     * DelegatingWebMvcConfiguration 에서 ViewResolverComposite 관련 설정할때 필요..
     * @param servletContext
     * @throws ServletException
     * {@link org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration}
     */

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setServletContext(servletContext);
        context.register(WebConfig.class);
        context.refresh();

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic app = servletContext.addServlet("app", dispatcherServlet);
        app.addMapping("/app/*");

    }
}
