package com.spring61.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriTemplate;
import com.spring61.mvc.model.ModelLogin;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
    @RequestMapping(value = "/spring/helloworld", method = RequestMethod.GET)
    public String helloworld(Locale locale, Model model) {
        logger.info("/spring/helloworld");
        
        model.addAttribute("serverTime", "Hello, world!!!" );
        
        return "spring/helloworld";
    }
    
    @RequestMapping(value = "/spring/sayHello", method = RequestMethod.GET)
    public ModelAndView sayHello(Locale locale, Model model) {
        logger.info("/spring/sayHello");
        
        Map<String, String> modelMap = new HashMap<String,String>(); 
        modelMap.put("serverTime", "say Hello");
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("spring/sayHello"); // view  설정 : jsp 파일
        mv.addAllObjects(modelMap);        // model 설정 : 데이터
        
        return mv;
    }
        
    // redirect 테스트
    @RequestMapping(value = "/spring/redirect", method = RequestMethod.GET)
    public String redirect(Locale locale, Model model) {
        logger.info("/spring/redirect");
        
        return "redirect:/spring/helloworld";
    }
    
    // forward 테스트
    @RequestMapping(value = "/spring/forward", method = RequestMethod.GET)
    public String forward(Locale locale, Model model) {
        logger.info("/spring/forward");
        
        return "forward:/spring/helloworld";
    }

    // QueryString 테스트 >> @RequestParam 테스트
    @RequestMapping(value = "/spring/querystring", method = RequestMethod.GET)
    public String querystring(Locale locale
            , Model model
            , @RequestParam( value="name" , defaultValue="" ) String  name1
            , @RequestParam( value="phone", defaultValue="1") Integer phone1
            , HttpServletRequest request ) {
        
        logger.info("/spring/querystring");
        String name2  = request.getParameter("name" );
        String phone2 = request.getParameter("phone");
        
        model.addAttribute("name1" , name1 );
        model.addAttribute("name2" , name2 );
        model.addAttribute("phone1", phone1);
        model.addAttribute("phone2", phone2);
        
        return "spring/querystring";
    }
    
    // QueryString 테스트 >> @PathVariable 테스트
    @RequestMapping(value = "/spring/pathvalue/{name}", method = RequestMethod.GET)
    public String pathvalue(Locale locale
            , Model model
            , @PathVariable(value="name") String name ) {
        
        logger.info("/spring/pathvalue");
        
        model.addAttribute("name", name );
        
        return "spring/pathvalue";
    }
    @RequestMapping(value = "/spring/pathvalue/{name}/{phone}", method = RequestMethod.GET)
    public String pathvalue(Locale locale
            , Model model
            , @PathVariable(value="name" ) String name
            , @PathVariable(value="phone") String phone ) {
        
        logger.info("/spring/pathvalue");
        
        model.addAttribute("name" , name  );
        model.addAttribute("phone", phone );
        
        return "spring/pathvalue";
    }
    
    // QueryString 테스트 >> @PathVariable 테스트
    /*
    ?  - zero or one charecter
    *  - one charecter
    ** - one or more charecters
    */
    @RequestMapping(value = "/spring/querypath/{name}/**", method = RequestMethod.GET)
    public ModelAndView querypath(
            Model model,
            @PathVariable(value="name") String name,  
            HttpServletRequest request ) {     
        logger.info("HomeController.querypath");
        
        String phone = null;
        
        String restOfUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
     
        UriTemplate template = new UriTemplate("/spring/querypath/{name}/{phone}");        
        boolean isTemplateMatched = template.matches(restOfUrl);
        if(isTemplateMatched) {
            Map<String, String> matchTemplate = new HashMap<String, String>();
            matchTemplate = template.match(restOfUrl);
            phone = matchTemplate.get("phone");
        }
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("name" , name  );
        map.put("phone", phone );
        
        return new ModelAndView("home/pathvalue", map) ;       
    }
           
    // login 테스트
    @RequestMapping(value = "/spring/login", method = RequestMethod.GET)
    public String login(Locale locale, Model model) {
        logger.info("/spring/login :: get");
        
        model.addAttribute("id", "aaa");
        
        return "spring/loginget";
    }
    // login 테스트
    @RequestMapping(value = "/spring/login", method = RequestMethod.POST)
    public String login(Locale locale
            , Model model
            , @RequestParam( value="id") String id 
            , @RequestParam( value="pw") String pw ) {
        logger.info("/spring/login :: post ");
        
        // DB 조회
        
        model.addAttribute("id", id );
        model.addAttribute("pw", pw );
        
        return "spring/loginpost";
    }
    

    
    // login 테스트
    @RequestMapping(value = "/spring/loginmodel", method = RequestMethod.GET)
    public String loginmodel(Locale locale, Model model) {
        logger.info("/spring/loginmodel :: get");
                
        return "spring/loginmodelget";
    }
    // login 테스트
    @RequestMapping(value = "/spring/loginmodel", method = RequestMethod.POST)
    public String loginmodel(Locale locale
            , Model model
            , @ModelAttribute ModelLogin info ) {
        logger.info("/spring/loginmodel :: post ");
            
        model.addAttribute("info", info );
        
        return "spring/loginmodelpost";
    }
    
}
