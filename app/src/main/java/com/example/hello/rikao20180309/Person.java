package com.example.hello.rikao20180309;

/**
 * Created by 韦作铭 on 2018/3/9.
 */

public class Person {
    private static String name;
    private static String gender;
    private static String age;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Person.name = name;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        Person.gender = gender;
    }

    public static String getAge() {
        return age;
    }

    public static void setAge(String age) {
        Person.age = age;
    }

    @Override
    public String toString() {
        return "Person{}";
    }
}
