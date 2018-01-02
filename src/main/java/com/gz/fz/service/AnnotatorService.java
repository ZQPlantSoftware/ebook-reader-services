package com.gz.fz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gz.fz.mapper.AnnotatorMapper;
import com.gz.fz.mapper.RangeMapper;
import com.gz.fz.model.Annotator;
import com.gz.fz.model.Ranges;

@Service
@Transactional
public class AnnotatorService {

	@Autowired
	private AnnotatorMapper annotatorMapper;
	
	@Autowired
	private RangeMapper rangeMapper;
	
	public boolean add(Annotator annotator) {
		if(annotator == null || annotatorMapper.insert(annotator) < 0){
			return false;
		}
		
		List<Ranges> ranges = annotator.getRanges();
		for(int i = 0;i < ranges.size(); i++) {
			Ranges that = ranges.get(i);
			that.setAnnotator_id(annotator.getId());
			rangeMapper.insert(that);
		}
		return true;
	}
	
	public Integer searchNum(Annotator annotator) {
		return annotatorMapper.searchNum(annotator.getUser_id(), annotator.getChapter(), annotator.getBook_id());
	}
	
	public List<Annotator> search(Annotator annotator) {
		List<Annotator> res = annotatorMapper.search(annotator.getUser_id(), annotator.getChapter(), annotator.getBook_id());
		
		for(int i = 0; i < res.size(); i++) {
			Ranges ranges = new Ranges(res.get(i).getId());
			res.get(i).setRanges(rangeMapper.select(ranges));
		}
		return res;
	}
	
	public List<Annotator> get(Annotator annotator) {
		List<Annotator> res = annotatorMapper.get(annotator.getUser_id(), annotator.getBook_id());
		
		for(int i = 0; i < res.size(); i++) {
			Ranges ranges = new Ranges(res.get(i).getId());
			res.get(i).setRanges(rangeMapper.select(ranges));
		}
		return res;
	}
	
	public boolean del(Integer ann_id) {
		Ranges ranges = new Ranges();
		ranges.setAnnotator_id(ann_id);
		rangeMapper.delete(ranges);
		
		annotatorMapper.deleteById(ann_id);
		return true;
	}
}
