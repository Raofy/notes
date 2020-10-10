package com.ryan.singletonmode;

import org.springframework.util.ObjectUtils;

/**
 * 懒汉式单例模式
 */
public class LazyMan {

    private static LazyMan lyInstance;

    private LazyMan() {

    }

    public static LazyMan getInstance() {
        if (lyInstance == null) {
            return new LazyMan();
        }
        else {
            return lyInstance;
        }
    }
}
