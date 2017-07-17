package com.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DownloadController  {

	@RequestMapping(value="/download", method=RequestMethod.POST)
	public String download(String filename, Model model) {
		model.addAttribute("filename", filename);
		
		return "inc/download";
	}	
}
