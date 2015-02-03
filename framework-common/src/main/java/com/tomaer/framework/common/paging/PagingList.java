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
import java.util.List;

/**
 * Description:分页封装对象,封装了数据结合和分页数据
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 21:44
 */
public class PagingList<E> implements Serializable {

    private static final long serialVersionUID = 3233079531706248991L;

    /**
     * 数据集合
     */
    private List<E> data;
    /**
     * 分页对象
     */
    private Paging paging;

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
