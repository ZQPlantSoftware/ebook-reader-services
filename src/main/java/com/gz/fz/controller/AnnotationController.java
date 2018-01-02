package com.gz.fz.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.fz.json.BaseJson;
import com.gz.fz.model.Annotator;
import com.gz.fz.service.AnnotatorService;
import com.gz.fz.to.AnnotatorSearchTo;


@Controller
@RequestMapping("annotator")
public class AnnotationController {
	
	@Autowired
	private AnnotatorService annotatorService;
	
	@ResponseBody
	@RequestMapping(value="get", method=RequestMethod.GET)
	public BaseJson get(Annotator ann) {
		BaseJson json = new BaseJson();
		json.setData(annotatorService.get(ann));
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value="search", method=RequestMethod.GET)
	public AnnotatorSearchTo search(Annotator ann) {
		Integer num = annotatorService.searchNum(ann);
		List<Annotator> res = annotatorService.search(ann);
		
		return new AnnotatorSearchTo(
				num, res
				);
	}
	
	@ResponseBody
	@RequestMapping(value="annotations", method = RequestMethod.POST)
	public String add(@RequestBody String json) {
		Annotator ann = Annotator.parse(json);
		ann.setCreated(new Date());
		annotatorService.add(ann);
		
		return json;
	}

	@ResponseBody
	@RequestMapping(value="del", method = {RequestMethod.DELETE, RequestMethod.GET})
	public BaseJson del(@RequestBody(required=false) String json, Integer id) {
		BaseJson jsono = new BaseJson();
		
		if(id == null) {
			
		} else {
			
		}
		
		annotatorService.del(id);
		return jsono;
	}
}
