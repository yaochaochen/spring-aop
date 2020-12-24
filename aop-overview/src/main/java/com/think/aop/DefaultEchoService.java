package com.think.aop;

/**
 * @description: 默认实现
 * @author: yaochaochen
 * @since: 2020/12/23
 */
public class DefaultEchoService implements EchoService {
    @Override
    public String echo(String message) {
        return "[ECHO]" + message;
    }
}
