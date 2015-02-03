/*
 * Copyright (c) 2009 Tomaer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tomaer.framework.common.paging;

import java.io.Serializable;

/**
 * Description:分页对象
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 21:43
 */
public class Paging implements Serializable {

    private static final long serialVersionUID = 9028264571706638217L;

    /**
     * 首页 
     */
    private int firstPage;
    /**
     * 尾页 
     */
    private int lastPage;
    /**
     * 下一页 
     */
    private int nextPage;
    /**
     * 上一页
     */
    private int prevPage;

    /**
     * 是否有首页 
     */
    private boolean hasFirst;
    /**
     * 是否有尾页
     */
    private boolean hasLast;
    /**
     * 是否有下一页
     */
    private boolean hasNext;
    /**
     * 是否有上一页
     */
    private boolean hasPrev;

    private int currentPage;
    private int totalPage;
    private int rowCount;
    private int pageSize;

    public Paging(int pageSize, int currentPage) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    @Deprecated
    public Paging(int rowCount, PagingAttribute pageRequest) {
        this.rowCount = rowCount;
        this.pageSize = pageRequest.getPageSize();
        if (pageRequest.getStartIndex() > 0) {
            this.currentPage = pageRequest.getStartIndex() / this.pageSize + 1;
        } else {
            this.currentPage = pageRequest.getPageNo();
        }
        this.totalPage =  this.rowCount % this.pageSize == 0 ? this.rowCount / this.pageSize : this.rowCount / this.pageSize + 1;
        if (this.currentPage > totalPage)
            this.currentPage = totalPage;
        if (this.currentPage < 1)
            this.currentPage = 1;
        if (this.totalPage > 0) {
            this.hasFirst = true;
            this.firstPage = 1;
        }
        if (this.currentPage > 1) {
            this.hasPrev = true;
            this.prevPage = this.currentPage - 1;
        }
        if (this.totalPage > 0 && this.currentPage < this.totalPage) {
            this.hasNext = true;
            this.nextPage = this.currentPage + 1;
        }
        if (this.totalPage > 0) {
            this.hasLast = true;
            this.lastPage = this.totalPage;
        }
    }

    public Paging(int rowCount, int pageSize, int currentPage) {
        this.rowCount = rowCount;

        this.pageSize = pageSize;
        this.totalPage = this.rowCount % pageSize == 0 ? this.rowCount / pageSize : this.rowCount / pageSize + 1;

        if (this.totalPage > 0) {
            this.hasFirst = true;
            this.firstPage = 1;
        }

        if (currentPage < 1) {
            currentPage = 1;
        } else if (currentPage > this.totalPage && this.totalPage > 0) {
            currentPage = this.totalPage;
        }

        this.currentPage = currentPage;
        if (this.currentPage > 1) {
            this.hasPrev = true;
            this.prevPage = this.currentPage - 1;
        }
        if (this.totalPage > 0 && this.currentPage < this.totalPage) {
            this.hasNext = true;
            this.nextPage = this.currentPage + 1;
        }
        if (this.totalPage > 0) {
            this.hasLast = true;
            this.lastPage = this.totalPage;
        }
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }

    public boolean isHasFirst() {
        return hasFirst;
    }

    public void setHasFirst(boolean hasFirst) {
        this.hasFirst = hasFirst;
    }

    public boolean isHasLast() {
        return hasLast;
    }

    public void setHasLast(boolean hasLast) {
        this.hasLast = hasLast;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPrev() {
        return hasPrev;
    }

    public void setHasPrev(boolean hasPrev) {
        this.hasPrev = hasPrev;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
