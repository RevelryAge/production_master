package cn.lp.control;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
//
	 @RequestMapping("/")
	    public String hello(Model m) {
	        return "login";
	    }
//	  @RequestMapping("/hello")
//	    public String hello() {
//	        return "Hello Spring Boot!";
//	    }
}
