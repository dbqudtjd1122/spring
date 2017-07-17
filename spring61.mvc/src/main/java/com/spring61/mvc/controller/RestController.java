package com.spring61.mvc.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring61.mvc.model.ModelLogin;
import com.spring61.mvc.model.ModelPerson;
import com.spring61.mvc.model.ModelPhone;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestController.class);

    @RequestMapping(value = "/rest/ ", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("home :: get", locale);
        
        return "redirect:/rest/ajaxone";        
    }
    
	@RequestMapping(value = "/rest/ajaxone ", method = RequestMethod.GET)
	public String ajaxone(Locale locale , Model model) {
		logger.info("ajaxone :: get", locale);
		
		return "rest/ajaxone";
	}
    
    @RequestMapping(value = "/rest/ajaxone ", method = RequestMethod.POST)
    @ResponseBody
    public ModelPerson ajaxone(Locale locale, Model model
            , @RequestParam(value="id", defaultValue="") String id
            , @RequestParam(value="pw", defaultValue="") String pw ) {
        logger.info("ajaxone :: post", locale);
        
        ModelPerson login = new ModelPerson();
        login.setEmail("oififk9@aofa.co.kf");
        login.setId(id);
        login.setName("Ses");
        login.setPassword(pw);
        
        return login;
    }
    

    
    @RequestMapping(value = "/rest/newversion", method = RequestMethod.GET)
    @ResponseBody
    public String newversion(@RequestParam(value="current_version", defaultValue="") String  current_version) {
        logger.info("newversion ");
        String result = "";
        
        if( current_version.isEmpty() ){
            LocalDate locdate = LocalDate.now();
            result=locdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
        }
        
        return result;
    }
    
    
    
}
