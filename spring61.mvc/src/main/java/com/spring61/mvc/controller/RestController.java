package com.spring61.mvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    // http://localhost/rest/
    @RequestMapping(value = "/rest/", method = RequestMethod.GET)
    public String rest() {
        logger.info("/ :: get");

        return "redirect:/rest/ajaxone";
    }
    
    // http://localhost/rest/ajaxone
	@RequestMapping(value = "/rest/ajaxone", method = RequestMethod.GET)
	public String ajaxone(Model model) {
		logger.info("ajaxone :: get");
	
		return "rest/ajaxone";		
	}    

    // http://localhost/rest/ajaxone
    @RequestMapping(value = "/rest/ajaxone", method = { RequestMethod.POST} )
    @ResponseBody 
    public ModelPerson ajaxone( @RequestParam("id") String id)  {
        logger.info("ajaxone :: post");
         
        ModelPerson person = new ModelPerson(id, new Date().toString(), "email", "password");
        
        return person;
    }

    // http://localhost/rest/ajaxlist
    @RequestMapping(value = "/rest/ajaxlist", method = RequestMethod.GET)
    public String ajaxlist() {
        logger.info("ajaxone :: get");

        return "rest/ajaxlist";
    }

    // http://localhost/rest/ajaxlist
    @RequestMapping(value = "/rest/ajaxlist", method = RequestMethod.POST )
    @ResponseBody 
    public List<ModelPerson> ajaxlist( @RequestParam("id") String id)  {
        logger.info("ajaxlist :: post");
         
        Date now = new Date();
        
        List<ModelPerson> list = new  ArrayList<ModelPerson>();
        
        list.add(new ModelPerson(id  , now.toString(), "email1", "password1"));        
        list.add(new ModelPerson(id+1, now.toString(), "email2", "password2"));
        
        return list;
    }    


    // http://localhost/rest/login    
    @RequestMapping(value = "/rest/login", method = RequestMethod.GET)
    public String login(Model model, @RequestParam("name") String name) {
        logger.info("login :: get");
        
        return "spring/loginget";
    }

    @RequestMapping(value = "/rest/login", method = RequestMethod.POST )
    @ResponseBody    
    public ModelLogin login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
        logger.info("login :: post");
        
        return new ModelLogin(id, pw);
    }

	@RequestMapping(value = "/rest/newversion", method = RequestMethod.GET)
	@ResponseBody
	public String newversion(Model model, @RequestParam("current_version") String current_version) {
		logger.info("newversion");
		
		String result = "";
		
		if( current_version.isEmpty() ) {
		    result = new Date().toString();
		}
		else {
		    result = current_version;
		}
		
		return result;
	}
    
    @RequestMapping(value = "/rest/uploadimage", method = RequestMethod.GET)
    @ResponseBody
    public ModelLogin uploadimage(Model model, @RequestParam("name") String name) {
        logger.info("uploadimage");
        
        ModelLogin result = new ModelLogin();
        result.setName("test");
        result.setPhone("01012345678");
        
        return result;
    }
}
