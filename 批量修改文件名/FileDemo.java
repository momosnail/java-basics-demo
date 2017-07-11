
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo {

	public static void main(String[] args) throws IOException {
//		File file=new File("/Users/wgl/Documents/JAVADEMO/aaa");
//		System.out.println(file.mkdir());
//		System.out.println(file.getAbsolutePath());
//		
////		File file2=new File("/Users/wgl/Documents/JAVADEMO/aaa.txt");
////		System.out.println("createNewFile:"+file2.createNewFile());
//		
//		File file3=new File("/Users/wgl/Documents/JAVADEMO/aaa.txt");
//		System.out.println("delete:"+file3.delete());
//		
//		File file4=new File("/Users/wgl/Documents/JAVADEMO/aaa");
//		System.out.println("delete:"+file4.delete());
//		File file5=new File("林青霞.jpg");
//		File file6=new File("东方不败.jpg");
//		System.out.println("create图片："+file5.createNewFile());
//		System.out.println("重命名图片："+file5.renameTo(file6));
		File file7=new File("/Users/wgl/Documents/JAVADEMO/bbb.txt");
		System.out.println(file7.getAbsolutePath());
		System.out.println(file7.getPath());
		System.out.println(file7.getName());
		System.out.println(file7.length());
		System.out.println(file7.lastModified());
	
		System.out.println("--------------");
		Date  date=new Date(file7.lastModified());
		SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		String s=sdf.format(date);
		System.out.println(s );
	}
}
