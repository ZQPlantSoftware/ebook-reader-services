package com.gz.fz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.fz.json.BaseJson;
import com.gz.fz.model.Book;
import com.gz.fz.service.BookService;
import com.gz.fz.to.BookTo;
import com.gz.fz.to.InitParamsTo;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	@ResponseBody
	@RequestMapping(value="/add")
	public BaseJson add(Book book) {
		return bookService.add(book);
	}
	
	@ResponseBody
	@RequestMapping(value="/get")
	public BaseJson get(Book book) {
		return new BaseJson(
				bookService.get(book)
				);
	}
	
	@ResponseBody
	@RequestMapping(value="/addFull", method = RequestMethod.POST)
	public BaseJson addFull(@RequestBody String json) {
		BookTo book = BookTo.parse(json);
		return bookService.addFull(book);
	}
	
	@ResponseBody
	@RequestMapping(value="/getFull", method = RequestMethod.GET)
	public BaseJson getFull(Book book) {
		return new BaseJson(
				bookService.getFull(book)
				);
	}
	
	@ResponseBody
	@RequestMapping(value="/init", method={RequestMethod.POST, RequestMethod.GET})
	public BaseJson init(String r) {
		
		InitParamsTo params = null;
		
		if(r.indexOf("{") == 0) {
			params = InitParamsTo.jParse(r);
		} else {
			try {
				params = InitParamsTo.sParse(r);
			} catch (Exception e) {
				e.printStackTrace();
				return new BaseJson("403", "参数不全", null);
			}
		}
		
		System.out.println("bid:"+ params.getBid());
		
		if(params.getUid() == null || params.getUid() < 0) {
			params.setUid(-1);
		}
		
		if(params.getProbation() == null) {
			params.setProbation(20);
		}
		
		BookTo book = null;
		
		if(params.getBid() != null) {
			Book bparams = new Book();
			bparams.setBid(params.getBid());
			bparams.setIs_init(null);
			book = bookService.getFull(bparams);
			
			if(book != null 
					&& book.getBook() != null 
					&& book.getBook().getIs_init() != null &&  book.getBook().getIs_init() != 1) {
				params.setUrl(book.getBook().getUrl());
				params.setBid(book.getBook().getBid());
				book = null;
			}
		} else if (params.getUrl() != null) {
			book = bookService.getFull(
					new Book(params.getUrl()));
		} else {
			return new BaseJson("403", "参数不全", null);
		}
		
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("book", book);
		res.put("params", params);
		
		if(book == null) {
			return new BaseJson("404", "无该书籍信息", res);
		}
		
		if(book.getBook().getIs_init() != 1) {
			return new BaseJson("10000", "书籍信息未初始化", res);
		}
		
		return new BaseJson(res);
	}
}
