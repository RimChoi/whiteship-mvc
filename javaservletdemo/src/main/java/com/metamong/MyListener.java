package com.metamong;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Memo.
 *  서블릿 리스너 분류
 *  - 서블릿 컨텍스트 수준의 Event
 *      - 컨텍스트 라이프사이클 이벤트 (*)
 *      - 컨텍스트 애트리뷰트 변경 이벤트
 *  - 세션 수준의 이벤트
 *      - 세션 라이프사이클 이벤트
 *      - 세션 애트리뷰트 변경 이벤트
 *
 *  각 각의 경우마다 구현해야할 인터페이스가 다르다.
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Context Initialized");
        sce.getServletContext().setAttribute("name", "metamong");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context Destroyed");
    }
}
