package com.gz.fz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.fz.mapper.BookMarkMapper;
import com.gz.fz.model.BookMark;

@Service
public class BookMarkService {

	@Autowired
	private BookMarkMapper bookMarkMapper;

	public List<BookMark> getList(BookMark mark) {
		
		if(mark != null) {
			return bookMarkMapper.select(mark);
		} else {
			return bookMarkMapper.selectAll();
		}
	}
	
	public boolean add(BookMark mark) {
		return bookMarkMapper.insert(mark) > 0;
	}
	
	public boolean delete(BookMark mark) {
		return bookMarkMapper.delete(mark) > 0;
	}
}
