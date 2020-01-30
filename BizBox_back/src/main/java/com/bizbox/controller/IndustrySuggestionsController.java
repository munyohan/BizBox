package com.bizbox.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bizbox.Service.ChangeBusinessService;
import com.bizbox.Service.IndustrySuggestionsService;
import com.bizbox.Service.PopulationByService;
import com.bizbox.Service.SalesService;
import com.bizbox.vo.Changebusiness;
import com.bizbox.vo.PopulationByLocation;
import com.bizbox.vo.PopulationByTime;
import com.bizbox.utils.*;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;
import com.bizbox.apis.*;


@CrossOrigin({ "*" })
@RestController
@RequestMapping("/suggestion")
public class IndustrySuggestionsController {
	@Autowired
	JusoApi api;
	@Autowired
	IndustrySuggestionsService suggestionservice;
	@Autowired
	SalesService saliesservice;
	
	@GetMapping("/Industry/{address}/{range}")
	public ResponseEntity<Object> suggestionIndustry(@PathVariable String address,@PathVariable String range){
		
		try {
			String num = api.getAddressByName(address);
			String xy = api.getAddressByXY(num);
			HashMap<String,Integer> total = api.findStoreToSpring(xy, range);
			
			for (Map.Entry<String, Integer> entry : total.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println(key +" "+value);
		}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return null;
	}
	
}
