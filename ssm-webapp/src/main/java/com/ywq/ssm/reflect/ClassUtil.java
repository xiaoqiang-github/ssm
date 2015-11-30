/**
 * 
 */
package com.ywq.ssm.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author yangWeiQiang
 *
 */
public class ClassUtil {

	
	
	
	/**
	 * 获取类的成员变量
	 * @param obj
	 */
	public static void printFieldInfo(Object obj){
		Class c = obj.getClass();
		//获取成员变量
		Field[] fields = c.getDeclaredFields();
		for(Field field : fields){
			//获取 成员变量的类型
			Class f = field.getType();
			System.out.print(f.getName()+"\t");
			
			//获取成员变量名称
			System.out.println(field.getName());
		}
	}
	
	
	/**
	 * 获取方法的的信息
	 * 返回值 + 方法名称 + 参数列表
	 * @param obj 实例
	 */
	public static void printMethodInfo(Object obj){
		Class objClass = obj.getClass();
		System.out.println("传入的类名称为:"+objClass.getName());
		Method[] methods = objClass.getDeclaredMethods();
		for(Method m : methods){
			//获取 方法返回类型的名称
			System.out.print(m.getReturnType().getName()+"\t");
			
			//获取 方法名称
			System.out.print(m.getName()+" (");
			
			//获取方法参数类型
			Class[] params = m.getParameterTypes();
			for(Class p : params){
				System.out.print(p.getName()+",");
			}
			System.out.println(")");
		}
	}
}
