package com.ywq.ssm.model;

import java.util.List;

public class PageData {

	private Integer pageCount = 10;//每页10条
	private Integer totalCount;//总记录数
	private Integer totalPage;//总页数
	private Integer currentPage = 1;//当前页默认第1页
	
	private Integer startRow;//从第几行记录开始
	private Integer endRow;//到第几行记录
	
	private List data;//存放页面数据

	public PageData(){}
	
	public PageData(Integer totalCount,Integer pageCount,Integer currentPage){
		this.totalCount = totalCount;
		this.pageCount = pageCount;
		this.currentPage = currentPage;
		
		this.startRow = (this.currentPage-1) * this.pageCount;
		//this.endRow = this.currentPage * this.pageCount > this.totalCount ? this.totalCount : this.currentPage * this.pageCount;
		this.endRow = this.pageCount;
		
		int temp = this.totalCount%this.pageCount;
		this.totalPage =  temp==0 ? this.totalCount/this.pageCount : this.totalCount/this.pageCount +1;
	}
	
	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		int temp = this.totalCount%this.pageCount;
		this.totalPage =  temp==0 ? this.totalCount/this.pageCount : this.totalCount/this.pageCount +1;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
		this.startRow = (this.currentPage-1) * this.pageCount;
		this.endRow = this.pageCount;
		//this.endRow = this.currentPage * this.pageCount > this.totalCount ? this.totalCount : this.currentPage * this.pageCount;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getEndRow() {
		return endRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}

	
	@Override
	public String toString() {
		return "PageData [pageCount=" + pageCount + ", totalCount="
				+ totalCount + ", totalPage=" + totalPage + ", currentPage="
				+ currentPage + ", startRow=" + startRow + ", endRow=" + endRow
				+ ", data=" + data + "]";
	}

	public static void main(String[] args) {
		
		PageData page = new PageData(136,10,14);
		System.out.println("取数据从:" + page.getStartRow() +" 开始取，截止到： " + page.getEndRow()
				+" ,总共:"+page.totalPage+"页！");
		
	}
}
