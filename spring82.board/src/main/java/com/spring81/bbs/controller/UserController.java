package com.spring81.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring81.bbs.commons.WebConstants;
import com.spring81.bbs.model.ModelUser;
import com.spring81.bbs.service.IServiceUser;

@Controller
@RequestMapping("/")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	@Qualifier("serviceuser")
	IServiceUser user ;

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login(Model model
	        , @RequestParam(value="url", defaultValue="") String url
	        , HttpServletRequest request) {
		logger.info("login : get");
		
		// get a previous page's url
		if( url.isEmpty() )
		    url = request.getHeader("Referer");
		
		model.addAttribute("url", url);
		
		return "user/login";
	}

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(Model model
            , RedirectAttributes rttr
            , @RequestParam(value="userid") String userid 
            , @RequestParam(value="passwd") String passwd 
            , @RequestParam(value="url"   ) String url
            , HttpSession session 
            , HttpResponse response ) {
        logger.info("login : post");

        ModelUser result = user.login(userid, passwd);
        
        // 로그인 성공시 : session 에 로그인 정보 저장
        
        // 로그인 실패시 : login.jsp의 msg 에 "로그인 실패" 메시지 출력되게. RedirectAttribute 사용
        // RedirectAttributes 는 일회성 데이터를 전달하고자 할 때 사용.
        
        if( result != null ){ // 로그인 성공시
            session.setAttribute(WebConstants.SESSION_NAME, result );
            
            if( url.isEmpty() ) {
                return "redirec:/";
            }
            else {
                return "redirect:" + url;
            }
        }
        else { // 로그인 실패시
            rttr.addFlashAttribute("msg", "로그인 실패");
            response.setHeader("url", url);  // url 정보를 http의 헤더에 담아서 보낼 때.
            
            return "redirect:/user/login?url=" + url;
        }
    }
	
}
