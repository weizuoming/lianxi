package com.example.hello.fanshedemo02;

/**
 * 
 * 1.@author 2.@date 2017-3-24 3.@description
 * 
 * ���䣺 
		* ��һ���ֽ����ļ����ص��ڴ��ʱ��jvm��Ը��ֽ�����н��ʣ�
		* Ȼ��ᴴ��һ�������Class���󣬰��ֽ����ļ�����Ϣȫ�����洢����Class�����У�����ֻҪ��ȡ��Class����
		* ���ǾͿ���ʹ���ֽ���������ö�������Ի��ߵ��ö���ķ����Ȳ���....
		* 
 ��ȡClass����ķ�ʽ:
		* �Ƽ�ʹ�ã� ��ȡClass����ķ�ʽһ
			* Class clazz1 = Class.forName("cn.itcast.reflect.Person");
			* System.out.println("clazz1:"+ clazz1);
			* д����
		* ��ȡClass����ķ�ʽ���� ͨ��������ȡ
			* Class clazz2 = Person.class;
			* System.out.println("clazz1==clazz2?"+ (clazz1==clazz2));
				* true,,,.class�ļ�������ص��ڴ��д���,��ֻ�����һ��
		* ��ȡClass����ķ�ʽ�� ��ͨ�������ȡ
			* Class clazz3 = new Person(110,"����").getClass();
			* System.out.println("clazz2==clazz3?"+ (clazz2==clazz3))
 */
public class Demo01 {
	public static void main(String[] args) throws Exception{
		/*Person person = new Person("����", 12);
		person.toString();*/
		
		//��ȡclass����ķ�ʽһ:ʹ�õ�ǰ���ȫ����
		Class clazz = Class.forName("com.bawei.fanshe.Person");
		System.out.println(clazz);
		
		//��ȡ����ĵڶ���:ʹ�õ�ǰ��
		Class clazz2 = Person.class;
		System.out.println("clazz==clazz2?"+(clazz==clazz2));
		
		//��ȡclass����ĵ����ַ�ʽ
		Class clazz3 = new Person("����", 12).getClass();
	}
}
