package day04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*往服务器上传图片
 * 1.创建Socket对象
 * 2.创建上传图片的流对象
 * 3.上传图片
 * 4.创建输入流对象 读取反馈并打印出来
 * 5.关闭Socket流对象 关闭2.的输入流对象
 */
public class ClientDemo {
	public static void main(String[] args) throws IOException{
		Socket s=new Socket("192.168.1.3",14444);
		
		BufferedInputStream bis=new BufferedInputStream(
//				new FileInputStream("/Users/wgl/Documents/java/study/day26/code/UDP协议发送和接收数据图解.bmp"));
				new FileInputStream("/Users/wgl/Documents/1131/可爱.jpg"));
		BufferedOutputStream bos=new BufferedOutputStream(s.getOutputStream());
		byte[] bys=new byte[1024];
		int len=0;
		while ((len=bis.read(bys))!=-1) {
			bos.write(bys,0,len);
			bos.flush();
		}
		s.shutdownOutput();
		
		//反馈
		BufferedInputStream bis2=new BufferedInputStream(s.getInputStream());
		byte[] bys2=new byte[1024];
		int len2=0;
		StringBuffer sb=new StringBuffer();
		if ((len2=bis2.read(bys2))!=-1) {
			sb.append(new String(bys2,0,len2));
		}
	
		System.out.println(sb.toString());
		
//		InputStream is=s.getInputStream();
//		byte[] bys3=new byte[1024];
//		int len3=is.read(bys3);
//		String str=new String(bys3,0,len3);
//		System.out.println(str);
		bis.close();
		s.close();
	}
}
