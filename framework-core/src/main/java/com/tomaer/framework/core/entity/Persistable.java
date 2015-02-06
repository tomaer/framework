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

import java.io.Serializable;

/**
 * Description: 持久化对象接口
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/6 22:41
 */
public interface Persistable extends Serializable {

    /**
     * 获得对象ID
     * @return
     */
    Long getId();

    /**
     * 对象是否是没有持久化过的
     * @return
     */
    boolean isNew();
}
