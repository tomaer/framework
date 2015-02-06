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
package com.tomaer.framework.core.entity;

import java.util.Date;

/**
 * Description:
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/6 22:50
 */
public class IdEntity extends AbstractEntity {

    private static final long serialVersionUID = 5232733439681437717L;
    
    private Long id;
    
    protected String createBy;

    protected String modifyBy;

    protected Date createDate;

    protected Date modifyDate;

    protected Long version = -1L;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdEntity)) return false;

        IdEntity idEntity = (IdEntity) o;

        if (createBy != null ? !createBy.equals(idEntity.createBy) : idEntity.createBy != null) return false;
        if (createDate != null ? !createDate.equals(idEntity.createDate) : idEntity.createDate != null) return false;
        if (id != null ? !id.equals(idEntity.id) : idEntity.id != null) return false;
        if (modifyBy != null ? !modifyBy.equals(idEntity.modifyBy) : idEntity.modifyBy != null) return false;
        if (modifyDate != null ? !modifyDate.equals(idEntity.modifyDate) : idEntity.modifyDate != null) return false;
        if (version != null ? !version.equals(idEntity.version) : idEntity.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (modifyBy != null ? modifyBy.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IdEntity{" +
                "id=" + id +
                ", createBy='" + createBy + '\'' +
                ", modifyBy='" + modifyBy + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", version=" + version +
                '}';
    }
}
