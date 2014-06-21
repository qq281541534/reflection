package com.liuyu.interceptor;
/**   
 *  
 * @Description: 
 * @author ly   
 * @date 2014-6-11 下午11:32:36 
 *    
 */
public class InterceptorClass {
	
	public void before(){
		System.out.println("拦截器InterceptorClass方法调用！before()");
	}
	
	public void after(){
		System.out.println("拦截器InterceptorClass方法调用！after");
	}
}


