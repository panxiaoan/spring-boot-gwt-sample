package com.pxa.sample;
 
import java.io.File;

import org.apache.commons.lang3.StringUtils;
 
/**
 * @author xfcyzq
 * @version 1.0
 */
public class DeleteUselessRepository {
 
	public static String MAVEN_PATH = "/Users/panxiaoan/work/devops/maven/m2-repo";
 
	public static void judge(File file) {
		File[] files = file.listFiles();
		if (files != null && files.length > 0) {
			for (File _file : files) {
				if (_file.isDirectory()) {
					judge(_file);
				} 
				
				if (StringUtils.endsWith(_file.getName(), ".jar") || StringUtils.endsWith(_file.getName(), ".pom")) {
					continue;
				} else {
					delete(file);
				}
			}
		}
	}
 
	public static void delete(File file) {
		if (file.isDirectory()) {
			return;
		}
		file.delete();
		System.out.println("已删除：" + file.getAbsolutePath());
	}
	
	public static void main(String[] args) {
		DeleteUselessRepository.judge(new File(MAVEN_PATH));
	}
}

