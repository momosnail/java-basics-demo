package day20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*
 * 标准复制文件操作
 * 		int read(byt[] b):一次读取一个字节数组，
 * 						返回值其实是实际读取的字节个数
 */
public class CopyJpgFileDemo {

	public static void main(String[] args) throws IOException {
		
		//字节流 复制文件 标准写法
		/*
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
		*/
		
		//字符流1
		/*
		FileReader fr=new FileReader("wgl.txt");
		int by=0;
		while ((by=fr.read())!=-1) {
			System.out.println((char)by);
		}
		fr.close();
		*/
		
		//字符流2 复制文件 标准写法
		FileReader fr=new FileReader("wgl.txt");
		FileWriter fw=new FileWriter("fos4.txt");
		char[] bys=new char[1024];
		int len=0;
		while ((len=fr.read(bys))!=-1) {
			System.out.println(new String(bys, 0, len));
			fw.write(bys, 0, len);
		}
		fr.close();
		fw.close();
	}
}
