package com.spring61.mvc.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring61.mvc.model.ModelPhone;
import com.spring61.mvc.service.IServicePhone;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PhoneController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);
	
	@Autowired
	IServicePhone svrphone;
	
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
        String price        = request.getParameter("price");

        int iprice =  StringUtils.isEmpty(price) ?  0 : Integer.parseInt(price) ;
        
        ModelPhone phone = new ModelPhone( name, manufacturer, iprice );
        
        // DB insert
        int result = svrphone.insertPhone(phone);
        
        // DB select
        List<ModelPhone> list = svrphone.getPhoneList();
        
        model.addAttribute("list", list);
        
        return "phone/writeListResult";
    }
    @RequestMapping(value = "/phone/writeone2", method = RequestMethod.POST)
    public String writeone2(Locale locale
            , Model model
            , @RequestParam(value="name"        , defaultValue="" ) String name
            , @RequestParam(value="manufacturer", defaultValue="" ) String manufacturer
            , @RequestParam(value="price"       , defaultValue="0") int price           ) {
        logger.info("writeone2 :: post", locale);
        
        ModelPhone phone = new ModelPhone(name, manufacturer, price);
        
        // DB insert
        int result = svrphone.insertPhone(phone);
        
        // DB select
        List<ModelPhone> list = svrphone.getPhoneList();
        
        model.addAttribute("list", list);
        
        return "phone/writeListResult";
    }
    
    @RequestMapping(value = "/phone/writeone3", method = RequestMethod.POST)
    public String writeone3(Locale locale
            , Model model
            , @ModelAttribute ModelPhone phone) {
        logger.info("writeone3 :: post", locale);
        
        // DB insert
        int result = svrphone.insertPhone(phone);
        
        // DB select
        List<ModelPhone> list = svrphone.getPhoneList();
        
        model.addAttribute("list", list);
        
        return "phone/writeListResult";
    }
    

    @RequestMapping(value = "writelist", method = RequestMethod.GET)
    public String writeListGet(Model model) {        
        return "phone/writeListForm";
    }

    @RequestMapping(value = "writelist", method = RequestMethod.POST)
    public String writeListPost(@ModelAttribute RepositoryPhone phone, Model model) {        
        List<ModelPhone> phonelist = phone.getPhoneItems();
        model.addAttribute("list", phonelist);        
        return "phone/writeListResult";
    }
 
}
