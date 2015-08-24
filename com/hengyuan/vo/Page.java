package com.hengyuan.vo;
/**
 * author:quhengqi
 * version:2.0
 * 
 */
import java.io.Serializable;

public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -121846469801377289L;
	private int maxPageNum;
	private int minPageNum;
	private int currentPage;
	public int getMaxPageNum() {
		return maxPageNum;
	}
	public void setMaxPageNum(int maxPageNum) {
		this.maxPageNum = maxPageNum;
	}
	public int getMinPageNum() {
		return minPageNum;
	}
	public void setMinPageNum(int minPageNum) {
		this.minPageNum = minPageNum;
	}
	public int getNextPage() {
		return currentPage+1;
	}
	public int getPrePage() {
		return currentPage-1;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
