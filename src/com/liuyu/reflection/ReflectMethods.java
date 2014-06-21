package com.liuyu.reflection;

import java.lang.reflect.Method;
import java.util.Hashtable;

/**   
 *  
 * @Description: 通过反射机制 调用 类 中带 参数的   方法示例
 * @author ly   
 * @date 2014-6-4 下午11:44:10 
 *    
 */
public class ReflectMethods {
	
	public String func(String s, Hashtable t) {
		System.out.println("func invoked");
		return s;
	}
	
	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("com.liuyu.reflection.ReflectMethods");
		//生成Class类的数组，一个参数为string，另一个参数为hashtable
		Class[] pTypes = new Class[2];
		pTypes[0] = Class.forName("java.lang.String");
		pTypes[1] = Class.forName("java.util.Hashtable");
		//获得方法名为func的方法。
		Method method = c.getMethod("func", pTypes);
		//生成Object类的数组，一个传String类型，一个传null
		Object[] arg = new Object[2];
		arg[0] = new String("Hello");
		arg[1] = null;
		//执行method对应的方法，
		Object result = method.invoke(c.newInstance(), arg);
		System.out.println(result);
	}
}


