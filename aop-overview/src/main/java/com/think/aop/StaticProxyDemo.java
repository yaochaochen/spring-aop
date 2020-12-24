package com.think.aop;

import org.aspectj.lang.reflect.NoSuchPointcutException;

/**
 * @description: 静态代理
 * @author: yaochaochen
 * @since: 2020/12/23
 */
public class StaticProxyDemo {

    public static void main(String[] args) throws NoSuchPointcutException {
        EchoService echoService = new ProxyEchoService(new DefaultEchoService());
        echoService.echo("Hello World");
    }
}
