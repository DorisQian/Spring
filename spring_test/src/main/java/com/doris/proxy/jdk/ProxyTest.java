package com.doris.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        //创建目标对象
        final Target target = new Target();
        //增强对象
        final Advice advice = new Advice();
        //返回值是动态生成的代理对象
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //目标对象类加载器
                target.getClass().getInterfaces(), //目标对象相同的接口字节码对象数组
                new InvocationHandler() {
                    //调用代理对象的任何方法 实质执行的都是invoke方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();//前置增强
                        //执行目标方法
                        method.invoke(target, args);
                        advice.after();//后置增强
                        return null;
                    }
                }
        );
        //调用代理对象的方法
        proxy.save();
    }
}
