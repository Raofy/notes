package com.ryan.singletonmode;

public class DCLLazyMan {


    private volatile static DCLLazyMan dcllyInstance;

    private DCLLazyMan() {
        synchronized (DCLLazyMan.class) {
            if (dcllyInstance != null) {
                throw new RuntimeException();
            }
        }

    }

    public static DCLLazyMan getInstance() {

        if (dcllyInstance == null) {
            synchronized (DCLLazyMan.class) {
                if (dcllyInstance == null) {
                    return new DCLLazyMan();
                }
            }
        }
        return dcllyInstance;

    }
}
