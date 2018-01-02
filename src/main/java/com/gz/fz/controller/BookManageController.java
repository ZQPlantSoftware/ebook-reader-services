package com.gz.fz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.fz.json.BaseJson;
import com.gz.fz.service.BookManagerService;

@Controller
@RequestMapping("/book/manager")
public class BookManageController {

	@Autowired
	BookManagerService bookManagerService;
	
	@ResponseBody
	@RequestMapping(value="/init")
	public BaseJson init(String url,String bid) {
		return bookManagerService.upload(url, bid);
	}
}
