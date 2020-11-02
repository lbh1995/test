package com.company;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.omg.PortableInterceptor.Interceptor;
import org.w3c.dom.html.HTMLLegendElement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.PublicKey;

public class ProxyDemo {
    interface SendMessgaeService{
        public void send(String message);
    }
    public static class User implements SendMessgaeService{
        public void send(String message) {
            System.out.println(message);
        }
    }
    public static class MyInvocationHandler implements InvocationHandler{
        SendMessgaeService sms = null;
        MyInvocationHandler(SendMessgaeService sms){
            this.sms = sms;
        }
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(1);
            method.invoke(sms,args);
            System.out.println(2);
            return null;
        }
    }
    public static class HelloSon {
        public void say(){
            System.out.println("CGLIB-hello");
        }
    }
    public static class MyInterceptor implements MethodInterceptor {
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("Cglib-1");
            methodProxy.invokeSuper(o,objects);
            System.out.println("cglib-2");
            return null;
        }
    }
    public static void main(String[] args) {
        SendMessgaeService sms = (SendMessgaeService)Proxy.newProxyInstance(
                SendMessgaeService.class.getClassLoader(), // 1. 类加载器
                new Class<?>[] {SendMessgaeService.class}, // 2. 代理需要实现的接口，可以有多个
                new MyInvocationHandler(new User()));// 3. 方法调用的实际处理者
        sms.send("hello");
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new MyInterceptor());
        enhancer.setSuperclass(HelloSon.class);
        enhancer.setClassLoader(HelloSon.class.getClassLoader());

        HelloSon helloSon = (HelloSon) enhancer.create();
        helloSon.say();
    }
}
