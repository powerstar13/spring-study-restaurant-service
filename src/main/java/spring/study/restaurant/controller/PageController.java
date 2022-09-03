package spring.study.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pages")
public class PageController {

    @GetMapping("/main")
    public ModelAndView main() { // ModelAndView: thymeleaf가 사용
        return new ModelAndView("page/main"); // resources/templates 하위에 있는 html 파일 경로
    }
}
