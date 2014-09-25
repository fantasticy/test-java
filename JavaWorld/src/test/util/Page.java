package test.util;

import java.util.List;

/**
 * 페이징 처리가 필요한 리스트를 꾸밀때 사용하는 클래스 입니다.
 * 
 * @author s
 *
 */
public class Page {
	
	private Paginate paginate = null;
	private List<?> list = null;
	
	public void setPaginate(long totalCount, int currentPage, int countPerPage, int pagePerBlock) {
		paginate = new Paginate(totalCount, currentPage, countPerPage, pagePerBlock);
	}

	public Paginate getPaginate() {
		return paginate;
	}

	public void setPaginate(Paginate pageDivBean) {
		this.paginate = pageDivBean;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
	
}
