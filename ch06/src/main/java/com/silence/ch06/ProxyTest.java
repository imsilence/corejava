package com.silence.ch06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyTest {
	public static void main(String[] args) {
		class TraceHandler implements InvocationHandler {

			private Object target = null;
			
			public TraceHandler(Object aTarget) {
				target = aTarget;
			}
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				System.out.print(target);
				System.out.print("." + method.getName() + "(");
				if(args != null) {
					for(int i = 0; i < args.length; ++i) {
						System.out.print(args[i]);
						if(i < args.length - 1) {
							System.out.print(",");	
						}
					}
				}
				System.out.println(")");
				return method.invoke(target, args);
			}
		}
		
		Object[] elements = new Object[10];
		for(int i = 0; i < elements.length; ++i) {
			elements[i] = Proxy.newProxyInstance(null, new Class[] {Comparable.class}, new TraceHandler(1 + i));
		}
		
		int result = Arrays.binarySearch(elements, 2);
		System.out.println(result);
		if(result >= 0) {
			System.out.println(elements[result]);
		}
	}
}