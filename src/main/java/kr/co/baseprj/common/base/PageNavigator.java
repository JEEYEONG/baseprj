package kr.co.baseprj.common.base;


/**
 * 페이지 기능을 구현한 클래스이다
 *
 * @author 인텔리진
 * @version 1.0
 */
public class PageNavigator {


	int currentPage;
	private int rowsPerPage;
	int startRow;
	int endRow;
	int totalSize;
	int pageTotal;
	int pageGroupStart;
	int pageGroupEnd;
	int pageBlock = 10;

	public PageNavigator() {

	}

	public PageNavigator(int i, int j) {
		setCurrentPage(i);
		setRowsPerPage(j);
	}

	public PageNavigator(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	// 현재 페이지 셋팅
	public void setCurrentPage(int currentPage) {
		if (currentPage < 1)
			currentPage = 1;
		this.currentPage = currentPage;
		calcStartEndRow(currentPage);
	}

	// 페이지당 row 갯수
	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
		calcStartEndRow(currentPage);
	}

	// 시작 row, 종료row 페이지 셋팅
	private void calcStartEndRow(int currentPage) {
		startRow = (currentPage - 1) * rowsPerPage ;
		endRow = currentPage * rowsPerPage;
	}

	// 총 row 갯수
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
		setPageTotal();
		setPageGroupStart();
		setPageGroupEnd();
	}

	// 총 페이지 갯수
	public void setPageTotal() {
		int pageTotal = (totalSize) / rowsPerPage;
		if(totalSize % rowsPerPage > 0) pageTotal++;
		this.pageTotal = pageTotal;
	}

	// 페이지 블록 시작
	public void setPageGroupStart() {
		this.pageGroupStart = ((getCurrentPage()-1) /getPageBlock()) * getPageBlock() + 1;
	}

	//페이지 블록 종료
	public void setPageGroupEnd() {
		int tempPageGroupEnd = getPageGroupStart() + getPageBlock();
		if (tempPageGroupEnd > getPageTotal())
			tempPageGroupEnd = getPageTotal() + 1;
		if (tempPageGroupEnd > 1)
			tempPageGroupEnd = tempPageGroupEnd - 1;
		this.pageGroupEnd = tempPageGroupEnd;
	}

	public void setPageBlock(int pageBlock){
		this.pageBlock = pageBlock;
	}

	public int getPageBlock(){
		return pageBlock;
	}


	public int getCurrentPage() {
		if (pageTotal > 0 && currentPage > pageTotal)
			currentPage = pageTotal;
		return currentPage;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public int getPageGroupStart() {
		return pageGroupStart;
	}

	public int getPageGroupEnd() {
		return pageGroupEnd;
	}

	@Override
	public String toString() {
		return "PageNavigator [currentPage=" + currentPage + ", rowsPerPage=" + rowsPerPage + ", startRow=" + startRow
				+ ", endRow=" + endRow + ", totalSize=" + totalSize + ", pageTotal=" + pageTotal + ", pageGroupStart="
				+ pageGroupStart + ", pageGroupEnd=" + pageGroupEnd + ", pageBlock="+ pageBlock+"]";
	}


}