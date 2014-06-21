package com.liuyu.interceptor;
/**   
 *  
 * @Description: 
 * @author ly   
 * @date 2014-6-11 下午11:49:35 
 *    
 */
public class Client {
	
	public static void main(String[] args) {
		//生成动态代理类实例
		DynamicProxyHandler handler = new DynamicProxyHandler();
		//这里所有的业务类只要继承了BusinessInterface，那他就会通过下面的代码被拦截器调用
		BusinessInterface business = new BusinessClass();
		//将业务组件对象和动态代理类实例绑定
		business = (BusinessInterface) handler.bind(business);
		
		business.doSomething();
	}
}


