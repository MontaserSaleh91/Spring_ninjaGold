package com.ninjagoldproject.ninjagold;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Homecontroller {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.isNew()) {
			ArrayList<String> logList = new ArrayList<String>();
			session.setAttribute("gold", 0);
			session.setAttribute("eventLog",logList);
		}
		return "index.jsp";
	}
	
	@RequestMapping(value="/gold", method=RequestMethod.POST)
	public String gold(@RequestParam(value="getgold")String getgold, HttpSession session) {
		if(getgold.equals("farm")) {
			
			String format = "EEEEE dd yyyy KK:mm aa";
			SimpleDateFormat dateFormat= new SimpleDateFormat(format);
			
				int goldGenerate = ThreadLocalRandom.current().nextInt(10,21);
				java.util.Date timeStamp = new java.util.Date() ;
				ArrayList<String> list = (ArrayList<String>) session.getAttribute("eventLog");
				list.add(0,"<div class=\"alert alert-info\" role=\"alert\">You enterd a farm and earned "+goldGenerate+" gold .("+timeStamp+")</div>");
				session.setAttribute("gold", (int)session.getAttribute("gold")+goldGenerate);
				session.setAttribute("logList", list);

			
		}
		
		if(getgold.equals("cave")) {
			
			String format = "EEEEE dd yyyy KK:mm aa";
			SimpleDateFormat dateFormat= new SimpleDateFormat(format);
			
				int goldGenerate = ThreadLocalRandom.current().nextInt(5,11);
				java.util.Date timeStamp = new java.util.Date() ;
				ArrayList<String> list = (ArrayList<String>) session.getAttribute("eventLog");
				list.add(0,"<div class=\"alert alert-info\" role=\"alert\">You enterd a cave and earned "+goldGenerate+" gold .("+timeStamp+")</div>");
				session.setAttribute("gold", (int)session.getAttribute("gold")+goldGenerate);
				session.setAttribute("logList", list);

			
		}
		
		if(getgold.equals("house")) {
			
			String format = "EEEEE dd yyyy KK:mm aa";
			SimpleDateFormat dateFormat= new SimpleDateFormat(format);
			
				int goldGenerate = ThreadLocalRandom.current().nextInt(2,6);
				java.util.Date timeStamp = new java.util.Date() ;
				ArrayList<String> list = (ArrayList<String>) session.getAttribute("eventLog");
				list.add(0,"<div class=\"alert alert-info\" role=\"alert\">You enterd a house and earned "+goldGenerate+" gold .("+timeStamp+")</div>");
				session.setAttribute("gold", (int)session.getAttribute("gold")+goldGenerate);
				session.setAttribute("logList", list);
				
			
		}
		
		if(getgold.equals("casino")) {
			
			int val = ThreadLocalRandom.current().nextInt(1,3);
			String format = "EEEEE dd yyyy KK:mm aa";
			SimpleDateFormat dateFormat= new SimpleDateFormat(format);
			
			if(val == 1) {
				int goldGenerate = ThreadLocalRandom.current().nextInt(0,51);
				java.util.Date timeStamp = new java.util.Date() ;
				ArrayList<String> list = (ArrayList<String>) session.getAttribute("eventLog");
				list.add(0,"<div class=\"alert alert-info\" role=\"alert\">You enterd a casino and earned "+goldGenerate+" gold .("+timeStamp+")</div>");
				session.setAttribute("gold", (int)session.getAttribute("gold")+goldGenerate);
				session.setAttribute("logList", list);
				
			}
			
			if(val == 2) {
				int goldGenerate = ThreadLocalRandom.current().nextInt(10,101);
				java.util.Date timeStamp = new java.util.Date() ;
				ArrayList<String> list = (ArrayList<String>) session.getAttribute("eventLog");
				list.add(0,"<div class=\"alert alert-danger\" role=\"alert\">You enterd a casino and lost "+goldGenerate+" gold .("+timeStamp+")</div>");
				session.setAttribute("gold", (int)session.getAttribute("gold")-goldGenerate);
				session.setAttribute("logList", list);
				
			}
			
		}
		
		return"redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
