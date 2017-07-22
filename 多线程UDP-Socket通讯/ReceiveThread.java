package day27;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveThread implements Runnable {

private	DatagramSocket ds;
	
	public ReceiveThread (DatagramSocket ds) {
		this.ds=ds;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			
			
			//创建一个数据包（接受容器）
			byte[] bys=new byte[1024*64];
			int length=bys.length;
			DatagramPacket dp=new DatagramPacket(bys, length);
			
			//调用Socket对象段接受方法接受数据
			try {
				ds.receive(dp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//解析数据包并显示在控制台
			//获取对方段IP
			InetAddress address=dp.getAddress();
			String ip=address.getHostAddress();
			byte[] xbys=dp.getData();
			int len=xbys.length;
			String s=new String(xbys,0,len);
			System.out.println(ip+"传递段数据是："+s);
			}
	}

}
