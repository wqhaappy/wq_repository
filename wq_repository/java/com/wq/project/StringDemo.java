package com.wq.project;

public class StringDemo {
public static void main(String[] args) {
	String str = "helloworld";	
	String str2 = "helloworld";	
	String str3 = "helloworld";

	String str4 = "hello"+"world";
	String a = "hello";
	String str5 = a + "world";
	
	/**
	 * str在创建的时候先会在堆内存中new一个新的对象，然后把地址返回到字符串常量池中，最后把地址返回栈内存中.
	 * str2在创建的时候会先去字符串常量池中查找是否存在，存在就直接返回地址
	 * == 用于比较引用类型数据的时候比较的是二个对象的内存地址
	 */
	System.out.println(str == str2);//true。
	System.out.println(str == str3);//true。理由同上
	/**
	 * 这是一个计算的表达式"hello"+"world"
	 * 当一个计算表达式计算符二边都是自变量时，会直接计算结果(结果是一个固定的值），然后将结果编译到Class文件中，因此str4在class文件中的样子
	 * String str4 = "helloworld";
	 * 
	 */
	System.out.println(str == str4);//true
	/**
	 * 只要运算符二边都是变量，那么一定会先在堆内存中创建一个新的对象。这样返回的地址不一样。
	 */
	System.out.println(str == str5);//false
		
	String s1 = "123abc";
	String s2 = 123 + "abc";
	String s3 = 1+"2"+3+"abc";
	String s4 = 1+2+"3"+"abc";
	String s5 = '1'+2+"3"+"abc";
	String s6 = "1"+'2'+3+"abc";

	//说出输出结果，并解释原因
	/*
	 * 字符串s2是计算表达式，计算符二边都是自变量，运算结果是一个固定的值
	 * */
	System.out.println(s1==s2);//true
	/*
	 * 字符串s2是计算表达式，计算符二边都是自变量，运算结果是一个固定的值
	 * */
	System.out.println(s1==s3);//true
	/**
	 * 
	 * 运算表达式，会先计算1+2的值，然后在计算自变量的值
	 * 结果：33abc
	 */
	System.out.println(s1==s4);//false
	/**
	 * 用引号引起来的是字符，而字符做+运算时会先转换成ascii码值
	 * 1的ascii码=49
	 * 49+2+3abc=513abc
	 */
	System.out.println(s5);//513abc
	System.out.println(s1==s5);//false
	/**
	运算表达式都是从左往右的，s5是因为第一个数据就是常量，第二个数也是常量，因此应该相加得到51
	s6第一个是字符串，第二个数据是char类型的字符，类型不一样是不能相加的，所以得到的是12
	*/
	System.out.println(s1==s6);//true
		
		
}
}
