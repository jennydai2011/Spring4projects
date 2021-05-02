package com.jdai.Spring5.SpringAngualrDemo.proxy;

public class UserDaoImpl implements UserDao{

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public String update(String id) {
        return "test:"+id;
    }
}
