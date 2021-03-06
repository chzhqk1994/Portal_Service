package kr.ac.jejunu.spring;

import com.sun.deploy.net.HttpResponse;
import kr.ac.jejunu.hello.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@RequestMapping("/user")
@Controller
public class UserController {
    @GetMapping("/servlet")
    public void servlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        session.setAttribute("user", user);
        response.getWriter().println(String.format
                ("<h1> %s : %s </h1><br />", "ID", id));
        response.getWriter().println(String.format
                ("<h1> %s : %s </h1><br />", "Name", name));
        response.getWriter().println(String.format
                ("<h1> %s : %s </h1><br />", "Password", password));
        // 쿠키는 브라우저에 저장되는 것 >> 스트링으로만 저장 된다.
    }

    @GetMapping("/session")
    public ModelAndView session(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user",
                session.getAttribute("user"));
        return modelAndView;
    }

    @GetMapping("/path/{id}/{name:[a-z]+}")
    public ModelAndView user(@PathVariable Integer id, @PathVariable("name") String name,
                       @RequestParam("password") String password, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView("user");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        modelAndView.addObject("user", user);
        response.addCookie(new Cookie("id", String.valueOf(id)));
        response.addCookie(new Cookie("name", String.valueOf(name)));
        response.addCookie(new Cookie("password", String.valueOf(password)));
        return modelAndView;

    }

    @GetMapping("/cookie")
    public ModelAndView cookie(@CookieValue("id") Integer id, @CookieValue("name") String name,
                             @CookieValue("password") String password){
        ModelAndView modelAndView = new ModelAndView("user");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        modelAndView.addObject("user", user);
        return modelAndView;

    }

    @GetMapping
    public User user(){
        return new User();
    }

}
