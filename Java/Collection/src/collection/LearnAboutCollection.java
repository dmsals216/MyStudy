package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LearnAboutCollection {
	
	public void learnAboutArray() {
		// ����
		// Ÿ�� �̸�[] = new Ÿ��[�迭����ũ��];
		int intArray[] = new int[10];
		System.out.println(intArray[7]);
	}
	
	// Index�� �����ϴ� ���� ��ü�迭
	public void learnAboutList() {
		// ������ �Ϲ� ��ü�� �ʱ�ȭ �ϴ� �Ͱ� ����.
		List<Item> list = new ArrayList<>();
		// ���׸� �����ϱ� : Ÿ��<���׸� Ÿ��> �����̸� = new Ÿ��<>();
		// ���׸��̶� �ڽ��� ������ ��ü�迭 �ȿ� �ϳ��� Ÿ�Ը� ���� ����
		
		// �Է�
		list.add(new Item());
		list.add(new Item());
		
		// ��ȸ
		list.get(0);
		
		// ����
		list.set(1, new Item());  //  <�� 1���� �������� ���ְ� �ڽ��� ����.
		
		// add�� �ٸ� ���
		list.add(1, new Item());  //  <�� 1������ ������ ������ index�� �ϳ��� ���� ��Ű�� �ڽ��� 1���� ����.
		
		// ����
		list.remove(1); // <�ѻ��� �ϴµ� ���� �����͵��� ������ �� ä������.
		
	}
	
	// List�� �����ѵ� �ߺ����� ������� �ʴ� ���� ��ü�迭
	public void learnAboutSet() {
		Set<String> set = new HashSet<>();
		
		set.add("Hello");
		set.add("Good to see you");
		set.add("Hello");
		
		for(String item : set) {
			System.out.println(item);
		}
		
	}
	
	// Key, Value�� ������ ���� ��ü�迭
	public void learnAboutMap() {
		// ����
		Map<String, Integer> map = new HashMap<>();
		// �Է�
		map.put("key01", 1234556);
		map.put("key02", 12312312);
		// ��ȸ
		System.out.println(map.get("key01"));
		
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(map.get(key));
		}
		
	}
}
