package day19;

import java.awt.List;
import java.io.File;

/*
 * 需求：把某个目录下所有以.rmvb.mkv.avi结尾的文件的绝对路径在控制台上打印出来
 * 分析：
 * 		A：封装目录
 * 		B：获取该目录下所有的文件或者文件夹的File数组
 * 		C：遍历该File数组，得到每个File对象
 * 		D：判断File对象是否是文件夹
 * 			是：回到B
 * 			否：继续判断是否以.rmvb结尾
 * 				是：就输出该文件路径
 * 				否：就什么也不做
 * 
 */
public class FilePathDemo {
	public static void main(String[] args) {
		File file=new File("/Users/wgl/Downloads");
		getAllRmvbFilePaths(file);
	}
	
	public static void getAllRmvbFilePaths(File file) {
		File[] filesArray=file.listFiles();
		if (filesArray!=null) {
			for (File f : filesArray) {
				if (f.isFile()) {
					if (f.getName().endsWith(".rmvb")||f.getName().endsWith(".mkv")||f.getName().endsWith(".avi")) {
						System.out.println(f.getAbsolutePath());
					}
				}else {
					getAllRmvbFilePaths(f);
				}
			}
		}
		
	}
}
