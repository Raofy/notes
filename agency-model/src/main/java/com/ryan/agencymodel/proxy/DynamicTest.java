package com.ryan.agencymodel.proxy;

import com.ryan.agencymodel.dynamic.ProxyInvocationHandler;
import com.ryan.agencymodel.service.UserService;
import com.ryan.agencymodel.service.impl.UserServiceImpl;

public class DynamicTest {

    public static void main(String[] args) {
        //真实对象
        UserServiceImpl userService = new UserServiceImpl();
        //代理对象的调用处理程序
        Dynamic pih = new Dynamic(userService);//设置要代理的对象
        UserService proxy = (UserService)pih.getProxy(); //动态生成代理类！
        proxy.delete();

    }
}
