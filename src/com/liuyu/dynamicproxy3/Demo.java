package com.liuyu.dynamicproxy3;

import java.lang.reflect.Proxy;


/**   
 *  
 * @Description: 
 * @author ly   
 * @date 2014-6-8 上午12:26:53 
 *    
 */
public class Demo {
	
	public static void main(String[] args) {
		
		//1.通用的动态代理类实现
		CommonInvocationHandler handler = new CommonInvocationHandler();
		
		Foo f;
		
		//2.接口实现
		handler.setTarget(new FooImp1());
		
		//方法参数说明：代理类，代理类实现的接口列表，处理器
		//关联代理类、代理类中接口方法、处理器，当代理类中接口方法被调用时，会自动分发到处理器的invoke方法
		f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[]{ Foo.class }, handler);
		
		f.doAction();
		
		//3.接口实现2
		handler.setTarget(new FooImp2());
		
		f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[]{ Foo.class }, handler);
		
		f.doAction();
				
		
		
		
	}
}


