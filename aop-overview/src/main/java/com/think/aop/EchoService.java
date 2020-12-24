package com.think.aop;

import org.aspectj.lang.reflect.NoSuchPointcutException;

/**
 * Echo 服务
 */
public interface EchoService {


    String echo(String message) throws NoSuchPointcutException;
}
