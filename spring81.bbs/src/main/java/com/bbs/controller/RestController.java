package com.bbs.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbs.model.ModelBoard;
import com.bbs.model.ModelUser;
import com.bbs.service.IServiceBoard;
import com.bbs.service.IServiceUser;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/restservice")
public class RestController {

    private static final Logger logger = LoggerFactory.getLogger(RestController.class);
    
    @Autowired
    @Qualifier("serviceboard")    
    private IServiceBoard boardsrv; 

    @Autowired
    private IServiceUser usersrv;
    
    // http://localhost/restservice/ajaxone
	@RequestMapping(value = "/ajaxone", method = RequestMethod.GET)
	public String ajaxone(Model model) {
		logger.info("RestController.ajaxone");
	
		return "restservice/ajaxone";		
	}
	
	// http://localhost/restservice/jsonview
    @RequestMapping(value = "/jsonview", method = RequestMethod.GET)
    public @ResponseBody ModelBoard AjaxView(@RequestParam("boardcd") String boardcd) {
        
        return  boardsrv.getBoardOne(boardcd);

    }

    
    // http://localhost/restservice/login
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST} )
    public @ResponseBody ModelUser login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
        
        return usersrv.login(id, pw);
    }
    
    
}
