package com.house.utils;

import java.util.UUID;

/**
 * 文件上传的工具类
 * @author Administrator
 */
public class UploadUtil {
	
	/**
	 * 传入文件的名称，返回的唯一的名称
	 * 例如：gril.jpg	返回sdjsljfsjdl.jpg
	 * @param filename
	 * @return
	 */
	public static String getUUIDName(String filename){
		// 先查找
		int index = filename.lastIndexOf(".");
		// 截取后缀名
		String lastname = filename.substring(index, filename.length());
		// 唯一 字符串  fsd-sfsdf-sfsd-sdfsd
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid+lastname;
	}
}
