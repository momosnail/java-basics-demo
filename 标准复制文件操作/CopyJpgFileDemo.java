package day20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/*
 * 标准复制文件操作
 * 		int read(byt[] b):一次读取一个字节数组，
 * 						返回值其实是实际读取的字节个数
 */
public class CopyJpgFileDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("/Users/wgl/Documents/1.pic_hd.jpg");
		FileOutputStream fos=new FileOutputStream("/Users/wgl/Documents/1131/可爱.jpg");
		//理论上比 一个字节一个字节读取的read() 快1025倍
		byte[] bys=new byte[1024];
		int b=0;
		while ((b=fis.read(bys))!=-1) {
			fos.write(bys, 0, b);
		}
		
		fis.close();
		fos.close();
	}
}
