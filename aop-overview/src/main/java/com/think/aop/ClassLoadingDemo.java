package com.think.aop;

/**
 * @description:
 * @author: yaochaochen
 * @since: 2020/12/24
 */
public class ClassLoadingDemo {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        System.out.print(classLoader);

        ClassLoader parentClassLoad = classLoader;
        while (true) {
            parentClassLoad = parentClassLoad.getParent();
            if(parentClassLoad == null) {
                break;
            }
            System.out.println(parentClassLoad);
        }
    }
}
