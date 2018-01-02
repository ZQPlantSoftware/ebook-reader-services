package com.gz.fz.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.gz.fz.model.Book;
import com.gz.fz.utils.BaseMapper;

public interface BookMapper extends BaseMapper<Book>{	

	
	final static String SUCCESS_INDEX = "<script>update book set is_index = 1 where bid = #{bid}</script>";
	
	@Update(SUCCESS_INDEX)
	public int successIndex(String bid);

	final static String GET_BOOK_BY_BID = "<script>select * from book where bid = #{bid}</script>";
	
	@Select(GET_BOOK_BY_BID)
	public Book getBookByBid(String bid);
	
}
