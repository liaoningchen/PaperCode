package com.examOnline.util;

import java.util.Random;

public class RandomUtil {

	//随机数
	public static String randomNo(int j) {
		Random random = new Random();
		String result="";
		for(int i=0;i<j;i++){
			result+=random.nextInt(10);
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(randomNo(6));
	}
}
