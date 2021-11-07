package com.bobocode.lib;

import com.bobocode.demo.annotation.Trimmed;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;

public class TrimmedAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanType = bean.getClass();
        if (beanType.isAnnotationPresent(Trimmed.class)) {
            return createLoggingProxy(beanType);
        }
        return bean;
    }

    private Object createLoggingProxy(Class<?> beanType) {
        var enhancer = new Enhancer();
        enhancer.setSuperclass(beanType);
        enhancer.setInterfaces(beanType.getInterfaces());
        MethodInterceptor interceptor = (Object obj, Method method, Object[] args, MethodProxy proxy) -> {
            System.out.println("ADVERTISEMENT ADVERTISEMENT ADVERTISEMENT \n");

            for (int i = 0; i < args.length; i++) {
                if (args[i].getClass().equals(String.class)) {
                    args[i] = ((String) args[i]).trim();
                }
            }

            return method.getReturnType().equals(String.class) ?
                    ((String) proxy.invokeSuper(obj, args)).trim() :
                    proxy.invokeSuper(obj, args);
        };

        enhancer.setCallback(interceptor);
        return beanType.cast(enhancer.create());
    }
}
