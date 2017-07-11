

import java.io.File;
import java.io.FilenameFilter;

/*
 * 判断某个目录下是否有后缀名为.jpg的文件，如果有，就输出文件
 * 分析1：
 * 		A：封装判断目录
 * 		B：获取该目录下所有文件或者文件夹的File数组
 * 		C：遍历该File数组，得到每一个File对象，然后判断
 * 		D：是否是文件
 * 			是：继续判断是否以.jpg结尾
 * 				是：就输出该文件名
 * 				否：就不搭理它
 * 			否：
 * 分析2：
 * 		A获取所有已满足条件的文件
 * 		B然后输出
 * 		要实现这个效果，必须学习一个接口：文件名称过滤器
 * 		public String[] list(FilenameFilter filter)
 * 		public File[] listFiles(FilenameFilter filter)
 */
public class FileDemo {
	public static void main(String[] args) {

		// 分析1代码实现
		/*
		 * File file =new File("/Users/wgl/Documents");
		 * 
		 * File[] files=file.listFiles(); 
		 * for (File f : files) {
		 *  if (f.isFile()){
		 *  
		 *   	if (f.getName().endsWith(".jpg")) {
		 * 			System.out.println(f.getName());
		 *  	}
		 *  
		 * 	 }
		 * }
		 */

		// 分析2代码实现
		File file = new File("/Users/wgl/Documents");
		String[] strArray = file.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				/*
				//File（dir）和下面的文件或文件夹（name）重新构成一个新的File 用于进一步判断
				File f=new File(dir, name);
				// 判断是否是文件
				boolean b1 = f.isFile();
				// 判断是否是以.jpg结尾
				boolean b2 = name.endsWith(".jpg");
				System.out.println(b1 && b2);
				return b1 && b2;
				*/
				//可以简化为
				return new File(dir,name).isFile()&&name.endsWith(".jpg");
			}
		});

		for (String string : strArray) {
			System.out.println(string);
		}
	}
}
