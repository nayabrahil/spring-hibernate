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
		model.addAttribute("message", "Nayab Rahil");
		for(User user : userService.findAllUser()){
			System.out.println(user.getName());
		}
		return "showMessage";
	}
	
	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("message", "welcomeMessage");
        return "showMessage";
    }
}
