package com.wq.project;

import java.text.DecimalFormat;

/**
 * 数字格式化
 * "0" 指定位置不存在则补0, 22.22+"000.000"->022.220
 * "#" 指定位置不存在则不显示, 22.22+"###.###"->22.22
 * "." 小数点,没有小数位数则不显示 22.00+"###.###"->22
 * "%" 会将结果数字乘以100后面再加上% 22.222+"###.###%"->2222.2%
 */
public class DecimalFormatDemo {
	public static void main(String[] args){
		double d = 22.22;
		DecimalFormat fmt = new DecimalFormat("000.000");
		System.out.println(fmt.format(d));//输出：22.220
		
		DecimalFormat fmt2 = new DecimalFormat("###.###");
		System.out.println(fmt2.format(d));//输出：22.22
		
		double d2 = 22.00;
		DecimalFormat fmt3 = new DecimalFormat("###.###");
		System.out.println(fmt3.format(d2));//输出：22
		
		double d3 = 22.222;
		DecimalFormat fmt4 = new DecimalFormat("###.###%");
		System.out.println(fmt4.format(d3));//输出:2222.2%
	}
}
