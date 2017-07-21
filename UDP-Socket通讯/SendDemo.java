package day26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {
	public static void main(String[] args) throws IOException {
		//创建发送段socket对象
		DatagramSocket ds=new DatagramSocket();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while ((line=br.readLine())!=null) {
			if ("886".equals(line)) {
				break;
			}
		
		//创建数据
//		byte[] bytes="hello.隔壁老王".getBytes();
		byte[] bytes=line.getBytes();
		//长度
		int length=bytes.length;
		//IP地址对象 192.168.1.3:为目标主机的IP地址 本机以下三种写法都可以。
		InetAddress address=InetAddress.getByName("192.168.1.3");
//		InetAddress address=InetAddress.getByName("192.168.1.255");
//		InetAddress address=InetAddress.getByName("127.0.0.1");
		int port=10086;
		DatagramPacket dp=new DatagramPacket(bytes, length,address,port);
		
		//调用Socket对象段发送方法发送数据包
		ds.send(dp);
		}
		//释放资源
		ds.close();
	}
}
