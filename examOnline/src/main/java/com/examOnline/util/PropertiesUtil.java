package com.examOnline.util;

import java.util.ResourceBundle;

public class PropertiesUtil {

	private static ResourceBundle resource;
	private static final PropertiesUtil util = new PropertiesUtil();
	private PropertiesUtil(){}
	/**
	 * <p>Title: getInstance</p>
	 * <p>Description: 获取PropertiesUtil实例</p>
	 * @param fileName 不包含扩展名称的properties文件名，如abc.properties应传入abc。文件要放在项目的WEB-INF/classes下
	 */
	public static PropertiesUtil getInstance(String fileName) {
		resource = ResourceBundle.getBundle(fileName);
		return util;
	}
	/**
	 * <p>Title: getValue</p>
	 * <p>Description: 根据key获取value值</p>
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		if(resource.containsKey(key)) {
			return resource.getString(key);
		}
		return null;
	}
	public static void main(String[] args) {
		PropertiesUtil resource=PropertiesUtil.getInstance("partner");
		String name = resource.getValue("name");
		System.out.println(name);
	}

}
