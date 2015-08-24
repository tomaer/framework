package com.tomaer.framework.core.common.paging;

/**
 * Created by tomaer on 2015/8/23.
 */
public class PagingAttribute implements java.io.Serializable {

    private static final long serialVersionUID = 4811364406899064727L;

    private final int DEFAULT_PAGE_SIZE = 15;
    private int pageNo = 1;
    private int pageSize = DEFAULT_PAGE_SIZE;
    private int startIndex = 0;

    public PagingAttribute() {
    }

    public PagingAttribute(int pageNo) {
        this.pageNo = pageNo > 0 ? pageNo : 1;
    }

    public PagingAttribute(int pageNo, int pageSize) {
        this(pageNo);
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return (pageSize > 0) ? pageSize : DEFAULT_PAGE_SIZE;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
