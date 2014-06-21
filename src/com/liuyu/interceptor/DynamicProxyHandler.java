package com.liuyu.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**   
 *  
 * @Description: 
 * @author ly   
 * @date 2014-6-11 下午11:36:44 
 *    
 */
public class DynamicProxyHandler implements InvocationHandler {

	//被代理对象(主要是在method.invoke（"这里使用",args）)
	private Object obj;
	//拦截器
	private InterceptorClass interceptor = new InterceptorClass();
	
	// 动态生成一个代理类对象,并绑定被代理类和代理处理器
	public Object bind(Object obj){
		this.obj = obj;
		return Proxy.newProxyInstance(
				//被代理类的ClassLoader
				obj.getClass().getClassLoader(),
				//要被代理的接口,本方法返回对象会自动声称实现了这些接口
				obj.getClass().getInterfaces(), 
				//代理处理器对象
				this);
	}
	
	
	/**
	  * @param proxy  代理类对象
	  * @param method 被代理的接口方法
	  * @param args   被代理接口方法的参数
	  * @throws Throwable
	  */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		interceptor.before();
		Object result = method.invoke(obj, args);
		interceptor.after();
		
		return result;
	}

}


