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
	
    @RequestMapping(value = "/jstl/jstl23fortokens", method = RequestMethod.GET)
    public String jstl23fortokens(Model model) {
        
        model.addAttribute("member", "효성^^지은~선화/징거");
                
        return "jstl/jstl23fortokens";
    }
    

    /**
     * http://localhost:8080/jstl/jstl31includefile
     */
    @RequestMapping(value = "/jstl/jstl31includefile", method = RequestMethod.GET)
    public String jstl31includefile(Locale locale, Model model) {
        logger.info("jstl31includefile");

        
        return "jstl/jstl31includefile";
    }
    
    @RequestMapping(value = "/jstl/jstl32includepage", method = RequestMethod.GET)
    public String jstl32includepage(Model model) {
       
        return "jstl/jstl32includepage";
    }
    

    /**
     * http://localhost:8080/jstl/jstl33import
     */
    @RequestMapping(value = "/jstl/jstl33import", method = RequestMethod.GET)
    public String jstl33import(Locale locale, Model model) {
        logger.info("jstl33import");

        return "jstl/jstl33import";
    }
    
    @RequestMapping(value = "/jstl/jstl41redirect", method = RequestMethod.GET)
    public String jstl41redirect(Model model) {
       
        return "jstl/jstl41redirect";
    }
    @RequestMapping(value = "/jstl/jstl42forward", method = RequestMethod.GET)
    public String jstl42forward(Model model) {
       
        return "jstl/jstl42forward";
    }

    @RequestMapping(value = "/jstl/jstl61scope", method = RequestMethod.GET)
    public String jstl61scope(Model model) {
        
        return "jstl/jstl61scope";
    }
    
    @RequestMapping(value = "/jstl/jstl61sub", method = RequestMethod.GET)
    public String jstl61sub(Model model) {
        
        return "jstl/jstl61sub";
    }
    
    @RequestMapping(value = "/jstl/jstl63session", method = RequestMethod.GET)
    public String jstl63session(Model model, HttpSession session) {

        model.addAttribute("errorMessage", "에러 발생");
        //session.setAttribute(name, value);
        
        return "jstl/jstl63session";
    }
    
    @RequestMapping(value = "/jstl/jstl64fn", method = RequestMethod.GET)
    public String jstl64fn(Model model, HttpSession session) {

        model.addAttribute("string1", "s01@aaa.co.kr");
        
        session.setAttribute("user", new ModelCheckBox("s01@aaa.co.kr", "s01@aaa.co.kr", true )  );
        
        return "jstl/jstl64fn";
    }
    
    @RequestMapping(value = "/jstl/jstl71checkbox", method = RequestMethod.GET)
    public String jstl71checkbox(Model model) {

        model.addAttribute("useYN", true);
        
        return "jstl/jstl71checkbox";
    }

    @RequestMapping(value = "/jstl/jstl72checkbox", method = RequestMethod.GET)
    public String jstl72checkbox(Model model) {
        
        List< ModelCheckBox > list = new ArrayList<>();

        list.add( new ModelCheckBox("s01", "s01", true ) );
        list.add( new ModelCheckBox("s02", "s02", false) );
        list.add( new ModelCheckBox("s03", "s03", true ) );
        list.add( new ModelCheckBox("s04", "s04", false) );
        list.add( new ModelCheckBox("s05", "s05", true ) );
        
        model.addAttribute("itemList", list);
        
        return "jstl/jstl72checkbox";
    }

    @RequestMapping(value = "/jstl/jstl74select", method = RequestMethod.GET)
    public String jstl74select(Model model) {
        
        List< String > list = new ArrayList<>();

        list.add( "010" );
        list.add( "011" );
        list.add( "016" );
        list.add( "017" );
        list.add( "018" );
        list.add( "019" );
        
        model.addAttribute("roleNames"   , list  );
        model.addAttribute("selectedRole", "016" );
        
        return "jstl/jstl74select";
    }
	    
}
