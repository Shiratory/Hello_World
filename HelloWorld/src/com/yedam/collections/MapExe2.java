package com.yedam.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.yedam.variable.Member;

public class MapExe2 {
	public static void main(String[] args) {
		Map<Member, Double> map = new HashMap<Member, Double>();
		map.put(new Member("홍길동", 29), 174.8);
		map.put(new Member("고양이", 82), 181.5);
		map.put(new Member("까마귀", 58), 53.1);
		
		map.remove(new Member("홍길동", 29));
		
		Set<Entry<Member, Double>> entryset = map.entrySet();
		for(Entry<Member, Double> entry : entryset) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
	}
}
