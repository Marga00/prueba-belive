package com.globalia.belive.prueba.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	@Autowired
	private CacheManager cacheManager;

	@GetMapping (value = { "/" })
	public ModelAndView loadFormPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("html/form-page");

		return modelAndView;
	}

}
