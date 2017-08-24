package com.spring81.bbs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
public class DownloadController {
	
	private static final Logger logger = LoggerFactory.getLogger(DownloadController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/download", method = RequestMethod.POST)
	public String download(Model model
	        , @RequestParam(value="filename", defaultValue=""    ) String filename
            , @RequestParam(value="tempfilename", defaultValue="") String tempfilename  ) {
		logger.info("download");
		
		model.addAttribute("filename"    , filename);
        model.addAttribute("tempfilename", tempfilename);
		
		return "inc/download";
	}
	
}
