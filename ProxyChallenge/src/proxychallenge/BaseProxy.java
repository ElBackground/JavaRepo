package proxychallenge;

import java.lang.reflect.*;

public class BaseProxy implements InvocationHandler {

    private BaseInterface base;

    private BaseProxy(BaseInterface base) {
        this.base = base;
    }

    public static BaseInterface newInstance(BaseInterface base, Class<?>... os) {
        return (BaseInterface) Proxy.newProxyInstance(
                base.getClass().getClassLoader(),
                os,
                new BaseProxy(base)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> declaringClass = method.getDeclaringClass();

        for (Class<?> interf : base.getClass().getInterfaces()) {
            if (declaringClass.isAssignableFrom(interf)) {
                System.out.println("Proxy ->");
                this.invokerVerify(method, args);
            }
        }
        return null;
    }

    private Object invokerVerify(Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("Verify ->");

        if (method.isAnnotationPresent(Intercept.class)) {
            System.out.println("Intercept value = " + method.getAnnotation(Intercept.class).value() + ":");
            
            switch (method.getAnnotation(Intercept.class).value()) {
                case AFTER:
                    method.invoke(base, args);
                    System.out.println("\t[!] Intercepted after");
                    break;
                case BEFORE:
                    System.out.println("\t[!] Intercepted before");
                    method.invoke(base, args);
                    break;
                case INSTEAD_OF:
                    System.out.println("\t[!] Intercepted");
                    break;
                case NONE:
                    method.invoke(base, args);
                    break;
            }

            return null;
        } else {
            System.out.println("Has no Intercep mark:");
            method.invoke(base, args);
            return null;
        }
    }
}
