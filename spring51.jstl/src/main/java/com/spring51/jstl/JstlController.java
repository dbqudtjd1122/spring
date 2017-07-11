package com.spring51.jstl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class JstlController {
	
	private static final Logger logger = LoggerFactory.getLogger(JstlController.class);
	
	/**
	 * http://localhost:8080/jstl/jstl01
	 */
	@RequestMapping(value = "/jstl/jstl01", method = RequestMethod.GET)
	public String jstl01(Locale locale, Model model) {
	    logger.info("jstl01"); 
	    
        return "jstl/jstl01";
	}

    /**
     * http://localhost:8080/jstl/jstl02
     */
    @RequestMapping(value = "/jstl/jstl02", method = RequestMethod.GET)
    public String jstl02(Locale locale, Model model) {
        logger.info("jstl02");   
        
        int num1 = 7;
        int num2 = 9;
        
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        
        return "jstl/jstl02";
    }

    /**
     * http://localhost:8080/jstl/jstl03
     */
    @RequestMapping(value = "/jstl/jstl03", method = RequestMethod.GET)
    public String jstl03(Locale locale, Model model) {
        logger.info("jstl03");   
        
        return "jstl/jstl03";
    }

    /**
     * http://localhost:8080/jstl/jstl11
     */
    @RequestMapping(value = "/jstl/jstl11", method = RequestMethod.GET)
    public String jstl11(Locale locale, Model model) {
        logger.info("jstl11");   
        
        return "jstl/jstl11";
    }

    /**
     * http://localhost:8080/jstl/jstl12
     */
    @RequestMapping(value = "/jstl/jstl12", method = RequestMethod.GET)
    public String jstl12(Locale locale, Model model) {
        logger.info("jstl12");   
        
        return "jstl/jstl12";
    }

    /**
     * http://localhost:8080/jstl/jstl21for
     */
    @RequestMapping(value = "/jstl/jstl21for", method = RequestMethod.GET)
    public String jstl21for(Locale locale, Model model) {
        logger.info("jstl21for");   
        
        return "jstl/jstl21for";
    }

    /**
     * http://localhost:8080/jstl/jstl22foreach
     */
    @RequestMapping(value = "/jstl/jstl22foreach", method = RequestMethod.GET)
    public String jstl22foreach(Locale locale, Model model) {
        logger.info("jstl22foreach");

        /* ====String 배열===== */
        String[] arr = {"순두부","된장찌개","제육덮밥"};
        model.addAttribute("array", arr);

        /* ====ArrayList 배열===== */
        List<String> arr1 = new ArrayList<String>();
        arr1.add("두부");
        arr1.add("찌개");
        arr1.add("덮밥");
        
        model.addAttribute("list", arr1);
        
        return "jstl/jstl22foreach";

    }
}
