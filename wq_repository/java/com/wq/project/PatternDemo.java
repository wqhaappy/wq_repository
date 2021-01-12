package com.wq.project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {
public static void main(String[] args) {
	
}
public static void demo2(){
	String article = ""; 
	//() 叫做匹配组
	String reg = "(.)\\.(jpg)";
	//1 编译正则表达式生成 Pattern对象
	Pattern pattern = Pattern.compile(reg);
	//2 Pattern对象 匹配 文本，生成Matcher对象
	Matcher matcher = pattern.matcher(article);
	//正则表达式 匹配到文本
	while(matcher.find()){
		//String s = matcher.group();//获取匹配到的文本
		//System.out.println(s);
		//正则表达式匹配组的数量
		//System.out.println(matcher.groupCount());
		//获取第0组 匹配组的值，第0组是全匹配，等价于 matcher.group();
		System.out.println(matcher.group(0));
		System.out.println(matcher.group());
		//获取第1组 匹配组的值
		//System.out.println(matcher.group(1)); // a b
		//获取第2组 匹配组的值
		//System.out.println(matcher.group(2));//jpg
	}
}
}
