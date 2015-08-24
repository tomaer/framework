package com.tomaer.framework.core.common.paging;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by tomaer on 2015/8/23.
 */
public final class PagingList<T> implements java.io.Serializable {

    private static final long serialVersionUID = -273517776636113586L;
    private List<T> datas;
    private Paging paging;

    public PagingList(List<T> datas, Paging paging) {
        super();
        this.datas = datas;
        this.paging = paging;
    }

    public List<T> getDatas() {
        if(null == datas){
            datas = Lists.newArrayList();
        }
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
