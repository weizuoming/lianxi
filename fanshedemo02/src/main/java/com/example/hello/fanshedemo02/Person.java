package com.example.hello.fanshedemo02;

public class Person {
	private String name;
	int id;
	
	public Person(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	private Person() {
		super();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "����:"+this.name+",���:"+this.id;
	}
	
	public void eat() {
		System.out.println(this.name+" �Է�");
	}
	
	private void sleep(int time) {
		System.out.println(this.name+"˯��"+time+"Сʱ");
	}
}
