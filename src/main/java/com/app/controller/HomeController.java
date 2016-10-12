package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.domain.entity.User;
import com.app.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(ModelMap model){
		User user = new User();
		user.setName("Nayab Rahil");
		user.setEmail("nayabrahil@gmail.com");
		user.setPassword("NoOneKnows");
		userService.save(user);
		model.addAttribute("message", "welcomeMessage");
		return "showMessage";
	}
	
	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
		model.addAttribute("message", "welcomeMessage");
        return "showMessage";
    }
}
