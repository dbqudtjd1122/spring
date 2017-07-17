package com.spring61.mvc.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring61.mvc.model.ModelPhone;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PhoneController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);
	
	@RequestMapping(value = "/phone/writeone", method = RequestMethod.GET)
	public String writeone(Locale locale, Model model) {
		logger.info("writeone :: get", locale);
		
		return "phone/writeOneForm";
	}
    @RequestMapping(value = "/phone/writeone1", method = RequestMethod.POST)
    public String writeone1(Locale locale, Model model, HttpServletRequest request) {
        logger.info("writeone1 :: post", locale);
        
        String name         = request.getParameter("name");
        String manufacturer = request.getParameter("manufacturer");
        Integer price       = Integer.valueOf(  request.getParameter("price") );
        
        ModelPhone phone = new ModelPhone(name, manufacturer, price);
        
        model.addAttribute("phone", phone);
        
        return "phone/writeOneResult";
    }
}
