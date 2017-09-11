## Java String

### String Api

1. length - 문자열의 길이를 구한다.
```Java
  String a = "String/Test";
  System.out.println(a.length());
```

2. indexOf - 문자열의 위치를 리턴한다.
```Java
  System.out.println(a.IndexOf("Te");
```

3. split - 특정 구분자로 분해
```Java
  String temp[] = a.split("/");
  for(String item : temp) {
    System.out.println(item);
  }
```

4. subString - 문자열 자르기
```Java
  System.out.println(a.subString(2, 7));
```

5. replace - 문자열 바꾸기
```Java
  System.out.println(a.replace("Te", "Px"));
```

6. startsWith - 특정 문자열로 시작하는 지 검사
```Java
  String address = "naver.com"
  if(!address.startsWith("http://")) {
    address = "http://" + address;
  }
```

### StringBuilder와 StringBuffer의 차이

1. 두가지는 사용방법이 거의 같다.
```Java
  //StringBuffer
  StringBuffer buffer = new StringBuffer();
  buffer.append("안");
  buffer.append("녕하").append("세요");
  buffer.append("반갑습니다");
  System.out.println(buffer.toString());
  //StringBuilder
  StringBuilder builder = new StringBuilder();
  builder.append("안");
  builder.append("녕하").append("세요");
  builder.append("반갑습니다");
  System.out.println(builder.toString());
```

2. 차이점

    * Builder가 속도가 더 빠르다.
    * 하지만 Builder가 비동기에서 안정성이 보장되지 않는다.
    * 다중 Thread환경에서는 StringBuilder를 사용하지 않는다.

### String ConstantPool
   * 자바는 String을 선언하는 방식이 2가지가 있다.
        1. new 연산자를 이용한 선언 방식
        2. 리터럴을 이용한 선언 방식


   * 이 두가지의 차이점은
        1. new 연선자를 이용해 String을 선언하면 메모리에 올라가게 되고 리터럴을 이용해 String을 선언하면
        ConstantPool이라는 메모리 영역에 저장된다.
        2. 리터럴을 이용해 선언을 하면 그 값을 비교할 때 true값이 뜨지만 new 연산자를 이용하면 그 값들을
        비교할 때 false가 반환된다.


   * new 연산자로 생성된 String 변수는 .intern()이라는 메서드를 이용해 ConstantPool 메모리 영역으로 이동시킨다.

### String과 관련된 Algorithm

   * 아나그램 알고리즘

       1. 내가 기본에 알던 메서드를 이용한 알고리즘
 ```Java
     public boolean checkAnagram(String a, String b) {
       // 반환할 boolean 변수 result를 선언
       boolean result = false;

       // 혹시나 있을 대문자를 소문자로 바꿈
       a = a.toLowerCase();
       b = b.toLowerCase();

       // 공백을 없애고 알파벳 단위로 String 배열에 쪼개서 넣음
       String[] aArray = a.replace(" ", "").split("");
       String[] bArray = b.replace(" ", "").split("");

       // 들어온 두개의 길이가 같지 않다면 굳이 아래의 코드를 실행시킬 필요가 없음
       if(aArray.length != bArray.length) {
       	return false;
       }

       // for문을 돌리기 위한 변수 선언
       int length = aArray.length;
       int check = 0;

       // String 배열에 있는 문자를 char형 배열에 넣어줌
       char[] aArrayC = new char[length];
       char[] bArrayC = new char[length];
       for(int i = 0; i < length; i++) {
       	aArrayC[i] = aArray[i].charAt(0);
       	bArrayC[i] = bArray[i].charAt(0);
       }

       // 하나하나의 문자들을 비교해서 갯수를 늘려준다.
       for(int i = 0; i < length; i++) {
       	for(int j = 0; j < length; j++) {
       		if(aArrayC[i] == bArrayC[j]) {
       			check++;
       			break;
       		}
       	}
       }

       // 문자 길이와 위에서 늘려준 갯수를 비교해서 같으면 변수 result값을 true로 바꿔줌
       if(length == check) {
       	result = true;
       }
       return result;
     }
 ```

       2. 몇가지 메서드를 알고 짠 코드


```Java
    public boolean checkAnagram2(String a, String b) {
      // 대문자를 소문자로 바꾸고 공백을 없앤다.
      a = a.toLowerCase().replace(" ", "");
      b = b.toLowerCase().replace(" ", "");

      // 들어온 문자 2개의 길이가 다르다면 아래의 코드를 실행할 필요가 없다.
      if(a.length() != b.length()) {
        return false;
      }

      // String 변수에 있는 값들을 char형 배열에 넣어준다.
      char[] aArrayC = a.toCharArray();
      char[] bArrayC = b.toCharArray();

      // char형 배열을 순서대로 정리해준다
      Arrays.sort(aArrayC);
      Arrays.sort(bArrayC);

      // 정리된 char형 배열을 비교하여 같은지 확인
      return Arrays.equals(aArrayC, bArrayC);
    }
```

### 참고할 내용

[String과 Math](http://github.com/dmsals216/September06)
