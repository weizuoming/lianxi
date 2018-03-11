package com.example.hello.fanshedemo02;

import java.lang.reflect.Method;

/**
 * 
 * 1.@author 2.@date 2017-3-24 3.@description
 * 
 * ͨ��Class�����ȡ����Ӧ�ķ���,�ڷ��似����ʹ����Method�������˷�����
		* ��ȡ�����й����ķ���
			* clazz.getMethods()
				* clazz.getDeclaredMethods(); //��ȡ�����еķ��������ǲ���������ķ���
			* System.out.println(method);
		* ��ȡ�����ķ���
			* clazz.getMethod("eat", int.class);//��һ���Ƿ�����,�ڶ��������ɱ�,���������е�����
			* m.invoke(p, 3); //invoke ִ��һ�������� ��һ�������������ĵ��ö��� �ڶ������� ��������Ҫ�Ĳ���
		* ִ��˽�еķ���
			* clazz.getDeclaredMethod("sleep",int.class);
			* m.setAccessible(true);//���÷���Ȩ���������
			* m.invoke(null, 6);
 */
public class Demo03 {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.bawei.fanshe.Person");
		
		//1.��ȡ�����й����ķ���
		//Method[] methods = clazz.getMethods();//��ȡ���еķ���,���������
		/*Method[] methods = clazz.getDeclaredMethods();//��ȡ��ǰ�����еķ���,�����������
		for (Method method : methods) {
			System.out.println(method);
		}*/
		
		//2.��ȡ�����ķ���,,,,��ִ��
		/*Method method = clazz.getMethod("eat", null);
		method.invoke(new Person("����", 21), null);//��һ����������صĶ���,�ڶ�����ʼ���ǿɱ����
*/		
		 //3.ִ��˽�еķ���
		//Method method = clazz.getMethod("sleep", int.class);
		Method method = clazz.getDeclaredMethod("sleep", int.class);
		//���÷��ʵ�Ȩ��,,,Ҳ�б�������
		method.setAccessible(true);
		method.invoke(new Person("����", 21), 15);
	}
}
