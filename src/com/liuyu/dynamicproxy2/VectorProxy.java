package com.liuyu.dynamicproxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

/**   
 *  
 * @Description: 
 * @author ly   
 * @date 2014-6-7 下午9:30:42 
 *    
 */
public class VectorProxy implements InvocationHandler {

	public Object proxyobj;
	
	public VectorProxy(Object obj){
		this.proxyobj = obj;
	}
	
	/**
	 * 返回一个代理类的实例
	 * @param obj
	 * @return
	 */
	public static Object factory(Object obj){
		Class<?> cls = obj.getClass();
		return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new VectorProxy(obj));
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(method + "方法执行前");
		
		if(args != null){
			for(int i=0; i<args.length; i++){
				System.out.println(args[i] + "");
			}
		}
		
		Object object = method.invoke(proxyobj, args);
		
		System.out.println(method + "方法执行后");
		return object;
	}

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//v现在代理了vector的所有方法，可以有add，remove等方法
		List<String> v = (List<String>) factory(new Vector<String>(10));
		
		
		/**对应输出结果
		 * public abstract boolean java.util.List.add(java.lang.Object)方法执行前
			第一个
			public abstract boolean java.util.List.add(java.lang.Object)方法执行后
		 */
		v.add("第一个");
		
		
		
		
		/**对应输出结果
		 * public abstract boolean java.util.List.add(java.lang.Object)方法执行前
			第二个
			public abstract boolean java.util.List.add(java.lang.Object)方法执行后
		 */
		v.add("第二个");
		
		
		
		
		/**对应输出结果
		 * public java.lang.String java.lang.Object.toString()方法执行前
			public java.lang.String java.lang.Object.toString()方法执行后
			[第一个, 第二个]
		 */
		System.out.println(v);
		
		
		
		/**
		 * 对应输出结果
		 * public abstract java.lang.Object java.util.List.remove(int)方法执行前
			0
			public abstract java.lang.Object java.util.List.remove(int)方法执行后
		 * 
		 */
		v.remove(0);
		
		
		
		/**对应输出结果
		 * public java.lang.String java.lang.Object.toString()方法执行前
			public java.lang.String java.lang.Object.toString()方法执行后
			[第二个]
		 */
		System.out.println(v);
			
		
		
		/**对应输出结果
		 * class com.sun.proxy.$Proxy0
		 * 
		 * 这里需要说明下一下，为什么值输出了这个内容，原因是只要是从Object的类继承过来的方法，只有toString,hashCode,equals这三个方法会使动态
		 * 代理类执行invoke方法，其他的方法都不会执行动态代理类的invoke方法，而是直接将改方法执行了，必须注意
		 */
		System.out.println(v.getClass());
		
		
	}
	
}


