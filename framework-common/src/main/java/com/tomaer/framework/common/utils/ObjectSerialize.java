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
package com.tomaer.framework.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Description:对象序列化反序列化工具类
 * Author: tomaer
 * Version: 1.0
 * Date: 2015/2/2 21:50
 */
public class ObjectSerialize implements Serializable {

    private static final long serialVersionUID = -6934277164229775725L;

    @SuppressWarnings("finally")
    public static String serialization(Object obj) {
        String result = StringUtils.EMPTY;
        ObjectOutputStream oos = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            result = bos.toString("ISO-8859-1");
            result = URLEncoder.encode(result, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                    oos = null;
                }
            } catch (Exception e) {
            }
            return result;
        }
    }

    @SuppressWarnings("finally")
    public static Object deserialization(String serial) {
        if (StringUtils.isBlank(serial)) {
            return null;
        }
        ObjectInputStream ois = null;
        Object result = null;
        try {
            String str = URLDecoder.decode(serial, "UTF-8");
            ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
            ois = new ObjectInputStream(bis);
            result = ois.readObject();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                    ois = null;
                }
            } catch (Exception e) {
            }
            return result;
        }
    }
}
