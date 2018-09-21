package cn.itcast.core.entity;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable{
		
	//封装分页需要的数据对象
	private Long total; //总条数
	private List rows;  //结果集
	
	
	
	public PageResult() {
		super();
	}
	public PageResult(Long total, List rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
