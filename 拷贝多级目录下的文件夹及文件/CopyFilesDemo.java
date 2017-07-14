package day21;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 拷贝多级文件夹文件
 * 		分析：
 * 			A：封装数据源File
 * 			B：封装目的地File
 * 			C：判断该File是文件夹还是文件
 * 					a.是文件夹
 * 						就在目的地目录下创建该文件夹
 * 						获取该File对象下的所有文件或文件夹File对象
 * 						遍历得到每一个File对象
 * 						回到C
 * 					b.是文件
 * 						就复制字节流
 */
public class CopyFilesDemo {
	public static void main(String[] args) throws IOException {
		File srcFile=new File("/Users/wgl/Documents/Klei");
		//下面会陷入死循环
		File destFile=new File("/Users/wgl/Documents/Klei/001");
//		File destFile=new File("/Users/wgl/Documents/DXInst");
		
		copyFolder(srcFile,destFile);
	}

	private static void copyFolder(File srcFile, File destFile) throws IOException {
		if (srcFile.isDirectory()) {
			File newFolder=new File(destFile,srcFile.getName());
			newFolder.mkdir();
			File[] files=srcFile.listFiles();
			for(File file:files){
				copyFolder(file, newFolder);
			}
		}else {
			File newFile=new File(destFile,srcFile.getName());
			CopyFile(srcFile, newFile);
		}
		
	}
	
	
	private static void CopyFile(File f, File newf) throws IOException {
		// TODO Auto-generated method stub
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(f));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(newf));
		byte[] len=new byte[1024];
		int b=0;
		while ((b=bis.read(len))!=-1) {
			bos.write(len,0,b);
		}
		bis.close();
		bos.close();
	}
}
