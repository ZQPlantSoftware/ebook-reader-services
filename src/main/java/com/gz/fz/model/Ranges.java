package com.gz.fz.model;

/**
 * 前端选中 对象实体类
 * 
 *
        {
            "start": "/p[34]",
            "startOffset": 140,
            "end": "/p[34]",
            "endOffset": 148
        }
 *
 * @author georgezou
 *
 */
public class Ranges {
	
	public Ranges() { }
	
	public Ranges(Integer annotator_id) {
		this.setAnnotator_id(annotator_id);
	}
	
	private Integer id;
	private Integer annotator_id;
	private String start;
	private Integer startOffset;
	private String end;
	private Integer endOffset;
	
	public Integer getAnnotator_id() {
		return annotator_id;
	}
	public void setAnnotator_id(Integer annotator_id) {
		this.annotator_id = annotator_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public Integer getStartOffset() {
		return startOffset;
	}
	public void setStartOffset(Integer startOffset) {
		this.startOffset = startOffset;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Integer getEndOffset() {
		return endOffset;
	}
	public void setEndOffset(Integer endOffset) {
		this.endOffset = endOffset;
	}
	
}
