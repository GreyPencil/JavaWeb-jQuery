package com.suze.test;

import com.suze.utils.WebUtils;

/**
 * @author suzekang
 * @Description
 * @create 2021-01-12 4:32 PM
 */
public class Test {
    public static void main(String[] args) {

        int id = WebUtils.parseInt("22", 0);
        System.out.println(id);

    }
}

