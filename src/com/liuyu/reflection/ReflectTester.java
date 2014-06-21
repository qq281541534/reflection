package com.liuyu.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**   
 *  
 * @Description: 用java的反射机制从一个对象像另个一个对象复制，并调用原对象的get方法，把get的值调用复制对象的set方法赋值
 * @author ly   
 * @date 2014-6-3 上午12:40:29 
 *    
 */
public class ReflectTester {

	public Object copy(Object object) throws Exception{
		//获得对象的类型
		Class<?> classType = object.getClass();
		System.out.println("Class: "+classType.getName());
		
		//通过默认的构造方法创建一个新的对象
		Object objectCopy = classType.getConstructor(new Class[]{}).newInstance();
		
		//获得对象的所有属性
		Field[] fields = classType.getDeclaredFields();
		
		for(int i=0; i<fields.length; i++){
			Field field = fields[i];
			
			//获取属性名
			String fieldName = field.getName();
//			System.out.println(fieldName);
			//获取属性名第一个字母并转换成大写
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			
			//获取属性对应的get方法名称
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
//			System.out.println(getMethodName);
			//获取属性对应的set方法名称
			String setMethodName = "set" + firstLetter + fieldName.substring(1);
			
			//获得和属性对应的get方法
			Method getMethod = classType.getMethod(getMethodName, new Class[]{});
			
			//获得和属性对应的set方法(因为set方法是需要传参数的，所以new Class[]{需要该属性的参数类型})
			Method setMethod = classType.getMethod(setMethodName, new Class[]{field.getType()});
			
			//调用原对象的get方法，并返回方法的return结果(第一个参数是原对象，第二个参数是getMethod方法传入的参数)
			Object value = getMethod.invoke(object, new Object[]{});
			System.out.println(fieldName +":"+ value);
			
			//调用拷贝对象的set方法,意思就是将原对象中的属性对应的值，set到copy对象的对应属性中
			setMethod.invoke(objectCopy, new Object[]{value});
		}
		return objectCopy;
		
	}
	
	public static void main(String[] args) throws Exception{
		Customer customer = new Customer("刘雨",20);
		customer.setId(123456L);
		Customer copyCustomer = (Customer) new ReflectTester().copy(customer);
		System.out.println(copyCustomer.getId() + ":" +copyCustomer.getName() + ":" + copyCustomer.getAge());
	}
}

class Customer{
	
	private Long id;
	private String name;
	private int age;
	
	public Customer(){
		
	}
	
	public Customer(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}

