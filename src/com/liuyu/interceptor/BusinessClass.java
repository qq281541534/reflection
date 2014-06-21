package com.liuyu.interceptor;
/**   
 *  
 * @Description: 
 * @author ly   
 * @date 2014-6-11 下午11:35:38 
 *    
 */
public class BusinessClass implements BusinessInterface {

	@Override
	public void doSomething() {
		System.out.println("业务组件BusinessClass方法调用:doSomething()"); 
	}

}


