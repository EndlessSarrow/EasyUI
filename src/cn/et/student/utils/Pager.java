package cn.et.student.utils;

import java.util.List;

public class Pager {

	/**
	 * 下一页算法： this.curPage == totalPage ? this.curPage : this.curPage + 1
	 */
	private Integer nextPage;

	/**
	 * 前一页算法： prePage = curPage == 1 ? 1 : curPage - 1
	 */
	private Integer prePage;

	// 当前页
	private Integer curPage;

	// 总记录数量
	private Integer total;

	/**
	 * 总页数的算法： totalPage = totalCount % this.pageSize == 0 ? totalCount /
	 * this.pageSize : totalCount / this.pageSize + 1
	 */
	private Integer totalPage;

	// 每页条数
	private Integer pageSize;

	/**
	 * limit起点算法： curPage * size - size + 1
	 */
	private Integer startIndex;

	/**
	 * limit终点算法： curPage * size
	 */
	private Integer endIndex;

	// 分页数据容器
	@SuppressWarnings("rawtypes")
	private List rows;

	/**
	 * 构造方法
	 * 
	 * @param curPage
	 *            当前页
	 * @param totalCount
	 *            总记录数
	 * @param pageSize
	 *            每页大小
	 */
	public Pager(Integer curPage, Integer totalCount, Integer pageSize) {
		this.curPage = curPage;
		this.total = totalCount;
		this.pageSize = pageSize == null ? 10 : pageSize; // 每页条数
		// 总页数
		this.totalPage = totalCount % this.pageSize == 0 ? totalCount
				/ this.pageSize : (totalCount / this.pageSize) + 1;
		this.nextPage = this.curPage == totalPage ? this.curPage
				: this.curPage + 1;// 下一页
		this.prePage = curPage == 1 ? 1 : curPage - 1;// 前一页
		this.startIndex = (curPage - 1) * this.pageSize + 1; // limit起点
		this.endIndex = curPage * this.pageSize; // limit终点

	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getPrePage() {
		return prePage;
	}

	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	@SuppressWarnings("rawtypes")
	public List getRows() {
		return rows;
	}

	@SuppressWarnings("rawtypes")
	public void setRows(List rows) {
		this.rows = rows;
	}
}
