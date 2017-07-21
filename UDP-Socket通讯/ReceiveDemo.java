package day26;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveDemo {
	public static void main(String[] args) throws IOException{
		//创建接收端Socket对象
		DatagramSocket ds=new DatagramSocket(10086);
		//创建一个数据包（接受容器）
		byte[] bys=new byte[1024*64];
		int length=bys.length;
		DatagramPacket dp=new DatagramPacket(bys, length);
		
		//调用Socket对象段接受方法接受数据
		ds.receive(dp);
		
		//解析数据包并显示在控制台
		//获取对方段IP
		InetAddress address=dp.getAddress();
		String ip=address.getHostAddress();
		byte[] xbys=dp.getData();
		int len=xbys.length;
		String s=new String(xbys,0,len);
		System.out.println(ip+"传递段数据是："+s);
		
		//释放资源
		ds.close();
	}
}
