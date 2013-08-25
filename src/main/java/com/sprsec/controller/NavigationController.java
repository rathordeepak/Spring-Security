package com.sprsec.controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.sprsec.navigation.Menu;

public class NavigationController {
	
	 public static void main(String[] args) {
	        try {
	            for (Method method : NavigationController.class
	                    .getClassLoader()
	                    .loadClass(("com.sprsec.controller.LinkNavigation"))
	                    .getMethods()) {
	                // checks if MethodInfo annotation is present for the method
	                if (method
	                        .isAnnotationPresent(Menu.class)) {
	                    try {
	                        // iterates all the annotations available in the method
	                        for (Annotation anno : method.getDeclaredAnnotations()) {
	                            System.out.println("Annotation in Method '"
	                                    + method + "' : " + anno);
	                        }
	                        Menu methodAnno = method
	                                .getAnnotation(Menu.class);
	                        System.out.println("menu :"+methodAnno.order());
	 
	                    } catch (Throwable ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            }
	        } catch (SecurityException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	 }
}
