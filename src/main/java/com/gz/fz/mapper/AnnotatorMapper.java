package com.gz.fz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gz.fz.model.Annotator;

public interface AnnotatorMapper{

    public final static String INSERT = "insert into annotator"
    		+ "(created, text, quote, uri, user_id, book_id, chapter, description, percentage) values "
    		+ "(#{created}, #{text}, #{quote}, #{uri}, #{user_id}, #{book_id}, #{chapter}, #{description}, #{percentage})";
    
    @Insert(INSERT)
    @Options(keyProperty = "id",useGeneratedKeys=true)
    public Integer insert(Annotator annotator);
    
    public final static String SELECT_BY_UID = "select * from annotator where user_id =  #{user_id} and book_id = #{book_id}";
    
    @Select(SELECT_BY_UID)
    public List<Annotator> get(@Param("user_id") Integer user_id, @Param("book_id")Integer book_id);
    
    
    public final static String SELECT_BY_UID_CHAPTER = "select * from annotator where user_id = #{user_id} and chapter = #{chapter} and book_id = #{book_id}";
    
    @Select(SELECT_BY_UID_CHAPTER)
    public List<Annotator> search(@Param("user_id") Integer user_id,
    						   @Param("chapter") String chapter, 
    						   @Param("book_id") Integer book_id);
    
    public final static String SELECT_BY_UID_CHAPTER_NUM = "select count(1) from annotator where user_id = #{user_id} and chapter = #{chapter} and book_id = #{book_id}";
    
    @Select(SELECT_BY_UID_CHAPTER_NUM)
    public Integer searchNum(@Param("user_id") Integer user_id,
    						   @Param("chapter") String chapter, 
    						   @Param("book_id") Integer book_id);
    
    public final static String DELETE_BY_ID = "delete from annotator where id = #{id}";
    
    @Delete(DELETE_BY_ID)
    public Integer deleteById(Integer id);
    
}
