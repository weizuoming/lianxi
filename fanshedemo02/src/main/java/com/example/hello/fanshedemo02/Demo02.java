package com.example.hello.fanshedemo02;

import java.lang.reflect.Constructor;

/**
 * 
 * 1.@author 2.@date 2017-3-24 3.@description
 * 
 * ���ͨ��Class�����ȡ���췽��
		* ͨ��Class�����ȡ��Ӧ�Ĺ��췽��
			*  getConstructors()��ȡһ��������й����Ĺ��췽��
				* clazz.getConstructors();
				* ������ӡ:System.out.println(constructor);
			* ��ȡ��һ��������й��췽��������˽�е�����
				* clazz.getDeclaredConstructors(); 
				* System.out.println(constructor);
			* getConstructor ��ȡ����ָ���Ĺ��췽��
				* clazz.getConstructor(int.class,String.class);
					* ������յĿɱ����(���Ըı�Ĳ���)
				* Person p  = (Person) constructor.newInstance(999,"С��"); // newInstance()����һ������
				* System.out.println(p)
			* ��ȡ˽�еĹ��캯��,��������
				* clazz.getDeclaredConstructor(null);
				* constructor.setAccessible(true);//��������
				* Person p  =(Person) constructor.newInstance(null);
				* System.out.println(p); 
 */
public class Demo02 {
	public static void main(String[] args) throws Exception{
		Class clazz = Class.forName("com.bawei.fanshe.Person");
		//1.��ȡ���й����Ĺ��췽��
		/*Constructor[] constructors = clazz.getConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}*/
		
		//2. ��ȡ��һ��������й��췽��������˽�е�����
		/*Constructor[] constructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}*/
		
		//3.getConstructor ��ȡ����ָ���Ĺ��췽��
		//Class... parameterTypes,,�ɱ����(�����Ƹ���,��������)
		/*Constructor constructor = clazz.getConstructor(String.class, int.class);
		//System.out.println(constructor);
		//ͨ���������ʽ��������
		Person person = (Person) constructor.newInstance("����",23);
		System.out.println(person);*/
		
		//4.��ȡ˽�еĹ��캯��,��������
		//java.lang.NoSuchMethodException: com.bawei.fanshe.Person.<init>()
		//Constructor constructor = clazz.getConstructor(null);
		
		Constructor constructor = clazz.getDeclaredConstructor(null);
		
		
		//java.lang.Illegal�Ƿ���Access����,����Exception:
		constructor.setAccessible(true);//˽�п��Է�����........
		Person person = (Person) constructor.newInstance(null);
		System.out.println(person);
	}
}
