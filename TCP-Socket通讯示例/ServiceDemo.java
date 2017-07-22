package day03;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * TCP协议接收数据：
 * 		A：创建Socket对象
 * 		B：监听客户端连接。返回一个对应的Socket对象。
 * 		C：获取输入流，读取数据，显示在控制台。
 * 		D：释放资源
 */
public class ServiceDemo {
	public static void main(String[] args) throws IOException {
		//创建Socket对象
		ServerSocket ss=new ServerSocket(5566);
		//监听客户端连接，返回一个对应的Socket对象
		Socket s=ss.accept();
		//获取输入流，读取数据，显示在控制台
		InputStream is=s.getInputStream();
		byte[] bys=new byte[1024*64];
		int len=is.read(bys,0,bys.length);
		String str=new String(bys,0,len);
		//ss.getInetAddress();获取的是服务器端的本地IP地址，s.getInetAddress();获取的是来自客户端的IP地址
		String ip=s.getInetAddress().getHostAddress();
		System.out.println(ip+"from:"+str);
		OutputStream os=s.getOutputStream();
		os.write("我是服务器发来的消息!!!".getBytes());
		//因为是某个客户端来的流，所以要关闭
		is.close();
		//因为是服务器端，要一只保持状态处理每个客户端来的信息，所以一般不关闭
//		ss.close();
	}
}
