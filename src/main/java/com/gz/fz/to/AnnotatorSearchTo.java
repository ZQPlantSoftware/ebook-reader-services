package com.gz.fz.to;

import java.util.List;

import com.gz.fz.model.Annotator;

/**
 * {
    "total": 43127,
    "rows": [
        {
            "id": "d41d8cd98f00b204e9800998ecf8427e",
            "text": "Updated annotation text",
            ...
        },
        ...
    ]
 * }
 * @author georgezou
 *
 */
public class AnnotatorSearchTo {

	public AnnotatorSearchTo() { }
	
	public AnnotatorSearchTo(Integer total, List<Annotator> rows) {
		this.setTotal(total);
		this.setRows(rows);
	}
	
	private Integer total;
	private List<Annotator> rows;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<Annotator> getRows() {
		return rows;
	}
	public void setRows(List<Annotator> rows) {
		this.rows = rows;
	}
	
}
