package com.gz.fz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gz.fz.json.BaseJson;
import com.gz.fz.model.Book;
import com.gz.fz.service.BookService;
import com.gz.fz.to.EpubSearch;
import com.gz.fz.utils.Configuration;
import com.gz.fz.utils.HttpUtils;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/search")
public class SearchController extends  BaseController {
	
	@Autowired
	BookService bookServices;
	@Autowired
	Configuration configure;
	
	String SEARCH_URL = "http://127.0.0.1:5000/";
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@ResponseBody
	@RequestMapping(value="/s")
	public BaseJson search(String bid, String str) {
		BaseJson result = new BaseJson();
		Book book = bookServices.getByBid(bid);
		
		if (book == null)
			return BaseJson.error("bid错误");
		
		if (book.getIs_index() != 1) {
			// 需要添加到搜索系统
			String queryUrl = SEARCH_URL + "index_book?path="+ configure.getDecompPath() + book.getUrl() +"&bid="+ bid;
			System.out.println("Add queryUrl:" + queryUrl);
			String res = HttpUtils.sendGet(queryUrl);
			if (res.indexOf("success") == -1) {
				return new BaseJson("查询错误");
			}
			
			bookServices.successIndex(bid);
		}
		
		String queryUrl = SEARCH_URL + "search?q="+ str +"&bid="+ bid;
		System.out.println("Query queryUrl:" + queryUrl);
		String json = HttpUtils.sendGet(queryUrl);
		JSONObject obj = JSONObject.fromObject(json);
		if (!obj.getString("code").equals("200")) {
			return BaseJson.error(obj.getString("msg"));
		}
		
		JSONArray arr = JSONArray.fromObject(obj.getString("results"));
		List<EpubSearch> searchResult = (List<EpubSearch>)JSONArray.toList(arr, EpubSearch.class);
		result.setData(searchResult);
		return result;
	}

	
//	public static void main(String []args) {
//		String data = HttpUtils.sendGet("http://127.0.0.1:5000/search?q=法律&bid=5");
//		System.out.println("data:" + data);
//	}
}
