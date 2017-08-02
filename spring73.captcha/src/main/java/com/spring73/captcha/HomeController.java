package com.spring73.captcha;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    // 글 작성 captcha 테스트
    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String boardWrite( Model model) {
        
        return "write"; 
    }
	
    // 글 작성 captcha 테스트
    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String boardWrite( Model model
                            , HttpSession session
                            , @RequestParam String captcha) {
        
        String captchaValue = (String) session.getAttribute("captcha");
        
        if (captcha == null || !captchaValue.equals(captcha)) {
            return "redirect:/write"; // 글 작성 페이지로 이동
        }
      
        model.addAttribute("serverTime", captcha);
         
        // TODO 글 작성 처리
        return "home"; // 작성한 게시글 페이지로 이동
    }

}
