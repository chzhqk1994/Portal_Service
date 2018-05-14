package kr.ac.jejunu.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@Slf4j
@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends GenericServlet {
    @Override
    public void destroy() {  // 자원해지
        System.out.println("***************** servlet destroy ******************");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {  // 첫 request 땐 얘가 호출이 됨
        System.out.println("***************** servlet init ******************");
        super.init();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException { // 그 다음 request 부턴 얘가 호출됨
        System.out.println("***************** servlet service ******************");
//        Log.info("***************** servlet service ******************");                           // 실질적으로 동작되는 액션은 여기에 구현
        res.getWriter().println("<h1> Hello World !!! </h1>");
    }
}
