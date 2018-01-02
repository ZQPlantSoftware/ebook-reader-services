package com.gz.fz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.gz.fz.model.EpubPage;
import com.gz.fz.utils.BaseMapper;

public interface EpubPageMapper extends BaseMapper<EpubPage>{

	final static String INSERT_CITIES = "<script>" +
            "insert into epub_page (book_id, cfi, page, height) values " +
            "<foreach collection=\"list\" item=\"page\" separator=\",\" >" +
                "(#{page.book_id}, #{page.cfi}, #{page.page}, #{page.height})" +
            "</foreach>" +
            "</script>";
	
    @Insert(INSERT_CITIES)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertPages(List<EpubPage> pages);
	
}
