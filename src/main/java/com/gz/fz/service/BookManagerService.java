package com.gz.fz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gz.fz.json.BaseJson;
import com.gz.fz.mapper.BookMapper;
import com.gz.fz.model.Book;
import com.gz.fz.utils.Configuration;
import com.gz.fz.utils.FileUploadUtils;

@Service
@Transactional
public class BookManagerService {

	@Autowired
	BookMapper bookMapper;

	@Autowired
	Configuration configure;

	String bookSavePath = "/Users/georgezou/DOcuments/WORK/DEMO/gz-epub/test/books";
	String bookSaveServerPath = "test/books";

	public BaseJson upload(String url, String bid) {
		BaseJson json = new BaseJson();

		try {
			//根据URL 下载并解压到指定文件夹
			String path = FileUploadUtils.downloadAndDecompressing(url, configure.getDecompPath(), configure.getWebServerPath());
			Book book = new Book(path, bid, url);

			if(bookMapper.insert(book) > 0) {
				json.setData(book);
				return json;
			} else {
				json.setMsg("UNKNOWN ERROR");
				json.setCode("500");
			}
		} catch(Exception e) {
			e.printStackTrace();
			json.setMsg(e.getMessage());
			json.setCode("500");
		}

		return json;
	}

}
