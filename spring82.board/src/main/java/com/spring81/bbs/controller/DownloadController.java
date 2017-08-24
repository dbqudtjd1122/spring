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

/**
 * Handles requests for the application home page.
 */
@Controller
public class DownloadController {
	
	private static final Logger logger = LoggerFactory.getLogger(DownloadController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download(Model model, String filename) {
		logger.info("download");
		
		model.addAttribute("filename", filename);
		
		return "inc/download";
	}
	
}
