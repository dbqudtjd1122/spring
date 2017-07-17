package com.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLEncoder;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bbs.commons.*;
import com.bbs.model.*;
import com.bbs.service.*;

@Controller
@RequestMapping("user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IServiceUser serviceuser ;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login( 
	          @RequestParam(defaultValue="") String url 
	        , HttpServletRequest request
			, Model model ) {
		logger.info("UserController.login");
				
        // get a previous page's url
		if( StringUtils.isEmpty(url) ) 
		    url =  request.getHeader("Referer");  

		model.addAttribute("url", url );	
		return "user/login";		
	}
	

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
	          @RequestParam(defaultValue="") String url
            , @ModelAttribute ModelUser logininfo
	        , HttpServletRequest request
            , HttpSession session 
            , RedirectAttributes rttr
			, Model model) {
        logger.info("UserController.login");
        
        ModelUser userinfo = serviceuser.login(logininfo.getUserid(), logininfo.getPasswd() );    
        
        if( userinfo != null ){ // login 성공    
	        session.setAttribute( WebConstants.USER_KEY, userinfo ); // 세션에 로그인 정보 저장     
			
			if( StringUtils.isEmpty(url) || url ==  request.getHeader("Referer") )
			    return  "redirect:/";
			else  
                return "redirect:" + url ;
        }
        else { // login 실패 
            rttr.addFlashAttribute("url", url );
            rttr.addFlashAttribute("msg", "로그인 실패" );
            
            return "redirect:/user/login";
        }    
    }    

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session ) {
        logger.info("UserController.logout"); 
        
        session.removeAttribute( WebConstants.USER_KEY); 
        return "redirect:/";        
    }

    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        logger.info("UserController.register");
        return "user/register";        
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute ModelUser user) {
        
        logger.info("UserController.register");
        
        serviceuser.insertUser(user);
        
        return "user/register_post";
    }   
    
    
    
    @RequestMapping(value = "/usermodify", method = RequestMethod.GET)
    public String usermodify(HttpServletRequest request, HttpSession session) throws Exception {
        
        ModelUser user = (ModelUser)session.getAttribute(WebConstants.USER_KEY);
        
        if (user == null) {
            
            // 로그인 후 다시 돌아오기 위해
            String url   = request.getServletPath();
            String query = request.getQueryString();
            
            if (query != null)
                url += "?" + query;
            
            // 로그인 페이지로 리다이렉트
            url = URLEncoder.encode(url, "UTF-8");
            
            return "redirect:/user/login?url=" + url;
        }
        
        return "user/usermodify";
    }
    
    @RequestMapping(value = "/usermodify", method = RequestMethod.POST)
    public String usermodify(@ModelAttribute ModelUser updateValue, HttpSession session) {
        
        ModelUser searchValue = (ModelUser) session.getAttribute(WebConstants.USER_KEY);

        // UseYN 값 수정
        updateValue.setRetireYN( false );
        
        
        if (searchValue == null) {
            throw new RuntimeException(WebConstants.NOT_LOGIN);
        }
        
        int check = serviceuser.updateUserInfo(updateValue, searchValue);
        
        if (check < 1) {
            throw new RuntimeException( WebConstants.AUTHENTICATION_FAILED);
        }
        
        session.setAttribute(WebConstants.USER_KEY, updateValue);
        
        return "user/changepassword";
        
    }
    
    @RequestMapping(value = "changepassword", method = RequestMethod.GET)
    public String changepassword(HttpServletRequest request, HttpSession session) throws Exception {
        
        ModelUser user = (ModelUser) session .getAttribute(WebConstants.USER_KEY);
        
        if (user == null) {
            // 로그인 후 다시 돌아오기 위해
            String url   = request.getServletPath();
            String query = request.getQueryString();
            
            if (query != null)
                url += "?" + query;
            
            // 로그인 페이지로 리다이렉트
            url = URLEncoder.encode(url, "UTF-8");
            
            return "redirect:/user/login?url=" + url;
        }
        
        return "user/changepassword";
    }
    
    @RequestMapping(value = "changepassword", method = RequestMethod.POST)
    public String changepassword(
              @RequestParam String currentPasswd
            , @RequestParam String newPasswd
            , HttpSession session ) {
        
        String userid = ((ModelUser) session.getAttribute(WebConstants.USER_KEY)).getUserid();
        
        int check = serviceuser.updatePasswd(newPasswd, currentPasswd, userid);
        
        if (check < 1) {
            throw new RuntimeException( WebConstants.AUTHENTICATION_FAILED);
        }
                
        return "user/changepassword_post";
    }
    
    @RequestMapping(value = "unregister", method = RequestMethod.GET)
    public String unregister(HttpServletRequest request, HttpSession session) throws Exception {
        
        ModelUser user = (ModelUser) session.getAttribute(WebConstants.USER_KEY);
        
        if (user == null) {
            // 로그인 후 다시 돌아오기 위해
            String url = request.getServletPath();
            String query = request.getQueryString();
            
            if (query != null)
                url += "?" + query;
            
            // 로그인 페이지로 리다이렉트
            url = URLEncoder.encode(url, "UTF-8");
            
            return "redirect:/user/login?url=" + url;
        }
        
        return "user/unregister";
    }
    
    @RequestMapping(value = "unregister", method = RequestMethod.POST)
    public String unregister(String email, String passwd, HttpSession session) {
        
        ModelUser user = (ModelUser) session .getAttribute(WebConstants.USER_KEY);
        
        if (user == null || !user.getEmail().equals(email)) {
            throw new RuntimeException( WebConstants.AUTHENTICATION_FAILED);
        }
        
        user = serviceuser.login(email, passwd);
        
        //serviceuser.unregister(user);
        session.removeAttribute(WebConstants.USER_KEY);
        
        return "user/unregister_post";
    }
    
    
    //Controller
    @RequestMapping(value = "/checkuserid", method = RequestMethod.GET)
    public @ResponseBody int checkuserid(@RequestParam(value="id", defaultValue="") String userid ) {
        logger.info("UserController.checkuserid");
        
        return serviceuser.checkuserid(userid);        
    } 
}
