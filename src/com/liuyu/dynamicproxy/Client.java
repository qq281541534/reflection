package com.liuyu.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**   
 *  
 * @Description: 客户端
 * @author ly   
 * @date 2014-6-7 下午9:00:38 
 *    
 */
public class Client {

	public static void main(String[] args) {
		
		RealSubject realSubjcet = new RealSubject();//这里指定被代理类
		
		InvocationHandler ds = new DynamicSubject(realSubjcet);
		
		Class<?> cls = realSubjcet.getClass();

		//一次性生成代理
		//生成动态代理类，第一个参数为真实对象的ClassLoader，因为是动态生成，所以需要jvm加载该类，
		//第二个参数是真实对象所实现的所有接口（Subject）
		//第三个参数是给那个动态代理类去执行，那么在这里就是给了DynamicSubject中的invoke方法执行
		Subject subject = (Subject)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
		subject.request();
	}

}


