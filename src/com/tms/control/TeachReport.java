package com.tms.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teachreport")
public class TeachReport {
     @RequestMapping("/getdata")
     public void getData(HttpServletRequest request,
 			HttpServletResponse response){
    	 System.out.println("aa");
     }
}
