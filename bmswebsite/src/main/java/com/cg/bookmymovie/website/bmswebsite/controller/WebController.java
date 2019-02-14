package com.cg.bookmymovie.website.bmswebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cg.bookmymovie.website.bmswebsite.entity.Profile;

@Controller
public class WebController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String form() {
		return "index";
	}

	@RequestMapping("/Signup")
	public String createProfile(Model model) {
		// model.addAttribute("profile", new Profile());
		return "Signup";
	}

	@RequestMapping("/add")
	public String create(@ModelAttribute Profile profile, Model model) {
		restTemplate.postForEntity("http://localhost:5062/profiles", profile, null);
		// System.out.println(profile);
		model.addAttribute("message", "Your profile has been successfully created....!!!!");
		// model.addAttribute("profile", new Profile());
		return "Signup";
	}

	@RequestMapping("/deleteProfile")
	public String deleteProfile() {
		return "DeleteProfile";
	}

	@RequestMapping("/delete")
	public String delete(@ModelAttribute Profile profile, Model model) {
		restTemplate.postForEntity("http://localhost:5062/profiles/deleteProfile", profile, null);
		model.addAttribute("message", "Your profile has been successfully deleted....!!!!");
		return "DeleteProfile";
	}
}
