package kr.ac.jejunu.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@org.springframework.stereotype.Controller
@RequestMapping("/helloworld")
@Slf4j
public class SimpleController {

    @GetMapping("/hi")
    public ModelAndView hello() {
        System.out.printf("****************** handler *******************");
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("hello", "Hello World!!!");

        return modelAndView;
    }

    @ExceptionHandler(NullPointerException.class)
    public String error(NullPointerException e) {
        return "error";
    }

    @GetMapping(path="/upload")
    public String upload(){
        return "upload";
    }

    @PostMapping(path="/upload")
    public ModelAndView upload(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IOException {
        File path = new File(request.getServletContext().getRealPath("/") + "/WEB-INF/static/" + file.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream); // 용량이 크면 버퍼로 조각조각 나눠서 Stream 을 옮김
        bufferedOutputStream.write(file.getBytes());
        bufferedOutputStream.close();  // 반드시 Close 해야 함, 안닫히면 계속 더미가 쌓이게
        ModelAndView modelAndView = new ModelAndView("upload");  // 업로드 되면 WEB-INF/static/ 에 저장이 됨
        modelAndView.addObject("url", "/images/" + file.getOriginalFilename());
        return modelAndView;
    }
}
