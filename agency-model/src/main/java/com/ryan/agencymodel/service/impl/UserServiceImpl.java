package com.ryan.agencymodel.service.impl;

import com.ryan.agencymodel.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加操作");
    }

    @Override
    public void delete() {
        System.out.println("删除操作");
    }

    @Override
    public void select() {
        System.out.println("查询操作");
    }

    @Override
    public void update() {
        System.out.println("更新操作");
    }
}
