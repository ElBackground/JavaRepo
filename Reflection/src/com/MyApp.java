package com;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.List;

public class MyApp {

    static List<Class<?>> list;
    public static final String ANNOTATION_NAME = "MyAnnotation";

    public static void main(String[] args) {
        list = PackageLoader.getClassesForPackage(Package.getPackage("com"));

        for (Class<?> c : list) {
            for (Annotation a : c.getAnnotations()) {
                if (ANNOTATION_NAME.equals(a.annotationType().getSimpleName())) {
                    for (Method m : a.annotationType().getDeclaredMethods()) {
                        try {
                            if ((boolean) m.invoke(a, null)) {
                                System.out.println("* " + c.getSimpleName() + "'s constructors:");
                                for (Constructor co : c.getConstructors()) {
                                    System.out.println("* * " + co);
                                }
                                System.out.println("\n");
                            }
                        } catch (Exception e) {
                            System.exit(265);
                        }
                    }
                }
            }
        }
    }
}
