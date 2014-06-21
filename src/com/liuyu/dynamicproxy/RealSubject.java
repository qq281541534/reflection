package com.liuyu.dynamicproxy;
/**   
 *  
 * @Description: 具体角色
 * @author ly   
 * @date 2014-6-7 上午11:46:17 
 *    
 */
public class RealSubject implements Subject {

	public RealSubject(){
		
	}
	
	@Override
	public void request() {
		System.out.println("这是具体角色 RealSubject类");
	}

}


