

import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * �����������
 * 		RandomAccessFile�಻����������Object������ࡣ
 * 		�����ں���InputStream��OutputStream�Ĺ��ܡ�
 * 		֧�ֶ��ļ���������ʶ�ȡ��д�롣
 * 
 * public RandomAccessFile(String name,String mode)����һ���������ļ�·�����ڶ��������ǲ����ļ���ģʽ��
 * 		ģʽ�����֣�������õ�һ�ֽ�"rw",���ַ�ʽ��ʾ�Ҽȿ���д���ݣ�Ҳ���Զ�ȡ���� 
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		// write();
		read();
	}

	private static void read() throws IOException {
		// �����������������
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");

		int i = raf.readInt();
		System.out.println(i);
		// ���ļ�ָ�����ͨ�� getFilePointer������ȡ����ͨ�� seek �������á�һ��int����4���֣�		//�ڣ������ǣ�4
		System.out.println("��ǰ�ļ���ָ��λ���ǣ�" + raf.getFilePointer());

		char ch = raf.readChar();
		System.out.println(ch);
		//һ��char����ռ2���ֽ� ���ԣ�4+2=6
		System.out.println("��ǰ�ļ���ָ��λ���ǣ�" + raf.getFilePointer());
		//readUTF()����˵�����Ӵ��ļ���ȡһ���ַ��������ַ�����ʹ�� UTF-8 �޸İ��ʽ���б��롣
		//�ӵ�ǰ�ļ�ָ�뿪ʼ��ȡǰ�����ֽڣ�������ʹ�� readUnsignedShort����ֵ�����ѱ����ַ�����		//�����ֽ����������ǽ���ַ����ĳ��ȡ������ֽ�Ȼ�����Ϊ UTF-8 �޸İ��ʽ���ֽڱ�����			//������ת��Ϊ�ַ��� �й���ÿ���ַ�ռ�����ֽ���6�� ����6+2+6=14
		String s = raf.readUTF();
		System.out.println(s);
		System.out.println("��ǰ�ļ���ָ��λ���ǣ�" + raf.getFilePointer());

		// �Ҳ�����ͷ��ʼ�ˣ��Ҿ�Ҫ��ȡa����ô����?
		raf.seek(4);
		ch = raf.readChar();
		System.out.println(ch);
	}

	private static void write() throws IOException {
		// �����������������
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");

		// ��ô����?
		raf.writeInt(100);
		raf.writeChar('a');
		raf.writeUTF("�й�");

		raf.close();
	}
}