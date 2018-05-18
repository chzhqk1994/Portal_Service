package kr.ac.jejunu.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class HelloInterceptor implements HandlerInterceptor{  // 로그인 처리 할 때 유용하다.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception { // 핸들러 메소드를 콜 하기 전에 프리핸들이 콜 된다
        System.out.printf("****************** prehandle *******************");
        return true; // true 라고 해야 Handler 까지 간다(?)
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception { //프리핸들이 콜 되고 나서 포스트 핸들이 콜 된다.
        System.out.printf("****************** posthandle *******************");
        System.out.println((String) modelAndView.getModel().get("hello"));

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
