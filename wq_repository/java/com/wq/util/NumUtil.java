package com.wq.util;

import java.util.Random;

/**
 * 数字工具类
 * @author
 *
 */
public class NumUtil {
	/**
	 * 生成 min-max之间的随机数
	 * @param max
	 * @param min
	 * @return
	 */
	public static int random(int min, int max){
		Random rand = new Random();
		return rand.nextInt(max-min) + min;
	}
	
	public static void main(String[] args) {
		System.out.println(random(0, 10));
	}
	
}
