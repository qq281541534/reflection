package com.liuyu.reflection;

import java.lang.reflect.Array;

/**   
 *  
 * @Description: 设置一个三维数组的[3][5][10]下标的值为37
 * @author ly   
 * @date 2014-6-4 下午6:06:00 
 *    
 */
public class ArrayTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int [] dims = new int[] { 5, 10, 15};
		//通过dims数据的长度是三位，所以实例化一个三维数组
		Object array = Array.newInstance(Integer.TYPE, dims);
		//获取该三维数组中的一维中的下标为3的二维数组
		Object arrayObj = Array.get(array, 3);
		//获取二维数组的组件类型
		Class<?> cls = arrayObj.getClass().getComponentType();
		System.out.println(cls);
		//在得到的二维数组中获取下标为5的三维数组
		arrayObj = Array.get(arrayObj, 5);
		//在得到的三维数组中下标为10的赋值为37
		Array.setInt(arrayObj, 10, 37);
		int [][][]arrayCast = (int[][][]) array;
		System.out.println(arrayCast[3][5][10]);
	}

}


