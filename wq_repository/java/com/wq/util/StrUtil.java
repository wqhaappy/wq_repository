package com.wq.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtil {
	/**
	 * 1、判断字符是否为空白字符串
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || (str.trim().length() == 0);
	}
	
	/**
 * 2、用字符c 在左边填充字符串str
 * 如：leftPad("abc", 10, "*"); 返回"*******abc"
 * 如：leftPad("abc", 10, "*"); 返回"*******abc"
 * @param str
 * @param size
 * @param c
 * @return

 */
public static String leftPad(String str, int size, char c) {
	StringBuilder builder = new StringBuilder(str);
	//把StringBuilder转换成String
	str = builder.toString();
	//填充
   for (int i = 0; i <size-str.length(); i++) {
		builder.insert(0, c); 
	}
	System.out.println(builder.toString());
	return null;
}

	/**
	 * 3、用字符串s 在左边填充字符串str
	 * 如：leftPad("123", 10, "你好")；返回"你好你好你好你123"
	 */
	public static String leftPad(String str, int size, String s) {
	StringBuilder builder = new StringBuilder(str);
	str = builder.toString();
	//String stt = builder.toString();
	//System.out.println(str == stt);
	//转换成字符串
	/*for (int i = 0; i < (size-str.length()-s.length()(i+1)); i++) {
		builder.insert(0, s);
	}
	System.out.println(builder.toString());*/
	return null;
}
	
	/**
	 *4、 用字符c 在中间填充字符串str
	 * 如center("123", 10, "x") 返回"xxx123xxxx"
	 * @return
	 */
	public static String center(String str, int size, char c) {
		return null;
	}
	
	/**
	 * 5、用字符串s 在中间填充字符串str
	 * 如 center("123", 10, "你好") 返回"你好你123你好你好"
	 * @return
	 */
	public static String center(String str, int size, String s) {
		return null;
	}
	
	/**
 *6、 校验是否是邮箱格式
 * 使用matches(int regx) 实现
 * @param email
 * @return
 */
public static boolean validEmail(String email) {
  //定义校验邮箱正则表达式
	String reg = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9]+)+";
	return email.matches(reg);
}

/**
 * 校验是否是邮箱格式
 * 要求：用 indexOf/lastIndexOf 实现
 * @param email
 * @return
 */
public static boolean validEmail2(String email) {
  /**用 indexOf/lastIndexOf 实现
   * 942498392@qq.com
   * 
   */
	/*Scanner scanner = new Scanner(System.in);
	scanner.nextLine();*/
	//@出现的索引跟.出现的索引
	int start = email.indexOf("@");
	System.out.println(start);
    int point = email.indexOf(".");
    if(start != -1 && point != -1){
    	System.out.println("这是一个合法邮箱");
    	return false;
    }else {
		System.out.println("这是一个非法的邮箱");
		 return true;
	}
}

	/**
 * 7、校验手机号码
 * 要求：用matches实现
 * @param phone
 * @return
 */
public static boolean validPhone(String phone) {
	//手机号校验   如果是接受短信的手机号正则(\+86|0086)?1[0-9]{10}
	String reg = "1[0-9]{10}";
	return phone.matches(reg);
}
	
	/**
	 * 8、判断字符text是否是回文
	 * 如：上海自来水来自上海 返回true
	 * 提示：用charAt 实现
	 * @param text
	 * @return
	 */
	public static boolean isPlalindrome(String text) {
		//遍历text
	for (int i = 0; i < text.length()/2; i++) {
		if (text.charAt(i) != text.charAt(text.length()-i-1)) {
			return false;
		}
	}
		return true;
	}

	/**
 * 9、生成长度为size 的一段随机中文
 * 提示：中文在unicode编码中的范围:4e00----9fa5
 * 要求使用 StringBuilder
 * @param size
 */
public static String randomStr(int size) {
	StringBuilder sb = new StringBuilder();
	char max = '\u9fa5';//中文unicode 最大值
	char min  = '\u4e00';//中文unicode 最小值
	for(int i=0;i<1000;i++){
		int n = NumUtil.random(max, min);
		sb.append((char)n);
	}
	return sb.toString();
	
}
	
	/**
 * 10、文件名 替换
 * 如：传入"a.png", 返回"1237456.png"
 * 要求返回的文件名必须唯一，不能重复
 * @param file
 * @return
 */
public static String genFileName(String file) {
	//切割图片
	String fileName[] = file.split("\\.");
	//获取系统的当前时间
	file=System.currentTimeMillis()+"."+fileName[1];
	System.out.println(file);
	return null;
}
	
	/**
	 * 11、实现 split方法
	 * @param str
	 * @return
	 */
	public static String[] splitStrings(String str, char c) {
		return str.split(c+"");
	}
	
	public static void main(String[] args) {
		String article = "";
		//String reg = "<img.*src=(.*?)[^>]*?>";
		String reg = "<img\\b[^<>]*?\\bsrc[\\s\\t\\r\\n]*=[\\s\\t\\r\\n]*[\"']?[\\s\\t\\r\\n]*([^\\s\\t\\r\\n\"'<>]*)[^<>]*?\\/?[\\s\\t\\r\\n]*>";
		List<String> imgList = getImgs(article,reg);
		System.out.println(imgList.size());
		System.out.println(imgList);
	}
	
	
	/**
	 * @param s "1z1"
	 * @return "bzb"
	 现在的需求：6|10  6z10-->gzba
                 gzba-->6z10
	写二个方法实现字符串转数字，数字转字符串的
	 */
	public static String TypeConversion(String s){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if('z'==c){
				sb.append(c);
				continue;
			}
			//'1'->a
			int j = Integer.parseInt(c+"");//1. '1' -> 1
			char c2 = (char)(j+'a');//2. 1 -> 'a'
			sb.append(c2);
		}
		return sb.toString();
	}
	
	/**
	 * 字符串转换成数字
	 */
	public static String getDigital(String str){
		StringBuilder stringBuilder =new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			if (a=='z') {
			  stringBuilder.append('|');
			  continue;
			}
			//字符转换成数字
			int b = a-'a';
			//'a'->0   'a'-'a'==0 'b'-'a'==1
	   stringBuilder.append(b);
		}
		return stringBuilder.toString();
	}
	
	/**
	 * 从文章article中 爬取所有图片返回
	 * @param article 文章
	 * @param reg 正则表达式
	 * @return 图片列表
	 */
	public static List<String> getImgs(String article, String reg){
		List<String> list = new ArrayList<String>();
		Pattern pattern = Pattern.compile(reg);
		//Pattern匹配文本，生成matchs对象
		Matcher matcher = pattern. matcher(article);
		while(matcher.find()){
			list.add(matcher.group());
		}
		return list;
	}
}
