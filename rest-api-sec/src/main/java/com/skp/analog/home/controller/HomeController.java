package com.skp.analog.home.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    
     @RequestMapping("/admin")
     public String admin() {
          return "admin";
     }
    
     @RequestMapping("/user")
     public String user() {
          return "user";
     }
     
     @RequestMapping("/loginMain")
     public String loginMain() {
          return "apiLogin";
     }
     
    @ResponseBody
 	@RequestMapping("/json")
 	public List<Map<String, Object>> list() {
    	List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
    	for(int i = 1; i < 10 ; i++ ) {
	 		Map<String, Object> map = new HashMap<String, Object>();
	 		map.put("title", "기억"+i);
	 		if(i == 1)
	 			map.put("body", "사람들은 그대로 멈췄으나 기계는 작동한다.");
	 		else if(i == 2)
	 			map.put("body", "영수는 그대로 멈췄으나 기계는 작동한다.");
	 		else if(i == 3)
	 			map.put("body", "철수는 그대로 멈췄으나 기계는 작동한다.");
	 		else if(i == 4)
	 			map.put("body", "정수는 그대로 멈췄으나 기계는 작동한다.");
	 		else if(i == 5)
	 			map.put("body", "달님은 그대로 멈췄으나 기계는 작동한다.");
	 		else
	 			map.put("body", "그외는 그대로 멈췄으나 기계는 작동한다.");
	 		map.put("active",false);
	 		result.add(map);
    	}
 		
 		return result;

 	}
}