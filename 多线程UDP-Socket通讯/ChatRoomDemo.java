package day27;

import java.io.IOException;
import java.net.DatagramSocket;

public class ChatRoomDemo {
	public static void main(String[] args) throws IOException{
		DatagramSocket dsSend=new DatagramSocket();
		DatagramSocket dsReceive=new DatagramSocket(12306);
		SendThread st=new SendThread(dsSend);
		ReceiveThread rt=new ReceiveThread(dsReceive);
		
		Thread ts=new Thread(st);
		Thread tr=new Thread(rt);
		
		ts.start();
		tr.start();
	}
}
