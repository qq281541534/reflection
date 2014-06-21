	package com.liuyu.dynamicproxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**   
 *  
 * @Description: 
 * @author ly   
 * @date 2014-6-8 上午12:04:42 
 *    
 */
public class CommonInvocationHandler implements InvocationHandler {

	//动态执行的对象，需要回调的对象
	private Object target;
	
	public CommonInvocationHandler(){
		
	}
	
	public CommonInvocationHandler(Object object){
		this.target = object;
	}
	
	public void setTarget(Object target){
		this.target = target;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		Object o = method.invoke(target, args);
		return o;
	}

}


