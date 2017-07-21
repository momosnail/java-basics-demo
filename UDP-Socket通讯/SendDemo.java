package day26;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {
	public static void main(String[] args) throws IOException {
		//创建发送段socket对象
		DatagramSocket ds=new DatagramSocket();
		
		//创建数据
		byte[] bytes="hello.隔壁老王".getBytes();
		//长度
		int length=bytes.length;
		//IP地址对象 192.168.1.3:为目标主机的IP地址
		InetAddress address=InetAddress.getByName("192.168.1.2");
		int port=10086;
		DatagramPacket dp=new DatagramPacket(bytes, length,address,port);
		
		//调用Socket对象段发送方法发送数据包
		ds.send(dp);
		//释放资源
		ds.close();
	}
}
