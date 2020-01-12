package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ZHANG
 * @Date: 2020/1/6
 * @Description:
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("show/{id}")
    public String getUser(@PathVariable String id) {
        return "aaaa";
    }
}
