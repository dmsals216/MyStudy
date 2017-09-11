## Collection

### List
Index를 포함하는 동적 객체 배열
1. List 선언 - List를 메모리에 올린다.
```Java
    List list = new ArrayList();
```
2. 입력 - List안에 값을 0번째 메모리부터 넣는다.
```Java
    list.add("첫 번째 값");
```
3. 조회 - List안의 값을 뺴온다.
```Java
    list.get(0);
```
4. 수정 - List안의 값을 없애고 새로운 값을 넣는다.
```Java
    list.set(1, "수정된 값");
```
5. 삭제 - List안의 값을 없애고 다음 값들의 메모리를 땡긴다.
```Java
    list.remove(0);
```

### Set
List와 유사하지만 중복값을 허용하지 않는 동적 객체 배열
```Java
    Set set = new HashSet();

    set.add("Hello");
    set.add("Good to see you");
    set.add("Hello");

    for(String item : set) {
    System.out.println(item);
    }
```

### Map
List와 Set과는 다르게 Key값과 Value값으로 이루어진 동적 객체 배열
```Java
    Map map = new HashMap();
    map.put("key01", 1234556);
    map.put("key02", 12312312);
    System.out.println(map.get("key01"));

    Set keys = map.keySet();
    for(String key : keys) {
      System.out.println(map.get(key));
    }
```

### Generic
위의 Collection들은 값의 형태가 정해져 있지 않아 다루기가 어렵다.
그래서 하나의 컬렉션에는 하나의 타입만 넣을 수 있게 도와주는 문법이다.
```Java
    List<String> list = new ArrayList();
```
