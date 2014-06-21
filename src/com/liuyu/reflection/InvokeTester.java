package com.liuyu.reflection;

import java.lang.reflect.Method;

/**   
 *  
 * @Description: 通过反射机制获取对象有参数的method的详细案例
 * @author ly   
 * @date 2014-6-4 下午5:22:25 
 *    
 */
public class InvokeTester {
	
	public int add(int param1, int param2) {
		return param1 + param2;
	}
	
	public String echo(String msg) {
		return "echo:" + msg;
	}
	
	public static void main(String [] args) throws Exception, IllegalAccessException {
		
		//获取Class类泛型
		Class<?> classType = InvokeTester.class;
		//实例化类
//		Object invokeTester = classType.newInstance();
		//这个方法与上面的方法相同，都是调用了构造方法，而这个方法，是可以调用所有的构造方法，不管有参数的还是没有参数的
		Object invokeTester1 = classType.getConstructor(new Class[]{}).newInstance();
		
		//获取对象中的add方法
		Method addMethod = classType.getMethod("add", new Class[]{ int.class, int.class });
		//执行invokerTester1的addMethod方法，并出入参数（这里的参数必须是包装类，而由于jdk5.0之后，添加的自动拆箱装箱的操作，所以直接写100，50也没问题）
		Object result = addMethod.invoke(invokeTester1, new Object[]{ new Integer(100), new Integer(50)});
		System.out.println((Integer)result);
		
		Method echoMethod = classType.getMethod("echo", new Class[]{String.class});
		result = echoMethod.invoke(invokeTester1, new Object[]{"invokeTester1的echo方法"});
		System.out.println((String)result);
	}
}


