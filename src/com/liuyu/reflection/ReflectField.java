package com.liuyu.reflection;

import java.lang.reflect.Field;

/**   
 *  
 * @Description: 通过反射机制获取类中属性并赋值
 * @author ly   
 * @date 2014-6-5 上午12:04:46 
 *    
 */
public class ReflectField {

	public Double d;
	
	public static void main(String agrs[]) throws Exception{
		
		Class<?> c = Class.forName("com.liuyu.reflection.ReflectField");
		//通过名称获取field
		Field field = c.getField("d");
		
		Object obj = c.newInstance();
		
		System.out.println((Double)field.get(obj));
		
		field.set(obj, 15.5);
		
		System.out.println(((ReflectField)obj).d);
	}
}


