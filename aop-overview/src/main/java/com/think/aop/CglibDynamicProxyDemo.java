package com.think.aop;

import org.aspectj.lang.reflect.NoSuchPointcutException;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CgLib 动态代理
 * @description:
 * @author: yaochaochen
 * @since: 2020/12/24
 */
public class CglibDynamicProxyDemo {

    public static void main(String[] args) throws NoSuchPointcutException {
        Enhancer enhancer = new Enhancer();
        //指定superClass
        Class<?> superClass = DefaultEchoService.class;
        enhancer.setSuperclass(superClass);
        //指定拦截接口
        enhancer.setInterfaces(new Class[]{EchoService.class});
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long satrtTime  = System.currentTimeMillis();
                // Source -> CGLIB 子类
                // 目标类  -> DefaultEchoService
                // 错误使用
//                Object result = method.invoke(source, args);
                // 正确的方法调用
                Object result = methodProxy.invokeSuper(o, objects);
                long costTime = System.currentTimeMillis() - satrtTime;
                System.out.println("[CGLIB 字节码提升] echo 方法执行的实现：" + costTime + " ms.");
                return result;
            }
        });
        // 创建代理对象
        EchoService echoService = (EchoService) enhancer.create();
        // 输出执行结果
        System.out.println(echoService.echo("Hello,World"));
    }
}
