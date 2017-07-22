package day04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 1.创建服务端ServerSocket对象 获取Socket对象。ServerSocket
 * 2.获取读取流对象 获取输出流对象，记得flush  
 * 3.反馈
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException{
		ServerSocket ss=new ServerSocket(14444);
		Socket s=ss.accept();
		BufferedInputStream bis=new BufferedInputStream(s.getInputStream());
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("abc.jpg"));
		byte[] bys=new byte[1024];
		int len=0;
		//bis.read(bys) 一定要记得read()里面的bys
		while ((len=bis.read(bys))!=-1) {
			bos.write(bys,0,len);
			bos.flush();
		}
//		s.shutdownInput();
		
		//反馈
//		BufferedOutputStream bos2=new BufferedOutputStream(s.getOutputStream());
//		bos2.write("图片接收完毕！".getBytes());
		//注意下面的是正确的，必须用 s.getOUputStream获取的对象。
		OutputStream bos2=s.getOutputStream();
		bos2.write("图片接收完毕！".getBytes());
		bos.close();
		s.close();
	}
}
