package com.hack.pkg;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hack.app.ISearchHelper;
import com.hack.app.Offer;
import com.snapdeal.web.controller.HttpServletRequest;
import com.snapdeal.web.controller.HttpServletResponse;

@Controller
public class SearchEngine {
	
	private ISearchHelper searchHelper;
   
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String search(@RequestParam("q") String query, HttpServletRequest request, HttpServletResponse response, ModelMap modal){
		List<Offer> offers = searchHelper.search(query);
		modal.addAttribute("searchResult", offers);
		return "searchSuccess";
	}
	
	@RequestMapping(value = "getSearch" , method = RequestMethod.GET)
	public String search(HttpServletRequest request, HttpServletResponse response, ModelMap modal){
		return "search";
	}
	
}
