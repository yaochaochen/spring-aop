package com.think.aop;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * AOP 过滤
 * @description:
 * @author: yaochaochen
 * @since: 2020/12/24
 */
public class TargetFilterDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        String targetClassName = "com.think.aop.EchoService";
        //获取当前线程加载类
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //获取目标类
        Class<?> targetClass = classLoader.loadClass(targetClassName);
        Method targetMethod = ReflectionUtils.findMethod(targetClass, "echo", String.class);
        System.out.println(targetMethod);
        ReflectionUtils.doWithMethods(targetClass, new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                System.out.println("仅抛出 NullPointerException 方法为：" + method);

            }
        });
    }
}
