package com.liuyu.reflection;

import java.lang.reflect.Constructor;

/**   
 *  
 * @Description: 使用反射机制调用类带参数的构造方法示例
 * @author ly   
 * @date 2014-6-4 下午11:26:53 
 *    
 */
public class ReflectConstructor {

	public static void main(String[] args) throws Exception {
		//获取类实例
		Class<?> c = Class.forName("com.liuyu.reflection.DynTest");
		//生成一个Class类型的数组，数组中存了一个double类型的class和一个int类型的class
		Class[] pTypes = new Class[]{ double.class, int.class};
		//获取DynTest类中对应的需要传入一个double类型和int类型的构造方法
		Constructor constructor = c.getConstructor(pTypes);
		Object obj = null;
		//生成一个对象数组，中存一个double值和一个int值（自变量）
		Object [] arg = new Object[] {31.50, 10};
		//用实例化这个构造方法
		obj = constructor.newInstance(arg);
		System.out.println(obj);
	}
	
}

class DynTest{
	
	public DynTest(double num1,int num2){
		System.out.println(num1 + num2);
	}
	
}
