

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PokerTest {
/*
 * 1 创建扑克
 * 2 洗牌
 * 3 发牌
 * 4 看牌
 */
	public static void main(String[] args) {
		/*
		 * 创建扑克
		 * 		花色
		 * 		A--k
		 * 		大小王
		 */
		//创建扑克牌集合
		HashMap<Integer, String> poker=new HashMap<>();
		ArrayList<Integer> arr=new ArrayList<>();
		String[] colors={"♥️","♦️","♠️","♣️"};
		//最小从3开始 所以顺序是3...A ,2
		String[] nums={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		//初始化HashMap集合角标
		int index=0;
		for (String num : nums) {
			for (String color : colors) {
				poker.put(index, color+num);
				arr.add(index);
				index++;
			}
		}
			poker.put(index, "小王");
			arr.add(index);
			index++;
			poker.put(index, "大王");
			arr.add(index);
			Set<Integer> set=poker.keySet();
			for (Integer integer : set) {
				System.out.print(poker.get(integer)+",");
			}
//			System.out.println();
		/*
		 *洗牌 
		 *	Collections工具类
		 */
			Collections.shuffle(arr);
		/*
		 * 发牌
		 * 		发牌的三个对象 因为要排序 所以用TreeSet
		 * 		牌底
		 */
		TreeSet<Integer> zhourunfa=new TreeSet<>();
		TreeSet<Integer> liudehua=new TreeSet<>();
		TreeSet<Integer> zhouxingchi=new TreeSet<>();
		TreeSet<Integer> dipai=new TreeSet<>();
			for (int i = 0; i < arr.size(); i++) {
				if (i>=arr.size()-3) {
					dipai.add(arr.get(i));
				}else if (i%3==0) {
						zhourunfa.add(arr.get(i));
					}else if (i%3==1) {
						liudehua.add(arr.get(i));
					}else if (i%3==2) {
						zhouxingchi.add(arr.get(i));
					}
				
			}
			
		/*
		 * 看牌
		 * 		排序的看牌 写一个方法
		 */
			SeePoker("周润发",zhourunfa,poker);
			SeePoker("刘德华",liudehua,poker);
			SeePoker("周星驰",zhouxingchi,poker);
			SeePoker("底牌",dipai,poker);
			
	}
	
	public static void SeePoker(String name,TreeSet<Integer> treeSet,HashMap<Integer, String> hMap){
		System.out.print(name+"的牌是：");
		for (Integer integer : treeSet) {
			System.out.print(hMap.get(integer)+" ");
		}
		System.out.println();
	}
}
