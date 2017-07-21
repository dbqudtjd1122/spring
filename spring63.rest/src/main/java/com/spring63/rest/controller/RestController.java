package com.spring63.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring63.rest.model.ModelPerson;
import com.spring63.rest.service.IServicePerson;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	
	@Autowired
	@Qualifier("serviceperson")
	IServicePerson svr;
	
	
	@RequestMapping(value = "/rest/currentversion", method = {RequestMethod.GET, RequestMethod.POST} )
	@ResponseBody
	public int currentversion(Model model) {
		logger.info("/rest/currentversion");
		
		return 1;
	}

    @RequestMapping(value = "/rest/login", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int login(Model model
            , @RequestParam(value="id", defaultValue="") String id 
            , @RequestParam(value="pw", defaultValue="") String pw) {
        logger.info("/rest/login");
        ModelPerson person = new ModelPerson(id, pw);
        int result = svr.login(person);
        return result;
    }    

    @RequestMapping(value = "/rest/personlist", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public List<ModelPerson> personlist(Model model
            , @RequestParam(value="name", defaultValue="") String name ) {
        logger.info("/rest/personlist");

        ModelPerson person = new ModelPerson();
        person.setName(name);
        
        List<ModelPerson>  result = svr.getPersonList(person);
        
        return result;
    }
    
    @RequestMapping(value = "/rest/insertperson", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public int insertperson(Model model
            , @ModelAttribute ModelPerson person) {
        logger.info("/rest/insertperson");
        
        int  result = svr.insertPerson(person);
        
        return result;
    }
}