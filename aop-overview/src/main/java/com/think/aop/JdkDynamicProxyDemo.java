package com.think.aop;

import org.aspectj.lang.reflect.NoSuchPointcutException;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @description: JDK 动态代理
 * @author: yaochaochen
 * @since: 2020/12/23
 */
public class JdkDynamicProxyDemo {

    public static void main(String[] args) throws NoSuchPointcutException {
        //当前线程下的classLoader
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object proxy = Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, (o, method, objects) -> {
            if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
                ProxyEchoService echoService = new ProxyEchoService(new DefaultEchoService());
                return echoService.echo((String) objects[0]);
            }
            return null;
        });
        EchoService echoService = (EchoService) proxy;
        echoService.echo("Hello, World");
    }
}
