package com.yedam.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("Hello");
		set.add("World");
//		set.add(100);
		set.add("Hello");
		
		Iterator<String> iter = set.iterator();// 반복자
		while(iter.hasNext()) {
			String result = iter.next();
			System.out.println(result);
		}
		
		// Set<Member>
		Set<Member> members = new HashSet<>();
		members.add(new Member("홍길동", 80));
		members.add(new Member("김민규", 88));
		members.add(new Member("홍길동", 80));
		
		Iterator<Member> miter = members.iterator();
		while(miter.hasNext()){
			Member result = miter.next();
			System.out.println(result.toString());
		}	
		
		// int => Integer
		int[] intAry = {10,20,30,40,20,10};
		// int배열에서 중복된 값을 제거한 결과 List추가
		// List 반복문 활용 출력
		
		Set<Integer> lset = new HashSet<>();
		Arrays.stream(intAry).forEach(num -> lset.add(num));
		// 중복값을 제거한 후 set 컬렉션에 저장
		for (int i=0; i<intAry.length; i++) {
			lset.add(intAry[i]);
		}
		//반복문 -> List저장
		List<Integer>ilist = new ArrayList<>();
		Iterator<Integer> iterator = lset.iterator();
		while(iterator.hasNext()) {
			ilist.add(iterator.next());
		}
		ilist.forEach(num -> System.out.println(num));
	}
	
}
