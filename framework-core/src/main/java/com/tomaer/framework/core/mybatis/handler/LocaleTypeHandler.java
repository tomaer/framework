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
package com.tomaer.framework.core.mybatis.handler;

import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Description:
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/6 23:35
 */
public class LocaleTypeHandler implements TypeHandler<Locale> {

    Locale getLocale(final String locale) {
        return StringUtils.isNotBlank(locale) ? LocaleUtils.toLocale(locale) : null;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, Locale parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, (null != parameter) ? parameter.toString() : Locale.ENGLISH.toString());
    }

    @Override
    public Locale getResult(ResultSet rs, String columnName) throws SQLException {
        return getLocale(rs.getString(columnName));
    }

    @Override
    public Locale getResult(ResultSet rs, int columnIndex) throws SQLException {
        return getLocale(rs.getString(columnIndex));
    }

    @Override
    public Locale getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getLocale(cs.getString(columnIndex));
    }
}
