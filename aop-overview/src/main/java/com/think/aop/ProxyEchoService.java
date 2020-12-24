package com.think.aop;

import org.aspectj.lang.reflect.NoSuchPointcutException;

/**
 * @description:
 * @author: yaochaochen
 * @since: 2020/12/23
 */
public class ProxyEchoService implements  EchoService {

    private final EchoService echoService;

    public ProxyEchoService(EchoService echoService) {
        this.echoService = echoService;
    }

    @Override
    public String echo(String message) throws NoSuchPointcutException {
        long startTime = System.currentTimeMillis();
        String result = echoService.echo(message);
        long costTime = System.currentTimeMillis() - startTime;
        System.out.println("echo 方法执行的实现：" + costTime + " ms.");
        return result;
    }
}
