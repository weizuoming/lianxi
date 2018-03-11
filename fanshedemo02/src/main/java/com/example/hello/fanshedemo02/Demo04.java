package com.example.hello.fanshedemo02;

import java.lang.reflect.Field;

/**
 * 
 * 1.@author 2.@date 2017-3-24 3.@description
 * 
 *  ͨ�������ȡ��Ӧ�ĳ�Ա����,�ڷ��似����ʹ����Field�������˳�Ա������
		* ��ȡ �����еĳ�Ա����
			* Field[] fields = clazz.getDeclaredFields();
		* ��ȡ˽�еĳ�Ա����
			* clazz.getDeclaredField("id")
			* field.setAccessible(true)//���ÿ��Է���
 */
public class Demo04 {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.bawei.fanshe.Person");
		
		//1. ��ȡ �����еĳ�Ա����
		/*Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field);
		}*/
		
		//2.��ȡ˽�еĳ�Ա����
		Person person = new Person("����", 24);
		System.out.println(person);
		
		Field field = clazz.getDeclaredField("name");
		field.setAccessible(true);
		//set(Object obj, Object value);;;;Object obj��ʾ˭���ֶν�Ҫ������,,,Object value��Ҫ�ĳɵ��µ�ֵ
		field.set(person, "����");
		System.out.println(person);
	}
}
