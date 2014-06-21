package com.liuyu.reflection;

import java.lang.reflect.Method;

/**   
 *  
 * @Description: 通过反射机制，获取命令行输入的类的所有方法
 * @author ly   
 * @date 2014-6-3 上午12:06:21 
 *    
 */
public class DumpMethods {
	
	public static void main(String[] args) throws ClassNotFoundException {
		//加载并初始化命令行参数指定的类
		Class<?> classType = Class.forName(args[0]);
		//获取这个类中的所有方法
		Method methods[] = classType.getDeclaredMethods();
		for(int i=0;i<methods.length;i++){
			System.out.println(methods[i].toString());
		}
	}
}


