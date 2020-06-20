/*
 * Copyright (c) 2015-2025 by HRT All rights reserved
 */
package listeningrain.cn.convert;

import java.lang.reflect.Method;

/**
 * 暂存rest请求的类和方法等信息
 */
public abstract class CurrentControllerMethod {

	private static final ThreadLocal<Class<?>> currentControllerClz = new ThreadLocal<>();
	private static final ThreadLocal<Method> currentMethodName = new ThreadLocal<>();

	public static void setCurrentControllerClz(Class<?> clz) {
		if (null != clz) {
			currentControllerClz.set(clz);
		} else {
			currentControllerClz.remove();
		}
	}

	public static void setCurrentControllerMethod(Method method) {
		if (null != method) {
			currentMethodName.set(method);
		} else {
			currentMethodName.remove();
		}
	}

	public static Class<?> getCurrentControllerClz() {
		return currentControllerClz.get();
	}

	public static Method getCurrentControllerMethod() {
		return currentMethodName.get();
	}

	public static void clear() {
		currentControllerClz.remove();
		currentMethodName.remove();
	}
}
