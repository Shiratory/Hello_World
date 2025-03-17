package com.yedam.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * list 컬렉숀
 */
public class ListExe {
	public static void main(String[] args) {
		// 배열 : int[], String[], Member[] => intAry[0]
		// 컬렉숀 : List<Integer>, List<String>, List<Member>
		// intList.get(0), intList.add(30)
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1000);
		intList.add(1500);
		intList.add(2000);
		intList.add(1000);
		
		for(int i=0; i<intList.size(); i++) {
			System.out.println(intList.get(i));
		}
		
		// Set 컬렉숀
		Set<Integer> intSet = new HashSet<Integer>();
		intSet.add(1000);
		intSet.add(1500);
		intSet.add(2000);
		intSet.add(1000);
		System.out.println("--------------------------");
		for(Integer num : intSet) {
			System.out.println(num);
		}
		
		// Set<Member>
		Set<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 20));
		members.add(new Member("박태욱", 21));
		members.add(new Member("최선욱", 23));
		members.add(new Member("홍길동", 20)); // hashCode, equals => 동등
		System.out.println("--------------------------");
		for(Member mbr : members) {
			System.out.println(mbr.toString());
		}
		
	}
}
