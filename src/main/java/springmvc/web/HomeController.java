package springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: ZHANG
 * @Date: 2020/1/6
 * @Description:
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
