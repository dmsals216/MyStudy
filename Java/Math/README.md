## Math

### Math Api

1. abs - 절댓값 구하기
```Java
System.out.println(Math.abs(-123));
```

2. round - 반올림
```Java
System.out.println(Math.round(123.5));
```

3. ceil - 올림
```Java
System.out.println(Math.ceil(343.1543));
```

4. floor - 내림
```Java
System.out.println(Math.floor(563.8));
```

5. 랜덤값 가져오기

* Math함수 이용 방법
```Java
System.out.println(Math.random() * 101);
```

* Random 클래스 이용 방법
```Java
Random random = new Random();
random.nextInt(100) + 1;
```

### Math를 이용한 Algorithm

 * 로또 번호 생성기
 ```Java
 public int[] getLottoNumbers() {
   // 로또 번호 변수선언
		int[] result = new int[6];
		Random random = new Random();
    // for문을 돌면서 로또 번호 result안에 랜덤하게 번호를 넣어준다.
		for(int i = 0; i < 6; i++) {
			int temp = random.nextInt(45) + 1;
			result[i] = temp;
			for(int j = 0; j < i; j++) {
        // result안에 이미 생성된 값이면 랜덤값을 다시 받게 설정
				if(temp == result[j]) {
					i--;
					break;
				}
			}
		}
		return result;
	}
 ```

 ### 참고할 내용

     [String과 Math](http://github.com/dmsals216/September06)
