package com.jdai.Spring5.SpringAngualrDemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {
    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};
        //way#1 - inner annoymous class
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });

        //2, commonly used option ----define a separate class implements Invocationhandler
        UserDao userDao = new UserDaoImpl();
        UserDao userDaoProxy = (UserDao)Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        //invoke proxy
        int result = userDaoProxy.add(1, 2);
        System.out.println(result);
    }

}
class UserDaoProxy implements InvocationHandler{
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    //enhanced code
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("enhanced code before method ......");

        //execute method
        Object result= method.invoke(obj, args);

        System.out.println("enhanced code after method executed......");
        return result;
    }
}
