package com.wy.ddd.infrastructure.util;

import com.wy.ddd.infrastructure.exception.BaseException;
import org.springframework.beans.BeanUtils;

/**
 * @Author wangyang
 * @Create 2022/4/25 18:30
 */
public class LocalBeanUtils {
    public static <T> T copyProperties(Object source, Class<T> tClass) {
        if (source == null) {
            return null;
        } else {
            try {
                T t = tClass.newInstance();
                BeanUtils.copyProperties(source, t);
                return t;
            } catch (IllegalAccessException var3) {
                var3.printStackTrace();
                throw new BaseException("CopyP错误:" + var3.getMessage());
            } catch (InstantiationException var4) {
                var4.printStackTrace();
                throw new BaseException("CopyP错误:" + var4.getMessage());
            }
        }
    }
}
