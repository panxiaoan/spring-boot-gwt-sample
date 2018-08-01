package com.pxa.sample;

import java.io.File;

/** 
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a> 
 * @since 2018-07-09 17:15 
 */
public class SimpleTest {
	
	public static void main(String[] args) {
		File mavenRoot = new File(DeleteUselessRepository.MAVEN_PATH);
		if (mavenRoot.exists()) {
			File[] files = mavenRoot.listFiles();
			if (files != null && files.length > 0) {
				for (File file : files) {
					DeleteUselessRepository.judge(file);
				}
			}
		}
	}
}
