package com.gz.fz.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.fz.json.BaseJson;
import com.gz.fz.model.BookMark;
import com.gz.fz.service.BookMarkService;

/**
 * 
 * @author georgezou
 *
 */
@Controller
@RequestMapping("/bookmark")
public class BookMarkController extends BaseController {
	
	@Autowired
	private BookMarkService bookMarkService;
	
	@ResponseBody
	@RequestMapping(value="/get")
	public BaseJson getAll(BookMark mark) {
		BaseJson result = new BaseJson();
		result.setData(
				bookMarkService.getList(mark)
				);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/add")
	public BaseJson add(BookMark mark) {
		mark.setDate(new Date());
		if(bookMarkService.add(mark)) {
			return new BaseJson();
		}
		return new BaseJson("500", "unknown error");
	}
	
	@ResponseBody
	@RequestMapping(value="/del")
	public BaseJson del(BookMark mark) {
		try {
			bookMarkService.delete(mark);
			return new BaseJson();
		} catch (Exception ex) {
			return new BaseJson("500", "unknown error");
		}
	}
	
}
