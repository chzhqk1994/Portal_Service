package kr.ac.jejunu.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Slf4j
public class HelloContextListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("***************** context listner init ******************");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("***************** context listner destroy ******************");

    }
}
