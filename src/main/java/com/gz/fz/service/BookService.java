package com.gz.fz.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gz.fz.json.BaseJson;
import com.gz.fz.mapper.BookMapper;
import com.gz.fz.mapper.EpubMetadataMapper;
import com.gz.fz.mapper.EpubPageMapper;
import com.gz.fz.mapper.EpubSpineMapper;
import com.gz.fz.model.Book;
import com.gz.fz.model.EpubMetadata;
import com.gz.fz.model.EpubPage;
import com.gz.fz.model.EpubSpine;
import com.gz.fz.to.BookTo;
import com.gz.fz.to.InitParamsTo;

@Service
public class BookService {

	@Autowired
	BookMapper bookMapper;
	@Autowired
	EpubMetadataMapper epubMetadataMapper;
	@Autowired
	EpubPageMapper epubPageMapper;
	@Autowired
	EpubSpineMapper epubSpineMapper;


	/**
	 * 成功导入到查询系统 修改数据库中的状态
	 * @param bid
	 * @return
	 */
	public boolean successIndex (String bid) {
		return bookMapper.successIndex(bid) > 0;
	}
	
	public Book get(Book book) {
		return bookMapper.selectOne(book);
	}

	public Book getByBid(String bid) {
		return bookMapper.getBookByBid(bid);
	}
	
	public BaseJson add(Book book) {
		if(book.getUrl() != null) {
			Book theBook = bookMapper.selectOne(new Book(book.getUrl()));
			if(theBook != null) {
				return new BaseJson("412", "书籍已存在", theBook);
			}
		}

		if(bookMapper.insert(book) > 0) {
			return new BaseJson(book);
		}
		return new BaseJson("500", "添加失败");
	}

	public BookTo getFull(Book book) {
		BookTo res = new BookTo();

//		Book resBook = bookMapper.selectOne(book);
		Book resBook = bookMapper.getBookByBid(book.getBid());
		
		if(resBook == null)
			return null;

		res.setBook(resBook);

		res.setMetadata(
				epubMetadataMapper.selectOne(
						new EpubMetadata(resBook.getId())));

		res.setPages(
				epubPageMapper.select(
						new EpubPage(resBook.getId())
						)
				);

		res.setSpines(
				epubSpineMapper.select(
						new EpubSpine(resBook.getId())
						)
				);

		return res;
	}

	public BaseJson addFull(BookTo bookTo) {
		Book book = bookTo.getBook();
		
		// 1. 如果有url,并且数据库中的数据初始化过，则不进行调价
		if(book != null && book.getUrl() != null && book.getBid() == null) {
			Book theBook = bookMapper.selectOne(new Book(book.getUrl()));
			if(theBook != null && theBook.getIs_init() == 1) {
				return new BaseJson("412", "书籍已存在", this.getFull(theBook));
			}
		}
		
		InitParamsTo params = bookTo.getParams();
		
		// 2. 如果根据bid进行查询出的数据已经初始化过，则返回
		if(params != null && params.getBid() != null) {
			Book p = new Book();
			p.setBid(params.getBid());
			p.setIs_init(null);
			Book theBook = bookMapper.selectOne(p);
			
			if(theBook != null) {
				if(theBook.getIs_init() != 0) {
					return new BaseJson("412", "书籍已存在", this.getFull(theBook));
				}
				
				book.setId(theBook.getId());
				book.setIs_init(1);
				book.setBid(params.getBid());
				book.setUrl(theBook.getUrl());
				book.setSource(theBook.getSource());
				
				if(bookMapper.updateByPrimaryKey(book) == 0) {
					return new BaseJson("500", "修改失败");
				}
			} else {
				book.setBid(null);
			}
		} 
		
		if(book.getBid() == null) {
			if(bookMapper.insert(book) == 0) {
				return new BaseJson("500", "添加失败");
			}
		}
		
		// 使用 添加或者原有的book 对象的id，添加 Metadata Pages Spines等对象

		if(bookTo.getMetadata() != null) {
			bookTo.getMetadata().setBook_id(book.getId());
			epubMetadataMapper.insert(bookTo.getMetadata());
		}

		if(bookTo.getPages() != null) {
			Iterator<EpubPage> iterator = bookTo.getPages().iterator();

			while(iterator.hasNext())
				iterator.next().setBook_id(book.getId());

			epubPageMapper.insertPages(bookTo.getPages());
		}

		if(bookTo.getSpines() != null) {
			Iterator<EpubSpine> iterator = bookTo.getSpines().iterator();

			while(iterator.hasNext())
				iterator.next().setBook_id(book.getId());

			epubSpineMapper.insertSpines(bookTo.getSpines());
		}

		return new BaseJson(bookTo);

	}
}
