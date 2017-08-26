package com.spring81.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring81.bbs.commons.WebConstants;
import com.spring81.bbs.model.ModelUser;
import com.spring81.bbs.service.IServiceUser;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	@Qualifier("serviceuser")
	IServiceUser usersvr ;

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login(Model model
	        , @RequestParam(value="url", defaultValue="") String url
	        , HttpServletRequest request
	        , HttpSession session ) {
		logger.info("login : get");
        
        // login 이 안된 상태에서 url을 통한 직접 접근시 오류 처리
		if( session.getAttribute(WebConstants.SESSION_NAME) != null )
		    return "redirect:/";
		
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
            , HttpServletResponse response ) {
        logger.info("login : post");

        ModelUser result = usersvr.login(userid, passwd);
        
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

    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session) {
        logger.info("logout : get");
        session.removeAttribute( WebConstants.SESSION_NAME );
        return "redirect:/";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String register(Model model, HttpSession session) {
        logger.info("register : get");
        
        // login 이 안된 상태에서 url을 통한 직접 접근시 오류 처리
        if( session.getAttribute(WebConstants.SESSION_NAME) != null )
            return "redirect:/";

        return "user/register";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String register(Model model
            , @ModelAttribute ModelUser user ) {
        logger.info("register : post");

        usersvr.insertUser(user);
        
        return "user/register_post";
    }

    @RequestMapping(value = "/user/checkuserid", method = RequestMethod.GET)
    @ResponseBody
    public int checkuserid(Model model
            , @RequestParam(value="userid", defaultValue="") String userid ) {
        logger.info("checkuserid : get");
        
        int result = usersvr.checkuserid(userid);

        return result;
    }

    @RequestMapping(value = "/user/usermodify", method = RequestMethod.GET)
    public String usermodify(Model model, HttpSession session) {
        logger.info("usermodify : get");

        ModelUser user = (ModelUser) session.getAttribute(WebConstants.SESSION_NAME);
        
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

    @RequestMapping(value = "/user/usermodify", method = RequestMethod.POST)
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
}
