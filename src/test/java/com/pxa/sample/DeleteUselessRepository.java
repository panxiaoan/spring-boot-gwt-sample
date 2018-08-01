package com.pxa.sample;
 
import java.io.File;
 
/**
 * @author xfcyzq
 * @version 1.0
 */
public class DeleteUselessRepository {
 
	public static String MAVEN_PATH = "/Users/panxiaoan/work/devops/maven/m2-repo";
 
	/**
	 * 判断是否存在jar
	 * 
	 * @author xfcyzq
	 * @version 1.0
	 * @param file
	 * @return
	 */
	public static boolean judge(File file) {
		boolean isHaveJar = false;
		File[] files = file.listFiles();
		if (files != null && files.length > 0) {
			for (File _file : files) {
				if (_file.getName().endsWith(".jar")) {
					isHaveJar = true;
				}
				if (_file.isDirectory()) {
					boolean isNextHaveJar = judge(_file);
					if (isNextHaveJar) {
						isHaveJar = true;
					}
				}
			}
		}
		if (!isHaveJar) {
			delete(file);
		}
		return isHaveJar;
	}
 
	/**
	 * 删除操作
	 * 
	 * @author xfcyzq
	 * @version 1.0
	 * @param file
	 */
	public static void delete(File file) {
		File[] files = file.listFiles();
		if (files != null && files.length > 0) {
			for (File f : files) {
				if (f.isDirectory()) {
					delete(f);
				}
				f.delete();
				System.out.println("已删除：" + f.getAbsolutePath());
			}
		} else {
			file.delete();
			System.out.println("已删除：" + file.getAbsolutePath());
		}
	}
	
	public static void main(String[] args) {
		
	}
}

