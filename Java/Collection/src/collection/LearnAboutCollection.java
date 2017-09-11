package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LearnAboutCollection {
	
	public void learnAboutArray() {
		// 선언
		// 타입 이름[] = new 타입[배열공간크기];
		int intArray[] = new int[10];
		System.out.println(intArray[7]);
	}
	
	// Index를 포함하는 동적 객체배열
	public void learnAboutList() {
		// 선언은 일반 객체를 초기화 하는 것과 같다.
		List<Item> list = new ArrayList<>();
		// 제네릭 선언하기 : 타임<제네릭 타입> 변수이름 = new 타입<>();
		// 제네릭이란 자신이 선언한 객체배열 안에 하나의 타입만 쓰기 위해
		
		// 입력
		list.add(new Item());
		list.add(new Item());
		
		// 조회
		list.get(0);
		
		// 수정
		list.set(1, new Item());  //  <ㅡ 1번의 아이템을 없애고 자신이 들어간다.
		
		// add의 다른 방법
		list.add(1, new Item());  //  <ㅡ 1번부터 이휴의 아이템 index를 하나씩 증가 시키고 자신이 1번에 들어간다.
		
		// 삭제
		list.remove(1); // <ㅡ삭제 하는데 다음 데이터들이 땡겨져 와 채워진다.
		
	}
	
	// List와 유사한데 중복값을 허용하지 않는 동적 객체배열
	public void learnAboutSet() {
		Set<String> set = new HashSet<>();
		
		set.add("Hello");
		set.add("Good to see you");
		set.add("Hello");
		
		for(String item : set) {
			System.out.println(item);
		}
		
	}
	
	// Key, Value로 구성된 동적 객체배열
	public void learnAboutMap() {
		// 선언
		Map<String, Integer> map = new HashMap<>();
		// 입력
		map.put("key01", 1234556);
		map.put("key02", 12312312);
		// 조회
		System.out.println(map.get("key01"));
		
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(map.get(key));
		}
		
	}
}
