package gunam.solarisgunam.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoLoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login-error")
    public String loginError(){
        return "login-error";
    }


    @RequestMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }

}
