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
 * Description:分页属性对象
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 21:44
 */
public class PagingAttribute implements Serializable {

    private static final long serialVersionUID = 766874526930903056L;

    private final int DEFAULT_PAGE_SIZE = 20;
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
