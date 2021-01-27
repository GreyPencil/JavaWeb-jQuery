package com.suze.utils;

import com.suze.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-10 4:23 PM
 */
public class WebUtils {

    public static <T> T copyParamToBean(Map value, T bean){
        try {

            BeanUtils.populate(bean,value);
            System.out.println(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt, int defaultValue){

        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultValue;

    }


}
