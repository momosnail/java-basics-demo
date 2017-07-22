package day03;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * TCP协议发送数据：
 * 		A：创建发送端的Socket对象
 * 				如果这一步成功，说明连接已建立成功。
 * 		B：获取输出资源，写数据（如果服务器那边写 这边也可以读数据）
 * 		C：释放资源
 * 
 * 连接被拒绝。TCP协议一定要先看服务器。
 * java.net.ConnectException: Connection refused: connect
 */
public class ClientDemo {
	public static void main(String[] args) throws IOException {
		//创建发送端Socket对象
		Socket s=new Socket("192.168.1.3",5566);
		//获取输出流
		OutputStream os=s.getOutputStream();
		os.write("我是客户端发来的消息!!!".getBytes());
		os.close();
		//释放资源
		s.close();
	}
}
