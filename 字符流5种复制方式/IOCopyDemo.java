package day21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 复制文本文件
 * 	分析：
 * 		复制文件，如果我们知道用记事本打开并能够读懂，就用的字符流，否则用字节流
 * 		通过该原理，我们知道我们应该采用字符流更方便一些。
 * 		而字符流有五种方式
 * 
 * 
 */
public class IOCopyDemo {
	public static void main(String[] args) throws IOException{
		String str1="wgl.txt";
		String str2="ccc.txt";
//		method1(str1,str2);
//		method2(str1,str2);
//		method3(str1,str2);
//		method4(str1,str2);
		method5(str1,str2);
	}

	//基本字符流一次读写一个字符
	private static void method1(String str1, String str2) throws IOException {
		// TODO Auto-generated method stub
		FileReader fileReader=new FileReader(str1);
		FileWriter fileWriter=new FileWriter(str2);
		int ch=0;
		while ((ch=fileReader.read())!=-1) {
			fileWriter.write(ch);
		}
		fileReader.close();
		fileWriter.close();
	}
	//基本字符流一次读写一个字符数组
	private static void method2(String str1, String str2) throws IOException {
		// TODO Auto-generated method stub
		FileReader fileReader=new FileReader(str1);
		FileWriter fileWriter=new FileWriter(str2);
		char[] cs=new char[1024];
		int ch=0;
		while ((ch=fileReader.read(cs))!=-1) {
			fileWriter.write(cs,0,ch);
		}
		fileReader.close();
		fileWriter.close();
	}
	//字符缓冲流一次读写一个字符
	private static void method3(String str1, String str2) throws IOException {
		BufferedReader fileReader=new BufferedReader(new FileReader(str1));
		BufferedWriter fileWriter=new BufferedWriter(new FileWriter(str2));
		char[] cs=new char[1024];
		int ch=0;
		while ((ch=fileReader.read(cs))!=-1) {
			fileWriter.write(cs,0,ch);
		}
		fileReader.close();
		fileWriter.close();
	}
	
	//字符缓冲流一次读写一个字符数组
		private static void method4(String str1, String str2) throws IOException {
			BufferedReader fileReader=new BufferedReader(new FileReader(str1));
			BufferedWriter fileWriter=new BufferedWriter(new FileWriter(str2));
			char[] cs=new char[1024];
			int ch=0;
			while ((ch=fileReader.read(cs))!=-1) {
			fileWriter.write(cs, 0, ch);
		}
			fileReader.close();
			fileWriter.close();
		}
		
		//字符缓冲流一次读写一个字符串
		private static void method5(String str1, String str2) throws IOException {
			BufferedReader fileReader=new BufferedReader(new FileReader(str1));
			BufferedWriter fileWriter=new BufferedWriter(new FileWriter(str2));
			String line=null;
			while ((line=fileReader.readLine())!=null) {
			fileWriter.write(line);
			fileWriter.newLine();
			fileWriter.flush();
		}
			fileReader.close();
			fileWriter.close();
		}
}
