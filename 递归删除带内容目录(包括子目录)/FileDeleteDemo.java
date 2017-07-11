package day20;

import java.io.File;

/*
 * 需求：递归删除带内容目录(包括子目录)
 * 分析：
 * 		A：封装目录
 * 		B：获取该目录下所有的文件或文件夹的File数组
 * 		C：遍历该File数组，得到每一个File对象
 * 		D：判断该File对象是否是文件夹
 * 			是：就回到B
 * 			否：就删除
 */
public class FileDeleteDemo {
		public static void main(String[] args) {
			File file=new File("/Users/wgl/Downloads/__MACOSX");
			deleteFolder(file);
		}

		private static void deleteFolder(File file) {
			File[] fileArray= file.listFiles();
			for(File f: fileArray){
				if (f.isDirectory()) {
					deleteFolder(f);
				}else {
					System.out.println(f.getName()+"---"+f.delete());
				}
			
			}
			//删除空文件夹
			System.out.println(file.getName()+"---"+file.delete());
			
		}
}
