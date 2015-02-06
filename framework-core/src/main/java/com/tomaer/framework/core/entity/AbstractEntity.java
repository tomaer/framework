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

/**
 * Description:
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/6 22:44
 */
public abstract class AbstractEntity implements Persistable {

    private static final long serialVersionUID = 8714275641792288435L;

    @Override
    public abstract Long getId();

    public abstract void setId(final Long id);

    @Override
    public boolean isNew() {
        return null == getId();
    }
    
}
