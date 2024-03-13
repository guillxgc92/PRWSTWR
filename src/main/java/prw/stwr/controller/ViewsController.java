package prw.stwr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"charRace"})
public class ViewsController {

	@GetMapping(value = {"/", "/index"})
	public String index() {
		
		return "index";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		
		return "subviews/login";
	}

	@GetMapping(value = "/register")
	public String register() {
		
		return "subviews/register";
	}

	@GetMapping(value = "/community")
	public String community() {
		
		return "subviews/community";
	}
	
	@GetMapping(value = "/information")
	public String info() {
		
		return "subviews/info";
	}
}
