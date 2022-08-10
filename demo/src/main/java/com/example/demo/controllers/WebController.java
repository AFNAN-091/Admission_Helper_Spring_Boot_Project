package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.userdatarepo;
import com.example.demo.model.user;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@Service
public class WebController {

	@RequestMapping({ "/home", "/", "/index" })
	public String getHomePage() {
		return "/index.html";
	}

	// public String value;

	@RequestMapping("/login")
	public String getLoginPage() {
		return "/login.html";
	}

	@RequestMapping("/footer")
	public String getFooterPage() {
		return "/footer.html";
	}

	@RequestMapping("/dashboard")
	public String getDashBoardPage() {
		return "/dashboard.html";
	}

	@RequestMapping("/landing")
	public String getLandingPage() {
		return "/landing.html";
	}

	@RequestMapping("/celandar")
	public String getCelandarPage() {
		return "/celandar.html";
	}

	@RequestMapping("/registration")
	public String getRegistrationPage() {
		return "/registration.html";
	}

	@RequestMapping("/apply")
	public String getApplyPage() {
		return "/apply.html";
	}

	@RequestMapping("/apply/BUET")
	public String getApplyBuetPage() {
		return "/BuetApply.html";
	}

	@RequestMapping("/apply/Engineering")
	public String getApplyEngineeringPage() {
		return "/EngineeringApply.html";
	}

	@RequestMapping("/apply/DU")
	public String getApplyDuPage() {
		return "/apply.html";
	}

	@RequestMapping("/apply/RU")
	public String getApplyRuPage() {
		return "/EngineeringApply.html";
	}

	@RequestMapping("/apply/GST")
	public String getApplyGstPage() {
		return "/apply.html";
	}

	@RequestMapping("/apply/AG")
	public String getApplyAgPage() {
		return "/apply.html";
	}

	@RequestMapping("/apply/MBA")
	public String getApplyMbaPage() {
		return "/MbaApply.html";
	}

	@RequestMapping("/result")
	public String getResultPage() {
		return "/result.html";
	}

	@RequestMapping("/notice")
	public String getNoticePage() {
		return "/notice.html";
	}

	@Autowired
	userdatarepo repo;

	@GetMapping("/Login")
	public String getLoginPage(@RequestParam String reg, @RequestParam String pass) {

		user info = repo.findByReg(reg);
		// user info2 = repo.findByPass(pass);
		// user damo = num(reg);
		System.out.println(reg);
		// System.out.println("Registration number " + info.getReg());
		// System.out.println("password " + info.getPass());
		// System.out.println("Roll " + info.getRoll());
		// System.out.println("Name " + info.getName());
		if (info == null) {
			System.out.println("Wrong");
			return "login";

		} else if (info.getPass().equals(pass)) {
			System.out.println("Correct");
			return "profile";
			// System.out.println(info.getPass());
		}
		// System.out.println("Wrong");
		return "login";

	}

	@RequestMapping("/profile")
	public ModelAndView getProfilePage() {
		// user person = new user();
		// person = repo.findByReg(value);
		// System.out.println("fasfj");
		// System.out.println(person.getName());
		ModelAndView model = new ModelAndView();
		model.setViewName("profile.html");
		// model.addObject("name", person.getName());
		// model.addObject("username", person.getName());
		// model.addObject("roll", person.getRoll());
		// model.addObject("reg", person.getReg());
		// System.out.println(person.getName());

		return model;

	}

	@GetMapping("/data")
	public String getinput(@RequestParam String name,
			@RequestParam String roll, @RequestParam String reg, @RequestParam String pass) {
		user n = new user();
		// System.out.print("yes");
		n.setName(name);
		n.setRoll(roll);
		n.setReg(reg);
		n.setPass(pass);
		// user person = new user();
		// person = repo.findByReg(reg);
		// if (person == null) {

		// return "redirect:/registration?Failed ! Registration Number already exist
		// :(";
		// }
		repo.save(n);

		return "login";
	}

}
