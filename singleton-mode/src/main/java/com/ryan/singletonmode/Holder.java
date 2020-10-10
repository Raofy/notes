package com.ryan.singletonmode;

public class Holder {

    private Holder() {

    }

    public static Holder getInstance(){
        return InnerClass.holder;
    }

    private static class InnerClass{
        private static Holder holder = new Holder();
    }
}
