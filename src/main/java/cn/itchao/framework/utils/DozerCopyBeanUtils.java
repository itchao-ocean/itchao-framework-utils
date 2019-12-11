/**
 * Copyright (c) 2011-2030, author jinchao (370696614@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package cn.itchao.framework.utils;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jinchao
 * @description TODO
 * @date 2019/12/11 16:22
 */
public class DozerCopyBeanUtils {


    public static final DozerBeanMapper beanMapper = new DozerBeanMapper();

    /**
     * 对象到类，目标类可以不是源对象的类
     * @param source 复制源
     * @param destclas Class可以不是source的Class
     * @return
     */
    public static <T> T mapFromClass(Object source, Class<T> destclas){
        return beanMapper.map(source, destclas);
    }

    /**
     * 集合复制
     * @param sources
     * @param destclas
     * @return
     */
    public static <T> List<T> mapFromClass(List<?> sources, Class<T> destclas){
        List<T> destList = new ArrayList<>(sources.size());
        for(Object source : sources){
            T dest = beanMapper.map(source, destclas);
            destList.add(dest);
        }
        return destList;
    }

    /**
     * 对象到对象
     * @param source
     * @param dest
     */
    public static void copyPropertys(Object source, Object dest){
        beanMapper.map(source, dest);
    }

    /**
     * 对象复制
     * @param source
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T cloneObject(T source){
        return (T) beanMapper.map(source, source.getClass());
    }
}
